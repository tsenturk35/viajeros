/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.viajeros.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Ritesh
 */
public class DateUtil {

	public static String getFormatedDate(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				Constants.DATE_FORMAT);
		return dateFormat.format(date);
	}

	public static String getFormatedDateTime(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				Constants.DATE_TIME_FORMAT);
		return dateFormat.format(date);
	}

	public static String getFormatedDateTime(java.sql.Timestamp timeStamp) {
		long time = timeStamp.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				Constants.DATE_TIME_FORMAT);
		return dateFormat.format(new Date(time));
	}

	public static Date parseDate(String date) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				Constants.DATE_FORMAT);
		Date parsedDate = dateFormat.parse(date);
		return new Date(parsedDate.getTime());
	}

	public static java.sql.Timestamp parseDateTime(String dateTime)
			throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				Constants.DATE_FORMAT);
		Date parsedDate = dateFormat.parse(dateTime);
		return new java.sql.Timestamp(parsedDate.getTime());
	}

	public static java.sql.Timestamp getCurrentTimeStamp() {
		return new java.sql.Timestamp(new Date().getTime());
	}

	public static java.sql.Date getCurrentDate() {
		return new java.sql.Date(new Date().getTime());
	}

}
