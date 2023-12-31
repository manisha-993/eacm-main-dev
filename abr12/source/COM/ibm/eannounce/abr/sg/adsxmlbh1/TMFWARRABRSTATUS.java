package COM.ibm.eannounce.abr.sg.adsxmlbh1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.CharacterIterator;
import java.text.MessageFormat;
import java.text.StringCharacterIterator;
import java.util.Hashtable;

import com.ibm.transform.oim.eacm.util.PokUtils;

import COM.ibm.eannounce.abr.sg.rfc.ChwYMdmOthWarranty;
import COM.ibm.eannounce.abr.sg.rfc.CommonUtils;
import COM.ibm.eannounce.abr.sg.rfc.RdhBase;
import COM.ibm.eannounce.abr.sg.rfc.TMF_UPDATE;
import COM.ibm.eannounce.abr.sg.rfc.UpdateParkStatus;
import COM.ibm.eannounce.abr.sg.rfc.XMLParse;
import COM.ibm.eannounce.abr.util.EACustom;
import COM.ibm.eannounce.abr.util.PokBaseABR;
import COM.ibm.eannounce.objects.EANList;
import COM.ibm.eannounce.objects.EANMetaAttribute;
import COM.ibm.eannounce.objects.EntityGroup;
import COM.ibm.eannounce.objects.EntityItem;
import COM.ibm.eannounce.objects.ExtractActionItem;
import COM.ibm.opicmpdh.middleware.D;
import COM.ibm.opicmpdh.middleware.MiddlewareException;

public class TMFWARRABRSTATUS extends PokBaseABR {
	private StringBuffer rptSb = new StringBuffer();
	private static final char[] FOOL_JTEST = { '\n' };
	static final String NEWLINE = new String(FOOL_JTEST);
	private int abr_debuglvl = D.EBUG_ERR;
	private String navName = "";
	@SuppressWarnings("rawtypes")
	private Hashtable metaTbl = new Hashtable();
	private String CACEHSQL = "select XMLMESSAGE from cache.XMLIDLCACHE where XMLENTITYTYPE = 'PRODSTRUCT' and XMLENTITYID = ?  and XMLCACHEVALIDTO > current timestamp with ur";
		
	private String FEATURESQL = "SELECT attributevalue FROM OPICM.TEXT WHERE ENTITYTYPE='FEATURE' AND ENTITYID=? and "
			+ " attributecode='MKTGNAME' AND NLSID=1 and valto>current timestamp and effto >current timestamp with ur";
	
	String xml = null;

	

	public String getDescription() {
		return "TMFWARRABRSTATUS";
	}

	public String getABRVersion() {
		return "1.0";
	}

	public void execute_run() {
		String HEADER = "<head>" + EACustom.getMetaTags(getDescription()) + NEWLINE + EACustom.getCSS() + NEWLINE
				+ EACustom.getTitle("{0} {1}") + NEWLINE + "</head>" + NEWLINE + "<body id=\"ibm-com\">"
				+ EACustom.getMastheadDiv() + NEWLINE
				+ "<p class=\"ibm-intro ibm-alternate-three\"><em>{0}: {1}</em></p>" + NEWLINE;
		String HEADER2 = "<table>" + NEWLINE + "<tr><th>Userid: </th><td>{0}</td></tr>" + NEWLINE
				+ "<tr><th>Role: </th><td>{1}</td></tr>" + NEWLINE + "<tr><th>Workgroup: </th><td>{2}</td></tr>"
				+ NEWLINE + "<tr><th>Date: </th><td>{3}</td></tr>" + NEWLINE
				+ "<tr><th>Description: </th><td>{4}</td></tr>" + NEWLINE + "</table>" + NEWLINE + "<!-- {5} -->"
				+ NEWLINE;

		String header1 = "";

		MessageFormat msgf;
		String abrversion = "";
		String rootDesc = "";

		Object[] args = new String[10];

		try {
			msgf = new MessageFormat(HEADER);
			args[0] = getShortClassName(getClass());
			args[1] = "ABR";
			header1 = msgf.format(args);
			setDGTitle("TMFWARRABRSTATUS report");
			setDGString(getABRReturnCode());
			setDGRptName("TMFWARRABRSTATUS"); // Set the report name
			setDGRptClass("TMFWARRABRSTATUS"); // Set the report class
			// Default set to pass
			setReturnCode(PASS);

			start_ABRBuild(false); // pull the VE

			abr_debuglvl = COM.ibm.opicmpdh.middleware.taskmaster.ABRServerProperties
					.getABRDebugLevel(m_abri.getABRCode());

			// get the root entity using current timestamp, need this to get the
			// timestamps or info for VE pulls
			  m_elist = m_db.getEntityList(m_prof,
                    new ExtractActionItem(null, m_db, m_prof,"dummy"),
                    new EntityItem[] { new EntityItem(null, m_prof, getEntityType(), getEntityID()) });
			/*
			 * m_db.getEntityList(m_prof, new ExtractActionItem(null, m_db,
			 * m_prof,"dummy"), new EntityItem[] { new EntityItem(null, m_prof,
			 * getEntityType(), getEntityID()) });
			 */

			EntityItem rootEntity = m_elist.getParentEntityGroup().getEntityItem(0);
			addDebug("*****mlm rootEntity = " + rootEntity.getEntityType() + rootEntity.getEntityID());
			// NAME is navigate attributes - only used if error rpt is generated
			navName = getNavigationName();
			rootDesc = m_elist.getParentEntityGroup().getLongDescription();
			addDebug("navName=" + navName);
			addDebug("rootDesc" + rootDesc);
			Connection connection = m_db.getODSConnection();
			PreparedStatement statement = connection.prepareStatement(CACEHSQL);
			statement.setInt(1, rootEntity.getEntityID());
			ResultSet resultSet = statement.executeQuery();
			
			
			while (resultSet.next()) {
				xml = resultSet.getString("XMLMESSAGE");
			}
			if (xml != null) {
			
				TMF_UPDATE tmf = XMLParse.getObjectFromXml(xml,TMF_UPDATE.class);
				
				String WARRSVCCOVR = tmf.getWARRSVCCOVR();
				if(!"Warranty".equalsIgnoreCase(WARRSVCCOVR)) {
					addOutput("WARRSVCCOVR value is not Warranty, so nothing to promote.");
				}else {
					//step1  Call ChwYMdmOthWarranty to populate iERP custom tables with warranty master data by setting the input parameter for ZYTMDMOTHWARRMOD structure
					//call ChwYMdmOthWarranty	
					String attributevalue = getAttributevalue(FEATURESQL,tmf.getFEATUREENTITYID());
					ChwYMdmOthWarranty chwYMdmOthWarranty = new ChwYMdmOthWarranty(tmf,attributevalue);
					if(chwYMdmOthWarranty.getZYTMDMOTHWARRTMF_LIST().size()>0) {
						this.runRfcCaller(chwYMdmOthWarranty);
						UpdateParkStatus updateParkStatus = new UpdateParkStatus("MD_CHW_IERP", tmf.getMACHTYPE()+tmf.getFEATURECODE());
						this.addDebug("Calling "+updateParkStatus.getRFCName());
						updateParkStatus.execute();
						this.addDebug(updateParkStatus.createLogEntry());
						if (updateParkStatus.getRfcrc() == 0) {
							this.addOutput("Parking records updated successfully for ZDMRELNUM="+ tmf.getMACHTYPE()+tmf.getFEATURECODE());
						} else {
							this.addOutput(updateParkStatus.getRFCName() + " called faild!");
							this.addOutput(updateParkStatus.getError_text());
						}
					}else {
						addOutput("No warranty linked to the TMF, so nothing to promote.");
					}
				}
				
				
				
			}	
		} catch (Exception e) {
			e.printStackTrace();
			// println(e.toString());
			setReturnCode(FAIL);
			java.io.StringWriter exBuf = new java.io.StringWriter();
			String Error_EXCEPTION = "<h3><span style=\"color:#c00; font-weight:bold;\">Error: {0}</span></h3>";
			String Error_STACKTRACE = "<pre>{0}</pre>";
			msgf = new MessageFormat(Error_EXCEPTION);
			setReturnCode(INTERNAL_ERROR);
			e.printStackTrace(new java.io.PrintWriter(exBuf));
			// Put exception into document
			args[0] = e.getMessage();
			rptSb.append(convertToTag(msgf.format(args)) + NEWLINE);
			msgf = new MessageFormat(Error_STACKTRACE);
			args[0] = exBuf.getBuffer().toString();
			rptSb.append(convertToTag(msgf.format(args)) + NEWLINE);
			logError("Exception: " + e.getMessage());
			logError(exBuf.getBuffer().toString());
			// was an error make sure user gets report
			setCreateDGEntity(true);
			
			// sentFile=exeFtpShell(ffPathName);
		} finally {
			StringBuffer sb = new StringBuffer();
			msgf = new MessageFormat(HEADER2);
			args[0] = m_prof.getOPName();
			args[1] = m_prof.getRoleDescription();
			args[2] = m_prof.getWGName();
			args[3] = getNow();
			args[4] = sb.toString();
			args[5] = abrversion + " " + getABRVersion();
			rptSb.insert(0, convertToHTML(xml)+NEW_LINE);
			rptSb.insert(0, header1 + msgf.format(args) + NEWLINE);

			println(EACustom.getDocTypeHtml()); // Output the doctype and html
			println(rptSb.toString()); // Output the Report
			printDGSubmitString();
			 if(!isReadOnly()) {
	                clearSoftLock();
	            }
			println(EACustom.getTOUDiv());
			buildReportFooter(); // Print </html>
		}
	}

	


	

	/*
	 * Get Name based on navigation attributes for root entity
	 *
	 * @return java.lang.String
	 */
	private String getNavigationName() throws java.sql.SQLException, MiddlewareException {
		return getNavigationName(m_elist.getParentEntityGroup().getEntityItem(0));
	}

	/**********************************************************************************
	 * Get Name based on navigation attributes for specified entity
	 *
	 * @return java.lang.String
	 */ 
	@SuppressWarnings("unchecked")
	private String getNavigationName(EntityItem theItem) throws java.sql.SQLException, MiddlewareException {
		StringBuffer navName = new StringBuffer();
		// NAME is navigate attributes
		// check hashtable to see if we already got this meta
		EANList metaList = (EANList) metaTbl.get(theItem.getEntityType());
		if (metaList == null) {
			EntityGroup eg = new EntityGroup(null, m_db, m_prof, theItem.getEntityType(), "Navigate");
			metaList = eg.getMetaAttribute(); // iterator does not maintain
												// navigate order
			metaTbl.put(theItem.getEntityType(), metaList);
		}
		for (int ii = 0; ii < metaList.size(); ii++) {
			EANMetaAttribute ma = (EANMetaAttribute) metaList.getAt(ii);
			navName.append(PokUtils.getAttributeValue(theItem, ma.getAttributeCode(), ", ", "", false));
			if (ii + 1 < metaList.size()) {
				navName.append(" ");
			}
		}
		return navName.toString();
	}
	
	 /********************************************************************************
     * Convert string into valid html.  Special HTML characters are converted.
     *
     * @param txt    String to convert
     * @return String
     */
    protected static String convertToHTML(String txt)
    {
        String retVal="";
        StringBuffer htmlSB = new StringBuffer();
        StringCharacterIterator sci = null;
        char ch = ' ';
        if (txt != null) {
            sci = new StringCharacterIterator(txt);
            ch = sci.first();
            while(ch != CharacterIterator.DONE)
            {
                switch(ch)
                {
                case '<':
                    htmlSB.append("&lt;");
                break;
                case '>':
                    htmlSB.append("&gt;");
                    break;
                case '"':
                    // double quotation marks could be saved as &quot; also. this will be &#34;
                    // this should be included too, but left out to be consistent with west coast
                    htmlSB.append("&quot;");
                    break;
                case '\'':
                    //IE6 doesn't support &apos; to convert single quotation marks,we can use &#39; instead
                    htmlSB.append("&#"+((int)ch)+";");
                    break;
                    //case '&': 
                    // ignore entity references such as &lt; if user typed it, user will see it
                    // could be saved as &amp; also. this will be &#38;
                    //htmlSB.append("&#"+((int)ch)+";");
                    //  htmlSB.append("&amp;");
                    //    break;
                default:
                    htmlSB.append(ch);
                break;
                }
                ch = sci.next();
            }
            retVal = htmlSB.toString();
        }

        return retVal;
    }
    
    /********************************************************************************
     * Convert string into valid html.  Special HTML characters are converted.
     *
     * @param txt    String to convert
     * @return String
     */
    protected static String convertToTag(String txt)
    {
        String retVal="";
        StringBuffer htmlSB = new StringBuffer();
        StringCharacterIterator sci = null;
        char ch = ' ';
        if (txt != null) {
            sci = new StringCharacterIterator(txt);
            ch = sci.first();
            while(ch != CharacterIterator.DONE)
            {
                switch(ch)
                {
                case '<':
                    htmlSB.append("&lt;");
                break;
                case '>':
                    htmlSB.append("&gt;");
                    break;
                default:
                    htmlSB.append(ch);
                break;
                }
                ch = sci.next();
            }
            retVal = htmlSB.toString();
        }

        return retVal;
    }
    
	 protected void addOutput(String msg) { rptSb.append("<p>"+msg+"</p>"+NEWLINE);}
	 
	 protected void addMsg(StringBuffer msg) { rptSb.append(msg.toString()+NEWLINE);}


		/**********************************
	     * add debug info as html comment
	     *    EBUG_ERR = 0;
	          EBUG_WARN = 1;
	          EBUG_INFO = 2;
	          EBUG_DETAIL = 3;
	          EBUG_SPEW = 4
	     */
	   
	protected void addDebug(String msg) {
		if (D.EBUG_DETAIL <= abr_debuglvl) {
		rptSb.append("<!-- " + msg + " -->" + NEWLINE);
		}
	}
	 /**********************************
     * add error info and fail abr
     */
    protected void addError(String msg) {
        addOutput(msg);
        setReturnCode(FAIL);
    }
    
    protected void runRfcCaller(RdhBase caller) throws Exception {
		this.addDebug("Calling " + caller.getRFCName());
		caller.execute();
		this.addDebug(caller.createLogEntry());
		if (caller.getRfcrc() == 0) {
			this.addOutput(caller.getRFCName() + " called successfully!");
		} else {
			this.addOutput(caller.getRFCName() + " called  faild!");
			this.addOutput(caller.getError_text());
		}
	}
    
    public String getAttributevalue(String sql,String entityid) {
    	String attributevalue = "";
    	try {
			Connection connection = m_db.getPDHConnection();
			Object[] params = new String[1]; 
			params[0] =entityid;			
			String realSql = CommonUtils.getPreparedSQL(sql, params);
			this.addDebug("querySql=" + realSql);
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, entityid);
			
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				attributevalue = resultSet.getString("attributevalue");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (MiddlewareException e) {
			e.printStackTrace();
		}    	
    	return attributevalue;
    	
    }
    
   
	
}
