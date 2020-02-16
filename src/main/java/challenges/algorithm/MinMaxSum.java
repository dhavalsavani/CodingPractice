package challenges.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/** 
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.
 * 
 * For example, . Our minimum sum is  and our maximum sum is . We would print
 * 
 * 16 24
 * Function Description
 * 
 * Complete the miniMaxSum function in the editor below. It should print two space-separated integers on one line: the minimum sum and the maximum sum of  of  elements.
 * 
 * miniMaxSum has the following parameter(s):
 * 
 * arr: an array of  integers
 * Input Format
 * 
 * A single line of five space-separated integers.
 * 
 * Constraints
 * 
 * 
 * Output Format
 * 
 * Print two space-separated long integers denoting the respective minimum and maximum values that can be calculated by summing exactly four of the five integers. (The output can be greater than a 32 bit integer.)
 * 
 * Sample Input
 * 
 * 1 2 3 4 5
 * Sample Output
 * 
 * 10 14
 * Explanation
 * 
 * Our initial numbers are , , , , and . We can calculate the following sums using four of the five integers:
 * 
 * If we sum everything except , our sum is .
 * If we sum everything except , our sum is .
 * If we sum everything except , our sum is .
 * If we sum everything except , our sum is .
 * If we sum everything except , our sum is .
 * Hints: Beware of integer overflow! Use 64-bit Integer.
 */
public class MinMaxSum {

	// Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
    	//Sorting Array into Ascending order
    	Arrays.sort(arr);
    	
    	//Printing minimum sum value by adding first four elements of array
    	long minResult = (long)arr[0] + (long)arr[1] + (long)arr[2] + (long)arr[3];
    	System.out.print(minResult);
    	
    	//Printing maximum sum value by adding last four elements of array
    	int length = arr.length;
    	long maxResult = (long)arr[length - 1] + (long)arr[length - 2] + (long)arr[length - 3] + (long)arr[length - 4];
    	System.out.print(" " + maxResult);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}