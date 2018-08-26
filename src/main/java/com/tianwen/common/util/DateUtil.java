package com.tianwen.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.Vector;

/**
 * 
 * 功能描述：完成与日期相关的各种操作
 *
 * <p>
 * 包括将日期格式化、从字符串中解析出对应的日期、对日期的加减操作等
 * 
 * @author maluming 2011-4-14
 * @see
 * @since 1.0
 */
public class DateUtil {
	/**
	 * 功能描述：按照给出格式解析出日期
	 * 
	 * @param dateStr
	 *            String 字符型日期
	 * @param format
	 *            String 格式
	 * @return Date 日期
	 */
	public static Date parseDate(String dateStr, String format) {
		Date date = null;
		try {
			DateFormat df_parseDate = new SimpleDateFormat(format);
			String dt = dateStr;
			date = (Date) df_parseDate.parse(dt);
		} catch (Exception e) {
		}
		return date;
	}

	/**
	 * 功能描述：格式化日期
	 * 
	 * @param dateStr
	 *            String 字符型日期：YYYY-MM-DD 格式
	 * @return Date
	 */
	public static Date parseDate(String dateStr) {
		return parseDate(dateStr, "yyyy-MM-dd");
	}

	/**
	 * 功能描述：格式化输出日期
	 * 
	 * @param date
	 *            Date 日期
	 * @param format
	 *            String 格式
	 * @return 字符型日期
	 */
	public static String format(Date date, String format) {
		String result = "";
		try {
			if (date != null) {
				DateFormat df_format = new SimpleDateFormat(format);
				result = df_format.format(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 功能描述：返回字符型日期
	 * 
	 * @param date
	 *            日期
	 * @return 返回字符型日期 yyyy/MM/dd 格式
	 */
	public static String getDate(Date date) {
		return format(date, "yyyy/MM/dd");
	}

	/**
	 * 功能描述：返回字符型时间
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回字符型时间 HH:mm:ss 格式
	 */
	public static String getTime(Date date) {
		return format(date, "HH:mm:ss");
	}

	/**
	 * 功能描述：返回字符型日期时间
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回字符型日期时间 yyyy/MM/dd HH:mm:ss 格式
	 */
	public static String getDateTime(Date date) {
		return format(date, "yyyy/MM/dd HH:mm:ss");
	}

	public static String getMillisDateTime(Date date) {
		return format(date, "yyyy/MM/dd HH:mm:ss.SSS");
	}

	/**
	 * 功能描述：取得指定月份的第一天
	 * 
	 * @param strdate
	 *            String 字符型日期
	 * @return String yyyy-MM-dd 格式
	 */
	public static String getMonthBegin(String strdate) {
		Date date = parseDate(strdate);
		return format(date, "yyyy-MM") + "-01";
	}

	/**
	 * 功能描述：常用的格式化日期
	 * 
	 * @param date
	 *            Date 日期
	 * @return String 日期字符串 yyyy-MM-dd格式
	 */
	public static String formatDate(Date date) {
		return formatDateByFormat(date, "yyyy-MM-dd");
	}

	/**
	 * 功能描述：以指定的格式来格式化日期
	 * 
	 * @param date
	 *            Date 日期
	 * @param format
	 *            String 格式
	 * @return String 日期字符串
	 */
	public static String formatDateByFormat(Date date, String format) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				result = sdf.format(date);
			} catch (Exception ex) {
			}
		}
		return result;
	}

	/**
	 * 计算2个日期之间的相隔天数
	 * 
	 * @param d1
	 *            日期1
	 * @param d2
	 *            日期2
	 * @return 日期1和日期2相隔天数
	 */
	public int getDaysBetween(Calendar d1, Calendar d2) {
		if (d1.after(d2)) {
			// swap dates so that d1 is start and d2 is end
			Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}
		int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
		int y2 = d2.get(Calendar.YEAR);
		if (d1.get(Calendar.YEAR) != y2) {
			d1 = (Calendar) d1.clone();
			do {
				days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
				d1.add(Calendar.YEAR, 1);
			} while (d1.get(Calendar.YEAR) != y2);
		}
		return days;
	}

	/**
	 * 计算2个日期之间的工作天数（去除周六周日）
	 * 
	 * @param d1
	 *            日期1
	 * @param d2
	 *            日期2
	 * @return 日期1和日期2之间的工作天数
	 */
	public int getWorkingDay(Calendar d1, Calendar d2) {
		int result = -1;
		if (d1.after(d2)) {
			// swap dates so that d1 is start and d2 is end
			Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}

		// int betweendays = getDaysBetween(d1, d2);

		// int charge_date = 0;

		// 开始日期的日期偏移量
		int charge_start_date = 0;
		// 结束日期的日期偏移量
		int charge_end_date = 0;

		int stmp;
		int etmp;
		stmp = 7 - d1.get(Calendar.DAY_OF_WEEK);
		etmp = 7 - d2.get(Calendar.DAY_OF_WEEK);

		// 日期不在同一个日期内
		if (stmp != 0 && stmp != 6) {// 开始日期为星期六和星期日时偏移量为0
			charge_start_date = stmp - 1;
		}
		if (etmp != 0 && etmp != 6) {// 结束日期为星期六和星期日时偏移量为0
			charge_end_date = etmp - 1;
		}
		// }
		result = (getDaysBetween(this.getNextMonday(d1), this.getNextMonday(d2)) / 7) * 5 + charge_start_date - charge_end_date;
		// System.out.println("charge_start_date>" + charge_start_date);
		// System.out.println("charge_end_date>" + charge_end_date);
		// System.out.println("between day is-->" + betweendays);
		return result;
	}

	/**
	 * 获取当前星期
	 * 
	 * @param date
	 *            当前日期
	 * @param character
	 *            zh : 标识中文 ， en : 标识英文（默认）
	 * @return 当前日期
	 */
	public String getChineseWeek(Calendar date, String character) {
		String dayNames[] = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

		if ("zh".equals(character)) {
			dayNames[0] = "星期日";
			dayNames[1] = "星期一";
			dayNames[2] = "星期二";
			dayNames[3] = "星期三";
			dayNames[4] = "星期四";
			dayNames[5] = "星期五";
			dayNames[6] = "星期六";
		}
		int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);

		// System.out.println(dayNames[dayOfWeek - 1]);
		return dayNames[dayOfWeek - 1];

	}

	/**
	 * 获得日期的下一个星期一的日期
	 * 
	 * @param date
	 * @return
	 */
	public Calendar getNextMonday(Calendar date) {
		Calendar result = null;
		result = date;
		do {
			result = (Calendar) result.clone();
			result.add(Calendar.DATE, 1);
		} while (result.get(Calendar.DAY_OF_WEEK) != 2);
		return result;
	}

	/**
	 * 计算两个日期之间的非工作日天数
	 * 
	 * @param d1
	 *            日期1
	 * @param d2
	 *            日期2
	 * @return 日期1与日期2之间的非工作天数
	 */
	public int getHolidays(Calendar d1, Calendar d2) {
		return this.getDaysBetween(d1, d2) - this.getWorkingDay(d1, d2);

	}

	/**
	 * 比较日期大小 是否date1小于date2
	 * 
	 * @return
	 */
	public static boolean getDaysEqual(Date date1, Date date2) {
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();

		calendar1.setTime(date1);
		calendar2.setTime(date2);
		if (calendar1.before(calendar2)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 对日期(时间)中的日进行加减计算. <br>
	 * 例子: <br>
	 * 如果Date类型的d为 2005年8月20日,那么 <br>
	 * calculateByDate(d,-10)的值为2005年8月10日 <br>
	 * 而calculateByDate(d,+10)的值为2005年8月30日 <br>
	 * 
	 * @param d
	 *            日期(时间).
	 * @param amount
	 *            加减计算的幅度.+n=加n天;-n=减n天.
	 * @return 计算后的日期(时间).
	 */
	public static Date calculateByDate(Date d, int amount) {
		return DateUtil.calculate(d, GregorianCalendar.DATE, amount);
	}

	public static Date calculateByMinute(Date d, int amount) {
		return DateUtil.calculate(d, GregorianCalendar.MINUTE, amount);
	}

	public static Date calculateByYear(Date d, int amount) {
		return DateUtil.calculate(d, GregorianCalendar.YEAR, amount);
	}

	/**
	 * 对日期(时间)中由field参数指定的日期成员进行加减计算. <br>
	 * 例子: <br>
	 * 如果Date类型的d为 2005年8月20日,那么 <br>
	 * calculate(d,GregorianCalendar.YEAR,-10)的值为1995年8月20日 <br>
	 * 而calculate(d,GregorianCalendar.YEAR,+10)的值为2015年8月20日 <br>
	 * 
	 * @param d
	 *            日期(时间).
	 * @param field
	 *            日期成员. <br>
	 *            日期成员主要有: <br>
	 *            年:GregorianCalendar.YEAR <br>
	 *            月:GregorianCalendar.MONTH <br>
	 *            日:GregorianCalendar.DATE <br>
	 *            时:GregorianCalendar.HOUR <br>
	 *            分:GregorianCalendar.MINUTE <br>
	 *            秒:GregorianCalendar.SECOND <br>
	 *            毫秒:GregorianCalendar.MILLISECOND <br>
	 * @param amount
	 *            加减计算的幅度.+n=加n个由参数field指定的日期成员值;-n=减n个由参数field代表的日期成员值.
	 * @return 计算后的日期(时间).
	 */
	private static Date calculate(Date d, int field, int amount) {
		if (d == null) {
			return null;
		}
		GregorianCalendar g = new GregorianCalendar();
		g.setGregorianChange(d);
		g.add(field, amount);
		return g.getTime();
	}

	/**
	 * 日期(时间)转化为字符串.
	 * 
	 * @param formater
	 *            日期或时间的格式.
	 * @param aDate
	 *            java.util.Date类的实例.
	 * @return 日期转化后的字符串.
	 */
	public static String date2String(String formater, Date aDate) {
		if (formater == null || "".equals(formater)) {
			return null;
		}
		if (aDate == null) {
			return null;
		}
		return (new SimpleDateFormat(formater)).format(aDate);
	}

	/**
	 * 当前日期(时间)转化为字符串.
	 * 
	 * @param formater
	 *            日期或时间的格式.
	 * @return 日期转化后的字符串.
	 */
	public static String date2String(String formater) {
		return DateUtil.date2String(formater, new Date());
	}

	/**
	 * 获取当前日期对应的星期数. <br>
	 * 1=星期天,2=星期一,3=星期二,4=星期三,5=星期四,6=星期五,7=星期六
	 * 
	 * @return 当前日期对应的星期数
	 */
	public static int dayOfWeek() {
		GregorianCalendar g = new GregorianCalendar();
		int ret = g.get(java.util.Calendar.DAY_OF_WEEK);
		g = null;
		return ret;
	}

	/**
	 * 获取所有的时区编号. <br>
	 * 排序规则:按照ASCII字符的正序进行排序. <br>
	 * 排序时候忽略字符大小写.
	 * 
	 * @return 所有的时区编号(时区编号已经按照字符[忽略大小写]排序).
	 */
	public static String[] fecthAllTimeZoneIds() {
		Vector v = new Vector();
		String[] ids = TimeZone.getAvailableIDs();
		for (int i = 0; i < ids.length; i++) {
			v.add(ids[i]);
		}
		java.util.Collections.sort(v, String.CASE_INSENSITIVE_ORDER);
		v.copyInto(ids);
		v = null;
		return ids;
	}


	/**
	 * 将日期时间字符串根据转换为指定时区的日期时间.
	 * 
	 * @param srcFormater
	 *            待转化的日期时间的格式.
	 * @param srcDateTime
	 *            待转化的日期时间.
	 * @param dstFormater
	 *            目标的日期时间的格式.
	 * @param dstTimeZoneId
	 *            目标的时区编号.
	 * 
	 * @return 转化后的日期时间.
	 */
	public static String string2Timezone(String srcFormater, String srcDateTime, String dstFormater, String dstTimeZoneId) {
		if (srcFormater == null || "".equals(srcFormater)) {
			return null;
		}
		if (srcDateTime == null || "".equals(srcDateTime)) {
			return null;
		}
		if (dstFormater == null || "".equals(dstFormater)) {
			return null;
		}
		if (dstTimeZoneId == null || "".equals(dstTimeZoneId)) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(srcFormater);
		try {
			int diffTime = DateUtil.getDiffTimeZoneRawOffset(dstTimeZoneId);
			Date d = sdf.parse(srcDateTime);
			long nowTime = d.getTime();
			long newNowTime = nowTime - diffTime;
			d = new Date(newNowTime);
			return DateUtil.date2String(dstFormater, d);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		} finally {
			sdf = null;
		}
	}

	/**
	 * 获取系统当前默认时区与UTC的时间差.(单位:毫秒)
	 * 
	 * @return 系统当前默认时区与UTC的时间差.(单位:毫秒)
	 */
	private static int getDefaultTimeZoneRawOffset() {
		return TimeZone.getDefault().getRawOffset();
	}

	/**
	 * 获取指定时区与UTC的时间差.(单位:毫秒)
	 * 
	 * @param timeZoneId
	 *            时区Id
	 * @return 指定时区与UTC的时间差.(单位:毫秒)
	 */
	private static int getTimeZoneRawOffset(String timeZoneId) {
		return TimeZone.getTimeZone(timeZoneId).getRawOffset();
	}

	/**
	 * 获取系统当前默认时区与指定时区的时间差.(单位:毫秒)
	 * 
	 * @param timeZoneId
	 *            时区Id
	 * @return 系统当前默认时区与指定时区的时间差.(单位:毫秒)
	 */
	private static int getDiffTimeZoneRawOffset(String timeZoneId) {
		return TimeZone.getDefault().getRawOffset() - TimeZone.getTimeZone(timeZoneId).getRawOffset();
	}

	/**
	 * 将日期时间字符串根据转换为指定时区的日期时间.
	 * 
	 * @param srcDateTime
	 *            待转化的日期时间.
	 * @param dstTimeZoneId
	 *            目标的时区编号.
	 * 
	 * @return 转化后的日期时间.
	 * @see #string2Timezone(String, String, String, String)
	 */
	public static String string2TimezoneDefault(String srcDateTime, String dstTimeZoneId) {
		return DateUtil.string2Timezone("yyyy-MM-dd HH:mm:ss", srcDateTime, "yyyy-MM-dd HH:mm:ss", dstTimeZoneId);
	}

	/**
	 * 获取当天时间的开始
	 * 
	 * @return
	 */
	public static String getStarDate() {
		Calendar starDate = Calendar.getInstance();
		starDate.set(Calendar.HOUR, 0);
		starDate.set(Calendar.MINUTE, 0);
		starDate.set(Calendar.SECOND, 0);
		starDate.set(Calendar.MILLISECOND, 0);
		return DateUtil.format(new Date(starDate.getTime().getTime()), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取当天时间的结束
	 * 
	 * @return
	 */
	public static String getEndDate() {
		Calendar EndDate = Calendar.getInstance();
		EndDate.set(Calendar.HOUR, 23);
		EndDate.set(Calendar.MINUTE, 59);
		EndDate.set(Calendar.SECOND, 59);
		EndDate.set(Calendar.MILLISECOND, 999);
		return DateUtil.format(new Date(EndDate.getTime().getTime()), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到几天后的时间
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static Calendar getDateAfter(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		return now;
	}
	
//	/**
//	 * 根据所给日期和星期标识获取一周的日期信息
//	 * @param localDate   某一日期
//	 * @param weekFlag    上一周，前一周，这一周标识，1标识下一周，-1标识上一周，其它标识这一周
//	 * @return
//	 */
//	public static List<String> getWeekDate(LocalDate localDate, String weekFlag){
//		List<String> list = new ArrayList<String>();
//		switch(weekFlag){
//			case "1"://下一周
//				localDate = localDate.plusWeeks(1);
//				break;
//			case "-1"://上一周
//				localDate = localDate.minusWeeks(1);
//				break;
//			default:
//				break;
//		}
//		
//		LocalDate monday = localDate.minusDays(localDate.getDayOfWeek().ordinal());
//		list.add(monday.toString());
//		for(int i=1; i<7; i++){
//			list.add(monday.plusDays(i).toString());
//		}
//		return list;
//	}
	
	/**
	 * 医生排班信息专用
	 * 根据一周日期信息获取排班表格所需日期信息及标题
	 * @param list
	 * @return
	 */
	public static Map<String, String> getWeekDateInfoAndTitle(List<String> list){
		Map<String, String> map = new HashMap<String, String>();
		String title = "";
		String year = "";
		for(int i=0; i<list.size(); i++){
			//将2018-05-21格式切割，存格式05/21至map中
			//格式为day1:05/21
			String[] localDateArray = list.get(i).split("-");
			map.put("day" + (i+1), localDateArray[1]+"/"+localDateArray[2]);
			if(i == 0){
				//取周一的年份
				year = localDateArray[0];
				//拼接排班信息标题
				title += year +"年" + localDateArray[1] + "月" +localDateArray[2] +"日 - ";
			}
			if(i == list.size()-1){
				//如果周一的年份与周日年份不相同，标题则要显示两个年份
				if(!year.equals(localDateArray[0])){
					title += localDateArray[0] +"年" + localDateArray[1] + "月" +localDateArray[2] +"日";
					break;
				}
				title +=localDateArray[1] + "月" +localDateArray[2] +"日";
			}
		}
		map.put("title", title);
		
		return map;
	}
	/**
	 * 计算时间，如果和现在时间不超过一天，则返回小时和分钟
	 * 若大于一天则返回多少天
	 * @param beginTime
	 * @return
	 */
	public static String waitTime(String beginTime){
		Date billdate  = DateUtil.parseDate(beginTime,"yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		long a = now.getTime()-billdate.getTime();
		if(a/(24*60*60*1000)==0){
			int h=(int)a/(60*60*1000);
			int s=(int)(a-h*60*60*1000)/(60*1000);
			return "等候"+h+"小时"+s+"分钟";
		}else{
			Calendar calendar = Calendar. getInstance(); 
			calendar.setTime(now);
			Calendar calendar1 = Calendar. getInstance(); 
			calendar1.setTime(billdate);
			DateUtil util =new DateUtil();
			return "等候"+util.getDaysBetween(calendar,calendar1)+"天";
		}
		
	}
	
	/**
	 * 返回字符串日期时间 格式为（yyyy-MM-dd HH:mm:ss）
	 * @param date
	 * @return
	 */
	public static String getFormatDateTime(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}
	
	public static void main(String[] args) {
		// DateUtil dt = new DateUtil();
		// System.out.println(d.toString());
		// System.out.println(formatDate(d).toString());
		// System.out.println(getMonthBegin(formatDate(d).toString()));
		// System.out.println(getMonthBegin("2008/07/19"));
		// System.out.println(getMonthEnd("2008/07/19"));
       System.out.println(DateUtil.waitTime("2018-06-06 12:12:12"));
		System.out.println(DateUtil.parseDate("2017-11-11 12:12:12", "yyyy-mm-dd hh:mm:ss"));
	}
	
	public static String getYmdAgeForChild(String birthdayString){
		String[] ymd = birthdayString.split("-");
		Integer y = Integer.parseInt(ymd[0]);
		Integer m = Integer.parseInt(ymd[1]);
		Integer d = Integer.parseInt(ymd[2]);
		
		Calendar birthday = new GregorianCalendar(y, m-1, d);//月份从0开始
        Calendar current = Calendar.getInstance();  
        int day = current.get(Calendar.DAY_OF_MONTH) - birthday.get(Calendar.DAY_OF_MONTH);  
        int month = current.get(Calendar.MONTH) - birthday.get(Calendar.MONTH);  
        int year = current.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);  
        //按照减法原理，先day相减，不够向month借；然后month相减，不够向year借；最后year相减。  
        if(day<0){  
            month -= 1;  
            current.add(Calendar.MONTH, -1);//得到上一个月，用来得到上个月的天数。  
            day = day + current.getActualMaximum(Calendar.DAY_OF_MONTH);  
        }  
        if(month<0){  
            month = (month+12)%12;  
            year--;  
        } 
		
		return year + "岁" + month + "月" + day + "天";
		
	}

}
