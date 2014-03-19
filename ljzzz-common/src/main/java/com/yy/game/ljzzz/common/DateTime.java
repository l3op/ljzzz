package com.yy.game.ljzzz.common;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang.time.DateUtils;

/**
 * 日期、时间工具类
 * @author dingtianbao
 *
 */
public final class DateTime {

	/** 默认日期时间格式 */
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/** 默认日期格式 */
	public static final String DATE_FORMAT = "yyyy-MM-dd";

	/** 默认时间格式 */
	public static final String TIME_FORMAT = "HH:mm:ss";
	
	public static final long _1_SECOND = 1000l;
	/**
	 * 1分钟的毫秒数
	 */
	public static final long _1_MINUTE = 60 * _1_SECOND;

	/** 1小时的毫秒数*/
	public static final long _1_HOUR = 60 * _1_MINUTE;

	/** 1天的毫秒数*/
	public static final long _1_DAY = 24 * _1_HOUR;
	
	/** 日期格式，MM-dd */
	public static final String DAY_FORMAT = "MM-dd";
	
	/**
	 * 静态工具方法,防止实例化
	 */
	private DateTime() {
		throw new AssertionError();
	}

	/**
	 * 把 java.util.Date 转换为 java.sql.Timestamp
	 * @param date - 指定时间
	 * @return - {@link Timestamp}
	 */
	public static Timestamp getTimestamp(Date date) {
		if (date != null) {
			return new Timestamp(date.getTime());
		}
		return null;
	}
	
	public static boolean isToday(Date time) {
		if(null == time) {
			return false;
		}
		
		Date now = new Date();
		return toString(now, DATE_FORMAT).equals(toString(time, DATE_FORMAT));
	}
	
	/**
	 * 2个时间相差的分钟数
	 * @param big
	 * @param small
	 * @return
	 */
	public static int differenceMinute(Date big, Date small) {
		long difference = big.getTime() - small.getTime();
		return (int)(difference/1000/60);
	}

	/**
	 * 字符转化日期
	 * @param dateStr - 字符型日期,至少有 (年-月-日)
	 * @param format - 格式
	 * @return - {@link Date}
	 */
	public static Date fromString(String dateStr, String format) {
		Date date = null;
		DateFormat dateFormat = new SimpleDateFormat(format);
		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			dateStr = dateStr.replaceAll("[/\\.]", "-");
			try {
				date = dateFormat.parse(dateStr);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		return date;
	}
	
	/**
	 * 返回今天0点的时间对象
	 * @return
	 */
	public static Date today0() {
		String today = getDate(new Date());
		return getDate(today);
	}

	/**
	 * 格式化日期
	 * @param dateStr - 字符型日期
	 * @return - {@link Date} (Sun Apr 04 00:00:00 CST 2010)
	 */
	public static Date getDate(String dateStr) {
		return fromString(dateStr, DATE_FORMAT);
	}

	/**
	 * 格式化日期
	 * @param dateStr - 字符型日期
	 * @return - {@link Date} (Sun Apr 04 16:20:00 CST 2010)
	 */
	public static Date getDateTime(String dateStr) {
		return fromString(dateStr, DATE_TIME_FORMAT);
	}

	/**
	 * 格式化字符日期时间
	 * @param date - 日期
	 * @param format - 格式
	 * @return - String 返回字符型日期
	 */
	public static String toString(Date date, String format) {
		if (date != null) {
			DateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.format(date);
		}
		return null;
	}

	/**
	 * 格式化日期时间
	 * @param date - 日期
	 * @return - String (2007-04-04 16:20:00)
	 */
	public static String getDateTime(Date date) {
		return toString(date, DATE_TIME_FORMAT);
	}

	/**
	 * 返回日期
	 * @param date - 日期
	 * @return - String (2007-04-04)
	 */
	public static String getDate(Date date) {
		return toString(date, DATE_FORMAT);
	}

	/**
	 * 返回时间
	 * @param date - 日期
	 * @return - String (16:20:00)
	 */
	public static String getTime(Date date) {
		return toString(date, TIME_FORMAT);
	}

	/**
	 * 返回下一次出现指定日期的时间
	 * @param weekDay - 取Calendar.DAY_OF_WEEK
	 * @param hour - 小时
	 * @param minute - 分
	 * @param second - 秒
	 * @return - {@link Date}
	 */
	public static Date getNextDate(int weekDay, int hour, int minute, int second) {
		long now = System.currentTimeMillis();
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(now);
		int currentWeekDay = cal.get(Calendar.DAY_OF_WEEK);
		int addDay = 0;

		if (currentWeekDay == weekDay) {
			cal.set(Calendar.HOUR_OF_DAY, hour);
			cal.set(Calendar.MINUTE, minute);
			cal.set(Calendar.SECOND, second);
			if (cal.getTime().getTime() < now) {
				currentWeekDay ++;
				currentWeekDay = currentWeekDay == 8 ? 1 : currentWeekDay;
				addDay ++;
			}
		}

		while (currentWeekDay != weekDay) {
			currentWeekDay ++;
			currentWeekDay = currentWeekDay == 8 ? 1 : currentWeekDay;
			addDay ++;
		}

		cal.add(Calendar.DAY_OF_MONTH, addDay);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, second);

		return cal.getTime();
	}

	/**
	 * 返回小时
	 * @return
	 */
	public static int getHour() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 返回小时
	 * @param date - 日期
	 * @return int - 小时
	 */
	public static int getHour(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 返回分钟
	 * @param date - 日期
	 * @return int - 分钟
	 */
	public static int getMinute(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MINUTE);
	}

	/**
	 * 返回秒钟
	 * @param date - 日期
	 * @return int - 秒钟
	 */
	public static int getSecond(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.SECOND);
	}

	/**
	 * 返回n年前/后的年份
	 * @param date 日期
	 * @param n - 系数(n可为负数)
	 * @return int - 年份
	 */
	public static int getYear(Date date, int n) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR) + n;
	}

	/**
	 * 返回n月前/后的月份
	 * @param date - 给定时间
	 * @param n - 系数(n可为负数)
	 * @return - int 月份
	 */
	public static int getMonth(Date date, int n) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.MONTH, c.get(Calendar.MONTH) + n);
		return c.get(Calendar.MONTH) + 1;
	}

	/**
	 * 返回n日后是日份
	 * @param date - 日期
	 * @param n - 系数(n可为负数)
	 * @return int - 日份
	 */
	public static int getDay(Date date, int n) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH) + n;
	}

	/**
	 * 计算N天前/后的时间
	 * @param date - 日期
	 * @param day - 天数
	 * @return - {@link Date}
	 */
	public static Date addDate(Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(date.getTime() + day * _1_DAY);
		return c.getTime();
	}

	/**
	 * 获得 N小时后的时间
	 * @param time - 当前时间
	 * @param hours - 小时
	 * @return - {@link Date}
	 */
	public static Date addHours(Date date, int hours) {
		if (date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.HOUR, hours);
			return cal.getTime();
		}
		return null;
	}

	/**
	 * 获得 N秒后的时间
	 * @param date - 当前时间
	 * @param seconds - 秒
	 * @return - {@link Date}
	 */
	public static Date addSeconds(Date date, int seconds) {
		if (date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.SECOND, seconds);
			return cal.getTime();
		}
		return null;
	}

	/**
	 * 计算两日期之间的天数
	 * @param start - 起始时间
	 * @param end - 结束时间
	 * @return - int 相差天数
	 */
	public static int getDayCount(Date start, Date end) {
		long s = start.getTime() / _1_DAY;
		long e = end.getTime() / _1_DAY;
		return (int)Math.abs(e - s);
	}

	/**
	 * 计算两日期之间的天数
	 * @param start - 起始时间
	 * @param end - 结束时间
	 * @return - int 相差天数
	 */
	public static int getDayCount(String start, String end) {
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
		try {
			return getDayCount(format.parse(start), format.parse(end));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 取指定时间所在月份的第一天
	 * @param date - 指定时间
	 * @return String - 第一天时间
	 */
	public static String getMonthBegin(Date date) {
		if (date != null) {
			return toString(date, "yyyy-MM") + "-01";
		}
		return null;
	}

	/**
	 * 取指定时间所在月份的最后一天
	 * @param date - 指定时间
	 * @return String - 最后一天时间
	 */
	public static String getMonthEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.setTime(getDate(getMonthBegin(calendar.getTime())));
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		return getDateTime(calendar.getTime());
	}

	/**
	 * 计算传入值是否是给定星期
	 * @param date - 给定日期（2007-03-22）
	 * @param weekDay - 给定星期
	 * @return boolean - 是返回true
	 */
	public static boolean checkWeek(String date, int weekDay) {
		boolean flag = false;
		if(date.length() >= 10) {
			weekDay = weekDay == 7 ? 1 : weekDay;
			date = date.replaceAll("[/\\.]", "-");
			Calendar cal = Calendar.getInstance();
			cal.setTime(java.sql.Date.valueOf(date));
			return cal.get(Calendar.DAY_OF_WEEK) == weekDay;
		}
		return flag;
	}

	/**
	 * Description: 获取GMT8时间
	 * @return 将当前时间转换为GMT8时区后的Date
	 */
	public static Date getGMT8Time() {
		Date gmt8 = null;
		try {
			Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"), Locale.CHINESE);
			Calendar day = Calendar.getInstance();
			day.set(Calendar.YEAR, cal.get(Calendar.YEAR));
			day.set(Calendar.MONTH, cal.get(Calendar.MONTH));
			day.set(Calendar.DATE, cal.get(Calendar.DATE));
			day.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY));
			day.set(Calendar.MINUTE, cal.get(Calendar.MINUTE));
			day.set(Calendar.SECOND, cal.get(Calendar.SECOND));
			gmt8 = day.getTime();
		} catch (Exception e) {
			e.printStackTrace();
			gmt8 = null;
		}
		return gmt8;
	}
	
	/**
	 * 获得昨天的时间
	 * @return
	 */
	public static String getYesterday() {
		Date yesterday = DateUtils.addDays(new Date(), -1);
		String str = DateTime.toString(yesterday, "yyyy-MM-dd");
		return str;
	}
	
	/**
	 * 昨天的00点
	 * @return
	 */
	public static Date getYesterday00() {
		Date time = DateTime.fromString(getYesterday() + " 00:00:00", "yyyy-MM-dd HH:mm:ss");
		return time;
	}
	
	/**
	 * 昨天的23点
	 * @return
	 */
	public static Date getYesterday23() {
		Date time = DateTime.fromString(getYesterday() + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
		return time;
	}
	
	/**
	 * 生成当前日期时Date对象
	 * @param day 日期,格式(MM-dd)
	 * @return
	 */
	public static Date parseDay(String day, int addDay){
		Date time = null;
		if(day.matches("\\d{2}-\\d{2}")){
			time = DateTime.fromString(getYear(new Date(), 0) + "-" + day + " 00:00:00", "yyyy-MM-dd HH:mm:ss");
		}
		return DateUtils.addDays(time, addDay);
	}
}
