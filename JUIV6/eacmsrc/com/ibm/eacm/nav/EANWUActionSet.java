//Licensed Materials -- Property of IBM
//
// (C) Copyright IBM Corp. 2012  All Rights Reserved.
// The source code for this program is not published or otherwise divested of
// its trade secrets, irrespective of what has been deposited with the U.S. Copyright office.
//
package com.ibm.eacm.nav;

import java.awt.Event;

import java.awt.event.KeyEvent;

import javax.swing.Action;

import com.ibm.eacm.actions.*;
import com.ibm.eacm.objects.Utils;

/*******
 * 
 * used for the collection of Navigate whereused actions, it will be used with a button and menu
 * @author Wendy Stimpson
 */
// $Log: EANWUActionSet.java,v $
// Revision 1.2  2013/09/09 20:37:23  wendy
// only enable set if actions exist
//
// Revision 1.1  2012/09/27 19:39:14  wendy
// Initial code
//
public class EANWUActionSet extends EANActionSet {
	private static final long serialVersionUID = 1L;
	private Navigate parent=null;
	
	/**
	 * whereused actionset to hold all NAV whereused actions
	 * @param n
	 * 
	 */
	public EANWUActionSet(Navigate n){
		super(NAVWU_ACTIONSET,KeyEvent.VK_5, Event.CTRL_MASK);
	    putValue(Action.LARGE_ICON_KEY, Utils.getImageIcon("used.gif"));
	    parent = n;
	}

	/* (non-Javadoc)
	 * @see com.ibm.eacm.actions.EACMAction#canEnable()
	 */
	protected boolean canEnable(){ 
		boolean ok = false;
		if(parent !=null && eai != null){
			ok = parent.hasSelectedData();
		}
		return ok; 
	}
	
	/* (non-Javadoc)
	 * @see com.ibm.eacm.actions.EANActionSet#addActions()
	 */
	protected void addActions() {
		if(eai.length==1){
			singleAction = getEANAction(eai[0].getActionItemKey());
			if (singleAction==null){
				singleAction = new EANWuAction(eai[0],parent,this);
				addAction(singleAction);
			}
			popup.add(singleAction);	 // share one action
		}else{
			for (int i=0;i<eai.length;++i) { // must build this for the menu
				EANAction act = getEANAction(eai[i].getActionItemKey());
				if(act==null){
					act = new EANWuAction(eai[i],parent,this);	
					addAction(act);
				}

				popup.add(act);	
			}
		}
	}
	
	public void dereference(){
		super.dereference();
		parent = null;
	}

	@Override
	protected boolean shouldEnable() {
		boolean enable = parent.hasSelectedData();
		int cnt= eai.length;
		return enable&& cnt>0;
	}
}
