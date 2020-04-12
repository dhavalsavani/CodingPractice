package challenges.hackerrank.java;

import java.util.Calendar;
import java.util.Locale;

public class JavaDateTime {
	
	public static void main(String[] args) {
		
		int month = 8;
		int day = 5;
		int year = 2015;
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		System.out.println(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG,Locale.ENGLISH).toUpperCase());
	}
}