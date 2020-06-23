//Licensed Materials -- Property of IBM

//(C) Copyright IBM Corp. 2012  All Rights Reserved.
//The source code for this program is not published or otherwise divested of
//its trade secrets, irrespective of what has been deposited with the U.S. Copyright office.

package com.ibm.eacm.nav;

import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ibm.eacm.actions.*;
import com.ibm.eacm.mw.DBSwingWorker;
import com.ibm.eacm.mw.RMIMgr;
import com.ibm.eacm.objects.OutOfRangeException;
import com.ibm.eacm.objects.Utils;


import COM.ibm.eannounce.objects.*;

/**
 * this is used for Navigate.. what is this? how to test?
 * @author Wendy Stimpson
 */
//$Log: EANABRViewAction.java,v $
//Revision 1.3  2014/10/20 19:56:07  wendy
//Add worker id to timing log output
//
//Revision 1.2  2013/07/18 20:06:19  wendy
//throw outofrange exception from base class and catch in derived action classes
//
//Revision 1.1  2012/09/27 19:39:14  wendy
//Initial code
//
public class EANABRViewAction extends EANNavActionBase {
	private static final long serialVersionUID = 1L;

	public EANABRViewAction(EANActionItem act,Navigate n,EANActionSet p) {
		super(act,n,ACTION_PURPOSE_ABRSTATUS,p);
	}

	public void actionPerformed(ActionEvent e) {
		outputStartInfo();

		EntityItem[] ei = null;
		try{
			ei = getEntityItems(false);
        } catch (OutOfRangeException range) {
        	com.ibm.eacm.ui.UI.showFYI(getNavigate(),range);
        	return;
        }
		
        if(!checkValidSingleInput(ei)){ // make sure this action has correct number ei selected
        	return;
        }
		if (ei != null) {
			outputDebug(ei);
			getNavigate().disableActionsAndWait(); //disable all other actions and also set wait cursor
			worker = new NavWorker(ei);
			RMIMgr.getRmiMgr().execute(worker);
		}
	}
	private class NavWorker extends DBSwingWorker<EntityList, Void> { 
		private EntityItem[] eia = null;
		private long t11 = 0L;
		NavWorker(EntityItem[] ei){
			eia = ei;
		}
		@Override
		public EntityList doInBackground() {
			EntityList list = null;
			try{		
				t11 = System.currentTimeMillis();
				Logger.getLogger(TIMING_LOGGER).log(Level.INFO,"starting "+getIdStr());
				list = navigate((ABRStatusActionItem) getEANActionItem(), eia);
			}catch(Exception ex){ // prevent hang
				Logger.getLogger(NAV_PKG_NAME).log(Level.SEVERE,"Exception "+ex,ex);
			}finally{
				Logger.getLogger(TIMING_LOGGER).log(Level.INFO,getIdStr()+" bg ended "+Utils.getDuration(t11));
				RMIMgr.getRmiMgr().complete(this);
				worker = null;
			}

			return list;
		}

		@Override
		public void done() {
			//this will be on the dispatch thread
			try {
				if(!isCancelled()){
					EntityList list = get();
					if (list !=null){
						// abrviews are shown in separate frame
						getNavigate().showPicklist(list);
					}
					clearAction(eia);	// why do this?
				}
			} catch (InterruptedException ignore) {}
			catch (java.util.concurrent.ExecutionException e) {
				listErr(e,"getting entity list");
			}finally{  
				Logger.getLogger(TIMING_LOGGER).log(Level.INFO,getIdStr()+" dispatch ended "+Utils.getDuration(t11));
				eia = null;
				getNavigate().enableActionsAndRestore();	
			}
		}
		public void notExecuted(){
			Logger.getLogger(NAV_PKG_NAME).log(Level.WARNING,getIdStr()+" not executed");
			getNavigate().enableActionsAndRestore();
			worker = null; 
		}
	}
	private EntityList navigate(ABRStatusActionItem _ai, EntityItem[] _ei) {
		EntityList el = null;
		try {
			EntityList.checkDomain(getNavigate().getProfile(),_ai,_ei); // RQ0713072645
			el = EntityList.getEntityList(ro(),getNavigate().getProfile(), _ai, _ei);
		} catch(DomainException de) { // RQ0713072645
			com.ibm.eacm.ui.UI.showException(getNavigate(),de);
			de.dereference();
		} catch (Exception exc) {
			if(RMIMgr.shouldTryReconnect(exc)){	// try to reconnect
				if (RMIMgr.getRmiMgr().reconnectMain()) {
					try {
						el = EntityList.getEntityList(ro(),getNavigate().getProfile(), _ai, _ei);
					} catch (Exception e) {
						if(RMIMgr.shouldPromptUser(e)){// show user msg and ask what to do
							if (com.ibm.eacm.ui.UI.showMWExcPrompt(getNavigate(), e) == RETRY) {
								el = navigate(_ai, _ei);
							}
						}else{ 
							com.ibm.eacm.ui.UI.showException(getNavigate(),e, "mw.err-title");
						}
					}
				} else{	// reconnect failed
					com.ibm.eacm.ui.UI.showException(getNavigate(),exc, "mw.err-title");
				}
			}else{ // show user msg and ask what to do
				if(RMIMgr.shouldPromptUser(exc)){
					if (com.ibm.eacm.ui.UI.showMWExcPrompt(getNavigate(), exc) == RETRY) {
						el = navigate(_ai, _ei);
					}// else user decide to ignore or exit	
				}else{
					com.ibm.eacm.ui.UI.showException(getNavigate(),exc, "mw.err-title");
				}
			}
		}
		return el;
	}
}
