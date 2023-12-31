//Licensed Materials -- Property of IBM
//
// (C) Copyright IBM Corp. 2010  All Rights Reserved.
// The source code for this program is not published or otherwise divested of
// its trade secrets, irrespective of what has been deposited with the U.S. Copyright office.
//
package COM.ibm.eannounce.abr.sg.bh;

import COM.ibm.eannounce.objects.*;

/**********************************************************************************
 SVCFCABRSTATUS_class=COM.ibm.eannounce.abr.sg.bh.SVCFCABRSTATUS
 SVCFCABRSTATUS_enabled=true
 SVCFCABRSTATUS_idler_class=A
 SVCFCABRSTATUS_keepfile=true
 SVCFCABRSTATUS_vename=DQVESVCFC
*/
//$Log: SVCFCABRSTATUS.java,v $
//Revision 1.7  2018/02/12 13:08:38  wangyul
//Story 1799258 GBS product structure support for Features
//
//Revision 1.5  2018/02/08 12:33:06  wangyul
//Story 1799258 GBS product structure support for Features
//
public class SVCFCABRSTATUS extends DQABRSTATUS
{

	/**********************************
	* nothing needed
	*/
	protected boolean isVEneeded(String statusFlag) {
		return true;
	}

	/**********************************
	 * complete abr processing after status moved to readyForReview; (status was chgreq)
	 * C.	Status changed to Ready for Review
	 */
	protected void completeNowR4RProcessing() throws
	java.sql.SQLException,
	COM.ibm.opicmpdh.middleware.MiddlewareException,
	COM.ibm.opicmpdh.middleware.MiddlewareRequestException
	{
		//setFlagValue(m_elist.getProfile(),"ADSABRSTATUS", getRFRQueuedValue("ADSABRSTATUS"));
	}

	/**********************************
	 * complete abr processing after status moved to final; (status was r4r)
	 *D. STATUS changed to Final
	 *
	 */
	protected void completeNowFinalProcessing() throws
	java.sql.SQLException,
	COM.ibm.opicmpdh.middleware.MiddlewareException,
	COM.ibm.opicmpdh.middleware.MiddlewareRequestException
	{
		addDebug(" status now final");
		// Set ADSABRSTATUS of all SVCMODs when status=final
		EntityGroup psGrp = m_elist.getEntityGroup("SVCPRODSTRUCT");
		addDebug("completeNowFinalProcessing SVCPRODSTRUCT count=" + psGrp.getEntityItemCount());
		for(int p = 0; p < psGrp.getEntityItemCount(); p++) {
			EntityItem psitem = psGrp.getEntityItem(p);
			EntityItem mdlItem = getDownLinkEntityItem(psitem, "SVCMOD");
			setFlagValue(m_elist.getProfile(),"ADSABRSTATUS", getQueuedValue("ADSABRSTATUS"), mdlItem);
		}
	}

	/**********************************
	* Note the ABR is only called when
	* DATAQUALITY transitions from 'Draft to Ready for Review',
	*	'Change Request to Ready for Review' and from 'Ready for Review to Final'
	*/
    protected void doDQChecking(EntityItem rootEntity, String statusFlag) throws Exception
    {
        addDebug("No checking required");
    }

    /***********************************************
    *  Get ABR description
    *
    *@return java.lang.String
    */
    public String getDescription()
    {
        String desc =  "SVCFEATURE ABR.";
        return desc;
    }

    /***********************************************
    *  Get the version
    *
    *@return java.lang.String
    */
    public String getABRVersion()
    {
        return "$Revision: 1.7 $";
    }
}
