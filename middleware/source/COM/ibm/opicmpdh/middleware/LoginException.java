//
// Copyright (c) 2001, International Business Machines Corp., Ltd.
// All Rights Reserved.
// Licensed for use in connection with IBM business only.
//
// $Log: LoginException.java,v $
// Revision 1.7  2001/08/22 16:52:56  roger
// Removed author RM
//
// Revision 1.6  2001/03/26 16:33:21  roger
// Misc formatting clean up
//
// Revision 1.5  2001/03/21 00:01:08  roger
// Implement java class file branding in getVersion method
//
// Revision 1.4  2001/03/16 15:52:20  roger
// Added Log keyword
//

package COM.ibm.opicmpdh.middleware;

/**
 * A class of exceptions used by the login transaction to indicate failure
 * @version @date
 */
public class LoginException extends Exception {

/**
 * Constructs a <code>LoginException</code> with no specified detail message
 */
  public LoginException() {
    super();
  }

/**
 * Constructs a <code>LoginException</code> with the specified detail message
 */
  public LoginException(String s) {
    super(s);
  }

/**
 * Return the date/time this class was generated
 * @return the date/time this class was generated
 */
  public String getVersion() {
    return new String("$Id: LoginException.java,v 1.7 2001/08/22 16:52:56 roger Exp $");
  }
}
