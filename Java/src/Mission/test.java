package Mission;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class test {
	public static void main(String[] args) {
		LocalDate nowDay = LocalDate.now();
		Date date = new Date();
		LocalDate yearDay = nowDay.plusDays(366);
		LocalTime nowTime = LocalTime.now();
		
		String time = nowTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		String day = nowDay.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		
		
		DayOfWeek dayOfWeek = nowDay.getDayOfWeek();
		DayOfWeek dayofweek2 = yearDay.getDayOfWeek();
		
		System.out.println(day);
		System.out.println(time);
		System.out.println(dayOfWeek.getDisplayName(TextStyle.NARROW, Locale.KOREAN));
		System.out.println(yearDay);
		System.out.println(dayofweek2.getDisplayName(TextStyle.NARROW, Locale.KOREAN));
		
		Calendar ca = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		ca.set(Calendar.DAY_OF_WEEK, 7);
		ca.set(Calendar.HOUR_OF_DAY, 9);
		ca.set(Calendar.MINUTE, 0);
		ca.set(Calendar.SECOND, 0);
		Calendar ca2 = new GregorianCalendar();
		ca2.set(Calendar.DAY_OF_WEEK, 7);
		ca2.set(Calendar.HOUR_OF_DAY, 10);
		ca2.set(Calendar.MINUTE, 0);
		ca2.set(Calendar.SECOND, 0);
		if(ca2.after(ca))
		{
			System.out.println("성공");
		}
		ca.add(Calendar.DATE, 7);
		String nextDay = sdf.format(ca.getTime());
		System.out.println(ca.getTime());
		System.out.println(nextDay);
		
		System.out.println(ca.getTime());
		System.out.println(date);
	
	}
}
