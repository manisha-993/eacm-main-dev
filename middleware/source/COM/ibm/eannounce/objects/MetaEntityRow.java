//
// Copyright (c) 2001, International Business Machines Corp., Ltd.
// All Rights Reserved.
// Licensed for use in connection with IBM business only.
//
// $Log: MetaEntityRow.java,v $
// Revision 1.10  2005/03/07 21:10:26  dave
// Jtest cleanup
//
// Revision 1.9  2003/03/14 17:54:18  gregg
// remove remote pdh update method from MetaRow class - instead update using db through remote interface
//
// Revision 1.8  2003/03/12 20:52:49  gregg
// add updatePdhRemote method to ALL MetaRows
//
// Revision 1.7  2002/11/06 22:43:27  gregg
// removing display statements
//
// Revision 1.6  2002/08/23 22:15:20  gregg
// updatePdhMeta method - only throw MiddlewareException
//
// Revision 1.5  2002/04/11 20:09:38  gregg
// free db stmnt
//
// Revision 1.4  2002/03/29 17:30:27  gregg
// made class final
//
// Revision 1.3  2002/03/12 23:23:53  gregg
// we are now updating to database
//
// Revision 1.2  2002/03/07 18:20:18  gregg
// ensure that EANMetaFoundation's key is MetaEntity's pk
//
// Revision 1.1  2002/03/01 18:28:11  gregg
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
* This is a container that holds all the information representing one Row in the MetaEntity Table
*
*/
public final class MetaEntityRow extends MetaRow {

    /**
    * @serial
    */
    static final long serialVersionUID = 1L;

    private String m_strEntityClass = null;
    private String m_strEntityType = null;

    /**
     *  MetaEntityRow
     * 
     * @param _prof
     * @param _strEntType
     * @param _strEntClass
     * @param _strValFrom
     * @param _strValTo
     * @param _strEffFrom
     * @param _strEffTo
     * @param _iTranId
     * @throws COM.ibm.opicmpdh.middleware.MiddlewareRequestException 
     */
    public MetaEntityRow(Profile _prof, String _strEntType, String _strEntClass, String _strValFrom, String _strValTo, String _strEffFrom, String _strEffTo, int _iTranId) throws MiddlewareRequestException {
        super(_prof, _strEntType + _strEntClass + _strValFrom + _strEffFrom + _prof.getEnterprise() //key is MetaEntity's pk
            , _strValFrom, _strValTo, _strEffFrom, _strEffTo, _iTranId);
        setEntityType(_strEntType);
        setEntityClass(_strEntClass);
        return;
    }

    /**
     * Accessor
     *
     * @return String
     */
    public String getEntityType() {
        return m_strEntityType;
    }

    /**
     * Mutator
     *
     * @param _s 
     */
    public void setEntityType(String _s) {
        m_strEntityType = _s;
        return;
    }

    /**
     * Accessor
     *
     * @return String
     */
    public String getEntityClass() {
        return m_strEntityClass;
    }

    /**
     * Mutator
     *
     * @param _s 
     */
    public void setEntityClass(String _s) {
        m_strEntityClass = _s;
        return;
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
        strBuf.append(getEntityType() + ",");
        strBuf.append(getEntityClass() + ",");
        strBuf.append(getValFrom() + ",");
        strBuf.append(getValTo() + ",");
        strBuf.append(getEffFrom() + ",");
        strBuf.append(getEffTo() + ",");
        strBuf.append(getOPWGID() + ",");
        strBuf.append(getTranID() + "]");
        return strBuf.toString();
    }

    /**
     * Update the corresponding row int the PDH
     *
     * @throws COM.ibm.opicmpdh.middleware.MiddlewareException
     * @param _db 
     */
    public void updatePdh(Database _db) throws MiddlewareException {
        try {
            _db.debug(D.EBUG_SPEW, "(UPDATE) MetaEntityRow: " + dump(false));
            _db.callGBL7505(new ReturnStatus(-1), getOPWGID(), getEnterprise(), getEntityType(), getEntityClass(), getTranID(), getEffFrom(), getEffTo());
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
        return "$Id: MetaEntityRow.java,v 1.10 2005/03/07 21:10:26 dave Exp $";
    }

}