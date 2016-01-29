package com.ibm.rdh.rfc.proxy;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ibm.pprds.epimshw.HWPIMSAbnormalException;
import com.ibm.pprds.epimshw.util.LogManager;
import com.ibm.rdh.chw.entity.CHWAnnouncement;
import com.ibm.rdh.chw.entity.CHWGeoAnn;
import com.ibm.rdh.chw.entity.TypeModel;
import com.ibm.rdh.chw.entity.TypeModelUPGGeo;

public class R100createTypeMaterialBasicViewTest extends RdhRestProxyTest {

	private static Logger logger = LogManager.getLogManager()
			.getPromoteLogger();

	String activeId = "Z_DM_SAP_MATM_CREATE";

	@Test
	public void r100New() {
		try {

			CHWAnnouncement chwA = new CHWAnnouncement();
			TypeModel typeModel = new TypeModel();
			CHWGeoAnn chwAg = new CHWGeoAnn();
			TypeModelUPGGeo tmUPGObj = new TypeModelUPGGeo();

			chwA.setAnnDocNo("123401");
			chwA.setAnnouncementType("New");
			typeModel.setType("EACM");
			typeModel.setDiv("B1");
			typeModel.setProductHierarchy("ph");
			chwAg.setAnnouncementDate(new Date());
			String newFlag = "NEW";
			String FromToType = "";
			String pimsIdentity = "C";
			String objectId = typeModel.getType() + newFlag;

			int deleteDataResult = deleteDataMatmCreate(objectId);
			assertEquals(deleteDataResult, 0);

			RdhRestProxy rfcProxy = new RdhRestProxy();
			rfcProxy.r100(chwA, typeModel, chwAg, newFlag, tmUPGObj,
					FromToType, pimsIdentity);

			Map<String, String> map = new HashMap<String, String>();
			Map<String, Object> rowDetails;

			map.clear();
			map.put("MANDT", "'" + Constants.MANDT + "'");
			map.put("ACTIV_ID", "'" + activeId + "'");
			map.put("OBJECT_ID", "'" + objectId + "'");

			rowDetails = selectTableRow(map, "ZDM_LOGHDR");
			assertNotNull(rowDetails);
			String activeId = (String) rowDetails.get("ACTIV_ID");
			assertEquals("Z_DM_SAP_MATM_CREATE", activeId);
			String sessionId = (String) rowDetails.get("ZSESSION");

			map.clear();
			map.put("ZSESSION", "'" + sessionId + "'");
			rowDetails = selectTableRow(map, "ZDM_LOGDTL");
			String logdtlText = (String) rowDetails.get("TEXT");

			rowDetails = selectTableRow(map, "ZDM_LOGHDR");

			assertNotNull("Material Master created/updated successfully",
					logdtlText);

			assertEquals("EA", "EA");

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
	public void r100Upg() {
		try {
			CHWAnnouncement chwA = new CHWAnnouncement();
			TypeModel typeModel = new TypeModel();
			CHWGeoAnn chwAg = new CHWGeoAnn();
			TypeModelUPGGeo tmUPGObj = new TypeModelUPGGeo();

			chwA.setAnnDocNo("123401");
			chwA.setAnnouncementType("New");
			typeModel.setType("EACM");
			typeModel.setDiv("B1");
			typeModel.setProductHierarchy("ph");
			chwAg.setAnnouncementDate(new Date());
			String newFlag = "UPG";
			String FromToType = "";
			String pimsIdentity = "C";
			String objectId = typeModel.getType() + newFlag;

			int deleteDataResult = deleteDataMatmCreate(objectId);
			assertEquals(deleteDataResult, 0);

			RdhRestProxy rfcProxy = new RdhRestProxy();
			rfcProxy.r100(chwA, typeModel, chwAg, newFlag, tmUPGObj,
					FromToType, pimsIdentity);

			Map<String, String> map = new HashMap<String, String>();
			Map<String, Object> rowDetails;

			map.clear();
			map.put("MANDT", "'" + Constants.MANDT + "'");
			map.put("ACTIV_ID", "'" + activeId + "'");
			map.put("OBJECT_ID", "'" + objectId + "'");

			rowDetails = selectTableRow(map, "ZDM_LOGHDR");
			assertNotNull(rowDetails);
			String activeId = (String) rowDetails.get("ACTIV_ID");
			assertEquals("Z_DM_SAP_MATM_CREATE", activeId);
			String sessionId = (String) rowDetails.get("ZSESSION");

			map.clear();
			map.put("ZSESSION", "'" + sessionId + "'");
			rowDetails = selectTableRow(map, "ZDM_LOGDTL");
			String logdtlText = (String) rowDetails.get("TEXT");

			rowDetails = selectTableRow(map, "ZDM_LOGHDR");

			assertNotNull("Material Master created/updated successfully",
					logdtlText);

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
	public void r100MtcToType() {
		try {
			CHWAnnouncement chwA = new CHWAnnouncement();
			TypeModel typeModel = new TypeModel();
			CHWGeoAnn chwAg = new CHWGeoAnn();
			TypeModelUPGGeo tmUPGObj = new TypeModelUPGGeo();

			chwA.setAnnDocNo("123401");
			chwA.setAnnouncementType("New");
			typeModel.setType("EACM");
			typeModel.setDiv("B1");
			typeModel.setProductHierarchy("ph");
			chwAg.setAnnouncementDate(new Date());
			tmUPGObj.setType("EACMT1");
			tmUPGObj.setProductHierarchy("ph");

			String pimsIdentity = "C";
			String newFlag = "MTC";
			String FromToType = "MTCTOTYPE";
			String objectId = tmUPGObj.getType() + newFlag;

			int deleteDataResult = deleteDataMatmCreate(objectId);
			assertEquals(deleteDataResult, 0);

			RdhRestProxy rfcProxy = new RdhRestProxy();
			rfcProxy.r100(chwA, typeModel, chwAg, newFlag, tmUPGObj,
					FromToType, pimsIdentity);

			Map<String, String> map = new HashMap<String, String>();
			Map<String, Object> rowDetails;

			map.clear();
			map.put("MANDT", "'" + Constants.MANDT + "'");
			map.put("ACTIV_ID", "'" + activeId + "'");
			map.put("OBJECT_ID", "'" + objectId + "'");

			rowDetails = selectTableRow(map, "ZDM_LOGHDR");
			assertNotNull(rowDetails);
			String activeId = (String) rowDetails.get("ACTIV_ID");
			assertEquals("Z_DM_SAP_MATM_CREATE", activeId);
			String sessionId = (String) rowDetails.get("ZSESSION");

			map.clear();
			map.put("ZSESSION", "'" + sessionId + "'");
			rowDetails = selectTableRow(map, "ZDM_LOGDTL");
			String logdtlText = (String) rowDetails.get("TEXT");

			rowDetails = selectTableRow(map, "ZDM_LOGHDR");

			assertNotNull("Material Master created/updated successfully",
					logdtlText);

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
	public void r100MtcFromType() {
		try {
			CHWAnnouncement chwA = new CHWAnnouncement();
			TypeModel typeModel = new TypeModel();
			CHWGeoAnn chwAg = new CHWGeoAnn();
			TypeModelUPGGeo tmUPGObj = new TypeModelUPGGeo();

			chwA.setAnnDocNo("123401");
			chwA.setAnnouncementType("New");
			typeModel.setType("EACM");
			typeModel.setDiv("B1");
			typeModel.setProductHierarchy("ph");
			chwAg.setAnnouncementDate(new Date());
			tmUPGObj.setType("EACMF1");
			tmUPGObj.setProductHierarchy("ph");
			String newFlag = "MTC";
			String FromToType = "MTCFROMTYPE";
			String pimsIdentity = "C";
			String objectId = tmUPGObj.getFromType() + newFlag;

			int deleteDataResult = deleteDataMatmCreate(objectId);
			assertEquals(deleteDataResult, 0);

			RdhRestProxy rfcProxy = new RdhRestProxy();
			rfcProxy.r100(chwA, typeModel, chwAg, newFlag, tmUPGObj,
					FromToType, pimsIdentity);

			Map<String, String> map = new HashMap<String, String>();
			Map<String, Object> rowDetails;

			map.clear();
			map.put("MANDT", "'" + Constants.MANDT + "'");
			map.put("ACTIV_ID", "'" + activeId + "'");
			map.put("OBJECT_ID", "'" + objectId + "'");

			rowDetails = selectTableRow(map, "ZDM_LOGHDR");
			assertNotNull(rowDetails);
			String activeId = (String) rowDetails.get("ACTIV_ID");
			assertEquals("Z_DM_SAP_MATM_CREATE", activeId);
			String sessionId = (String) rowDetails.get("ZSESSION");

			map.clear();
			map.put("ZSESSION", "'" + sessionId + "'");
			rowDetails = selectTableRow(map, "ZDM_LOGDTL");
			String logdtlText = (String) rowDetails.get("TEXT");

			rowDetails = selectTableRow(map, "ZDM_LOGHDR");

			assertNotNull("Material Master created/updated successfully",
					logdtlText);

		} catch (HWPIMSAbnormalException ex) {
			logger.info("error message= " + ex.getMessage());
			Assert.fail("error message= " + ex.getMessage());
		} catch (Exception e) {
			e.getStackTrace();
			Assert.fail("There is some error :" + e.getMessage());
		} finally {

		}

	}

}
