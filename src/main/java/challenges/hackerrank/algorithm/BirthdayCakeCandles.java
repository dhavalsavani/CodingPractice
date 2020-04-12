package challenges.hackerrank.algorithm;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * You are in charge of the cake for your niece's birthday and have decided the cake will have one candle for each year of her total age. When she blows out the candles, she’ll only be able to blow out the tallest ones. Your task is to find out how many candles she can successfully blow out.
 * 
 * For example, if your niece is turning  years old, and the cake will have  candles of height , , , , she will be able to blow out  candles successfully, since the tallest candles are of height  and there are  such candles.
 * 
 * Function Description
 * 
 * Complete the function birthdayCakeCandles in the editor below. It must return an integer representing the number of candles she can blow out.
 * 
 * birthdayCakeCandles has the following parameter(s):
 * 
 * ar: an array of integers representing candle heights
 * Input Format
 * 
 * The first line contains a single integer, , denoting the number of candles on the cake. 
 * The second line contains  space-separated integers, where each integer  describes the height of candle .
 * 
 * Constraints
 * 
 * Output Format
 * 
 * Print the number of candles that can be blown out on a new line.
 * 
 * Sample Input 0
 * 
 * 4
 * 3 2 1 3
 * Sample Output 0
 * 
 * 2
 * Explanation 0
 * 
 * We have one candle of height , one candle of height , and two candles of height . Your niece only blows out the tallest candles, meaning the candles where . Because there are  such candles, we print  on a new line.
 */
public class BirthdayCakeCandles {

    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar) {
        int count = 0;
    	int max = Arrays.stream(ar).max().getAsInt();
    	for(int i = 0; i < ar.length; i++) {
    		if(ar[i] == max)
    			count++;
    	}
    	
    	return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = birthdayCakeCandles(ar);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}