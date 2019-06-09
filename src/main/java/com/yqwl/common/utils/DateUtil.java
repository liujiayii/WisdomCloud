package com.yqwl.common.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期工具类
 */
public class DateUtil {
	/** 记录日志 */
	private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

	/** 年月日 yyyy-MM-dd */
	public static final String DATE_FORMAT = "yyyy-MM-dd";

	/** 24小时制 yyyy-MM-dd HH:mm:ss */
	public static final String DATETIMEPATTERN24H = "yyyy-MM-dd HH:mm:ss";

	/**
	 * Base ISO 8601 Date format yyyyMMdd i.e., 20021225 for the 25th day of
	 * December in the year 2002
	 */
	public static final String ISO_DATE_FORMAT = "yyyyMMdd";

	/** Default lenient setting for getDate. */
	private static final boolean LENIENTDATE = false;

	/** 一天的秒数 **/
	private static final int DAYSERCOND = 24 * 60 * 60;

	/**
	 * 返回当前日期字符串
	 * 
	 * @param pattern
	 *            日期字符串样式
	 * @return
	 */
	public static String getCurrentDateString(String pattern) {
		return dateToString(getCurrentDateTime(), pattern);
	}

	/**
	 * 字符串转换为日期java.util.Date
	 * 
	 * @param dateText
	 *            字符串
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static Date stringToDate(String dateString) {
		return stringToDate(dateString, DATE_FORMAT, LENIENTDATE);
	}

	/**
	 * 字符串转换为日期java.util.Date
	 * 
	 * @param dateText
	 *            字符串
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static Date stringToDateTime(String dateString) {
		return stringToDate(dateString, DATETIMEPATTERN24H, LENIENTDATE);
	}

	/**
	 * 字符串转换为时间戳java.sql.Timestamp
	 * 
	 * @param dateText
	 *            字符串
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static Timestamp stringDatetimeToTimestamp(String dateString) {
		if (dateString == null || dateString.trim().length() == 0) {
			return null;
		}
		if (dateString.trim().length() <= 10) {
			dateString = dateString.trim().concat(" 00:00:00");
		}
		Date date = stringToDate(dateString, DATETIMEPATTERN24H, LENIENTDATE);
		if (date == null) {
			return null;
		}
		return new Timestamp(date.getTime());
	}

	/**
	 * 字符串转换为日期java.util.Date
	 * 
	 * @param dateText
	 *            字符串
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static Date stringToDate(String dateString, String format) {
		return stringToDate(dateString, format, LENIENTDATE);
	}

	/**
	 * 字符串转换为日期java.util.Date(如果字符串为空或不能转换则返回null，不报异常)
	 * 
	 * @param dateText
	 *            字符串
	 * @param format
	 *            日期格式
	 * @param lenient
	 *            日期越界标志
	 * @return
	 */
	public static Date stringToDate(String dateText, String format, boolean lenient) {
		if (dateText == null) {
			return null;
		}
		dateText = dateText.replaceAll("\\+", " ");
		DateFormat df = null;
		try {
			if (format == null) {
				df = new SimpleDateFormat();
			} else {
				df = new SimpleDateFormat(format);
			}
			// setLenient avoids allowing dates like 9/32/2001
			// which would otherwise parse to 10/2/2001
			df.setLenient(false);
			df.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
			return df.parse(dateText);
		} catch (ParseException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * 返回当前时间
	 * 
	 * @return 返回当前时间
	 */
	public static Date getCurrentDateTime() {
		java.util.Calendar calNow = java.util.Calendar.getInstance();
		java.util.Date dtNow = calNow.getTime();
		return dtNow;
	}

	/**
	 * 返回当前时间戳
	 * 
	 * @return 返回当前时间戳
	 */
	public static Timestamp getCurrentTimestamp() {
		java.util.Calendar calNow = java.util.Calendar.getInstance();
		return new Timestamp(calNow.getTimeInMillis());
	}

	/**
	 * 根据时间变量返回时间字符串
	 * 
	 * @return 返回时间字符串
	 * @param pattern
	 *            时间字符串样式
	 * @param date
	 *            时间变量
	 */
	public static String dateToString(Object date, String pattern) {
		if (date == null) {
			return null;
		}
		try {
			SimpleDateFormat sfDate = new SimpleDateFormat(pattern);
			sfDate.setLenient(false);
			return sfDate.format(date);
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * 获取几天的秒数
	 * 
	 * @param day
	 * @return
	 */
	public static int transformDayToSecond(int day) {
		return day * DAYSERCOND;
	}

	/**
	 * 取得当前年
	 * 
	 * @return
	 */
	public static int getCurrentYear() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		return Integer.parseInt(df.format(new Date()));
	}

	/**
	 * 取得当前年月
	 * 
	 * @return
	 */
	public static int getCurrentYearMonth() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
		return Integer.parseInt(df.format(new Date()));
	}

	/**
	 * 取得指定日期年月 yyyy-MM
	 * 
	 * @return
	 */
	public static String getYearMonth(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
		return df.format(date);
	}

	/**
	 * 取得当前年月日
	 * 
	 * @return
	 */
	public static int getCurrentYearMonthDay() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		return Integer.parseInt(df.format(new Date()));
	}

	/**
	 * 日期转换格式 yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}

	/**
	 * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
	 * 
	 * @param nowTime
	 *            当前时间
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return
	 * @author jqlin
	 */
	public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
		if (nowTime.getTime() == startTime.getTime() || nowTime.getTime() == endTime.getTime()) {
			return true;
		}

		Calendar date = Calendar.getInstance();
		date.setTime(nowTime);

		Calendar begin = Calendar.getInstance();
		begin.setTime(startTime);

		Calendar end = Calendar.getInstance();
		end.setTime(endTime);

		if (date.after(begin) && date.before(end)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获取时间 小时:分;秒 HH:mm:ss
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date getTimeShort(Date date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		String dateString = formatter.format(date);
		return formatter.parse(dateString);
	}
	
	public static Date getTime(Date date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(DATETIMEPATTERN24H);
		String dateString = formatter.format(date);
		return formatter.parse(dateString);
	}

	/****
	 * 传入具体日期 ，返回具体日期减少N天   
	 * 
	 * @param date
	 * @param i
	 * @throws ParseException 
	 *              
	 */

	public static String subDay(Date date,int i) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date); 
		calendar.add(Calendar.DATE, i);
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		return sdf.format(calendar.getTime()); 
	}
	public static Date subDayToDate(Date date,int i) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date); 
		calendar.add(Calendar.DATE, i);
		return calendar.getTime(); 
	}

}