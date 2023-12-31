// Licensed Materials -- Property of IBM
//
// (C) Copyright IBM Corp. 2008  All Rights Reserved.
// The source code for this program is not published or otherwise divested of
// its trade secrets, irrespective of what has been deposited with the U.S. Copyright office.
//
package COM.ibm.eannounce.abr.sg;

import COM.ibm.eannounce.abr.util.*;

/**********************************************************************************
*
*
1	<FCTRANSACTION_UPDATE>					1	FCTRANSACTION
1	<PDHDOMAIN>	</PDHDOMAIN>				2	FCTRANSACTION	PDHDOMAIN
1	<DTSOFMSG>	</DTSOFMSG>					2	FCTRANSACTION	ABR Queued
1	<ACTIVITY>	</ACTIVITY>					2	FCTRANSACTION	Activity
1	<FEATURECONVERSIONENTITYTYPE>	</FEATURECONVERSIONENTITYTYPE>	2	FCTRANSACTION	ENTITYTYPE
1	<FEATURECONVERSIONENTITYID>	</FEATURECONVERSIONENTITYID>	2	FCTRANSACTION	ENTITYID
1	<FROMMACHTYPE>	</FROMMACHTYPE>			2	FCTRANSACTION	FROMMACHTYPE
1	<FROMMODEL>	</FROMMODEL>				2	FCTRANSACTION	FROMMODEL
1	<FROMMODELENTITYID>	</FROMMODELENTITYID>	2	MODEL	entityid
1	<FROMFEATURECODE>	</FROMFEATURECODE>	2	FCTRANSACTION	FROMFEATURECODE
1	<FROMFEATUREENTITYID>	</FROMFEATUREENTITYID>	2	FEATURE	entityid
1	<TOMACHTYPE>	</TOMACHTYPE>			2	FCTRANSACTION	TOMACHTYPE
1	<TOMODEL>	</TOMODEL>					2	FCTRANSACTION	TOMODEL
1	<TOMODELENTITYID>	</TOMODELENTITYID>	2	FCTRANSACTION	entityid
1	<TOFEATURECODE>	</TOFEATURECODE>		2	FCTRANSACTION	TOFEATURECODE
1	<TOFEATUREENTITYID>	</TOFEATUREENTITYID>	2	FCTRANSACTION	entityid
1	<STATUS>	</STATUS>					2	FCTRANSACTION	STATUS
1	<BOXSWAPREQUIREDFORUPGRADES>	</BOXSWAPREQUIREDFORUPGRADES>	2	FCTRANSACTION	BOXSWAP
1	<CUSTOMERSETUP>	</CUSTOMERSETUP>		2	FCTRANSACTION	INSTALL
1	<FEATURETRANSACTIONCATEGORY>	</FEATURETRANSACTIONCATEGORY>	2	FCTRANSACTION	FTCAT
1	<FEATURETRANSACTIONSUBCATEGORY>	</FEATURETRANSACTIONSUBCATEGORY>	2	FCTRANSACTION	FTSUBCAT
1	<INSTALLABILITY>	</INSTALLABILITY>	2	FCTRANSACTION	INSTALLABILITY
1	<INTERNALNOTES>	</INTERNALNOTES>		2	FCTRANSACTION	INTERNALNOTES
1	<PARTSSHIPPEDINDICATOR>	</PARTSSHIPPEDINDICATOR>	2	FCTRANSACTION	PARTSSHIPPED
1	<QUANTITY>	</QUANTITY>	2	FCTRANSACTION	TRANSACTQTY
1	<REMOVEQUANTITY>	</REMOVEQUANTITY>	2	FCTRANSACTION	TRANSACTREMOVEQTY
1	<RETURNEDPARTSMES>	</RETURNEDPARTSMES>	2	FCTRANSACTION	RETURNEDPARTS
1	<UPGRADETYPE>	</UPGRADETYPE>			2	FCTRANSACTION	UPGRADETYPE
1	<ZEROPRICEDINDICATOR>	</ZEROPRICEDINDICATOR>	2	FCTRANSACTION	ZEROPRICE
1	<COUNTRYLIST>							2	AVAIL
0..N	<COUNTRYELEMENT>					3
1	<COUNTRYACTION>	</COUNTRYACTION>		4	AVAIL	CountryAction
1	<COUNTRY>	</COUNTRY>					4	AVAIL	COUNTRYLIST
1	<STATUS>	</STATUS>					4	AVAIL	STATUS	Flag Description Class
1	<PUBFROM>	</PUBFROM>					4	AVAIL	PubFrom
1	<PUBTO>	</PUBTO>						4	AVAIL	PubTo
		</COUNTRYELEMENT>					3
		</COUNTRYLIST>						2
		</FCTRANSACTION_UPDATE>				1

*/
// ADSFCTRANSABR.java,v
// Revision 1.2  2008/05/28 13:46:08  wendy
// updates for spec "SG FS ABR ADS System Feed 20080528c.doc"
//
// Revision 1.1  2008/04/29 14:31:38  wendy
// Init for
//  -   CQ00003539-WI -  BHC 3.0 Support - Feed of ZIPSRSS product info to BHC
//  -   CQ00005096-WI -  BHC 3.0 Support - Feed of ZIPSRSS product info to BHC - Add Category MM and Images
//  -   CQ00005046-WI -  BHC 3.0 Support - Feed of ZIPSRSS product info to BHC - Support CRAD in BHC
//  -   CQ00005045-WI -  BHC 3.0 Support - Feed of ZIPSRSS product info to BHC - Upgrade/Conversion Support
//  -   CQ00006862-WI  - BHC 3.0 Support - Support for Services Data UI
//
//
public class ADSFCTRANSABR extends XMLMQRoot
{
    private static final XMLElem XMLMAP;

    static {
        XMLMAP = new XMLGroupElem("FCTRANSACTION_UPDATE");
         // level2
        XMLMAP.addChild(new XMLElem("PDHDOMAIN","PDHDOMAIN"));
        XMLMAP.addChild(new XMLNotificationElem("DTSOFMSG")); // pull from profile.endofday
        XMLMAP.addChild(new XMLActivityElem("ACTIVITY"));
        XMLMAP.addChild(new XMLElem("FEATURECONVERSIONENTITYTYPE","ENTITYTYPE"));
        XMLMAP.addChild(new XMLElem("FEATURECONVERSIONENTITYID","ENTITYID"));
        XMLMAP.addChild(new XMLElem("FROMMACHTYPE","FROMMACHTYPE"));
        XMLMAP.addChild(new XMLElem("FROMMODEL","FROMMODEL"));
        XMLMAP.addChild(new XMLElem("FROMFEATURECODE","FROMFEATURECODE"));

/*D.  <FROMMODELENTITYID> and <FROMFEATUREENTITYID>

Search for PRODSTRUCT using
<FROMMACHTYPE>
<FROMMODEL>
<FROMFEATURECODE>
then FROMMODELENTITYID = PRODSTRUCT.ENTITY2ID and FROMFEATUREENTITYID = PRODSTRUCT.ENTITY1ID
*/
		XMLRelatorSearchElem srchElem = new XMLRelatorSearchElem("FROMMODELENTITYID", "FROMFEATUREENTITYID", "SRDPRODSTRUCT33", "PRODSTRUCT");
		srchElem.addSearchAttr("FROMMACHTYPE", "MODEL:MACHTYPEATR");
		srchElem.addSearchAttr("FROMMODEL", "MODEL:MODELATR");
		srchElem.addSearchAttr("FROMFEATURECODE", "FEATURE:FEATURECODE");
		XMLMAP.addChild(srchElem);


        XMLMAP.addChild(new XMLElem("TOMACHTYPE","TOMACHTYPE"));
        XMLMAP.addChild(new XMLElem("TOMODEL","TOMODEL"));
        XMLMAP.addChild(new XMLElem("TOFEATURECODE","TOFEATURECODE"));

/*E.  <TOMODELENTITYID> and <TOFEATUREENTITYID>

Search for PRODSTRUCT using
<TOMACHTYPE>
<TOMODEL>
<TOFEATURECODE>
then TOMODELENTITYID = PRODSTRUCT.ENTITY2ID and TOFEATUREENTITYID = PRODSTRUCT.ENTITY1ID
*/
		srchElem = new XMLRelatorSearchElem("TOMODELENTITYID", "TOFEATUREENTITYID", "SRDPRODSTRUCT33", "PRODSTRUCT");
		srchElem.addSearchAttr("TOMACHTYPE", "MODEL:MACHTYPEATR");
		srchElem.addSearchAttr("TOMODEL", "MODEL:MODELATR");
		srchElem.addSearchAttr("TOFEATURECODE", "FEATURE:FEATURECODE");
		XMLMAP.addChild(srchElem);

        XMLMAP.addChild(new XMLElem("STATUS","STATUS",XMLElem.FLAGVAL));
        XMLMAP.addChild(new XMLElem("BOXSWAPREQUIREDFORUPGRADES","BOXSWAP"));
        XMLMAP.addChild(new XMLElem("CUSTOMERSETUP","INSTALL"));
        XMLMAP.addChild(new XMLElem("FEATURETRANSACTIONCATEGORY","FTCAT"));
        XMLMAP.addChild(new XMLElem("FEATURETRANSACTIONSUBCATEGORY","FTSUBCAT"));
        XMLMAP.addChild(new XMLElem("INSTALLABILITY","INSTALLABILITY"));
        XMLMAP.addChild(new XMLElem("INTERNALNOTES","INTERNALNOTES"));
        XMLMAP.addChild(new XMLElem("PARTSSHIPPEDINDICATOR","PARTSSHIPPED"));
        XMLMAP.addChild(new XMLElem("QUANTITY","TRANSACTQTY"));
        XMLMAP.addChild(new XMLElem("REMOVEQUANTITY","TRANSACTREMOVEQTY"));
        XMLMAP.addChild(new XMLElem("RETURNEDPARTSMES","RETURNEDPARTS"));
        XMLMAP.addChild(new XMLElem("UPGRADETYPE","UPGRADETYPE"));
        XMLMAP.addChild(new XMLElem("ZEROPRICEDINDICATOR","ZEROPRICE"));
		XMLElem list = new XMLElem("COUNTRYLIST");
		XMLMAP.addChild(list);
		list.addChild(new XMLCtryElem());
    }

    /**********************************
    * get xml object mapping
    */
    public XMLElem getXMLMap() {
        return XMLMAP;
    }

    /**********************************
    * get the name of the VE to use
    */
    public String getVeName() { return "ADSFCTRANSACTION";}

    /**********************************
    * get the status attribute to use for this ABR
    */
    public String getStatusAttr() { return "STATUS";}

    /**********************************
    *
	A.	MQ-Series CID
    */
    public String getMQCID() { return "FCTRANSACTION"; }

    /***********************************************
    *  Get the version
    *
    *@return java.lang.String
    */
    public String getVersion()
    {
        return "1.2";
    }
}
