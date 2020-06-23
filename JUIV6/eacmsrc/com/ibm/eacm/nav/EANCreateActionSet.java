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
 * used for the collection of Navigate create actions, it will be used with a button and menu
 * @author Wendy Stimpson
 */
// $Log: EANCreateActionSet.java,v $
// Revision 1.1  2012/09/27 19:39:13  wendy
// Initial code
//
public class EANCreateActionSet extends EANActionSet {
	private static final long serialVersionUID = 1L;
	private Navigate parent=null;
	
	/**
	 * create action to hold all NAV create actions
	 * @param n
	 * 
	 */
	public EANCreateActionSet(Navigate n){
		super(NAVCRT_ACTIONSET,KeyEvent.VK_6, Event.CTRL_MASK);
	    putValue(Action.LARGE_ICON_KEY, Utils.getImageIcon("new.gif"));
	    parent = n;
	}

	protected void addActions() {
		if(eai.length==1){
			singleAction = getEANAction(eai[0].getActionItemKey());
			if (singleAction==null){
				singleAction = new EANCreateAction(eai[0],parent,this);
				addAction(singleAction);
			}
			popup.add(singleAction);	 // share one action
		}else{
			for (int i=0;i<eai.length;++i) { // must build this for the menu
				EANAction act = getEANAction(eai[i].getActionItemKey());
				if(act==null){
					act = new EANCreateAction(eai[i],parent,this);
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
		return true;
	}
}
