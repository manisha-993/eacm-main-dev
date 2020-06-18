//
// Copyright (c) 2004, International Business Machines Corp., Ltd.
// All Rights Reserved.
// Licensed for use in connection with IBM business only.
//
// $Log: CalendarAdjust.java,v $
// Revision 1.4  2005/03/10 23:21:25  dave
// do not throw column conversion in int/long
//
// Revision 1.3  2004/08/23 23:39:29  gregg
// getVersion() method
//
// Revision 1.2  2004/08/23 16:44:25  gregg
// update
//
//

package COM.ibm.eannounce.hula;

import java.util.*;
import java.text.*;

public class CalendarAdjust {

	static final long serialVersionUID = 20011106L;

	private SimpleDateFormat dateFormat = new SimpleDateFormat();

	public CalendarAdjust() {}

	/*
	 _pattern a date pattern "yyyy-MM-dd"
	 _date the string of the date "2004-08-10"
	 */
	public Date getDate(String _pattern, String _date) {
		dateFormat.applyPattern(_pattern);
		try {
			return dateFormat.parse(_date);
		} catch (ParseException _pe) {
			_pe.printStackTrace();
		}
		return null;
	}

	/*
	 this function doesNot adjust subsequent fields.
	 _date the date to adjust
	 _field the field to adjust
	 _amount the amount to adjust by
	 */
	public Date dateRoll(Date _date, int _field, int _amount) {
		if (_date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(_date);
			cal.roll(_field,_amount);
			return cal.getTime();
		}
		return null;
	}

	/*
	 this function will adjust subsequent fields if required

	 _date the date to adjust
	 _field the field to adjust
	 _amount the amount to adjust by
	 */
	public Date dateAdd(Date _date, int _field, int _amount) {
		if (_date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(_date);
			cal.add(_field,_amount);
			return cal.getTime();
		}
		return null;
	}

	public String formatDate(Date _date, String _format) {
		dateFormat.applyPattern(_format);
		return dateFormat.format(_date);
	}

	public static void main(String[] _args) {
		CalendarAdjust dr = new CalendarAdjust();
		if (_args == null || _args.length != 4) {
			String[] args = {"yyyy-MM-dd","2004-08-10","6","-28"};
			_args = args;
		}
		Date in = dr.getDate(_args[0],_args[1]);
		Date roll = dr.dateRoll(in,toInt(_args[2]),toInt(_args[3]));
		Date add = dr.dateAdd(in,toInt(_args[2]),toInt(_args[3]));
		System.out.println("input date(0): " + in);
		System.out.println("roll date(0) : " + roll);
		System.out.println("add date(0)  : " + add);
		System.out.println("form date(0) : " + dr.formatDate(add,_args[0]));

		_args[1] = "2004-03-10";
		in = dr.getDate(_args[0],_args[1]);
		roll = dr.dateRoll(in,toInt(_args[2]),toInt(_args[3]));
		add = dr.dateAdd(in,toInt(_args[2]),toInt(_args[3]));
		System.out.println("input date(1): " + in);
		System.out.println("roll date(1) : " + roll);
		System.out.println("add date(1)  : " + add);
		System.out.println("form date(1) : " + dr.formatDate(add,_args[0]));

		_args[1] = "2004-01-10";
		in = dr.getDate(_args[0],_args[1]);
		roll = dr.dateRoll(in,toInt(_args[2]),toInt(_args[3]));
		add = dr.dateAdd(in,toInt(_args[2]),toInt(_args[3]));
		System.out.println("input date(2): " + in);
		System.out.println("roll date(2) : " + roll);
		System.out.println("add date(2)  : " + add);
		System.out.println("form date(2) : " + dr.formatDate(add,_args[0]));

		System.exit(0);
		return;
	}

	private static int toInt(String _s) {
		try {
			return Integer.valueOf(_s).intValue();
		} catch (NumberFormatException nfe) {
			//_nfe.printStackTrace();
		}
		return 0;
	}

/*
 * Version info
 */
	public String getVersion() {
	    return new String("$Id: CalendarAdjust.java,v 1.4 2005/03/10 23:21:25 dave Exp $");
    }
}
