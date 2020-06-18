//
// Copyright (c) 2001, International Business Machines Corp., Ltd.
// All Rights Reserved.
// Licensed for use in connection with IBM business only.
//
// $Log: SingleFlagAttribute.java,v $
// Revision 1.3  2008/02/01 22:10:08  wendy
// Cleanup RSA warnings
//
// Revision 1.2  2002/02/12 22:06:27  dave
// more fixes to syntax
//
// Revision 1.1  2002/02/12 21:54:45  dave
// more attribute objects
//
//

package COM.ibm.eannounce.objects;

import COM.ibm.opicmpdh.middleware.Profile;
import COM.ibm.opicmpdh.middleware.MiddlewareRequestException;

/**
*/
public class SingleFlagAttribute extends EANFlagAttribute{

  // Instance variables
  /**
  * @serial
  */
  static final long serialVersionUID = 1L;

  public String getVersion() {
    return new String("$Id: SingleFlagAttribute.java,v 1.3 2008/02/01 22:10:08 wendy Exp $");
  }
	
  /**
  * Main method which performs a simple test of this class
  */
  public static void main(String arg[]) {
  }

	/**
	* Manages EANTextAttributes in the e-announce data model
	*/
	public SingleFlagAttribute(EANDataFoundation _edf, Profile _prof, MetaSingleFlagAttribute _msfa) throws MiddlewareRequestException {
		super(_edf, _prof, _msfa);
  }
  
}
