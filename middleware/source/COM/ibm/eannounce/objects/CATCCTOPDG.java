//
// Copyright (c) 2001, International Business Machines Corp., Ltd.
// All Rights Reserved.
// Licensed for use in connection with IBM business only.
//
// $Log: CATCCTOPDG.java,v $
// Revision 1.4  2008/09/04 20:48:03  wendy
// Cleanup RSA warnings
//
// Revision 1.3  2006/05/19 17:16:21  joan
// changes
//
// Revision 1.2  2006/05/18 15:22:40  joan
// changes
//
// Revision 1.1  2006/05/17 23:09:16  joan
// initial load
//
//

package COM.ibm.eannounce.objects;

import java.sql.SQLException;
import java.util.*;

import COM.ibm.opicmpdh.middleware.MiddlewareException;
import COM.ibm.opicmpdh.middleware.MiddlewareRequestException;
import COM.ibm.opicmpdh.middleware.MiddlewareShutdownInProgressException;
import COM.ibm.opicmpdh.middleware.Profile;
import COM.ibm.opicmpdh.middleware.Database;
import COM.ibm.opicmpdh.middleware.DatePackage;
import COM.ibm.opicmpdh.middleware.D;
import COM.ibm.opicmpdh.transactions.OPICMList;


/**
 * CATCCTOPDG
 *
 */
public class CATCCTOPDG extends PDGActionItem {
    static final long serialVersionUID = 20011106L;

	private static final String ATT_CATAUDIENCE = "CATAUDIENCE";
	private static final String ATT_CATNEWOFF = "CATNEWOFF";
	private static final String ATT_CATLGMKTGDESC = "CATLGMKTGDESC";

	private static final String ATT_PF = "PUBFROM";
//	private static final String ATT_PT = "PUBTO";

	//private static final String ATT_OFFCOUNTRY	= "OFFCOUNTRY";
	//private static final String ATT_GENAREANAME	= "GENAREANAME";

	public String m_strEntityType = null;
	OPICMList m_audList = new OPICMList();
	//private static final int CHUNK = 500;

    /*
    * Version info
    */
    /**
     * (non-Javadoc)
     * getVersion
     *
     * @see COM.ibm.eannounce.objects.EANFoundation#getVersion()
     */
    public String getVersion() {
        return "$Id: CATCCTOPDG.java,v 1.4 2008/09/04 20:48:03 wendy Exp $";
    }

    /**
     * CATCCTOPDG
     *
     * @param _mf
     * @param _ai
     * @throws COM.ibm.opicmpdh.middleware.MiddlewareRequestException
     *  @author David Bigelow
     */
    public CATCCTOPDG(EANMetaFoundation _mf, CATCCTOPDG _ai) throws MiddlewareRequestException {
        super(_mf, _ai);
    }

    /**
     * This represents a PDG Action Item.  It can only be constructed via a database connection, a Profile, and an Action Item Key
     *
     * @param _emf
     * @param _db
     * @param _prof
     * @param _strActionItemKey
     * @throws java.sql.SQLException
     * @throws COM.ibm.opicmpdh.middleware.MiddlewareException
     * @throws COM.ibm.opicmpdh.middleware.MiddlewareRequestException
     */
    public CATCCTOPDG(EANMetaFoundation _emf, Database _db, Profile _prof, String _strActionItemKey) throws SQLException, MiddlewareException, MiddlewareRequestException {
        super(_emf, _db, _prof, _strActionItemKey);
    }

    /**
     * (non-Javadoc)
     * dump
     *
     * @see COM.ibm.eannounce.objects.EANObject#dump(boolean)
     */
    public String dump(boolean _bBrief) {
        StringBuffer strbResult = new StringBuffer();
        strbResult.append("CATCCTOPDG:" + getKey() + ":desc:" + getLongDescription());
        strbResult.append(":purpose:" + getPurpose());
        strbResult.append(":entitytype:" + getEntityType() + "/n");
        return new String(strbResult);
    }

    /**
     * (non-Javadoc)
     * getPurpose
     *
     * @see COM.ibm.eannounce.objects.EANActionItem#getPurpose()
     */
    public String getPurpose() {
        return "CATCCTOPDG";
    }


	private String getCatAudValue(Database _db, Profile _prof, String _strAudience) throws SQLException, MiddlewareException, MiddlewareShutdownInProgressException {
		String strTraceBase = "CATCCTOPDG getCatAudValue method ";

		D.ebug(D.EBUG_SPEW,strTraceBase + " _strAudience: " + _strAudience);
		StringBuffer sbReturn = new StringBuffer();
		StringTokenizer stComma = new StringTokenizer(_strAudience, ",");
		boolean bFirst = true;

		while (stComma.hasMoreTokens()) {
			String strAud = stComma.nextToken();

			String strCatAud = (String)m_audList.get(strAud);
			if (strCatAud == null) {
				String[] aCatAud = m_utility.getFlagCodeForLikedDesc(_db, _prof, ATT_CATAUDIENCE, strAud);
				if (aCatAud == null || aCatAud.length <= 0) {
					strCatAud = "";
				} else {
					strCatAud = aCatAud[0];
				}
				m_audList.put(strAud, strCatAud);
			}

			if (strCatAud != null && strCatAud.length() > 0){
				if (!bFirst) {
					sbReturn.append(",");
				}
				sbReturn.append(strCatAud);
				bFirst = false;

			} else {
				D.ebug(D.EBUG_SPEW,strTraceBase + " unable to find CATAUDIENCE for desc: " + strAud);

			}

		}
		return sbReturn.toString();
	}

    /**
     * (non-Javadoc)
     * checkMissingData
     *
     * @see COM.ibm.eannounce.objects.PDGActionItem#checkMissingData(COM.ibm.opicmpdh.middleware.Database, COM.ibm.opicmpdh.middleware.Profile, boolean)
     */
    public StringBuffer checkMissingData(Database _db, Profile _prof, boolean _bGenData) throws SQLException, MiddlewareException, MiddlewareShutdownInProgressException, SBRException {
        String strTraceBase =  "CATCCTOPDG checkMissingDataForCCTO method ";
        StringBuffer sbReturn = new StringBuffer();

		DatePackage dp = _db.getDates();
		String strNow = dp.getNow();
		String strCurrentDate = strNow.substring(0, 10);
		StringBuffer sb = new StringBuffer();
		String strSai = null;
		//OPICMList audList = new OPICMList();

		//String strDate = m_utility.getDate(strCurrentDate, 15);

		String strFileName = "PDGtemplates/ECCMCATLGPUB01.txt";

		String strGA = m_utility.getAttrValue(m_eiPDG, "GENAREANAME");

		String strXai =  (String) m_xaiList.get("CCTO");
		ExtractActionItem xaiCCTO = new ExtractActionItem(null, _db, _prof, strXai);

		EntityItem[] aei = {m_eiPDG};

		EntityList elCCTO = EntityList.getEntityList(_db, _prof, xaiCCTO, aei);
		EntityGroup egCCTO = elCCTO.getEntityGroup("CCTO");

		if (elCCTO.getParentEntityGroup().getEntityType().equals("CCTO")) {
			egCCTO = elCCTO.getParentEntityGroup();
		}

		EntityItem eiCCTO = egCCTO.getEntityItem(m_eiPDG.getKey());
		D.ebug(D.EBUG_SPEW,strTraceBase + " eiCCTO: " + eiCCTO.getKey());

		String strCCTO_CCOSOLTARGANNDATE = m_utility.getAttrValueDesc(eiCCTO, "CCOSOLTARGANNDATE");
		String strCCOSOLCATALOGNAME = m_utility.getAttrValueDesc(eiCCTO, "CCOSOLCATALOGNAME");
		String strCATNEWOFF = "No";
		OPICMList infoList = new OPICMList();
		infoList.put("PDG", m_eiPDG);
		String strCatAud = getCatAudValue(_db, _prof, strCCOSOLCATALOGNAME);
		D.ebug(D.EBUG_SPEW,strTraceBase + " found strCatAud: " + strCatAud);
		if (strCatAud == null || strCatAud.length() <= 0) {
			return sbReturn;
		}

		// find CATCCTO
		sb = new StringBuffer();
		sb.append("map_GENAREANAME=" +  strGA + ";");
		sb.append("map_CATPNUMB=" +  m_utility.getAttrValue(eiCCTO, "CCOSOLPNUMB") + ";");
		strSai =  (String) m_saiList.get("CATCCTO");
		EntityItem[] aeiCATCCTO = m_utility.dynaSearch(_db, _prof, null, strSai, "CATCCTO", sb.toString());
		if (aeiCATCCTO == null || aeiCATCCTO.length <= 0) {
			// only create CATCCTO
			infoList.put("CCTO", eiCCTO);
			infoList.put("WG", m_eiRoot);
			infoList.put("AUDIENVALUE", strCatAud);

			//If NOW() < CCOSOLTARGANNDATE + 30 days then "Yes" else "No"
			if (strCCTO_CCOSOLTARGANNDATE.length() > 0) {
				int iDC2 = m_utility.dateCompare(strCurrentDate, m_utility.getDate(strCCTO_CCOSOLTARGANNDATE, 30));
				if (iDC2 == PDGUtility.EARLIER) {
					strCATNEWOFF = "Yes";
				}
			}

			infoList.put("CATNEWOFFVALUE", strCATNEWOFF);

			EntityItem[] aeiPR = getParentPR(elCCTO, eiCCTO);
			if (aeiPR != null && aeiPR.length > 0) {
				infoList.put("PR", aeiPR[0]);
			}

			_prof = m_utility.setProfValOnEffOn(_db, _prof);
			TestPDGII pdgObject = new TestPDGII(_db, _prof, eiCCTO, infoList, strFileName );
			StringBuffer sbMissing = pdgObject.getMissingEntities();
			D.ebug(D.EBUG_SPEW,strTraceBase + " creating entity. ");
			generateDataII(_db, _prof, sbMissing, "");
			pdgObject = null;
			infoList = null;
		} else{
			// update attributes CATNEWOFF, PUBFROM, PUBTO, CATLGMKTGDESC, Set CATWORKFLOW to �Change� if updated.
			String strCCOSOLPNUMBDESC = m_utility.getAttrValue(eiCCTO, "CCOSOLPNUMBDESC");
			for (int i = 0; i < aeiCATCCTO.length; i++) {
				OPICMList attL = new OPICMList();
				EntityItem eiCATCCTO = aeiCATCCTO[i];

				String strPrevAudValue = m_utility.getAttrValue(eiCATCCTO, "CATAUDIENCE");
				if (!strPrevAudValue.equals(strCatAud)) {
					attL.put(ATT_CATAUDIENCE, ATT_CATAUDIENCE + "=" + strCatAud);
				}

				if (!m_utility.getAttrValue(eiCATCCTO, ATT_CATNEWOFF).equals(strCATNEWOFF)) {
					attL.put(ATT_CATNEWOFF, ATT_CATNEWOFF + "=" + strCATNEWOFF);
				}

				if (!m_utility.getAttrValue(eiCATCCTO, ATT_PF).equals(strCCTO_CCOSOLTARGANNDATE)) {
					attL.put(ATT_PF, ATT_PF + "=" + strCCTO_CCOSOLTARGANNDATE);
				}

				if (!m_utility.getAttrValue(eiCATCCTO, ATT_CATLGMKTGDESC).equals(strCCOSOLPNUMBDESC)) {
					attL.put(ATT_CATLGMKTGDESC, ATT_CATLGMKTGDESC + "=" + strCCOSOLPNUMBDESC);
				}

				if (attL.size() > 0) {
					String strWorkFlow = m_utility.getAttrValue(eiCATCCTO, "CATWORKFLOW");
					if (strWorkFlow.equals("Override")) {
						attL.put("CATWORKFLOW", "CATWORKFLOW=SalesStatusOverride");
					} else if (strWorkFlow.equals("Accept")) {
						attL.put("CATWORKFLOW", "CATWORKFLOW=Change");
					} else if (strWorkFlow.equals("New")) {
						attL.put("CATWORKFLOW", "CATWORKFLOW=Change");
					}
					_prof = m_utility.setProfValOnEffOn(_db, _prof);
					D.ebug(D.EBUG_SPEW,strTraceBase + " updating entity " + eiCATCCTO.getKey());
					m_utility.updateAttribute(_db, _prof, eiCATCCTO, attL);
				}
			}
		}
		aeiCATCCTO = null;

		elCCTO = null;
		egCCTO = null;
		aei = null;

        return sbReturn;
    }

	private EntityItem[] getParentPR(EntityList _el, EntityItem _ei) {
		//String strTraceBase = "CATCCTOPDG getParentPR method ";
		EANList eiList = new EANList();
		//D.ebug(D.EBUG_SPEW,strTraceBase + " : " + _el.dump(false));
		if (_ei.getEntityType().equals("CCTO")) {
			Vector vCTO = m_utility.getParentEntityIds(_el, _ei.getEntityType(), _ei.getEntityID(), "CTO", "CCTOCTO");

			EntityGroup egPR = _el.getEntityGroup("PR");
			if (_el.getParentEntityGroup().getEntityType().equals("PR")) {
				egPR = _el.getParentEntityGroup();
			}

			//D.ebug(D.EBUG_SPEW,strTraceBase + " vCTO size: " + vCTO.size());

			for (int i =0; i < vCTO.size(); i++) {
				int iCTO = ((Integer)vCTO.elementAt(i)).intValue();
				//D.ebug(D.EBUG_SPEW, strTraceBase + " iCTO: " + iCTO);
				Vector vPR  = m_utility.getParentEntityIds(_el, "CTO", iCTO, "PR", "PRCTO");
				//D.ebug(D.EBUG_SPEW,strTraceBase + " vPR size: " + vPR.size());
				for (int j = 0; j < vPR.size(); j++) {
					int iPR = ((Integer)vPR.elementAt(j)).intValue();
					try {
						EntityItem eiPR = new EntityItem(egPR, null, "PR", iPR);
						eiPR = egPR.getEntityItem(eiPR.getKey());
						if (eiPR != null) {
							eiList.put(eiPR);
						}
					} catch (MiddlewareRequestException ex) {
						ex.printStackTrace();
					}
				}
			}
		} else if (_ei.getEntityType().equals("CSOL")) {
			Vector vOF = m_utility.getParentEntityIds(_el, _ei.getEntityType(), _ei.getEntityID(), "OF", "OFCSOL");

			EntityGroup egPR = _el.getEntityGroup("PR");
			if (_el.getParentEntityGroup().getEntityType().equals("PR")) {
				egPR = _el.getParentEntityGroup();
			}

			//D.ebug(D.EBUG_SPEW,strTraceBase + " vOF size: " + vOF.size());

			for (int i =0; i < vOF.size(); i++) {
				int iOF = ((Integer)vOF.elementAt(i)).intValue();
				//D.ebug(D.EBUG_SPEW, strTraceBase + " iOF: " + iOF);
				Vector vPR  = m_utility.getParentEntityIds(_el, "OF", iOF, "PR", "PROF");
				//D.ebug(D.EBUG_SPEW,strTraceBase + " vPR size: " + vPR.size());
				for (int j = 0; j < vPR.size(); j++) {
					int iPR = ((Integer)vPR.elementAt(j)).intValue();
					try {
						EntityItem eiPR = new EntityItem(egPR, null, "PR", iPR);
						eiPR = egPR.getEntityItem(eiPR.getKey());
						if (eiPR != null) {
							eiList.put(eiPR);
						}
					} catch (MiddlewareRequestException ex) {
						ex.printStackTrace();
					}
				}
			}
		} else if (_ei.getEntityType().equals("CVAR")) {
			Vector vVAR = m_utility.getParentEntityIds(_el, _ei.getEntityType(), _ei.getEntityID(), "VAR", "VARCVAR");

			EntityGroup egPR = _el.getEntityGroup("PR");
			if (_el.getParentEntityGroup().getEntityType().equals("PR")) {
				egPR = _el.getParentEntityGroup();
			}

			//D.ebug(D.EBUG_SPEW,strTraceBase + " vVAR size: " + vVAR.size());

			for (int i =0; i < vVAR.size(); i++) {
				int iVAR = ((Integer)vVAR.elementAt(i)).intValue();
				//D.ebug(D.EBUG_SPEW, strTraceBase + " iVAR: " + iVAR);
				Vector vPR  = m_utility.getParentEntityIds(_el, "VAR", iVAR, "PR", "PRVAR");
				//D.ebug(D.EBUG_SPEW,strTraceBase + " vPR size: " + vPR.size());
				for (int j = 0; j < vPR.size(); j++) {
					int iPR = ((Integer)vPR.elementAt(j)).intValue();
					try {
						EntityItem eiPR = new EntityItem(egPR, null, "PR", iPR);
						eiPR = egPR.getEntityItem(eiPR.getKey());
						if (eiPR != null) {
							eiList.put(eiPR);
						}
					} catch (MiddlewareRequestException ex) {
						ex.printStackTrace();
					}
				}
			}
		}

		EntityItem[] aeiPR = new EntityItem[eiList.size()];
		eiList.copyTo(aeiPR);
		return aeiPR;
	}

	public EntityItem[] getArray(Profile _prof, String[] _asei, int _iStart, int _iEnd) {
		String strTraceBase = "CATCCTOPDG getArray method ";
		System.out.println(strTraceBase + " start: " + _iStart + ", end: " + _iEnd);
		Vector v = new Vector();
		try {
			for (int i= _iStart; i < _iEnd; i++) {
				String strEI = _asei[i];
				StringTokenizer st = new StringTokenizer(strEI, ":");
				if (st.countTokens() == 2) {
					String strEntityType = st.nextToken();
					int iEntityID = Integer.parseInt(st.nextToken().trim());
					EntityItem ei = new EntityItem(null, _prof, strEntityType, iEntityID);
					v.addElement(ei);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		EntityItem[] aeiReturn = new EntityItem[v.size()];
		v.toArray(aeiReturn);
		return aeiReturn;
	}


    /**
     * (non-Javadoc)
     * checkPDGAttribute
     *
     * @see COM.ibm.eannounce.objects.PDGActionItem#checkPDGAttribute(COM.ibm.opicmpdh.middleware.Database, COM.ibm.opicmpdh.middleware.Profile, COM.ibm.eannounce.objects.EntityItem)
     */
    protected void checkPDGAttribute(Database _db, Profile _prof, EntityItem _pdgEI) throws SQLException, MiddlewareRequestException, MiddlewareException, SBRException, MiddlewareShutdownInProgressException {
        for (int i = 0; i < _pdgEI.getAttributeCount(); i++) {
            EANAttribute att = _pdgEI.getAttribute(i);
            //String textAtt = "";
            //String sFlagAtt = "";
            //String sFlagClass = "";
            Vector mFlagAtt = new Vector();

            //int index = -1;
            if (att instanceof EANTextAttribute) {
              //  textAtt = ((String) att.get()).trim();
            } else if (att instanceof EANFlagAttribute) {
                if (att instanceof SingleFlagAttribute || att instanceof StatusAttribute) {
                    MetaFlag[] amf = (MetaFlag[]) att.get();
                    for (int f = 0; f < amf.length; f++) {
                        if (amf[f].isSelected()) {
                //            sFlagAtt = amf[f].getLongDescription().trim();
                  //          sFlagClass = amf[f].getFlagCode().trim();
                    //        index = f;
                            break;
                        }
                    }
                } else if (att instanceof MultiFlagAttribute) {
                    MetaFlag[] amf = (MetaFlag[]) att.get();
                    for (int f = 0; f < amf.length; f++) {
                        if (amf[f].isSelected()) {
                            mFlagAtt.addElement(amf[f].getLongDescription().trim());
                        }
                    }
                }
            }
        }

    }

    /**
     * (non-Javadoc)
     * resetVariables
     *
     * @see COM.ibm.eannounce.objects.PDGActionItem#resetVariables()
     */
    protected void resetVariables() {
        m_eiList = new EANList();
    }

    /**
     * (non-Javadoc)
     * viewMissing
     *
     * @see COM.ibm.eannounce.objects.PDGTemplateActionItem#viewMissing(COM.ibm.opicmpdh.middleware.Database, COM.ibm.opicmpdh.middleware.Profile)
     */
    public byte[] viewMissing(Database _db, Profile _prof) throws SQLException, MiddlewareException, MiddlewareShutdownInProgressException, SBRException {
        return null;
    }


    /**
     * (non-Javadoc)
     * executeAction
     *
     * @see COM.ibm.eannounce.objects.PDGTemplateActionItem#executeAction(COM.ibm.opicmpdh.middleware.Database, COM.ibm.opicmpdh.middleware.Profile)
     */
    public void executeAction(Database _db, Profile _prof) throws SQLException, MiddlewareException, MiddlewareShutdownInProgressException, SBRException {

        //ExtractActionItem eaItem = null;
        //EntityItem[] eiParm = new EntityItem[1];
        //EntityList el = null;
        //EntityGroup eg = null;

        String strTraceBase = " CATCCTOPDG executeAction method ";
        m_SBREx = new SBRException();
        String strData = "";
        resetVariables();
        try {
            _db.debug(D.EBUG_DETAIL, strTraceBase);
            if (m_eiPDG == null) {
                D.ebug(D.EBUG_SPEW,"PDG entity is null");
                return;
            }

            _prof = m_utility.setProfValOnEffOn(_db, _prof);
			// get WG
			EntityGroup egWG = new EntityGroup(null, _db, _prof, "WG", "Edit", false);
			m_eiRoot = new EntityItem(egWG, _prof, _db, _prof.getWGName(), _prof.getWGID());

			EntityGroup egPDG = new EntityGroup(null, _db, _prof, m_eiPDG.getEntityType(), "Edit", false);
			m_eiPDG = new EntityItem(egPDG, _prof, _db, m_eiPDG.getEntityType(), m_eiPDG.getEntityID());

            // validate data
            if (m_SBREx.getErrorCount() > 0) {
                throw m_SBREx;
            }

            m_utility.resetActivities();
            m_sbActivities = new StringBuffer();
            m_sbActivities.append("<PDGACTTIONITEM>" + getLongDescription() + "</PDGACTTIONITEM>");
            strData = checkMissingData(_db, _prof, true).toString();
            m_sbActivities.append(strData);

        } catch (SBRException ex) {
            m_utility.savePDGStatusXML(_db, _prof, m_eiPDG, PDGUtility.STATUS_ERROR, ex.toString(), getLongDescription());
            throw ex;
        }
    }

    /**
     * (non-Javadoc)
     * checkDataAvailability
     *
     * @see COM.ibm.eannounce.objects.PDGActionItem#checkDataAvailability(COM.ibm.opicmpdh.middleware.Database, COM.ibm.opicmpdh.middleware.Profile, COM.ibm.eannounce.objects.EntityItem)
     */
    protected void checkDataAvailability(Database _db, Profile _prof, EntityItem _pdgEI) throws SQLException, MiddlewareException, MiddlewareShutdownInProgressException, SBRException {
    }

}
