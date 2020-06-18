//
// Copyright (c) 2001, International Business Machines Corp., Ltd.
// All Rights Reserved.
// Licensed for use in connection with IBM business only.
//
// $Log: MetaHelpRow.java,v $
// Revision 1.8  2005/03/08 23:15:46  dave
// Jtest checkins from today and last ngith
//
// Revision 1.7  2003/03/14 17:54:17  gregg
// remove remote pdh update method from MetaRow class - instead update using db through remote interface
//
// Revision 1.6  2003/03/12 20:52:49  gregg
// add updatePdhRemote method to ALL MetaRows
//
// Revision 1.5  2002/11/06 22:43:27  gregg
// removing display statements
//
// Revision 1.4  2002/08/23 22:28:06  gregg
// updatePdh throws MiddlewareException only
//
// Revision 1.3  2002/04/11 20:11:12  gregg
// free db stmt
//
// Revision 1.2  2002/03/29 17:30:27  gregg
// made class final
//
// Revision 1.1  2002/03/14 19:39:37  gregg
// initial load
//
//

package COM.ibm.eannounce.objects;

import COM.ibm.opicmpdh.middleware.Profile;
import COM.ibm.opicmpdh.middleware.Database;
import COM.ibm.opicmpdh.middleware.D;
import COM.ibm.opicmpdh.middleware.MiddlewareException;
import COM.ibm.opicmpdh.middleware.MiddlewareRequestException;
import COM.ibm.opicmpdh.middleware.ReturnStatus;

/**
* This is a container that holds all the information representing one Row in the MetaHelp Table
*
*/
public final class MetaHelpRow extends MetaRow {

    /**
    * @serial
    */
    static final long serialVersionUID = 1L;

    private String m_strAttributeCode = null;
    private int m_iNLSID = 1;

    /**
     * MetaHelpRow
     *  
     * @param _prof
     * @param _strAttCode
     * @param _iNLSID
     * @param _strValFrom
     * @param _strValTo
     * @param _strEffFrom
     * @param _strEffTo
     * @param _iTranId
     * @param _strHelpValue
     * @throws COM.ibm.opicmpdh.middleware.MiddlewareRequestException 
     */
    public MetaHelpRow(Profile _prof, String _strAttCode, int _iNLSID, String _strValFrom, String _strValTo, String _strEffFrom, String _strEffTo, int _iTranId, String _strHelpValue) throws MiddlewareRequestException {
        super(_prof, _strAttCode + _prof.getEnterprise() + _iNLSID + _strValFrom + _strEffFrom //key is MetaHelp's pk
            , _strValFrom, _strValTo, _strEffFrom, _strEffTo, _iTranId);
        setAttributeCode(_strAttCode);
        setNLSID(_iNLSID);
        setHelpValue(_strHelpValue);
        return;
    }

    /**
     * Accessor
     *
     * @return String
     */
    public String getAttributeCode() {
        return m_strAttributeCode;
    }

    /**
     * Mutator
     *
     * @param _s 
     */
    public void setAttributeCode(String _s) {
        m_strAttributeCode = _s;
        return;
    }

    /**
     * Mutator
     *
     * @param _s 
     */
    public void setHelpValue(String _s) {
        putLongDescription(getNLSID(), _s);
        return;
    }

    /**
     * Accessor
     *
     * @return String
     */
    public String getHelpValue() {
        return getLongDescription();
    }

    /**
     * Mutator
     *
     * @param _i 
     */
    public void setNLSID(int _i) {
        m_iNLSID = _i;
    }

    /**
     * Accessor
     *
     * @return int
     */
    public int getNLSID() {
        return m_iNLSID;
    }

    /**
     * (non-Javadoc)
     * dump
     *
     * @see COM.ibm.eannounce.objects.EANObject#dump(boolean)
     */
    public String dump(boolean _brief) {
        StringBuffer strBuf = new StringBuffer("[");
        strBuf.append(getEnterprise() + ",");
        strBuf.append(getAttributeCode() + ",");
        strBuf.append(getNLSID() + ",");
        strBuf.append(getValFrom() + ",");
        strBuf.append(getValTo() + ",");
        strBuf.append(getEffFrom() + ",");
        strBuf.append(getEffTo() + ",");
        strBuf.append(getOPWGID() + ",");
        strBuf.append(getTranID() + ",");
        strBuf.append(getHelpValue() + "]");
        return strBuf.toString();
    }

    /**
     * Update the corresponding row int the PDH
     *
     * @param _db
     * @throws COM.ibm.opicmpdh.middleware.MiddlewareException 
     */
    public void updatePdh(Database _db) throws MiddlewareException {
        try {
            _db.debug(D.EBUG_SPEW, "(UPDATE) MetaHelpRow: " + dump(false));
            _db.callGBL7512(new ReturnStatus(-1), getOPWGID(), getEnterprise(), getAttributeCode(), getNLSID(), getHelpValue(), getTranID(), getEffFrom(), getEffTo());
            _db.freeStatement();
            _db.isPending();
        } finally {
            _db.freeStatement();
            _db.isPending();
        }
        return;
    }

    /**
     * Get the version Id - generated by CVS
     *
     * @return String
     */
    public String getVersion() {
        return "$Id: MetaHelpRow.java,v 1.8 2005/03/08 23:15:46 dave Exp $";
    }

}
