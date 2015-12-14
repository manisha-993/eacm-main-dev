package com.ibm.rdh.rfc.proxy;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.pprds.epimshw.HWPIMSAbnormalException;
import com.ibm.pprds.epimshw.util.LogManager;
import com.ibm.rdh.chw.entity.CHWAnnouncement;

public class R176create300ClassificationForTypeFEATTest extends
		RdhRestProxyTest {

	private static Logger logger = LogManager.getLogManager()
			.getPromoteLogger();

	@Before
	public void prepareData() {
		String sql_klah = "insert into SAPR3.KLAH select '200',CLINT,KLART,'MK_1234_FEAT_0000',STATU,KLAGR,BGRSE,BGRKL,BGRKP,ANAME,"
				+ "ADATU,VNAME,VDATU,VONDT,BISDT,ANZUO,PRAUS,SICHT,DOKNR,DOKAR,DOKTL,"
				+ "DOKVR,DINKZ,NNORM,NORMN,NORMB,NRMT1,NRMT2,AUSGD,VERSD,VERSI,LEIST,VERWE,SPART,LREF3,WWSKZ,"
				+ "WWSSI,POTPR,CLOBK,CLMUL,CVIEW,DISST,MEINS,CLMOD,VWSTL,VWPLA,CLALT,"
				+ "LBREI,BNAME,MAXBL,KNOBJ,SHAD_UPDATE_TS,SHAD_UPDATE_IND,SAP_TS from SAPR3.KLAH "
				+ "where mandt='300' and KLART='300' and CLASS='MK_0010_FEAT_0000'";
		String sql_mara_1 = "insert into sapr3.mara (mandt,matnr) values('200','1234NEW')";
		String sql_mara_2 = "insert into sapr3.mara (mandt,matnr) values('200','1234UPG')";
		String sql_mara_3 = "insert into sapr3.mara (mandt,matnr) values('200','1234MTC')";

		int t1 = SqlHelper.runUpdateSql(sql_klah, conn);
		int t2 = SqlHelper.runUpdateSql(sql_mara_1, conn);
		int t3 = SqlHelper.runUpdateSql(sql_mara_2, conn);
		int t4 = SqlHelper.runUpdateSql(sql_mara_3, conn);

		if (t1 >= 0 && t2 >= 0 && t3 >= 0 && t4 >= 0) {
			System.out.println("insert success");
		} else {
			System.out.println("insert failed");
		}
	}

	@Test
	public void testR176QueryFound01() {
		try {
			String type = "1234";
			String newFlag = "NEW";
			deleteDataClassicationMaint(type + newFlag);
			deletezdmLogHdrAndzdmLogDtl(Constants.MANDT,
					"Z_DM_SAP_CLASSIFICATION_MAINT", "300" + type + newFlag);

			CHWAnnouncement chwA = new CHWAnnouncement();
			chwA.setAnnDocNo("123401");

			String range = "0000";
			String pimsIdentity = "C";
			RdhRestProxy rfcProxy = new RdhRestProxy();
			rfcProxy.r176(type, range, newFlag, chwA, pimsIdentity);

			// Test function execute success
			Map<String, String> map = new HashMap<String, String>();
			Map<String, Object> rowDetails;

			map.clear();
			map.put("MANDT", "'" + Constants.MANDT + "'");
			map.put("ZDMOBJKEY", "'300" + type + newFlag + "'");
			map.put("ZDMOBJTYP", "'CLF'");
			rowDetails = selectTableRow(map, "ZDM_PARKTABLE");
			assertNotNull(rowDetails);

			map.clear();
			map.put("MANDT", "'" + Constants.MANDT + "'");
			map.put("ACTIV_ID", "'Z_DM_SAP_CLASSIFICATION_MAINT'");
			map.put("OBJECT_ID", "'300" + type + newFlag + "'");
			map.put("STATUS", "'success'");
			rowDetails = selectTableRow(map, "ZDM_LOGHDR");
			assertNotNull(rowDetails);
			String sessionId = (String) rowDetails.get("ZSESSION");

			map.clear();
			map.put("ZSESSION", "'" + sessionId + "'");
			map.put("TEXT", "'Classification created / updated successfully.'");
			rowDetails = selectTableRow(map, "ZDM_LOGDTL");
			assertNotNull(rowDetails);
		} catch (HWPIMSAbnormalException ex) {
			logger.info("error message= " + ex.getMessage());
			Assert.fail("error message= " + ex.getMessage());
		} catch (Exception e) {
			e.getStackTrace();
			Assert.fail("There is some error :" + e.getMessage());
		} finally {

		}
	}

	@Test
	public void testR176QueryFound02() {
		try {
			String type = "1234";
			String newFlag = "UPG";
			deleteDataClassicationMaint(type + newFlag);
			deletezdmLogHdrAndzdmLogDtl(Constants.MANDT,
					"Z_DM_SAP_CLASSIFICATION_MAINT", "300" + type + newFlag);

			CHWAnnouncement chwA = new CHWAnnouncement();
			chwA.setAnnDocNo("123401");

			String range = "0000";
			String pimsIdentity = "C";
			RdhRestProxy rfcProxy = new RdhRestProxy();
			rfcProxy.r176(type, range, newFlag, chwA, pimsIdentity);

			// Test function execute success
			Map<String, String> map = new HashMap<String, String>();
			Map<String, Object> rowDetails;

			map.clear();
			map.put("MANDT", "'" + Constants.MANDT + "'");
			map.put("ZDMOBJKEY", "'300" + type + newFlag + "'");
			map.put("ZDMOBJTYP", "'CLF'");
			rowDetails = selectTableRow(map, "ZDM_PARKTABLE");
			assertNotNull(rowDetails);

			map.clear();
			map.put("MANDT", "'" + Constants.MANDT + "'");
			map.put("ACTIV_ID", "'Z_DM_SAP_CLASSIFICATION_MAINT'");
			map.put("OBJECT_ID", "'300" + type + newFlag + "'");
			map.put("STATUS", "'success'");
			rowDetails = selectTableRow(map, "ZDM_LOGHDR");
			assertNotNull(rowDetails);
			String sessionId = (String) rowDetails.get("ZSESSION");

			map.clear();
			map.put("ZSESSION", "'" + sessionId + "'");
			map.put("TEXT", "'Classification created / updated successfully.'");
			rowDetails = selectTableRow(map, "ZDM_LOGDTL");
			assertNotNull(rowDetails);
		} catch (HWPIMSAbnormalException ex) {
			logger.info("error message= " + ex.getMessage());
			Assert.fail("error message= " + ex.getMessage());
		} catch (Exception e) {
			e.getStackTrace();
			Assert.fail("There is some error :" + e.getMessage());
		} finally {

		}
	}

	@Test
	public void testR176QueryFound03() {
		try {
			String type = "1234";
			String newFlag = "MTC";
			deleteDataClassicationMaint(type + newFlag);
			deletezdmLogHdrAndzdmLogDtl(Constants.MANDT,
					"Z_DM_SAP_CLASSIFICATION_MAINT", "300" + type + newFlag);

			CHWAnnouncement chwA = new CHWAnnouncement();
			chwA.setAnnDocNo("123401");

			String range = "0000";
			String pimsIdentity = "C";
			RdhRestProxy rfcProxy = new RdhRestProxy();
			rfcProxy.r176(type, range, newFlag, chwA, pimsIdentity);

			// Test function execute success
			Map<String, String> map = new HashMap<String, String>();
			Map<String, Object> rowDetails;

			map.clear();
			map.put("MANDT", "'" + Constants.MANDT + "'");
			map.put("ZDMOBJKEY", "'300" + type + newFlag + "'");
			map.put("ZDMOBJTYP", "'CLF'");
			rowDetails = selectTableRow(map, "ZDM_PARKTABLE");
			assertNotNull(rowDetails);

			map.clear();
			map.put("MANDT", "'" + Constants.MANDT + "'");
			map.put("ACTIV_ID", "'Z_DM_SAP_CLASSIFICATION_MAINT'");
			map.put("OBJECT_ID", "'300" + type + newFlag + "'");
			map.put("STATUS", "'success'");
			rowDetails = selectTableRow(map, "ZDM_LOGHDR");
			assertNotNull(rowDetails);
			String sessionId = (String) rowDetails.get("ZSESSION");

			map.clear();
			map.put("ZSESSION", "'" + sessionId + "'");
			map.put("TEXT", "'Classification created / updated successfully.'");
			rowDetails = selectTableRow(map, "ZDM_LOGDTL");
			assertNotNull(rowDetails);
		} catch (HWPIMSAbnormalException ex) {
			logger.info("error message= " + ex.getMessage());
			Assert.fail("error message= " + ex.getMessage());
		} catch (Exception e) {
			e.getStackTrace();
			Assert.fail("There is some error :" + e.getMessage());
		} finally {

		}
	}

	@After
	public void deleteData() {
		String del_klah = "delete from SAPR3.KLAH where mandt='200' and KLART='300' and CLASS='MK_1234_FEAT_0000'";
		String del_mara_1 = "delete from SAPR3.MARA where mandt='200' and MATNR='1234NEW'";
		String del_mara_2 = "delete from SAPR3.MARA where mandt='200' and MATNR='1234UPG'";
		String del_mara_3 = "delete from SAPR3.MARA where mandt='200' and MATNR='1234MTC'";

		int t1 = SqlHelper.runUpdateSql(del_klah, conn);
		int t2 = SqlHelper.runUpdateSql(del_mara_1, conn);
		int t3 = SqlHelper.runUpdateSql(del_mara_2, conn);
		int t4 = SqlHelper.runUpdateSql(del_mara_3, conn);

		if (t1 >= 0 && t2 >= 0 && t3 >= 0 && t4 >= 0) {
			System.out.println("delete success");
		} else {
			System.out.println("delete failed");
		}
	}

	public int deleteDataClassicationMaint(String prodctID) {
		// table list KSSK, INOB
		// first delete the exist data in the table
		int t1 = SqlHelper.runUpdateSql("delete from SAPR3.KSSK where mandt='"
				+ Constants.MANDT + "' and KLART='300'", conn);
		int t2 = SqlHelper.runUpdateSql("delete from SAPR3.INOB where mandt='"
				+ Constants.MANDT + "' and objek='" + prodctID + "'", conn);

		if (t1 >= 0 && t2 >= 0) {
			return 0;
		} else {
			return -1;
		}

	}
}
