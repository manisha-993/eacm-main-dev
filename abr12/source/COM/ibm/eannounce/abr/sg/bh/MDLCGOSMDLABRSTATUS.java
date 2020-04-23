// Licensed Materials -- Property of IBM
//
// (C) Copyright IBM Corp. 2007  All Rights Reserved.
// The source code for this program is not published or otherwise divested of
// its trade secrets, irrespective of what has been deposited with the U.S. Copyright office.
//
/**
MDLCGOSMDLABRSTATUS_class=COM.ibm.eannounce.abr.sg.MDLCGOSMDLABRSTATUS
MDLCGOSMDLABRSTATUS_enabled=true
MDLCGOSMDLABRSTATUS_idler_class=A
MDLCGOSMDLABRSTATUS_keepfile=true
MDLCGOSMDLABRSTATUS_read_only=true
MDLCGOSMDLABRSTATUS_report_type=DGTYPE01
MDLCGOSMDLABRSTATUS_vename=dummy

 *
 * MDLCGOSMDLABRSTATUS.java,v
 * Revision 1.2  2011/01/13 17:01:31  wendy
 * get queued value from properties file
 *
 * Revision 1.1  2007/09/14 17:35:57  wendy
 * New GX ABRs
 *
 */
package COM.ibm.eannounce.abr.sg.bh;

import COM.ibm.eannounce.objects.*;

//$Log: MDLCGOSMDLABRSTATUS.java,v $
//Revision 1.2  2011/02/10 12:59:55  lucasrg
//Added CVS Log annotation
//

/**********************************************************************************
* MDLCGOSMDLABRSTATUS class
*
* From "SG FS ABR Data Quality 20070911.doc"
*A.	STATUS = Draft | Change Request
*
*Criteria = None
*
*B.	STATUS = Ready for Review
*
*None
*
*C.	STATUS changed to Ready for Review
*
*1.	Set COMPATGENABR = 0020 (Queued)
*
*D.	STATUS changed to Final
*
*1.	Set COMPATGENABR = 0020 (Queued)
*
*
*/
public class MDLCGOSMDLABRSTATUS extends DQABRSTATUS
{

	/**********************************
	* nothing needed
	*/
	protected boolean isVEneeded(String statusFlag) {
		return false;
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

	/**********************************
	* complete abr processing after status moved to final; (status was r4r)
	*/
	protected void completeNowFinalProcessing() throws
        java.sql.SQLException,
        COM.ibm.opicmpdh.middleware.MiddlewareException,
        COM.ibm.opicmpdh.middleware.MiddlewareRequestException
	{
		setFlagValue(m_elist.getProfile(),"COMPATGENABR", getQueuedValue("COMPATGENABR"));
	}

	/**********************************
	* complete abr processing after status moved to readyForReview; (status was chgreq)
	*/
	protected void completeNowR4RProcessing()throws
        java.sql.SQLException,
        COM.ibm.opicmpdh.middleware.MiddlewareException,
        COM.ibm.opicmpdh.middleware.MiddlewareRequestException
	{
		setFlagValue(m_elist.getProfile(),"COMPATGENABR", getRFRQueuedValue("COMPATGENABR"));
	}

    /***********************************************
    *  Get ABR description
    *
    *@return java.lang.String
    */
    public String getDescription()
    {
        String desc =  "MDLCGOSMDLABRSTATUS ABR.";

        return desc;
    }

    /***********************************************
    *  Get the version
    *
    *@return java.lang.String
    */
    public String getABRVersion()
    {
        return "1.2";
    }
}