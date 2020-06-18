//
// Copyright (c) 2001, International Business Machines Corp., Ltd.
// All Rights Reserved.
// Licensed for use in connection with IBM business only.
//
// $Log: XMLAttribute.java,v $
// Revision 1.2  2008/01/31 22:56:01  wendy
// Cleanup RSA warnings
//
// Revision 1.1  2002/04/17 20:46:37  dave
// added .java to XMLattribute file name
//
// Revision 1.1  2002/04/17 20:17:06  dave
// new XMLAttribute and its MetaPartner
//
//
//

package COM.ibm.eannounce.objects;

import COM.ibm.opicmpdh.middleware.Profile;
import COM.ibm.opicmpdh.middleware.MiddlewareRequestException;

/**
*/
public class XMLAttribute extends EANTextAttribute{

  // Instance variables
  /**
  * @serial
  */
  static final long serialVersionUID = 1L;

  public String getVersion() {
    return new String("$Id: XMLAttribute.java,v 1.2 2008/01/31 22:56:01 wendy Exp $");
  }
	
  /**
  * Main method which performs a simple test of this class
  */
  public static void main(String arg[]) {
  }

	/**
	* Manages XMLAttribute in the e-announce data model
	*/
	public XMLAttribute(EANDataFoundation _edf, Profile _prof, MetaXMLAttribute _mxa) throws MiddlewareRequestException {
		super(_edf, _prof, _mxa);
  }
  
}
