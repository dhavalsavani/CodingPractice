package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DynamicStringReplacement {

	public static String getString(String str, String... strings) {
		Pattern pattern = Pattern.compile("\\?");
		StringBuilder builder = new StringBuilder(str);
		Matcher matcher = pattern.matcher(builder);
		int index = 0;
		int counter = 0;
		while(matcher.find(index)) {
			if(counter >= strings.length) {
				throw new RuntimeException("Number of words to be replace and replacement word count does not match.");
			}
			String replacement = strings[counter++];
			builder.replace(matcher.start(), matcher.end(), replacement);
			index = matcher.start() + replacement.length();
		}
		return builder.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getString("products.db_host.test", "on-v3"));
	}
}