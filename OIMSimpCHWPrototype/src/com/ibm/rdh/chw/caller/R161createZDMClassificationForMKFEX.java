package com.ibm.rdh.chw.caller;

import java.util.Date;

import com.ibm.pprds.epimshw.HWPIMSAbnormalException;
import com.ibm.rdh.chw.entity.CHWAnnouncement;
import com.ibm.rdh.rfc.Api_auspTable;
import com.ibm.rdh.rfc.Api_auspTableRow;
import com.ibm.rdh.rfc.KlahTable;
import com.ibm.rdh.rfc.KlahTableRow;
import com.ibm.rdh.rfc.KsskTable;
import com.ibm.rdh.rfc.KsskTableRow;
import com.ibm.rdh.rfc.MaraTable;
import com.ibm.rdh.rfc.MaraTableRow;
import com.ibm.rdh.rfc.Object_keyTable;
import com.ibm.rdh.rfc.Object_keyTableRow;
import com.ibm.rdh.rfc.RcucoTable;
import com.ibm.rdh.rfc.RcucoTableRow;
import com.ibm.rdh.rfc.Zdm_geo_to_classTable;
import com.ibm.rdh.rfc.Zdm_geo_to_classTableRow;

public class R161createZDMClassificationForMKFEX extends Rfc {

	private com.ibm.rdh.rfc.Z_DM_SAP_CLASSIFICATION_MAINT rfc;

	public R161createZDMClassificationForMKFEX(String type, String newFlag,
			CHWAnnouncement chwA, String pimsIdentity) throws Exception {

		reInitialize();
		Date curDate = new Date();
		rfcName = "Z_DM_SAP_CLASSIFICATION_MAINT";
		rfc = new com.ibm.rdh.rfc.Z_DM_SAP_CLASSIFICATION_MAINT();

		// Set up the RFC fields
		// OBJECT_KEY - R0
		Object_keyTable r0Table = new Object_keyTable();
		Object_keyTableRow r0Row = r0Table.createEmptyRow();

		r0Row.setKeyFeld("MATNR");

		if ("UPG".equals(newFlag)) {
			r0Row.setKparaValu(type + "UPG");
		} else if ("MTC".equals(newFlag)) {
			r0Row.setKparaValu(type + "MTC");
		}

		r0Table.appendRow(r0Row);
		rfc.setIObjectKey(r0Table);
		rfcInfo.append("OBJECTKEY \n");
		rfcInfo.append(Tab + "KEYFELD>>" + r0Row.getKeyFeld() + ", KPARAVALU>>"
				+ r0Row.getKparaValu() + "\n");

		// KLAH - R2
		KlahTable r2Table = new KlahTable();
		KlahTableRow r2Row = r2Table.createEmptyRow();

		r2Row.setClass("MK_FEX");

		r2Table.appendRow(r2Row);
		rfc.setIKlah(r2Table);
		rfcInfo.append("KLAH \n");
		rfcInfo.append(Tab + "CLASS>>" + r2Row.get_Class() + "\n");

		// KSSK - R3
		KsskTable r3Table = new KsskTable();
		KsskTableRow r3Row = r3Table.createEmptyRow();

		r3Row.setKlart("300");

		r3Table.appendRow(r3Row);
		rfc.setIKssk(r3Table);
		rfcInfo.append("KSSK \n");
		rfcInfo.append(Tab + "KLART>>" + r3Row.getKlart() + "\n");

		// RCUCO - R4
		RcucoTable r4Table = new RcucoTable();
		RcucoTableRow r4Row = r4Table.createEmptyRow();

		r4Row.setObtab("MARA");

		r4Table.appendRow(r4Row);
		rfc.setIRcuco(r4Table);
		rfcInfo.append("RCUCO \n");
		rfcInfo.append(Tab + "OBTAB>>" + r4Row.getObtab() + "\n");

		// MARA - R5
		MaraTable r5Table = new MaraTable();
		MaraTableRow r5Row = r5Table.createEmptyRow();

		// Passing date
		r5Row.setErsda(curDate);

		r5Table.appendRow(r5Row);
		rfc.setIMara(r5Table);
		rfcInfo.append("MARA  \n");
		rfcInfo.append(Tab + "ERSDA>>" + r5Row.getErsdaString() + "\n");

		// API_AUSP - R6

//		int group;
//		int seq;
//
//		for (group = 1; group <= 6; group++) {
//
//			Api_auspTable r6Table = new Api_auspTable();
//			Api_auspTableRow r6Row = r6Table.createEmptyRow();
//
//			String char1 = "MK_FEX_FTR_ADD_GRP0" + group + "_SEQ01";
//			String char2 = "MK_FEX_QTY_ADD_GRP0" + group + "_SEQ01";
//
//			r6Row.setCharact(char1);
//			r6Row.setValue("");
//
//			r6Table.appendRow(r6Row);
//			rfc.setIApiAusp(r6Table);
//			rfcInfo.append("API_AUSP \n");
//			rfcInfo.append(Tab + "CHARACT>> " + r6Row.getCharact()
//					+ ", VALUE>> " + r6Row.getValue() + "\n");
//
//			r6Row.setCharact(char2);
//			r6Row.setValue("");
//
//			r6Table.appendRow(r6Row);
//			rfc.setIApiAusp(r6Table);
//			rfcInfo.append("API_AUSP \n");
//			rfcInfo.append(Tab + "CHARACT>> " + r6Row.getCharact()
//					+ ", VALUE>> " + r6Row.getValue() + "\n");
//
//			// Refering to page 104 in design document v1_0e (CHARACT )
//
//			for (seq = 1; seq <= 6; seq++) {
//
//				String char3 = "MK_FEX_FTR_REM_GRP0" + group + "_SEQ0" + seq;
//				String char4 = "MK_FEX_QTY_REM_GRP0" + group + "_SEQ0" + seq;
//
//				r6Row.setCharact(char3);
//				r6Row.setValue("");
//
//				r6Table.appendRow(r6Row);
//				rfc.setIApiAusp(r6Table);
//				// rfcInfo.append("API_AUSP \n");
//				rfcInfo.append(Tab + "CHARACT>> " + r6Row.getCharact()
//						+ ", VALUE>> " + r6Row.getValue() + "\n");
//
//				r6Row.setCharact(char4);
//				r6Row.setValue("");
//
//				r6Table.appendRow(r6Row);
//				rfc.setIApiAusp(r6Table);
//
//				// rfcInfo.append("API_AUSP \n");
//				rfcInfo.append(Tab + "CHARACT>> " + r6Row.getCharact()
//						+ ", VALUE>> " + r6Row.getValue() + "\n");
//
//			}
//
//		}

		// ZDM_GEO_TO_CLASS
		Zdm_geo_to_classTable zdmTable = new Zdm_geo_to_classTable();
		Zdm_geo_to_classTableRow zdmRow = zdmTable.createEmptyRow();

		zdmRow.setZGeo("US");
		zdmTable.appendRow(zdmRow);

		rfc.setGeoData(zdmTable);
		rfcInfo.append("ZDM_GEO_TO_CLASS \n");
		rfcInfo.append(Tab + "GEO>>" + zdmRow.getZGeo() + "\n");

		// PIMSIdentity
		rfc.setPimsIdentity(pimsIdentity);
		rfcInfo.append("PIMSIdentity \n");
		rfcInfo.append(Tab + "PIMSIdentity>>" + rfc.getPimsIdentity() + "\n");

		// RFANUMBER
		rfc.setRfaNum(chwA.getAnnDocNo());
		rfcInfo.append("RFANUM \n");
		rfcInfo.append(Tab + "RFANumber>>" + rfc.getRfaNum() + "\n");

	}

	@Override
	public void execute() throws Exception {
		logExecution();
		getRfc().execute();
		getLog().debug(getErrorInformation());
		if (getSeverity() == ERROR) {
			throw new HWPIMSAbnormalException(getErrorInformation());
		}

	}

	@Override
	public String getTaskDescription() {
		StringBuffer sb = new StringBuffer();
		sb.append(" " + getMaterialName());
		return sb.toString();
	}

	@Override
	protected boolean isSuccessful() {
		boolean ans = false;
		int rc = getRfc().getRfcrc();
		if (0 == rc) {
			ans = true;
		}
		return ans;
	}

	@Override
	protected String getErrorInformation() {
		String ans;
		if (isSuccessful()) {
			ans = RFC_OK_MESSAGE;
		} else {
			ans = formatRfcErrorMessage(getRfc().getRfcrc(), getRfc()
					.getErrorText());
		}
		return ans;
	}

	@Override
	protected String getMaterialName() {
		return "Create 300 Classification for MK_FEX";
	}

	@Override
	public String getRfcName() {
		return ClassUtil.getSimpleClassName(getRfc());
	}

	public com.ibm.rdh.rfc.Z_DM_SAP_CLASSIFICATION_MAINT getRfc() {
		return rfc;
	}

	public void evaluate() throws Exception {
		execute();
	}

}
