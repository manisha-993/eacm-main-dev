package com.ibm.rdh.rfc.proxy;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.ibm.pprds.epimshw.HWPIMSAbnormalException;
import com.ibm.pprds.epimshw.util.LogManager;
import com.ibm.rdh.chw.entity.CHWAnnouncement;
import com.ibm.rdh.chw.entity.TypeFeature;

public class R186DeleteTypeFeatureCharacteristicTest extends RdhRestProxyTest {

	private static Logger logger = LogManager.getLogManager()
			.getPromoteLogger();

	@Test
	public void r186() {
		try {

			CHWAnnouncement chwA = new CHWAnnouncement();
			TypeFeature typeFeature = new TypeFeature();
			chwA.setAnnDocNo("123401");
			typeFeature.setType("EACF");
			typeFeature.setFeature("1000");
			typeFeature.setDescription("Features");
			String pimsIdentity = "C";
			String charac = "MK_" + typeFeature.getType() + "_"
					+ typeFeature.getFeature();
			String activeId = "Z_DM_SAP_CHAR_MAINTAIN";
			deletezdmLogHdrAndzdmLogDtl(Constants.MANDT,
					"Z_DM_SAP_CHAR_MAINTAIN", charac);

			RdhRestProxy rfcProxy = new RdhRestProxy();
			rfcProxy.r186(typeFeature, chwA, pimsIdentity);

			Map<String, String> map = new HashMap<String, String>();
			Map<String, Object> rowDetails;

			map.clear();
			map.put("MANDT", "'" + Constants.MANDT + "'");
			map.put("ZDMOBJKEY", "'" + charac + "'");
			map.put("ZDMOBJTYP", "'CHR'");
			rowDetails = selectTableRow(map, "ZDM_PARKTABLE");
			assertNotNull(rowDetails);

			map.clear();
			map.put("MANDT", "'" + Constants.MANDT + "'");
			map.put("ACTIV_ID", "'" + activeId + "'");
			map.put("OBJECT_ID", "'" + charac + "'");
			rowDetails = selectTableRow(map, "ZDM_LOGHDR");
			assertNotNull(rowDetails);
			String sessionId = (String) rowDetails.get("ZSESSION");
			String status = (String) rowDetails.get("STATUS");
			assertEquals(status, "success");

			map.clear();
			map.put("ZSESSION", "'" + sessionId + "'");
			map.put("TEXT", "'Characteristic  " + charac
					+ " created/updated successfully.'");
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

		String del_cabn = "delete from SAPR3.CABN where mandt='200' and ATNAM='MK_EACF_1000'";
		String del_cabnt = "delete from SAPR3.CABNT where mandt='200' and ATBEZ='Features'";

		int t1 = SqlHelper.runUpdateSql(del_cabn, conn);
		int t2 = SqlHelper.runUpdateSql(del_cabnt, conn);

		if (t1 >= 0 && t2 >= 0) {
			System.out.println("delete success");
		} else {
			System.out.println("delete failed");
		}
	}

}
