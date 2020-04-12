package challenges.hackerrank.algorithm;

import java.io.IOException;
import java.util.Scanner;

/**
 * Given a time in -hour AM/PM format, convert it to military (24-hour) time.
 * 
 * Note: Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock. Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock.
 * 
 * Function Description
 * 
 * Complete the timeConversion function in the editor below. It should return a new string representing the input time in 24 hour format.
 * 
 * timeConversion has the following parameter(s):
 * 
 * s: a string representing time in  hour format
 * Input Format
 * 
 * A single string  containing a time in -hour clock format (i.e.:  or ), where  and .
 * 
 * Constraints
 * 
 * All input times are valid
 * Output Format
 * 
 * Convert and print the given time in -hour format, where .
 * 
 * Sample Input 0
 * 
 * 07:05:45PM
 * Sample Output 0
 * 
 * 19:05:45
 */
public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
    	//Checking time is AM or PM
    	if(s.toLowerCase().contains("pm")) {
    		//Tacking hour part
    		int hours = Integer.parseInt(s.substring(0, 2));
    		
    		//Checking if hour is 12 then replacing hour with 00
    		if(hours == 12) {
    			return (s.substring(0, s.length() - 2));
    		} else {
    			//Else adding 12 to the hour part and returning it
    			return ((hours + 12) + s.substring(2, s.length() - 2));
    		}
    	} else {
    		//Tacking hour part
    		int hours = Integer.parseInt(s.substring(0, 2));

    		//Checking if hour is 12 then replacing hour with 00
    		if(hours == 12) {
    			return ("00" + s.substring(2, s.length() - 2));
    		} else {
    			//else removing AM from given string and returning back
    			return s.substring(0, s.length() - 2);
    		}
    	}
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scan.nextLine();

        String result = timeConversion(s);

       System.out.println(result);
    }
}