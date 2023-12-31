package COM.ibm.eannounce.abr.sg.rfc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import COM.ibm.eannounce.abr.sg.rfc.entity.LANGUAGE;

public class ChwMachTypeMtc extends RfcCallerBase {
	
	private MODEL chwModel;
	private Connection rdhConnection;
	private Connection odsConnection;
	
	private String FROMMODELTOMODEL = "SELECT trim(FROMMACHTYPE)||trim(FROMMODEL)||'_'||trim(TOMACHTYPE)||trim(TOMODEL) AS FromModelToModel FROM ("
		    + " SELECT DISTINCT t1.ATTRIBUTEVALUE AS FROMMACHTYPE, t3.ATTRIBUTEVALUE AS FROMMODEL, t2.ATTRIBUTEVALUE AS TOMACHTYPE, t4.ATTRIBUTEVALUE AS TOMODEL FROM OPICM.flag F"
		    + " INNER JOIN opicm.text t1 ON f.ENTITYID =t1.ENTITYID AND f.ENTITYTYPE =t1.ENTITYTYPE AND t1.ATTRIBUTECODE ='FROMMACHTYPE' AND T1.VALTO > CURRENT  TIMESTAMP AND T1.EFFTO > CURRENT  TIMESTAMP"
		    + " INNER JOIN OPICM.TEXT t2 ON f.ENTITYID =t2.ENTITYID AND f.ENTITYTYPE =t2.ENTITYTYPE AND t2.ATTRIBUTECODE ='TOMACHTYPE' AND T2.ATTRIBUTEVALUE =? and T2.VALTO > CURRENT  TIMESTAMP AND T2.EFFTO > CURRENT  TIMESTAMP"
		    + " INNER JOIN opicm.text t3 ON f.ENTITYID =t3.ENTITYID AND f.ENTITYTYPE =t3.ENTITYTYPE AND t3.ATTRIBUTECODE ='FROMMODEL' AND T3.VALTO > CURRENT  TIMESTAMP AND T3.EFFTO > CURRENT  TIMESTAMP"
		    + " INNER JOIN opicm.text t4 ON f.ENTITYID =t4.ENTITYID AND f.ENTITYTYPE =t4.ENTITYTYPE AND t4.ATTRIBUTECODE ='TOMODEL' AND T4.VALTO > CURRENT  TIMESTAMP AND T4.EFFTO > CURRENT  TIMESTAMP"
		    + " INNER JOIN OPICM.FLAG F1 ON F1.ENTITYID =t2.ENTITYID AND F1.ENTITYTYPE =t2.ENTITYTYPE AND F1.ATTRIBUTECODE ='PDHDOMAIN' and F1.VALTO > CURRENT  TIMESTAMP AND F1.EFFTO > CURRENT  TIMESTAMP"
		    + " INNER JOIN OPICM.METADESCRIPTION M ON M.DESCRIPTIONCLASS=F1.ATTRIBUTEVALUE AND  M.NLSID=1 AND M.VALTO > CURRENT  TIMESTAMP AND M.EFFTO > CURRENT  TIMESTAMP"
		    + " WHERE f.ENTITYTYPE ='MODELCONVERT' AND F.ATTRIBUTECODE IN ('ADSABRSTATUS' ,'MODELCONVERTIERPABRSTATUS')  "
		    + " AND T1.ATTRIBUTEVALUE !=T2.ATTRIBUTEVALUE AND  F.ATTRIBUTEVALUE ='0030' AND M.LONGDESCRIPTION=? "
		    + " ) AS TT"
		    + " WITH UR";
	
	
	public ChwMachTypeMtc(MODEL chwProduct,Connection rdhConnection, Connection odsConnection) {	
		this.chwModel = chwProduct;
		this.rdhConnection = rdhConnection;
		this.odsConnection = odsConnection;
	}
	public void execute() throws Exception{

			String empty ="";
			String obj_id = chwModel.getMACHTYPE() + "MTC";
			String rfaNum = chwModel.getMACHTYPE()+chwModel.getMODEL()+"MTC";
			//1. Call ChwMatmCreate to create the material master for the product object.
			ChwMatmCreate chwMatmCreate = new ChwMatmCreate(chwModel,"ZMAT",chwModel.getMACHTYPE() + "MTC", rfaNum);
			this.addRfcName(chwMatmCreate);			
			chwMatmCreate.execute();
			this.addRfcResult(chwMatmCreate);
			
			//2. Call Chw001ClfCreate to create the standard 001 classifications and characteristics 
			//   which are tied to the offering's material master record.
			
			Chw001ClfCreate chw001ClfCreate = new Chw001ClfCreate(chwModel,"ZMAT",chwModel.getMACHTYPE()+ "MTC", rfaNum, odsConnection);
			this.addDebug("Calling " + "Chw001ClfCreate");
			try{
				chw001ClfCreate.execute();
				this.addMsg(chw001ClfCreate.getRptSb());
			}catch (Exception e) {
				this.addMsg(chw001ClfCreate.getRptSb());
				throw e;
			}
			
			//3. Call the TssClassificationMaint constructor to associate the MK_REFERENCE class to the product's material master record
			RdhClassificationMaint rdhClassificationMaint = new RdhClassificationMaint(obj_id,"MK_REFERENCE","300","H",rfaNum);
			this.addRfcName(rdhClassificationMaint);
			rdhClassificationMaint.execute();
			this.addRfcResult(rdhClassificationMaint);
			
			//4. Call the TssClassificationMaint constructor to associate the MK_T_VAO_NEW class to the product's material master record
			rdhClassificationMaint = new RdhClassificationMaint(obj_id,"MK_T_VAO_NEW","300","H",rfaNum);
			this.addRfcName(rdhClassificationMaint);
			rdhClassificationMaint.execute();
			this.addRfcResult(rdhClassificationMaint);	
			
			//5. Call the TssClassificationMaint constructor to associate the MK_D_VAO_NEW class to the product's material master record
			rdhClassificationMaint = new RdhClassificationMaint(obj_id,"MK_D_VAO_NEW","300","H",rfaNum);
			this.addRfcName(rdhClassificationMaint);
			rdhClassificationMaint.execute();
			this.addRfcResult(rdhClassificationMaint);
			
			//6.Call the TssClassificationMaint constructor to associate the MK_FC_EXCH class to the product's material master record.
			rdhClassificationMaint = new RdhClassificationMaint(obj_id,"MK_FC_EXCH","300","H", rfaNum);
			this.addRfcName(rdhClassificationMaint);
			rdhClassificationMaint.execute();
			this.addRfcResult(rdhClassificationMaint);
			
			//7.Call the TssClassificationMaint constructor to associate the MK_FC_CONV class to the product's material master record.
			rdhClassificationMaint = new RdhClassificationMaint(obj_id,"MK_FC_CONV","300","H", rfaNum);
			this.addRfcName(rdhClassificationMaint);
			rdhClassificationMaint.execute();
			this.addRfcResult(rdhClassificationMaint);
			//8.Create the MK_machineType_MOD class and MK_T_machineType_MOD characteristic if it does not exist.  
			//	Assign the MK_machineType_MOD class to the product's material master record.
			
			//8.a Call the ChwCharMaintain constructor to create the MK_T_machineType_MOD characteristic
			ChwCharMaintain chwCharMaintain = 
			new ChwCharMaintain(rfaNum  //String obj_id Set to concatenation of chwProduct.machineType + "MTC"
								,"MK_T_"+chwModel.getMACHTYPE()+"_MOD" //String charact  Set to  "MK_T_<machine_type>_MOD"
								, "CHAR" 			//String datatype
								, 6 				//int charnumber
								, empty				//String decplaces
								, empty				//String casesens
								, empty				//String neg_vals
								, empty				//String group
								, "S"				//String valassignm  Set to "-".
								, empty				//String no_entry
								, empty				//String no_display
								, "X" 				//String addit_vals Set to "X".
								, chwModel.getMACHTYPE() +" Model Characteristic" //String chdescr  Set to "<machine_type> Model Characteristic" where <machine_type> is chwProduct.machineType
								);
			this.addRfcName(chwCharMaintain);
			//8.b Call the ChwCharMaintain.addValue() method to add the model with its description to the MK_T_machineType_MOD characteristic
			String invname = "";
			List<LANGUAGE> languagesList = chwModel.getLANGUAGELIST();
			for(LANGUAGE language : languagesList){
				String nlsid = language.getNLSID();
				if("1".equals(nlsid)){					//<NLSID>1</NLSID>
					invname = language.getINVNAME();
					break;
				}
			}			
			//Set to SUBSTRING(chwProduct/INVNAME FROM 1 FOR 25)||' '||chwProduct/MODEL;
			String valdescr = CommonUtils.getFirstSubString(invname,25) + " " + chwModel.getMODEL();
			chwCharMaintain.addValue(chwModel.getMODEL(), valdescr);
			chwCharMaintain.execute();
			this.addRfcResult(chwCharMaintain);
			//8.c Call the ChwClassMaintain constructor to create the MK_machineType_MOD class. 
			ChwClassMaintain ChwClassMaintain = 
			new ChwClassMaintain(
					rfaNum 								//String obj_id Set to concatenation of chwProduct.machineType + "MTC"
					, "MK_"+chwModel.getMACHTYPE()+"_MOD"  //String class_name   Set to  "MK_<machine_type>_MOD" where <machine_type> is chwProduct.machineType
					, "MK_"+chwModel.getMACHTYPE()+"_MOD"  //String class_type   Set to  "MK_<machine_type>_MOD" where <machine_type> is chwProduct.machineType.
					);
			this.addRfcName(ChwClassMaintain);
			//8.d Call the ChwClassMaintain.addCharacteristic() method to add the MK_T_machineType_MOD characteristic to the MK_machineType_MOD characteristic class
			ChwClassMaintain.addCharacteristic("MK_T_"+chwModel.getMACHTYPE()+"_MOD"); 
			ChwClassMaintain.execute();
			this.addRfcResult(ChwClassMaintain);
			//8.e Call the TssClassificationMaint constructor to associate the MK_machineType_MOD class to the product's material master record
			//reuse ==>no TssClassificationMaint but RdhClassificationMaint 
			RdhClassificationMaint TssClassificationMaint = 
			new RdhClassificationMaint(
					obj_id 								//String obj_id Set to concatenation of chwProduct.machineType + "MTC"
					, "MK_"+chwModel.getMACHTYPE()+"_MOD"  //String class_name   Set to  "MK_<machine_type>_MOD" where <machine_type> is chwProduct.machineType
					, "300"  							//String class_type   Set to "300"
					, "H"
					, rfaNum);
			this.addRfcName(TssClassificationMaint);
			TssClassificationMaint.execute();
			this.addRfcResult(TssClassificationMaint);
			//9.Create the MK_machineType_MTC class and MK_machineType_MTC characteristic if it does not exist.
			//9.a Call the ChwCharMaintain constructor to create the MK_machineType_MTC characteristic.
			ChwCharMaintain ChwCharMaintain = 
			new ChwCharMaintain(
					rfaNum				 				//String obj_id  Set to concatenation of chwProduct.machineType + "MTC"
					, "MK_"+chwModel.getMACHTYPE()+"_MTC"	//String charact  Set to  "MK_machineType_MTC" where <machine_type> is chwProduct.machineType
					, "CHAR" 							//String datatype  Set to "CHAR".
					, 15 								//int charnumber  Set to "15".
					, empty 		//String decplaces
					, empty 		//String casesens
					, empty 		//String neg_vals
					, empty 		//String group
					, "-" 			//String valassignm  Set to "-".
					, empty 		//String no_entry
					, empty 		//String no_display
					, "X" 			//String addit_vals   Set to "X".
					, "Machine Type Conversions " + chwModel.getMACHTYPE()	//String chdescr	Set to "Machine Type Conversions <machine_type>" 				
					);
			this.addRfcName(ChwCharMaintain);
			//9.B For each MODELCONVERT which meets all of conditions below 
			String machtype = chwModel.getMACHTYPE();
			//ArrayList<HashMap<String, String>> recordArray = getModelConvert(machtype);
			List<String> FromModelToModel = this.getFromModelToModel(FROMMODELTOMODEL, chwModel.getMACHTYPE(),chwModel.getPDHDOMAIN());	
			for(String value : FromModelToModel){
				String value_descr = value.replace("_", " to ");
				ChwCharMaintain.addValue(value, value_descr);
			}				
//			for(HashMap<String, String> modelConvertMap: recordArray){				
//				String modelconvert_value = modelConvertMap.get("FROMMACHTYPE") + modelConvertMap.get("FROMMODEL")
//						+ "_" + modelConvertMap.get("TOMACHTYPE") + modelConvertMap.get("TOMODEL");
//				String modelConvert_desc  = modelConvertMap.get("FROMMACHTYPE") + modelConvertMap.get("FROMMODEL")
//						+ " to " + modelConvertMap.get("TOMACHTYPE") + modelConvertMap.get("TOMODEL");
//				ChwCharMaintain.addValue(modelconvert_value, modelConvert_desc);
//			}	
			ChwCharMaintain.execute();
			this.addRfcResult(ChwCharMaintain);
			//9.c Call the ChwClassMaintain constructor to create the MK_machineType_MTC class. 
			ChwClassMaintain =
			new ChwClassMaintain(
					rfaNum 								//String obj_id Set to concatenation of chwProduct.machineType + "MTC"
					, "MK_"+chwModel.getMACHTYPE()+"_MTC"  //String class_name   Set to  "MK_<machine_type>_MOD" where <machine_type> is chwProduct.machineType
					, "MK_"+chwModel.getMACHTYPE()+"_MTC"  //String class_type   Set to  "MK_<machine_type>_MOD" where <machine_type> is chwProduct.machineType.
					);
			this.addRfcName(ChwClassMaintain);
//			//9.d Call the ChwClassMaintain.addCharacteristic() method to add the MK_machineType_MTC characteristic to the MK_machineType_MTC  class
			ChwClassMaintain.addCharacteristic("MK_"+chwModel.getMACHTYPE()+"_MTC");
			ChwClassMaintain.execute();
			this.addRfcResult(ChwClassMaintain);
			//9.e Call the TssClassificationMaint constructor to associate the MK_machineType_MOD class to the product's material master record
			TssClassificationMaint = 
			new RdhClassificationMaint(
					obj_id 								//String obj_id Set to concatenation of chwProduct.machineType + "MTC"
					, "MK_"+chwModel.getMACHTYPE()+"_MTC"  //String class_name   Set to  "MK_<machine_type>_MTC" where <machine_type> is chwProduct.machineType
					, "300"  							//String class_type   Set to "300"
					, "H"
					, rfaNum);
			this.addRfcName(TssClassificationMaint);
			TssClassificationMaint.execute();
			this.addRfcResult(TssClassificationMaint);
			
			
			//10.Call the ChwConpMaintain to create a configuration profile for the product's material master record
			//10.a Call the ChwConpMaintain constructor.
			ChwConpMaintain ChwConpMaintain  = 
			new ChwConpMaintain(
					obj_id 				//String obj_id  Set to concatenation of chwProduct.machineType + "MTC"
					, "INITIAL"         //String c_profile Set to "INITIAL".
					, "SD01"			//String bomappl Set to "SD01".
					, "2"				//String bomexpl Set to "2".
					, chwModel.getMACHTYPE() +	"MTCUI"		//String design	 Set to Set to concatenation of chwProduct.machineType + "MTCUI" 
					, rfaNum);
			this.addRfcName(ChwConpMaintain);
			
			//10.b Call the ChwConpMaintain.addConfigDependency() method.
			ChwConpMaintain.addConfigDependency("E2E", empty); //Set to "E2E".
			//10.c 
			ChwConpMaintain.addConfigDependency("PR_"+chwModel.getMACHTYPE()+"_SET_MODEL", empty);  //Set to "PR_<chwProduct.machineType>_SET_MODEL"
			//10.d
			ChwConpMaintain.addConfigDependency("PR_E2E_SET_MTM", empty);  //Set to "PR_E2E_SET_MTM".
			//10.e 
			ChwConpMaintain.addConfigDependency("PR_E2E_PRICING_HW", empty);  //Set to "PR_E2E_PRICING_HW".
			//10.f 
			ChwConpMaintain.addConfigDependency("PR_E2E_CSTIC_HIDING_HW", empty);  //Set to "PR_E2E_PRICING_HW".
			
			ChwConpMaintain.execute();// excute 1 time 
			this.addRfcResult(ChwConpMaintain);
		
	}
	
//	private ArrayList<HashMap<String, String>> getModelConvert(String machtype) throws SQLException {
//		
//		ArrayList<HashMap<String, String>> recordArray = new ArrayList<HashMap<String, String>>();
//		String modelConvertQuery ="SELECT MT.ENTITYID FROM OPICM.TEXT AS MT "
//				+ " JOIN  OPICM.TEXT AS MF "
//				+ " ON MT.ENTITYTYPE = MF.ENTITYTYPE "
//				+ " and MT.ENTITYID = MF.ENTITYID "
//				+ " WHERE MT.EFFTO >current timestamp "
//				+ " AND MT.VALTO >current timestamp "
//				+ " AND MF.EFFTO >current timestamp "
//				+ " AND MF.VALTO >current timestamp "
//				+ " AND MT.ENTITYTYPE ='MODELCONVERT' "
//				+ " AND MT.ATTRIBUTECODE ='TOMACHTYPE' "
//				+ " AND MF.ATTRIBUTECODE ='FROMMACHTYPE' "
//				+ " AND MT.ATTRIBUTEVALUE <> MF.ATTRIBUTEVALUE "
//				+ " AND MT.ATTRIBUTEVALUE =? "
//				+ " AND MT.ENTITYID IN (  SELECT ENTITYID FROM OPICM.FLAG "
//				+ " WHERE ENTITYTYPE ='MODELCONVERT' "
//				+ " AND ((ATTRIBUTECODE ='ADSABRSTATUS' AND ATTRIBUTEVALUE = '0040') "
//				+ " OR (ATTRIBUTECODE ='MODELCONVERTIERPABRSTATUS' AND ATTRIBUTEVALUE = '0040')) "
//				+ " AND EFFTO >current timestamp "
//				+ " AND VALTO > current timestamp )"
//				+ " WITH ur";
//		PreparedStatement statement = rdhConnection.prepareStatement(modelConvertQuery);
//		statement.setString(1, machtype);
//		ResultSet resultSet = statement.executeQuery();
//		Map<String,String> attributeMap = new HashMap<String,String>();
//		attributeMap.put("FROMMACHTYPE", "");
//		attributeMap.put("FROMMODEL", "");
//		attributeMap.put("TOMACHTYPE", "");
//		attributeMap.put("TOMODEL ", "");
//		
//		while(resultSet.next()){
//			int entityid = resultSet.getInt("ENTITYID");
//			String modelConvert = "SELECT ATTRIBUTECODE,ATTRIBUTEVALUE FROM OPICM.TEXT "
//					+ " WHERE ENTITYTYPE ='MODELCONVERT' "
//					+ " AND ENTITYID=? "
//					+ " AND EFFTO >current timestamp "
//					+ " AND VALTO > current timestamp WITH ur";
//			PreparedStatement attributeStatement = rdhConnection.prepareStatement(modelConvert);
//			statement.setInt(1, entityid);
//			ResultSet attributeResultSet = attributeStatement.executeQuery();
//			HashMap<String,String> modelConvertMap = new HashMap<String,String>();
//			while(attributeResultSet.next()){
//				String attributecode = attributeResultSet.getString("ATTRIBUTECODE");
//				if(attributeMap.containsKey(attributecode)){
//					modelConvertMap.put(attributecode, attributeResultSet.getString("ATTRIBUTEVALUE"));					
//				}
//			}
//			if(!modelConvertMap.containsKey("FROMMACHTYPE")){
//				modelConvertMap.put("FROMMACHTYPE", "");
//			}
//			if(!modelConvertMap.containsKey("FROMMODEL")){
//				modelConvertMap.put("FROMMODEL", "");
//			}
//			if(!modelConvertMap.containsKey("TOMACHTYPE")){
//				modelConvertMap.put("TOMACHTYPE", "");
//			}
//			if(!modelConvertMap.containsKey("TOMODEL")){
//				modelConvertMap.put("TOMODEL", "");
//			}
//			recordArray.add(modelConvertMap);			
//		}
//		return recordArray;
//	}
	

	private List<String> getFromModelToModel(String sql,String type,String pdhdomain) throws SQLException {
		List<String> fromModelToModelList = new ArrayList<String>();
		Object[] params = new String[2]; 
		params[0] =type;
		params[1] =pdhdomain;
		String realSql = CommonUtils.getPreparedSQL(sql, params);
		this.addDebug("querySql=" + realSql);
		
		PreparedStatement statement = rdhConnection.prepareStatement(sql);
		statement.setString(1, type);
		statement.setString(2, pdhdomain);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()){
			fromModelToModelList.add(resultSet.getString("FromModelToModel"));
		}		
		return fromModelToModelList;
	}
	public static void main(String[] args) {
		MODEL model = new MODEL();
		model.setMACHTYPE("UTC");
		model.setMODEL("MOD_NAME");
//		MODELIERPABRSTATUSCaller MODELIERPABRSTATUSCaller = new MODELIERPABRSTATUSCaller(model);
//		MODELIERPABRSTATUSCaller.excute();
		

	}

}
