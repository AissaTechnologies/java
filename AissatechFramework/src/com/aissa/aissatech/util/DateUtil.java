/**
 * 
 */
package com.aissa.aissatech.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Classe di utilità per la gestione delle date
 * @author Camelia Boban
 * @version 1.0
 */
public class DateUtil {
	
	/**
	 * Data in Formato dd-MM-yyyy
	 */
	public static final String STANDARD = "dd-MM-yyyy";
	/**
	 * Data in Formato ddMMyyyy
	 */
	public static final String STANDARD_NOSEP = "ddMMyyyy";
	/**
	 * Data in Formato dd-MM-yyyy HH:mm:ss'
	 */
	public static final String STANDARD_FULL = "dd-MM-yyyy HH:mm:ss";
	/**
	 * Data in Formato ddMMyyyyHHmmss'
	 */
	public static final String STANDARD_FULL_NOSEP = "ddMMyyyyHHmmss";
	/**
	 * Data in Formato yyyy-MM-ddTHH:mm:ss 
	 */
	public static final String STANDARD_FULL_XBRL = "yyyy-MM-dd'T'HH:mm:ss";
	/**
	 * Date in Formato yyyy-MM-dd 
	 */
	public static final String STANDARD_XBRL = "yyyy-MM-dd";
	/**
	 * Data in Formato MM-dd-yyyy
	 */
	public static final String INGLESE = "MM-dd-yyyy";
	/**
	 * Data in Formato yyyy-MM-dd
	 */
	public static final String ISO8601 = "yyyy-MM-dd";
	/**
	 * Data in Formato yyyy-MM-dd HH:mm:ss
	 */
	public static final String ISO8601_FULL = "yyyy-MM-dd HH:mm:ss";
	/**
	 * Data in Formato yyyyMMdd
	 */
	public static final String ISO8601_NOSEP = "yyyyMMdd";
	/**
	 * Data in Formato yyyyMMddHHmmss
	 */
	public static final String ISO8601_FULL_NOSEP = "yyyyMMddHHmmss";
	/**
	 * Data in Formato yyyy-MM-dd HH:mm:ss
	 */
	public static final String MONTH_NAME = "MMMM";	
	/**
	 * Data in Formato yyyyMM
	 */
	public static final String YEAR_MONTH = "yyyyMM";
	/**
	 * Concat date
	 */
	public static final String CONCAT_DATE = "ddMMyyyy";
	/**
	 * Concat date
	 */
	public static final String CONCAT_DATE_2 = "yyyyMMdd";
	
	/**
	 * Restituisce la data corrente
	 * @return Date
	 */
	public static Date now(){
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}
	
	/**
	 * Restituisce un oggetto data corrispondente
	 * alla stringa passata nel formato specificato
	 * @param _format
	 * @param _date
	 * @return Date
	 * @throws ParseException
	 */
	public static Date parse(String _format, String _date) throws ParseException{
		DateFormat df = new SimpleDateFormat(_format);
		return df.parse(_date);
	}
	
	/**
	 * Restituisce una data rappresentata dalla stringa
	 * 
	 * @param date La stringa che rappresenta la data in formato AAAAMMGG
	 * @return La data rappresentata dalla stringa nel formato standard
	 * @throws ParseException 
	 */
	public static Date parse(String date) throws ParseException {
		if(date != null && date.length() == 8){
			String anno = date.substring(0, 4);
			String mese = date.substring(4, 6);
			String giorno = date.substring(6);
			return parse(ISO8601, anno + "-" + mese + "-" + giorno);
		}else{
			throw new ParseException("Parser data non possibile",0);
		}
	}
	
	/**
	 * Restituisce una stringa contente una data
	 * nel formato specificato
	 * @param _format
	 * @param _date
	 * @return String
	 */
	public static String format(String _format, Date _date){
		DateFormat df = new SimpleDateFormat(_format);
		return df.format(_date);
	}
	
	public static Date startMonthYear(Date _date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}
	
	public static Date startMonthYear(String _format, Date _date) throws ParseException{
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		DateFormat df = new SimpleDateFormat(_format);
		return df.parse(df.format(cal.getTime()));
	}
	
	public static Date endMonthYear(Date _date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}
	
	public static Date endMonthYear(String _format, Date _date) throws ParseException{
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		DateFormat df = new SimpleDateFormat(_format);
		return df.parse(df.format(cal.getTime()));
	}
	
	public static Date startYear(Date _date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.MONTH, 0);
		return cal.getTime();
	}
	
	public static Date startYear(String _format, Date _date) throws ParseException{
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.MONTH, 0);
		DateFormat df = new SimpleDateFormat(_format);
		return df.parse(df.format(cal.getTime()));
	}
	
	public static Date endYear(Date _date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		cal.set(Calendar.MONTH, 11);
		return cal.getTime();
	}
	
	public static Date endYear(String _format, Date _date) throws ParseException{
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		cal.set(Calendar.MONTH, 11);
		DateFormat df = new SimpleDateFormat(_format);
		return df.parse(df.format(cal.getTime()));
	}
	
	public static Date startLastTrim(Date _date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		cal.add(Calendar.MONTH, -2);
		cal.set(Calendar.DAY_OF_MONTH, 1);		
		return cal.getTime();
	}
	
	public static Date startLastTrim(String _format, Date _date) throws ParseException{
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		cal.add(Calendar.MONTH, -2);
		cal.set(Calendar.DAY_OF_MONTH, 1);		
		DateFormat df = new SimpleDateFormat(_format);
		return df.parse(df.format(cal.getTime()));
	}
	
	public static int getYear(Date _date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		return cal.get(Calendar.YEAR);
	}
	
	public static String getMounthName(Date _date){
		DateFormat df = new SimpleDateFormat(MONTH_NAME,Locale.ITALIAN);
		return df.format(_date);
	}
	
	public static Date addDay(Date _date, int _day){
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		cal.add(Calendar.DAY_OF_MONTH, _day);
		return cal.getTime();
	}
	
	public static Date addMonth(Date _date, int _month){
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		cal.add(Calendar.MONTH, _month);
		return cal.getTime();
	}
	
	public static Date addYear(Date _date, int _year){
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		cal.add(Calendar.YEAR, _year);
		return cal.getTime();
	}
	
	public static int dayOfWeek(Date _date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}
	
	public static int month(Date _date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		return cal.get(Calendar.MONTH);
	}
	
	public static int day(Date _date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public static String quarterlyForTrigger(Date _date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		int trim = cal.get(Calendar.MONTH) + 1;
		return trim==1?"1,4,7,10":trim==2?"2,5,8,11":"3,6,9,12";
	}
	
	public static String fourMonthlyForTrigger(Date _date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		int quad = cal.get(Calendar.MONTH) + 1;
		return quad==1?"1,5,9":quad==2?"2,6,10":quad==3?"3,7,11":"4,8,12";
	}
	
	public static String semestralForTrigger(Date _date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		int sem = cal.get(Calendar.MONTH) + 1;
		return sem==1?"1,7":sem==2?"2,80":sem==3?"3,9":sem==4?"4,10":sem==5?"5,11":"6,12";
	}
	
	public static int calcultateAge(Date _date){
		Calendar calDob = Calendar.getInstance();  
		calDob.setTime(_date);
		Calendar calNow = Calendar.getInstance();
		int age = (calNow.get(Calendar.YEAR) - calDob.get(Calendar.YEAR));  
		int ageMo = (calNow.get(Calendar.MONTH) - calDob.get(Calendar.MONTH));
		if (ageMo < 0) age--;
		return age;
	}
	
	public static String makeCronExpression(Date _date){
		Calendar cal = Calendar.getInstance();  
		cal.setTime(_date);
		
		String exp = "";
		// Secondi
		exp += "0 ";
		// Minuti
		exp += cal.get(Calendar.MINUTE) + " ";
		// Ore
		exp += cal.get(Calendar.HOUR_OF_DAY) + " ";
		// Giorno del mese
		exp += cal.get(Calendar.DAY_OF_MONTH) + " ";
		// Mese
		exp += (cal.get(Calendar.MONTH) + 1) + " ";
		// Giorno della settimana
		exp += "? ";
		// Anno
		exp += cal.get(Calendar.YEAR);
				
		return exp;
	}
}
