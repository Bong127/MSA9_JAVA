package Mission;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class test {
	public static void main(String[] args) {
		// 현재 날짜
		Calendar toDay = Calendar.getInstance();
		// 이번주 토요일
		Calendar sDay = Calendar.getInstance();	
		// 1년뒤 날짜
		Calendar yearDay = Calendar.getInstance();	
		
		// 이번주 토요일 21시 정각으로 설정
		sDay.set(Calendar.DAY_OF_WEEK, 7);
		sDay.set(Calendar.HOUR_OF_DAY, 21);
		sDay.set(Calendar.MINUTE, 0);
		sDay.set(Calendar.SECOND, 0);
		
		// 토요일 9시 이후 일 경우 7일 더하기
		if(toDay.after(sDay))
			sDay.add(Calendar.DATE, 7);
		
		// 현재 날짜로부터 1년 뒤
		yearDay.add(Calendar.DATE, 366);
		
		// 날짜 및 시간 형식
		SimpleDateFormat formatDay = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
		
		// 현재 날짜, 시간, 요일
		String toDay_Day = formatDay.format(toDay.getTime());
		String toDay_Time = formatTime.format(toDay.getTime());
		String toDay_Week = toDay.getDisplayName(Calendar.DAY_OF_WEEK, 	Calendar.NARROW_FORMAT, Locale.KOREAN);
		
		// 토요일 날짜, 시간, 요일
		String sDay_Day = formatDay.format(sDay.getTime());
		String sDay_Time = formatTime.format(sDay.getTime());
		String sDay_Week = sDay.getDisplayName(Calendar.DAY_OF_WEEK, 	Calendar.NARROW_FORMAT, Locale.KOREAN);
		
		// 1년뒤 날짜, 시간, 요일
		String yearDay_Day = formatDay.format(yearDay.getTime());
		String yearDay_Time = formatTime.format(yearDay.getTime());
		String yearDay_Week = yearDay.getDisplayName(Calendar.DAY_OF_WEEK, 	Calendar.NARROW_FORMAT, Locale.KOREAN);
		
		System.out.println(toDay_Day);
		System.out.println(toDay_Time);
		System.out.println(toDay_Week);
		System.out.println(sDay_Day);
		System.out.println(sDay_Time);
		System.out.println(sDay_Week);
		System.out.println(yearDay_Day);
		System.out.println(yearDay_Time);
		System.out.println(yearDay_Week);
	}
}
