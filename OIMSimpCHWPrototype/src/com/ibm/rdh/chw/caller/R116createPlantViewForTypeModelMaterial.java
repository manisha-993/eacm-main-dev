package com.ibm.rdh.chw.caller;

import java.text.SimpleDateFormat;

import com.ibm.pprds.epimshw.HWPIMSAbnormalException;
import com.ibm.pprds.epimshw.PropertyKeys;
import com.ibm.pprds.epimshw.util.ConfigManager;
import com.ibm.pprds.epimshw.util.ProfitCenterPlantSelector;
import com.ibm.rdh.chw.entity.CHWAnnouncement;
import com.ibm.rdh.chw.entity.CHWGeoAnn;
import com.ibm.rdh.chw.entity.TypeModel;
import com.ibm.rdh.rfc.Bmm00Table;
import com.ibm.rdh.rfc.Bmm00TableRow;
import com.ibm.rdh.rfc.Bmmh1Table;
import com.ibm.rdh.rfc.Bmmh1TableRow;
import com.ibm.rdh.rfc.Zdm_geo_to_classTable;
import com.ibm.rdh.rfc.Zdm_geo_to_classTableRow;

public class R116createPlantViewForTypeModelMaterial extends Rfc {

	private com.ibm.rdh.rfc.Z_DM_SAP_MATM_CREATE rfc;

	public R116createPlantViewForTypeModelMaterial(CHWAnnouncement chwA,
			TypeModel typeModel, String sapPlant, String loadingGroup,
			CHWGeoAnn chwAg, String storageLocation, String pimsIdentity)
			throws Exception {
		reInitialize();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
		rfc = new com.ibm.rdh.rfc.Z_DM_SAP_MATM_CREATE();

		// Set Up the RFC Fields
		// Bmm00 - B0 Structure
		Bmm00Table b0Table = new Bmm00Table();
		Bmm00TableRow b0Row = b0Table.createEmptyRow();

		b0Row.setTcode("MM01");
		b0Row.setMatnr(typeModel.getType() + typeModel.getModel());
		// [Work Item 1681833] New: HIPO materials (5313 HPO and 5372 IS5)are still set to material type of ZPRT in RDH. Should be ZMAT
		if (isHIPOModel(typeModel.getType(), typeModel.getModel())) {
			b0Row.setMtart("ZMAT");
		} else {
			b0Row.setMtart("ZPRT");
		}
		// end
		b0Row.setMbrsh("M");
		b0Row.setXeiv4("X");
		b0Row.setWerks(sapPlant);
		b0Row.setLgort(storageLocation);
		b0Row.setXeid1("X");
		b0Row.setXeid2("X");
		b0Row.setXeib1("X");
		// SAP Ledger
		if (ConfigManager.getConfigManager()
				.getString(PropertyKeys.KEY_SAP_LEDGER).equals("Y")) {
			if (typeModel.getVendorID() != null
					&& (!"".equals(typeModel.getVendorID()))) {
				b0Row.setXeie1("X");
			}
		}

		b0Table.appendRow(b0Row);
		rfc.setIBmm00(b0Table);
		rfcInfo.append("BMM00 \n");
		rfcInfo.append(Tab + "MTART>>" + b0Row.getMtart() + "\n");
		rfcInfo.append(Tab + "TCODE>>" + b0Row.getTcode() + ", MATNR>>"
				+ b0Row.getMatnr() + ", MBRSH>>" + b0Row.getMbrsh()
				+ ", XEIV4>>" + b0Row.getXeiv4() + ", WERKS>>"
				+ b0Row.getWerks() + ", LGORT>>" + b0Row.getLgort()
				+ ", XEID1>>" + b0Row.getXeid1() + ", XEID2>>"
				+ b0Row.getXeid2() + ", XEIB1>>" + b0Row.getXeib1()
				+ ", XEIE1>>" + b0Row.getXeie1() + "\n");

		// Bmmh1 - B1
		Bmmh1Table b1Table = new Bmmh1Table();
		Bmmh1TableRow b1Row = b1Table.createEmptyRow();

		b1Row.setMeins("EA");
		b1Row.setTragr("STD");
		b1Row.setLadgr(loadingGroup);
		b1Row.setKtgrm(typeModel.getAcctAsgnGrp());
		b1Row.setMatkl("000");
		b1Row.setGewei("KG");
		b1Row.setXmcng("X");
		b1Row.setSernp("NONE");
		b1Row.setPerkz("M");
		if (storageLocation.substring(3, 4).equals("1")) {
			b1Row.setDiskz("");
		} else {
			b1Row.setDiskz("1");
		}
		b1Row.setSbdkz("1");
		if (sapPlant.equals("1999"))
			b1Row.setMtvfp("NC");
		else
			b1Row.setMtvfp("ZE");
		b1Row.setDismm("PD");
		b1Row.setDispo("000");
		b1Row.setFhori("000");
		b1Row.setDisls("EX");
		b1Row.setMaabc("A");
		b1Row.setDisgr("Z010");
		b1Row.setVprsv("S");
		b1Row.setPeinh("1");
		b1Row.setStprs("1");
		b1Row.setBklas("7900");

		// this is required by code, but not set in mapping
		b1Row.setZeiar(chwA.getAnnouncementType());
		b1Row.setZeinr(chwA.getAnnDocNo());
		b1Row.setAeszn(sdf.format(chwAg.getAnnouncementDate()));
		b1Row.setSpart(typeModel.getDiv());
		// end
		// SAP Ledger

		System.out.println("Profit Center Value for R116"
				+ typeModel.getProfitCenter());
		System.out.println("Print Vendor ID when Blank"
				+ typeModel.getVendorID());
		boolean existsPro = ProfitCenterPlantSelector
				.checkProfitCenterPlants(sapPlant);
		if (existsPro) {
			if (typeModel.getProfitCenter() != null) {
				b1Row.setPrctr(typeModel.getProfitCenter());
			}
		}
		if (typeModel.getVendorID() != null
				&& (!"".equals(typeModel.getVendorID()))) {
			b1Row.setEkgrp("001");
		}

		if (!"".equals(typeModel.getVendorID())) {
			b1Row.setMfrnr(typeModel.getVendorID());
		} else {
			b1Row.setMfrnr("?");
		}

		b1Table.appendRow(b1Row);
		rfc.setIBmmh1(b1Table);

		rfcInfo.append("BMMH1 \n");
		rfcInfo.append(Tab + "ZEIAR>>" + b1Row.getZeiar() + ", ZEINR>>"
				+ b1Row.getZeinr() + ", AESZN>>" + b1Row.getAeszn()
				+ ", SPART>>" + b1Row.getSpart() + "\n");

		rfcInfo.append(Tab + "MEINS>>" + b1Row.getMeins() + ", TRAGR>>"
				+ b1Row.getTragr() + ", LADGR>>" + b1Row.getLadgr()
				+ ", MTPOS>>" + b1Row.getMtpos() + ", KTGRM>>"
				+ b1Row.getKtgrm() + ", MATKL>>" + b1Row.getMatkl()
				+ ", GEWEI>>" + b1Row.getGewei() + ", XMCNG>>"
				+ b1Row.getXmcng() + ", SERNP>>" + b1Row.getSernp()
				+ ", PERKZ>>" + b1Row.getPerkz() + ", DISKZ>>"
				+ b1Row.getDiskz() + ", SBDKZ>>" + b1Row.getSbdkz()
				+ ", MTVFP>>" + b1Row.getMtvfp() + ", DISMM>>"
				+ b1Row.getDismm() + ", DISPO>>" + b1Row.getDispo()
				+ ", FHORI>>" + b1Row.getFhori() + ", DISLS>>"
				+ b1Row.getDisls() + ", MAABC>>" + b1Row.getMaabc()
				+ ", DISGR>>" + b1Row.getDisgr() + ", VPRSV>>"
				+ b1Row.getVprsv() + ", PEINH>>" + b1Row.getPeinh()
				+ ", STPRS>>" + b1Row.getStprs() + ", BKLAS>>"
				+ b1Row.getBklas() + ", PRCTR>>" + b1Row.getPrctr()
				+ ", EKGRP>>" + b1Row.getEkgrp() + ", MFRNR>>"
				+ b1Row.getMfrnr() + "\n");

		// ZDM_GEO_TO_CLASS
		Zdm_geo_to_classTable zdmTable = new Zdm_geo_to_classTable();
		Zdm_geo_to_classTableRow zdmRow = zdmTable.createEmptyRow();
		zdmRow.setZGeo("US");
		zdmTable.appendRow(zdmRow);
		rfc.setGeoData(zdmTable);
		rfcInfo.append("ZDM_GEO_TO_CLASS \n");
		rfcInfo.append(Tab + "GEO>>" + zdmRow.getZGeo() + "\n");

		// PIMS_IDENTITY
		rfc.setPimsIdentity(pimsIdentity);
		rfcInfo.append("PIMSIdentity \n");
		rfcInfo.append(Tab + "PIMSIdentity>>" + pimsIdentity + "\n");

		// RFANUMBER
		rfc.setRfaNum(chwA.getAnnDocNo());
		rfcInfo.append("RFANUM \n");
		rfcInfo.append(Tab + "RFANUM>>" + chwA.getAnnDocNo() + "\n");

	}

	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
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

	public com.ibm.rdh.rfc.Z_DM_SAP_MATM_CREATE getRfc() {
		return rfc;
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
		// TODO Auto-generated method stub
		return "Create Generic Plant View for Type/Model material";
	}

	@Override
	public String getRfcName() {
		return ClassUtil.getSimpleClassName(getRfc());
	}

	public void evaluate() throws Exception {

		execute();
	}

}
