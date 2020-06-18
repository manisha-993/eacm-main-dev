//
// TEMPLATE: REMOTEDBINT.TXT (2020-06-15-05.16.43.622000)
//
// Copyright (c) 2001, International Business Machines Corp., Ltd.
// All Rights Reserved.
// Licensed for use in connection with IBM business only.
//
// $Log: remotedbint.txt,v $
// Revision 1.304  2014/02/24 14:59:41  wendy
// RCQ285768 - view cached XML in JUI
//
// Revision 1.303  2013/10/24 17:31:04  wendy
// added getDynaSearchTable() for search picklist perf
//
// Revision 1.302  2013/09/19 14:57:33  wendy
// add abr queue status
//
// Revision 1.301  2011/09/09 17:23:33  wendy
// add securelogin for RMI
//
// Revision 1.300  2009/05/15 17:51:15  wendy
// Change return type for checkVELockOwners()
//
// Revision 1.299  2009/05/14 18:08:21  wendy
// Added methods for UI performance improvements
//
// Revision 1.298  2009/03/12 19:56:05  wendy
// back out JCE (encryption) for now - requires jre1.4
//
// Revision 1.297  2009/03/11 18:24:19  wendy
// Added encrypted login
//
// Revision 1.296  2008/08/08 21:35:34  wendy
// CQ00006067-WI : LA CTO - More support for QueryAction
//
// Revision 1.295  2008/07/31 18:54:00  wendy
// CQ00006067-WI : LA CTO - Added support for QueryAction
//
// Revision 1.294  2006/10/05 15:44:42  roger
// Log putBlob calls for caching into TCOUNT table
//
// Revision 1.293  2006/03/10 17:39:59  joan
// remove not needed method for pdg
//
// Revision 1.292  2006/03/07 16:37:31  joan
// remove some not needed methods
//
// Revision 1.291  2005/10/11 18:20:03  joan
// add new method for PDG
//
// Revision 1.290  2005/08/11 17:21:27  tony
// added EntityItem array to catalog function
//
// Revision 1.289  2005/08/11 15:55:41  tony
// remote execution of addtional processes.
//
// Revision 1.288  2005/05/25 17:21:19  tony
// compile
//
// Revision 1.287  2005/05/25 17:09:16  tony
// reLoad
//
// Revision 1.286  2005/05/24 21:13:27  tony
// mw proper pass thru
//
// Revision 1.285  2005/05/24 16:08:46  roger
// Primitive mail message support
//
// Revision 1.284  2005/05/09 19:19:30  tony
// backward compat
//
// Revision 1.283  2005/05/09 17:55:24  tony
// improved versioning logic.
//
// Revision 1.282  2005/03/24 18:30:54  joan
// work on flag maintenance
//
// Revision 1.281  2005/03/07 23:09:53  joan
// work on flag maintenance
//
// Revision 1.280  2005/03/07 19:58:13  joan
// work on flag maintenance
//
// Revision 1.279  2005/03/04 17:44:37  joan
// add methods for flag code maintenance
//
// Revision 1.278  2005/03/01 23:39:20  joan
// work on Meta Maintenance
//
// Revision 1.277  2005/02/10 00:54:54  joan
// add throw exception
//
// Revision 1.276  2005/02/08 20:54:24  roger
// Clean up
//
// Revision 1.275  2005/01/14 19:16:15  tony
// fix compiler error.
//
// Revision 1.274  2005/01/14 19:07:59  tony
// improved update logic.
//
// Revision 1.273  2004/12/17 18:35:09  joan
// add new method
//
// Revision 1.272  2004/11/22 23:01:06  gregg
// MetaColumnOrderGroup on SearchBinder
//
// Revision 1.271  2004/10/13 18:51:28  tony
// added softwareImageUpdate Version request.
//
// Revision 1.270  2004/10/12 21:36:12  tony
// Added getSoftwareImage and putSoftwareImage to
// allow for on-line updating of the application.
//
// Revision 1.269  2004/08/13 17:32:44  roger
// Done?
//
// Revision 1.268  2004/08/13 17:26:29  roger
// Fix it
//
// Revision 1.267  2004/07/30 17:15:38  gregg
// cleanup object pool code
//
// Revision 1.266  2004/07/26 22:08:53  joan
// add unlockEntityItems
//
// Revision 1.265  2004/07/26 17:44:37  joan
// fix compile
//
// Revision 1.264  2004/07/26 17:06:02  joan
// add lockEntityItems
//
// Revision 1.263  2004/07/25 03:45:50  dave
// remove static
//
// Revision 1.262  2004/07/25 03:39:27  dave
// more settings
//
// Revision 1.261  2004/07/25 03:23:34  dave
// more RMI config exposure
//
// Revision 1.260  2004/06/21 15:02:36  joan
// add ABRStatus action
//
// Revision 1.259  2004/06/18 19:29:32  roger
// Want to use specialized BluePageException
//
// Revision 1.258  2004/06/18 16:10:57  roger
// Support new BluePageEntry feature and object
//
// Revision 1.257  2004/06/15 20:36:42  joan
// add CopyActionItem
//
// Revision 1.256  2004/06/14 20:28:08  roger
// Expose getBluePageEntry to remote world
//
// Revision 1.255  2004/06/08 17:05:23  joan
// add methods
//
// Revision 1.254  2004/05/27 20:05:09  joan
// add collectInfo method
//
// Revision 1.253  2004/05/21 22:37:12  joan
// more adjustment
//
// Revision 1.252  2004/05/21 21:55:28  joan
// work on chain action
//
// Revision 1.251  2004/05/20 22:09:57  joan
// work on chain action
//
// Revision 1.250  2004/05/11 17:31:06  gregg
// saveRuntime
//
// Revision 1.249  2004/05/10 21:39:58  gregg
// method name change: getLatestRuntime-->getRuntime
//
// Revision 1.248  2004/05/10 21:33:42  gregg
// getLatestRuntime
//
// Revision 1.247  2004/04/23 16:26:07  gregg
// getExtractActionItem
//
// Revision 1.246  2004/04/23 16:20:54  gregg
// compile fix
//
// Revision 1.245  2004/04/23 16:12:47  gregg
// getWatchdogActionItem, getWorkflowActionItem
//
// Revision 1.244  2004/04/20 20:32:12  gregg
// genVEChangeXML
//
// Revision 1.243  2004/03/19 21:20:30  gregg
// iDupMode to putBookmarkedActionItem
//
// Revision 1.242  2004/03/19 19:26:55  gregg
// returning BookmarkItem on store
//
// Revision 1.241  2004/03/15 21:09:11  gregg
// getLinkActionItem
//
// Revision 1.240  2004/03/12 19:12:38  gregg
// getCommonProfiles() method
//
// Revision 1.239  2004/01/12 20:43:11  dave
// abstract errors
//
// Revision 1.238  2004/01/08 22:39:19  dave
// fixes for ActionTree I
//
// Revision 1.237  2003/12/16 23:40:50  joan
// work on CR
//
// Revision 1.236  2003/12/16 22:07:51  gregg
// getMetaColumnOrderForMatrix
//
// Revision 1.235  2003/09/29 20:30:47  joan
// throw exception
//
// Revision 1.234  2003/09/26 20:46:30  joan
// add queuedABR method
//
// Revision 1.233  2003/09/04 17:27:40  dave
// interface fix
//
// Revision 1.232  2003/08/25 21:28:47  dave
// Remote throwing
//
// Revision 1.231  2003/08/25 20:06:47  dave
// streamlining the SearchActionItem to not
// carry the full entityGroup upon creation, but to
// go get it .. when the search action item is actually invoked
// with an exec or rexec
//
// Revision 1.230  2003/08/20 16:17:21  dave
// exposing setTranslationPackageStatus to remote interface
//
// Revision 1.229  2003/08/15 20:21:29  dave
// adding remote ETS interface back
//
// Revision 1.228  2003/07/24 15:58:43  joan
// fix compile error
//
// Revision 1.227  2003/07/24 15:51:18  joan
// add InactiveGroup
//
// Revision 1.226  2003/06/26 22:39:27  joan
// move changes from v111
//
// Revision 1.225  2003/06/04 17:52:49  roger
// Expose hasPDH() and hasODS()
//
// Revision 1.224  2003/05/29 18:17:51  gregg
// getSearchActionItem method
//
// Revision 1.223  2003/05/16 15:43:03  joan
// add SPDGActionItem
//
// Revision 1.222  2003/05/15 16:17:18  joan
// work on lock
//
// Revision 1.221  2003/05/14 23:32:15  joan
// add getAllSoftLockforWGID method
//
// Revision 1.220  2003/05/13 23:54:18  joan
// add refreshEntityItem
//
// Revision 1.219  2003/05/09 21:58:25  gregg
// remove emf parent param from ChangeHistoryGroup constructor
//
// Revision 1.218  2003/05/07 20:47:33  dave
// commenting out remote access to the Mail Stuff to see if
// anything in Tony's code breaks
//
// Revision 1.217  2003/04/30 17:38:26  roger
// Fix exception list
//
// Revision 1.216  2003/04/30 17:27:04  roger
// Expose method for mail
//
// Revision 1.215  2003/04/29 17:05:49  dave
// clean up and removal of uneeded function
//
// Revision 1.214  2003/04/28 19:26:04  dave
// more interface changing
//
// Revision 1.213  2003/04/28 19:14:52  dave
// fixing remote interface
//
// Revision 1.212  2003/04/15 17:58:25  gregg
// setting a max limit on # of Bookmarks stored in database
//
// Revision 1.211  2003/03/29 00:46:29  gregg
// add enterprise column to bookmark
//
// Revision 1.210  2003/03/27 18:59:16  gregg
// changes to getMetaColumnOrderGroup to avoid passing EnttiyGroup object
//
// Revision 1.209  2003/03/26 18:50:37  gregg
// getNewProfileInstance method
//
// Revision 1.208  2003/03/20 20:20:23  gregg
// MiddlewareRequestException for getChangeHistoryGroup methods
//
// Revision 1.207  2003/03/20 00:59:32  gregg
// Kompyle ficks
//
// Revision 1.206  2003/03/20 00:49:47  gregg
// getMetaEntityList method
//
// Revision 1.205  2003/03/19 18:51:04  gregg
// pass primitive params into deleteBookmark (no entire object)
//
// Revision 1.204  2003/03/19 18:46:25  gregg
// deleteBookmark method
//
// Revision 1.203  2003/03/18 22:27:56  gregg
// throw MiddlewareShutdownInProgressException in getBookmarkGroup
//
// Revision 1.202  2003/03/18 22:16:17  gregg
// putBookmarkedActionItem fix
//
// Revision 1.201  2003/03/18 21:58:44  gregg
// getBookmarkGroup method
//
// Revision 1.200  2003/03/18 21:25:47  gregg
// putBookmaredActionItem
//
// Revision 1.199  2003/03/18 01:41:51  gregg
// throw Exception in getBookmarkedActionItem method
//
// Revision 1.198  2003/03/18 01:23:33  gregg
// getBookmarkedActionItem method
//
// Revision 1.197  2003/03/17 20:31:02  gregg
// executeAction on NavActionItem
//
// Revision 1.196  2003/03/14 21:16:49  joan
// fix viewMissingData
//
// Revision 1.195  2003/03/14 18:50:24  gregg
// return a MetaRow in updatePdhMetaRow
//
// Revision 1.194  2003/03/14 18:32:41  gregg
// missing ';'
//
// Revision 1.193  2003/03/14 18:22:18  gregg
// throw more Exceptions for updatePdhMetaRow method
//
// Revision 1.192  2003/03/14 17:56:02  gregg
// updatePdhMetaRow
//
// Revision 1.191  2003/03/13 23:26:49  gregg
// more compile fix
//
// Revision 1.190  2003/03/13 22:51:09  gregg
// rollback
//
// Revision 1.189  2003/03/11 17:07:08  gregg
// getMetaColumnOrderGroup method
//
// Revision 1.188  2003/03/10 16:59:13  joan
// work on  PDG
//
// Revision 1.187  2003/03/05 18:21:24  gregg
// getAttributeChangeHistoryGroup
//
// Revision 1.186  2003/03/04 01:00:17  joan
// add pdg action item
//
// Revision 1.185  2003/03/03 18:36:37  joan
// add PDG action item
//
// Revision 1.184  2003/03/03 17:36:09  gregg
// getEntityChangeHistoryGroup method
//
// Revision 1.183  2003/02/05 00:34:51  gregg
// compile fix
//
// Revision 1.182  2003/02/05 00:09:41  gregg
// getIntervalGroup methods
//
// Revision 1.181  2003/01/29 00:12:14  joan
// add getGeneralAreaList
//
// Revision 1.180  2003/01/20 23:09:16  joan
// fix compile errors
//
// Revision 1.179  2003/01/20 23:00:49  joan
// add methods to get VELockOwner and the list for VELock/Entity/Relator
//
// Revision 1.178  2003/01/16 21:31:41  joan
// add code to check for VELock when link
//
// Revision 1.177  2003/01/14 00:56:37  joan
// add checkOrphan
//
// Revision 1.176  2003/01/07 18:23:33  joan
// throw orphan exception
//
// Revision 1.175  2003/01/06 16:27:23  joan
// add getParentChildList method
//
// Revision 1.174  2002/12/23 22:17:52  joan
// add resetWGDefault method
//
// Revision 1.173  2002/12/13 21:30:53  joan
// fix bugs
//
// Revision 1.172  2002/12/13 21:05:44  joan
// fix compile errors
//
// Revision 1.171  2002/12/13 20:41:04  joan
// fix for addition column in Softlock table
//
// Revision 1.170  2002/12/06 21:57:24  joan
// add getLockListForLockEntity method
//
// Revision 1.169  2002/11/19 18:27:46  joan
// adjust lock, unlock
//
// Revision 1.168  2002/11/19 00:06:31  joan
// adjust isLocked method
//
// Revision 1.167  2002/10/25 22:47:07  joan
// add getListOfCountriesForAVAIL method
//
// Revision 1.166  2002/10/23 23:11:11  bala
// fix typo
//
// Revision 1.165  2002/10/23 22:53:06  bala
// Plug in remote methods to refresh the DG queue
//
// Revision 1.164  2002/10/15 20:33:33  joan
// add HWUPGRADEActionItem
//
// Revision 1.163  2002/10/14 23:03:08  joan
// fix compile
//
// Revision 1.162  2002/10/14 22:53:53  joan
// add method to get HWUpgradeList
//
// Revision 1.161  2002/10/08 18:05:06  dave
// more fixes hopefully
//
// Revision 1.160  2002/10/08 16:20:53  dave
// putting in the backend stub for DynaSearch
//
// Revision 1.159  2002/10/04 23:43:58  joan
// add HWPDG
//
// Revision 1.158  2002/09/11 15:58:08  dave
// adding remote database interface stuff
//
// Revision 1.157  2002/09/09 20:42:53  joan
// throw SBRException
//
// Revision 1.156  2002/08/12 21:50:50  dave
// syntax error fixes
//
// Revision 1.155  2002/08/12 21:33:49  dave
// idl queue transfer logic for ECCM idl
//
// Revision 1.154  2002/08/12 18:28:20  bala
// Added updateWGDefault method
//
// Revision 1.153  2002/07/30 01:29:08  dave
// more clean up
//
// Revision 1.152  2002/07/30 01:00:04  dave
// whopps brought back to life
//
// Revision 1.151  2002/07/30 00:51:06  dave
// more cleanup and removal
//
// Revision 1.150  2002/07/23 17:24:05  joan
// fix getLockList
//
// Revision 1.149  2002/07/23 16:51:07  joan
// fix getLockList
//
// Revision 1.148  2002/07/19 22:35:04  joan
// fix errors
//
// Revision 1.147  2002/07/19 22:24:41  joan
// fix locklist
//
// Revision 1.146  2002/07/18 21:51:50  joan
// add SBRActionItem
//
// Revision 1.145  2002/06/25 20:36:10  joan
// add create method for whereused
//
// Revision 1.144  2002/06/21 15:46:14  joan
// add WhereUsedActionItem methods
//
// Revision 1.143  2002/06/18 18:28:10  joan
// working on picklist
//
// Revision 1.142  2002/06/06 20:54:03  joan
// working on link
//
// Revision 1.141  2002/06/05 17:37:46  joan
// add MatrixActionItem
//
// Revision 1.140  2002/05/24 18:15:05  bala
// Changed update method
// updateEntity,updateReturnEntityKey, updateReturnRelatorKey
// Added new signature to update and above methods
// to accept a "updateAttributesOnly" flag to bypass
// the sp update of entity rows when set to true
//
// Revision 1.139  2002/05/15 19:47:05  gregg
// return a WatchdogActionItem in executeAction(WatchdogActionItem)
//
// Revision 1.138  2002/05/15 15:58:51  joan
// add executeAction for LockActionItem
//
// Revision 1.137  2002/05/14 23:12:03  gregg
// executeAction(WatchdogActionItem) method added
//
// Revision 1.136  2002/05/13 16:55:52  joan
// compile errors
//
// Revision 1.135  2002/05/13 16:42:11  joan
// fixing unlock method
//
// Revision 1.134  2002/05/10 20:45:56  joan
// fixing lock
//
// Revision 1.133  2002/05/09 22:43:28  joan
// fix throwing exceptions
//
// Revision 1.132  2002/05/09 20:27:22  joan
// working on throwing exception
//
// Revision 1.131  2002/05/08 16:38:13  joan
// fixing compile errors
//
// Revision 1.130  2002/05/02 20:09:16  joan
// working on DeleteActionItem
//
// Revision 1.129  2002/04/22 20:18:00  joan
// working on unlock
//
// Revision 1.128  2002/04/22 18:00:13  dave
// removed final from interface doc
//
// Revision 1.127  2002/04/22 17:51:33  dave
// more function removal
//
// Revision 1.126  2002/04/22 17:27:50  dave
// syntax fix on remoteDbInt
//
// Revision 1.125  2002/04/22 17:16:13  dave
// attempting to fix remotedatabase
//
// Revision 1.124  2002/04/22 16:37:54  dave
// stripping 1.0 functionality from the 1.1 arch
//
// Revision 1.123  2002/04/19 20:13:55  joan
// working on lock
//
// Revision 1.122  2002/04/17 21:46:41  joan
// add methods to clear lock
//
// Revision 1.121  2002/04/17 18:33:24  joan
// syntax
//
// Revision 1.120  2002/04/17 18:13:35  joan
// fixing createLock method and add lockgroup methods in entityitem
//
// Revision 1.119  2002/04/16 23:44:08  joan
// add lock method
//
// Revision 1.118  2002/04/16 22:17:40  joan
// add getLockList method
//
// Revision 1.117  2002/04/05 18:43:40  dave
// first attempt at the extract action item
//
// Revision 1.116  2002/03/23 20:37:01  dave
// fixed update problem and renamed OPICMUpdate to update
//
// Revision 1.115  2002/03/22 18:39:14  bala
// OPICM Update
//
// Revision 1.114  2002/03/08 18:58:46  dave
// first attempt at bringing edit online
//
// Revision 1.113  2002/03/07 22:18:30  dave
// too many getEntityGroup's in rdi
//
// Revision 1.112  2002/03/07 22:08:48  dave
// adding get EntityGroup to the database interface...
//
// Revision 1.111  2002/03/06 18:23:58  dave
// removed final from remotedbint
//
// Revision 1.110  2002/03/06 18:16:35  dave
// adding the Search Action Item
//
// Revision 1.109  2002/03/06 00:39:32  bala
// Add OPICMUpdate Method
//
// Revision 1.108  2002/03/05 17:04:52  dave
// added methods to EntityList for Create
//
// Revision 1.107  2002/02/26 17:25:04  dave
// merging the new link into the mix
//
// Revision 1.106  2002/02/18 19:01:49  dave
// more syntax error fixes
//
// Revision 1.105  2002/02/18 18:42:18  dave
// adding cart methods
//
// Revision 1.104  2002/02/14 18:54:09  dave
// syntax fixes
//
// Revision 1.103  2002/02/14 18:39:56  dave
// integrating getEntityList into the remote Interface
//
// Revision 1.102  2002/01/29 23:15:39  roger
// Reapply deactivatedBlob change
//
// Revision 1.101  2002/01/29 23:01:09  roger
// Restored 1.98 revision
//
// Revision 1.98  2002/01/07 21:24:17  joan
// add changes for serialhistorygroup and deactivateBlob
//
// Revision 1.97  2002/01/02 17:50:11  dave
// sync between 1.0 and 1.1
//
// Revision 1.96  2001/12/26 22:46:46  joan
// add new putBlob and getBlob methods
//
// Revision 1.95  2001/12/04 21:36:56  joan
// 17369
//
// Revision 1.94  2001/10/25 23:28:09  bala
// typo
//
// Revision 1.93  2001/10/25 23:24:50  bala
// added getFlagAttrHistory method
//
// Revision 1.92  2001/10/25 18:38:48  bala
// debug
//
// Revision 1.91  2001/10/25 18:22:36  bala
// debug
//
// Revision 1.90  2001/10/25 18:13:58  bala
// debug
//
// Revision 1.89  2001/10/25 18:03:29  bala
// modified createVeasnavobj to accept valon and effon dates
// added wrapper to createveasnavobj to get the dates from profile
// add new method to return a delta of a ve navobj between 2 sets of dates
//
// Revision 1.88  2001/10/15 21:36:15  dave
// encorporated call into remote object
//
// Revision 1.87  2001/10/11 23:25:45  dave
// added getMetaFlagAttributeList to the remote interface
//
// Revision 1.86  2001/10/05 17:29:06  bala
// Converting sp PSG0006 to PSG0106 database method
//
// Revision 1.85  2001/10/03 16:50:03  bala
// Added remoteDBint methods to createVEasNavObj
//
// Revision 1.84  2001/09/26 20:23:39  dave
// added getNavigateObject to remote accessors
//
// Revision 1.83  2001/09/20 22:17:58  dave
// fixes for new search
//
// Revision 1.82  2001/09/20 16:51:45  roger
// Use accessors for objects
//
// Revision 1.81  2001/09/14 22:10:16  dave
// more syntax
//
// Revision 1.80  2001/09/13 16:46:17  roger
// Profile changes
//
// Revision 1.79  2001/09/13 16:26:00  roger
// Profile changes
//
// Revision 1.78  2001/09/12 20:54:52  roger
// Profile changes
//
// Revision 1.77  2001/09/12 17:02:12  roger
// Remove changePassword
//
// Revision 1.76  2001/09/12 16:26:06  roger
// Had a dupe login method
//
// Revision 1.75  2001/09/12 16:12:36  roger
// Exception trouble
//
// Revision 1.74  2001/09/12 16:04:51  roger
// Clean up and more Profile changes
//
// Revision 1.73  2001/09/11 23:11:45  roger
// Beautify
//
// Revision 1.72  2001/09/11 22:33:23  roger
// Remove dupe login method
//
// Revision 1.71  2001/09/11 21:57:55  roger
// Convert ConnectionItem + SessionObject + NLSID to Profile
//
// Revision 1.70  2001/09/10 17:36:03  dave
// exposing new entrypoints in remote object
//
// Revision 1.69  2001/09/07 22:26:08  roger
// Remove imports of login package
//
// Revision 1.68  2001/08/30 21:38:49  roger
// Changes for login10
//
// Revision 1.67  2001/08/30 18:04:50  roger
// login10 and login11
//
// Revision 1.66  2001/08/29 22:31:42  roger
// Needed to rename, return variable not enough signature difference
//
// Revision 1.65  2001/08/29 22:24:01  roger
// Put LDAP feature in database instead
//
// Revision 1.64  2001/08/24 00:25:38  roger
// Trouble getting member variable use method instead
//
// Revision 1.63  2001/08/23 23:16:25  roger
// Change method to login
//
// Revision 1.62  2001/08/22 16:54:09  roger
// Removed author RM
//
// Revision 1.61  2001/08/15 16:31:53  dave
// added import statements for report
//
// Revision 1.60  2001/08/15 16:23:57  dave
// ReportSet exposed through RMI
//
// Revision 1.59  2001/08/13 17:41:02  roger
// More fixes
//
// Revision 1.58  2001/08/13 16:57:14  roger
// Needed import
//
// Revision 1.57  2001/08/13 16:51:34  roger
// More fixes
//
// Revision 1.56  2001/08/08 18:54:37  dave
// added import statements for the RemoteObjects templates
//
// Revision 1.55  2001/08/08 18:35:03  dave
// fixes to API on searchRequest (syntax)
//
// Revision 1.54  2001/08/08 18:17:06  dave
// hooking up the getSearchRequest to the RemoteDatabase object
//
// Revision 1.53  2001/06/02 20:16:12  dave
// added boolean to deactivatedList for unrestricted case
//
// Revision 1.52  2001/06/02 17:49:49  dave
// capping the number of Entities a client can get to 200 through
// RMI
//
// Revision 1.51  2001/06/01 17:22:01  dave
// changed PDHAttribute to string on getHelpText parm
//
// Revision 1.50  2001/05/07 21:19:22  dave
// basic syntax error catching
//
// Revision 1.49  2001/05/07 20:35:50  dave
// first attempt at setting up the clearing of the Object Cache
//
// Revision 1.48  2001/05/04 20:09:12  dave
// LockException added to deactivateEntity
//
// Revision 1.47  2001/05/02 20:10:55  dave
// cleaned up linkUI and added 100 transaction limit on the
// remote side to not allow for big transactions through the UI
//
// Revision 1.46  2001/04/28 20:30:27  dave
// added base logic to create navigate objects from pdhitems
//
// Revision 1.45  2001/04/26 21:25:27  roger
// Clean up
//
// Revision 1.44  2001/04/25 15:40:57  dave
// Login exception removed for changePassword method(s)
//
// Revision 1.43  2001/04/23 15:10:50  dave
// changed PDHAttribute to PDHMetaAttribute in getHelpText
//
// Revision 1.42  2001/04/23 02:02:28  dave
// first pass at getHelpText
//
// Revision 1.41  2001/04/11 23:30:54  dave
// syntax fixes and ensuring _ is used for parm variables
//
// Revision 1.40  2001/04/11 23:06:10  dave
// added multiple parent option on copyLink along with copy count
//
// Revision 1.39  2001/04/10 20:27:45  dave
// syntax in interface
//
// Revision 1.38  2001/04/10 19:56:44  dave
// added a persistence flag to the clearsoftlock call(s)
//
// Revision 1.37  2001/04/10 19:49:04  dave
// Added RemoteMethods for getAllSoftLocksforOPENID
//
// Revision 1.36  2001/04/10 04:28:16  dave
// First Pass at adding persistence to the create softlock process
//
// Revision 1.35  2001/04/05 22:19:52  dave
// final sytax
//
// Revision 1.34  2001/04/05 21:22:17  dave
// syntax fixes
//
// Revision 1.33  2001/04/05 20:37:58  dave
// change for clearAllSoftLocksbyOperator
//
// Revision 1.32  2001/04/04 22:03:25  gregg
// change for genConfigOffering
//
// Revision 1.31  2001/04/03 04:24:58  dave
// fixed syntax errors..
//
// Revision 1.30  2001/04/03 03:56:39  dave
// fix for RMI entityUpdate call
//
// Revision 1.29  2001/04/02 21:15:33  dave
// fixed putBlob for TranID using either the TranID from the ConnectionItem
// or the DUMMY_INT to ensure no hardcoding is involved
//
// Revision 1.28  2001/03/30 21:02:42  dave
// Added base logic for showAllUsers
//
// Revision 1.27  2001/03/30 01:15:11  dave
// final errors for changepassword migration
//
// Revision 1.26  2001/03/30 00:27:07  dave
// first pass at syntax errors for changepassword
//
// Revision 1.25  2001/03/30 00:09:11  dave
// first attempt at migrating the change password logic
//
// Revision 1.24  2001/03/28 04:14:30  dave
// stubbed out whereused function to return simple NavigateObject
//
// Revision 1.23  2001/03/27 04:16:20  dave
// Added stubs to middleware for moveLink
// (rename of cutpaste)
//
// Revision 1.22  2001/03/27 01:21:02  roger
// Misc formatting clean up
//
// Revision 1.21  2001/03/23 17:49:06  dave
// Clean up and syntax error fixes for copyLink
//
// Revision 1.20  2001/03/23 17:22:41  dave
// Based code for the copy/paste (changed to copyLink).. more to follow
//
// Revision 1.19  2001/03/22 08:23:16  dave
// Added foundation for deactivateUNDO in JDBC, RMI, and Interface
//
// Revision 1.18  2001/03/22 07:47:28  dave
// Added PDHInactiveEntityGroup as the class that gets returned from the deactivatedList method
//
// Revision 1.17  2001/03/21 21:08:25  dave
// Added Base code for deactivatedList for V2.3
//
// Revision 1.16  2001/03/21 20:39:49  roger
// Added branded feature to interfaces
//
// Revision 1.15  2001/03/21 18:33:15  roger
// Have to find a technique to brand interfaces - they can't have constants
//
// Revision 1.14  2001/03/21 18:09:12  roger
// Added branding code
//
// Revision 1.13  2001/03/21 15:30:51  roger
// Put v2.2.3 link method back in temporarily for eTS
//
// Revision 1.12  2001/03/20 21:50:34  dave
// Link to LinkUI name change
//
// Revision 1.11  2001/03/20 21:36:52  roger
// Removed ConnectionItem from declarePackage
//
// Revision 1.10  2001/03/20 21:06:44  roger
// Include ConnectionItem to declarePackage for link method
//
// Revision 1.9  2001/03/16 22:09:57  roger
// Restored createVirtualEntity from v2.2.3
//
// Revision 1.8  2001/03/16 16:30:24  roger
// Needed import statement for eTS
//
// Revision 1.7  2001/03/16 05:25:17  roger
// Included updatePDH
//
// Revision 1.6  2001/03/16 04:39:23  roger
// Added @exception and eTS method defs
//
// Revision 1.5  2001/03/16 03:18:49  roger
// Added Log keyword
//
package COM.ibm.opicmpdh.middleware;

import java.rmi.*;
import java.util.*;
import java.io.*;
import COM.ibm.opicmpdh.objects.*;
import COM.ibm.opicmpdh.transactions.*;
import COM.ibm.opicmpdh.translation.*;
import COM.ibm.eannounce.objects.*;
import javax.mail.internet.InternetAddress;

/**
 * This interface declares the methods which will be implemented by the RemoteDatabase class
 */
public interface RemoteDatabaseInterface extends Remote {
    public static final String CLASS_BRAND = "$Id: remotedbint.txt,v 1.304 2014/02/24 14:59:41 wendy Exp $";
    public String getVersion() throws RemoteException;
    public OPICMList update(Profile _prof, Vector vctTransactions,boolean bCheckDeactivatedEntity,boolean _bAttributesOnly) throws RemoteException, MiddlewareException, MiddlewareBusinessRuleException, MiddlewareShutdownInProgressException;
    public OPICMList update(Profile _prof, Vector vctTransactions,boolean bCheckDeactivatedEntity) throws RemoteException, MiddlewareException, MiddlewareBusinessRuleException, MiddlewareShutdownInProgressException;
    public OPICMList update(Profile _prof, Vector vctTransactions) throws RemoteException, MiddlewareException, MiddlewareBusinessRuleException, MiddlewareShutdownInProgressException;
    public OPICMList updateWGDefault(Profile _prof, Vector _vctTransactions) throws RemoteException, MiddlewareException, MiddlewareBusinessRuleException, MiddlewareShutdownInProgressException;
    public void resetWGDefault(Profile _prof, Vector _vctTransactions) throws RemoteException, MiddlewareException, MiddlewareBusinessRuleException, MiddlewareShutdownInProgressException;
    public String getHelpText(Profile _prof, String _strAttributeCode) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public boolean hasPDH() throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public boolean hasODS() throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public MetaFlagAttributeList getMetaFlagAttributeList(Profile _prof, String _strAttributeCode) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public SerialHistoryGroup getSerialHistoryGroup(Profile _prof, String _s) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public COM.ibm.opicmpdh.objects.Blob getBlob(Profile _prof, String entityType, int entityID, String attributeCode) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public COM.ibm.opicmpdh.objects.Blob getBlob(Profile _prof, String entityType, int entityID, String attributeCode, int nlsid) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public ReturnDataResultSetGroup putBlob(Profile _prof, COM.ibm.opicmpdh.objects.Blob blobAttribute) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public ReturnDataResultSetGroup putBlob(Profile _prof, COM.ibm.opicmpdh.objects.Blob blobAttribute, int _nlsID) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public ReturnDataResultSetGroup deactivateBlob(Profile _prof, String _strEntityType, int _iEntityID, String _strAttributeCode, int _iNLSID) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public String testThruPut(int iLogStringLength, String strLogString) throws RemoteException;
    public String log(String strLogString) throws RemoteException;
    public ReturnDataResultSetGroup ping() throws RemoteException;
    public String[] command(String strCommand) throws RemoteException;
    public EntityList getEntityList(Profile _prof) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public EntityList getEntityList(Profile _prof, NavActionItem _ai, EntityItem[] _aei, boolean _bActionTree) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public EntityList getEntityList(Profile _prof, EANActionItem _ai, EntityItem[] _aei) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    /*
    public EntityList getEntityList(Profile _prof, ExtractActionItem _ai, EntityItem[] _aei) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public EntityList getEntityList(Profile _prof, CreateActionItem _ai, EntityItem[] _aei) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public EntityList getEntityList(Profile _prof, EditActionItem _ai, EntityItem[] _aei) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public EntityList getEntityList(Profile _prof, CopyActionItem _ai, EntityItem[] _aei) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public EntityList getEntityList(Profile _prof, ABRStatusActionItem _ai, EntityItem[] _aei) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    */
    public EntityList getEntityList(Profile _prof, SearchActionItem _ai) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public EntityGroup getEntityGroup(Profile _prof, String _strEntityType, String _strPurpose) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public OPICMList link(Profile _prof, Vector _vctReturnRelatorKeys, String _strLinkOption, int _iSwitch, int _iCopyCount, boolean _bCheckOrphan) throws LinkException, RemoteException, MiddlewareException,MiddlewareShutdownInProgressException;
//    public ProfileSet login(String _strOPName, String _strPassword, String _strVersionLiteral) throws LoginException, VersionException, RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
// this needs to exist until all autoupdates are completed or user won't be able to login
    public ProfileSet login(String _strOPName, String _strPassword, String _strVersionLiteral, String _strClient) throws LoginException, VersionException, RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public ProfileSet secureLogin(byte[][] encryptedUidPw, String _strVersionLiteral) throws VersionException, LoginException, RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public ProfileSet secureLogin(byte[][] encryptedUidPw, String _strVersionLiteral,String _strClient) throws VersionException, LoginException, RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public LockList getLockList(Profile _prof, boolean _bGetLock) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public LockList getLockListForLockEntity(Profile _prof, EntityItem _lockEI, String _strLockOwner) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public LockGroup getLockGroup(Profile _prof, EntityItem _lockEI, EntityItem _ei, String _strLockOwner, int _iLockType, boolean _bCreateLock) throws LinkException, RemoteException, MiddlewareException,MiddlewareShutdownInProgressException;
    public LockGroup[] getLockGroups(Profile _prof, EntityItem _lockEI, EntityItem[] _aei, String _strLockOwner, int _iLockType, boolean _bCreateLock) throws LinkException, RemoteException, MiddlewareException,MiddlewareShutdownInProgressException;
    public void clearLock(Profile _prof, String _strEntityType, int _iEntityID, String _strLockEntityType, int _iLockEntityID, String _strLockOwner) throws RemoteException, MiddlewareException,MiddlewareShutdownInProgressException;
    public void clearLocks(Profile _prof, EntityItem[] _aei, String _strLockEntityType, int _iLockEntityID, String _strLockOwner, int _iLockType) throws RemoteException, MiddlewareException,MiddlewareShutdownInProgressException;
    public ParentChildList getParentChildList(Profile _prof, EntityItem _pEI, EntityItem _cEI) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public void executeAction(Profile _prof, DeleteActionItem _eai) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException, LockException, EANBusinessRuleException;
    public Object executeAction(Profile _prof, LinkActionItem _eai) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException, LockException, EANBusinessRuleException, WorkflowException;
    public Vector executeLink(Profile _prof, LinkActionItem _eai) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException, LockException, EANBusinessRuleException, WorkflowException;
    public void executeAction(Profile _prof, WorkflowActionItem _eai) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException, WorkflowException;
    public WatchdogActionItem executeAction(WatchdogActionItem _eai) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException, WorkflowException;
    public EntityList executeAction(Profile _prof, NavActionItem _nai) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public void executeAction(Profile _prof, LockActionItem _eai) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public MatrixList executeAction(Profile _prof, MatrixActionItem _eai) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public EntityList executeAction(Profile _prof, SearchActionItem _sai) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public EntityList generatePickList(Profile _prof, MatrixActionItem _mai, String _strRelatorType) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public WhereUsedList executeAction(Profile _prof, WhereUsedActionItem _eai, boolean _bMeta) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public EntityList generatePickList(Profile _prof, WhereUsedActionItem _mai, String _strRelatorType) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public EntityList createEntity(Profile _prof, WhereUsedActionItem _mai, String _strRelatorType) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public void transferQueues(Profile _prof, int _iOLDOPWG, String _strQueueName, int _iStartID, int _iEndID) throws RemoteException, MiddlewareException,MiddlewareShutdownInProgressException;
    public DescriptionChangeList getDescriptionChangeList(Profile _prof, int _iChangeType, String _strStartDate, String _strEndDate) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public void refreshDGQueue(Profile _prof) throws RemoteException, MiddlewareException,MiddlewareShutdownInProgressException;
    public String[] getListOfCountriesForAVAIL(Profile _prof, EntityItem _ei) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException, LinkException;
    public String[] getVELockOwners(Profile _prof, EntityItem _ei) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
	public String[][] checkVELockOwners(Profile _prof, EntityItem[] _eia) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;

    public VELockERList getVELockERList(Profile _prof, String _strEntityType) throws RemoteException, MiddlewareException,MiddlewareShutdownInProgressException ;
    public GeneralAreaList getGeneralAreaList(Profile _prof) throws RemoteException, MiddlewareException,MiddlewareShutdownInProgressException ;
    public IntervalGroup getIntervalGroup(EANMetaFoundation _emf, Profile _prof, String _strQueueType) throws RemoteException, MiddlewareException,MiddlewareShutdownInProgressException ;
    public IntervalGroup getIntervalGroup(EANMetaFoundation _emf, Profile _prof, String _strQueueType, String _strStartDate , String _strEndDate) throws RemoteException, MiddlewareException,MiddlewareShutdownInProgressException ;
    public EntityChangeHistoryGroup getEntityChangeHistoryGroup(Profile _prof, EntityItem _ei) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException ;
    public AttributeChangeHistoryGroup getAttributeChangeHistoryGroup(Profile _prof, EANAttribute _ea) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException ;
    public MetaColumnOrderGroup getMetaColumnOrderGroup(String _strEntityType, Profile _prof) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public MetaColumnOrderGroup getMetaColumnOrderGroup(String _strEntityType, Profile _prof, boolean isQueryType) throws RemoteException, MiddlewareException,MiddlewareShutdownInProgressException;
    public MetaColumnOrderGroup getMetaColumnOrderGroup(SearchBinder _searchBinder) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public MetaColumnOrderGroup getMetaColumnOrderGroupForMatrix(String _strEntityType, String _strMatrixActionKey, Profile _prof) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public MetaRow updatePdhMetaRow(MetaRow _mr) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public EANActionItem getBookmarkedActionItem(Profile _prof, String _strActionItemKey, String _strUserDescription) throws Exception, RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public BookmarkItem putBookmarkedActionItem(Profile _prof, EANActionItem _eai, String _strUserDescription, int _iDupMode) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException, BookmarkException;
    public BookmarkGroup getBookmarkGroup(Profile _prof) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public void deleteBookmark(String _strEnterprise, int _iOPID, String _strActionItemKey, String _strUserDescription) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public MetaEntityList getMetaEntityList(Profile _prof) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public Profile getNewProfileInstance(Profile _prof) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
/* save space
    public void executeAction(Profile _prof, PDGActionItem _pdgai) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException, SBRException;
    public void executeAction(Profile _prof, SPDGActionItem _spdgai) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException, SBRException;
*/
    public void executeAction(Profile _prof, PDGTemplateActionItem _spdgai) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException, SBRException;
    public byte[] viewMissingData(Profile _prof, PDGActionItem _pdgai) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException, SBRException;
    public void queuedABR(Profile _prof, PDGActionItem _pdgai) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException, SBRException;
    public PDGCollectInfoList collectInfo(Profile _prof, int _iStep, PDGActionItem _pdgai) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException, SBRException;
    public PDGCollectInfoList collectInfo(Profile _prof, EANMetaAttribute _meta, PDGActionItem _pdgai) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException, SBRException;
    public void queuedABR(Profile _prof, SPDGActionItem _spdgai) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException, SBRException;
    public byte[] viewMissingData(Profile _prof, SPDGActionItem _spdgai) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException, SBRException;
    public EntityItem refreshEntityItem(Profile _prof, EntityGroup _eg, EntityItem _ei) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public LockList getAllSoftLocksForWGID(Profile _prof) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public SearchActionItem getSearchActionItem(EANMetaFoundation _emf, Profile _prof, String _strActionItemKey) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public NavActionItem getNavActionItem(EANMetaFoundation _emf, Profile _prof, String _strActionItemKey) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public CreateActionItem getCreateActionItem(EANMetaFoundation _emf, Profile _prof, String _strActionItemKey) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public DeleteActionItem getDeleteActionItem(EANMetaFoundation _emf, Profile _prof, String _strActionItemKey) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public WhereUsedActionItem getWhereUsedActionItem(EANMetaFoundation _emf, Profile _prof, String _strActionItemKey) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public LinkActionItem getLinkActionItem(EANMetaFoundation _emf, Profile _prof, String _strActionItemKey) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public WatchdogActionItem getWatchdogActionItem(EANMetaFoundation _emf, Profile _prof, String _strActionItemKey) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public WorkflowActionItem getWorkflowActionItem(EANMetaFoundation _emf, Profile _prof, String _strActionItemKey) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public ExtractActionItem getExtractActionItem(EANMetaFoundation _emf, Profile _prof, String _strActionItemKey) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public EditActionItem getEditActionItem(EANMetaFoundation _emf, Profile _prof, String _strActionItemKey) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public LockActionItem getLockActionItem(EANMetaFoundation _emf, Profile _prof, String _strActionItemKey) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public MatrixActionItem getMatrixActionItem(EANMetaFoundation _emf, Profile _prof, String _strActionItemKey) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public ReportActionItem getReportActionItem(EANMetaFoundation _emf, Profile _prof, String _strActionItemKey) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public InactiveGroup getInactiveGroup(Profile _prof, String _strStartDate, boolean _bViewAll) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public InactiveGroup deactivatedUndo(Profile _prof, InactiveGroup _iag, InactiveItem[] _aiai) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public Vector getPackagesAwaitingTranslation(Profile _prof) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public TranslationPackage pullPDHPackageForTranslation (Profile _prof, PackageID _pkID) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public void putETSTranslatedPackage(Profile _prof, TranslationPackage _trnp) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public void setTranslationPackageStatus(Profile _prof, PackageID _pkID, PackageStatus _ps) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public COM.ibm.opicmpdh.objects.Blob getBlobNow(Profile _prof, String _strEntityType, int _iEntityID, String _strAttributeCode, int _iNLSID) throws Exception, RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public ProfileSet getCommonProfiles(Profile _prof) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public StringBuffer genVEChangeXML(String _strAppRoot, Profile _prof, String _strExtractActionItem, String _strT1, String _strT2, String _strEntityType, int _iEntityID) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public String getRuntime(String _strEnterprise, String _strRunType) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public void saveRuntime(String _strEnterprise, String _strRunType, String _strRunTime) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException;
    public BluePageEntry getBluePageEntry(InternetAddress _iaEmailAddress) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException, BluePageException;
    public BluePageEntryGroup getBluePageEntryGroup(String _strLastName, String _strFirstName) throws RemoteException, MiddlewareException, MiddlewareRequestException, MiddlewareShutdownInProgressException, BluePageException;
    public ReturnDataResultSetGroup putSoftwareImage(Profile _prof, String _enterprise, COM.ibm.opicmpdh.objects.Blob blobAttribute) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public COM.ibm.opicmpdh.objects.Blob getSoftwareImage(Profile _prof, String _enterprise, String entityType, int entityID, String attributeCode) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public COM.ibm.opicmpdh.objects.Blob getSoftwareImageVersion(Profile _prof, String _enterprise, String entityType, int entityID, String attributeCode) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public COM.ibm.opicmpdh.objects.Blob getSoftwareImageVersion(Profile _prof, String _enterprise, String entityType, int entityID, String attributeCode, String _clientVersion) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public COM.ibm.opicmpdh.objects.Blob getSoftwareImage(String _enterprise, String entityType, int entityID, String attributeCode,String strValOn, String strEffOn) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public void cleanUpPartNo(EntityItem _ei) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public MetaFlagMaintList getMetaFlagMaintList(MetaMaintActionItem _mmai, Profile _prof, String _strAttributeCode) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public OPICMList addFlagCodes(Profile _prof, String _strAttributeCode, MetaFlagMaintItem[] _amfmi) throws RemoteException, MiddlewareException,MiddlewareShutdownInProgressException;
    public OPICMList expireFlagCodes(Profile _prof, String _strAttributeCode, MetaFlagMaintItem[] _amfmi) throws RemoteException, MiddlewareException,MiddlewareShutdownInProgressException;
    public OPICMList unexpireFlagCodes(Profile _prof, String _strAttributeCode, MetaFlagMaintItem[] _amfmi) throws RemoteException, MiddlewareException,MiddlewareShutdownInProgressException;
    public void clearCacheForAttribute(Profile _prof, String _strAttributeCode) throws RemoteException, MiddlewareException,MiddlewareShutdownInProgressException;
    public EANMetaAttribute buildMetaAttribute(MetaFlagMaintList _mfml, EANMetaAttribute _meta) throws RemoteException, MiddlewareException,MiddlewareShutdownInProgressException;
    public void sendEmail(String _strTo, String _strSubject, String _strBody) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public String[] getTargetVersions(Profile _prof, String[] _in, String _eod) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public QueryList executeAction(Profile _prof, QueryActionItem _qai) throws RemoteException, MiddlewareException,MiddlewareShutdownInProgressException;
    public ABRQueueStatusList getABRQueueStatus(Profile _prof) throws RemoteException, MiddlewareException,MiddlewareShutdownInProgressException;
    public String getCachedXML(String entityType, int entityId) throws RemoteException, MiddlewareException,MiddlewareShutdownInProgressException;
    public RowSelectableTable getDynaSearchTable(SearchActionItem sai) throws RemoteException, MiddlewareException,MiddlewareShutdownInProgressException;
    public Object execAdditional(Profile _prof, EANActionItem _eai, EntityItem[] _ei, Object[] _parms) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public String getInstanceName() throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
    public boolean hasChanges(Profile _prof, EntityItem[] _ei, String _fromDate, String _actionKey) throws RemoteException, MiddlewareException, MiddlewareShutdownInProgressException;
/**
 * Exposes stored procedure GBL99992 (Return the current server time values Now/Forever/Epoch) through RMI
 * @author generated code
 * @return ReturnDataResultSetGroup or void
 * @exception RemoteException, MiddlewareException
 */
  public ReturnDataResultSetGroup remoteGBL99992
  (
  ) throws RemoteException, MiddlewareException;
/**
 * Exposes stored procedure GBL9999 (Return the current server time values Now/Forever/Epoch) through RMI
 * @author generated code
 * @return ReturnDataResultSetGroup or void
 * @exception RemoteException, MiddlewareException
 */
  public ReturnDataResultSetGroup remoteGBL9999
  (
  ) throws RemoteException, MiddlewareException;
/**
 * Exposes stored procedure GBL0003 (Rule51:fetch an attribute value) through RMI
 * @author generated code
 * @return ReturnDataResultSetGroup or void
 * @exception RemoteException, MiddlewareException
 */
  public ReturnDataResultSetGroup remoteGBL0003
  (
    String enterprise
  , String entityType
  , int entityID
  , String attributeCode
  , int nlsID
  ) throws RemoteException, MiddlewareException;
/**
 * Exposes stored procedure GBL0006 (Rule51:is this a rule 51 entitytype?) through RMI
 * @author generated code
 * @return ReturnDataResultSetGroup or void
 * @exception RemoteException, MiddlewareException
 */
  public ReturnDataResultSetGroup remoteGBL0006
  (
    String enterprise
  , String entityType
  ) throws RemoteException, MiddlewareException;
/**
 * Exposes stored procedure GBL2028 (Return the current server time values Now/Forever/Epoch) through RMI
 * @author generated code
 * @return ReturnDataResultSetGroup or void
 * @exception RemoteException, MiddlewareException
 */
  public ReturnDataResultSetGroup remoteGBL2028
  (
  ) throws RemoteException, MiddlewareException;
/**
 * Exposes stored procedure GBL2031 (Insert Soft Lock) through RMI
 * @author generated code
 * @return ReturnDataResultSetGroup or void
 * @exception RemoteException, MiddlewareException
 */
  public void remoteGBL2031
  (
    String enterprise
  , String entityType
  , int entityID
  , int lockLevel
  , String lockEntityType
  , int lockEntityID
  , String lockOwner
  , int oPWGID
  , int tranID
  ) throws RemoteException, MiddlewareException;
/**
 * Exposes stored procedure GBL2055 (Return all parent entity ids related to the passed entity through the relatortype for the given Enterprise.) through RMI
 * @author generated code
 * @return ReturnDataResultSetGroup or void
 * @exception RemoteException, MiddlewareException
 */
  public ReturnDataResultSetGroup remoteGBL2055
  (
    String enterprise
  , String relatorType
  , String entity2Type
  , int entity2ID
  , String valOn
  , String effOn
  ) throws RemoteException, MiddlewareException;
/**
 * Exposes stored procedure GBL7003 ( Returns class and NLS Description based upon the given ActionKey NLSID) through RMI
 * @author generated code
 * @return ReturnDataResultSetGroup or void
 * @exception RemoteException, MiddlewareException
 */
  public ReturnDataResultSetGroup remoteGBL7003
  (
    String enterprise
  , String actionType
  , int nlsID
  , String valOn
  , String effOn
  ) throws RemoteException, MiddlewareException;
/**
 * Exposes stored procedure GBL7008 ( Returns class and NLS Description based upon the given ActionKey NLSID) through RMI
 * @author generated code
 * @return ReturnDataResultSetGroup or void
 * @exception RemoteException, MiddlewareException
 */
  public ReturnDataResultSetGroup remoteGBL7008
  (
    String enterprise
  , String actionType
  , String valOn
  , String effOn
  ) throws RemoteException, MiddlewareException;
/**
 * Exposes stored procedure GBL7030 ( Returns Attributes of an Action) through RMI
 * @author generated code
 * @return ReturnDataResultSetGroup or void
 * @exception RemoteException, MiddlewareException
 */
  public ReturnDataResultSetGroup remoteGBL7030
  (
    String enterprise
  , String actionType
  , String valOn
  , String effOn
  ) throws RemoteException, MiddlewareException;
/**
 * Exposes stored procedure GBL7065 (Get all Allowable Flag Values for the given Workgroup) through RMI
 * @author generated code
 * @return ReturnDataResultSetGroup or void
 * @exception RemoteException, MiddlewareException
 */
  public ReturnDataResultSetGroup remoteGBL7065
  (
    String enterprise
  , int wGID
  , String valOn
  , String effOn
  ) throws RemoteException, MiddlewareException;
/**
 * Exposes stored procedure GBL7549 (delete MetaColOrder info) through RMI
 * @author generated code
 * @return ReturnDataResultSetGroup or void
 * @exception RemoteException, MiddlewareException
 */
  public void remoteGBL7549
  (
    String enterprise
  , int oPWGID
  , String entityType
  ) throws RemoteException, MiddlewareException;
/**
 * Exposes stored procedure GBL7567 (Grab a specific error message from the MetaDescription table) through RMI
 * @author generated code
 * @return ReturnDataResultSetGroup or void
 * @exception RemoteException, MiddlewareException
 */
  public ReturnDataResultSetGroup remoteGBL7567
  (
    String enterprise
  , String descriptionType
  , int nlsID
  ) throws RemoteException, MiddlewareException;
/**
 * Exposes stored procedure GBL8004 (Pulls back the Action Template used in GBL8000 for API use) through RMI
 * @author generated code
 * @return ReturnDataResultSetGroup or void
 * @exception RemoteException, MiddlewareException
 */
  public ReturnDataResultSetGroup remoteGBL8004
  (
    String enterprise
  , String entityType
  , String actionType
  ) throws RemoteException, MiddlewareException;
}
