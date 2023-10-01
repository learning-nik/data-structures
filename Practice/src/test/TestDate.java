package test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.design.pattern.creational.MetroRate;
import com.design.pattern.creational.RateFactory;

public class TestDate {

	public static void main(String[] args) {

		Date date = new Date();
		System.out.println(date);
		
		System.out.println(Calendar.getInstance());
		System.out.println(Calendar.getInstance(TimeZone.getTimeZone("UTC")));
		
		System.out.println(Calendar.getInstance().getTime());
		
		LocalDate localDate = LocalDate.parse("2018-05-05");
		
		System.out.println(localDate);
		
		System.out.println(LocalDateTime.now());
		
		System.out.println(LocalDate.now());
		//SimpleDateFormat sdf = new SimpleDateFormat("");
		
		StringBuilder sb = new StringBuilder();
		sb.append("test");
		System.out.println(sb);
		
	}

}
