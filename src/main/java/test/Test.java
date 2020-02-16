package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		String regex = "</\\w+>";
		String str = "<h1>Nayeem loves counseling</h1>";
		int matchCount = 0;
		
		Matcher matcher = Pattern.compile(regex).matcher(str);
		while(matcher.find()) {
			matchCount++;
			System.out.println(matcher.start());
			System.out.println(matcher.end());
			System.out.println(matcher.group());
			System.out.println(str.substring(matcher.start(), matcher.end()));
		}
		
		System.out.println(matchCount);
	}
}