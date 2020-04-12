package challenges.hackerrank.algorithm;

import java.util.Scanner;

/**
 * 
 * Given an array of integers, calculate the fractions of its elements that are positive, negative, and are zeros. Print the decimal value of each fraction on a new line.
 * 
 * Note: This challenge introduces precision problems. The test cases are scaled to six decimal places, though answers with absolute error of up to  are acceptable.
 * 
 * For example, given the array  there are  elements, two positive, two negative and one zero. Their ratios would be ,  and . It should be printed as
 * 
 * 0.400000
 * 0.400000
 * 0.200000
 * Function Description
 * 
 * Complete the plusMinus function in the editor below. It should print out the ratio of positive, negative and zero items in the array, each on a separate line rounded to six decimals.
 * 
 * plusMinus has the following parameter(s):
 * 
 * arr: an array of integers
 * Input Format
 * 
 * The first line contains an integer, , denoting the size of the array. 
 * The second line contains  space-separated integers describing an array of numbers .
 * 
 * Constraints
 * 
 *  
 * 
 * Output Format
 * 
 * You must print the following  lines:
 * 
 * A decimal representing of the fraction of positive numbers in the array compared to its size.
 * A decimal representing of the fraction of negative numbers in the array compared to its size.
 * A decimal representing of the fraction of zeros in the array compared to its size.
 * Sample Input
 * 
 * 6
 * -4 3 -9 0 4 1         
 * Sample Output
 * 
 * 0.500000
 * 0.333333
 * 0.166667
 * Explanation
 * 
 * There are  positive numbers,  negative numbers, and  zero in the array. 
 * The proportions of occurrence are positive: , negative:  and zeros: .
 *
 */
public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
    	int length = arr.length;
    	float positiveNumberRatio = 0;
    	float negativeNumberRatio = 0;
    	float zeroNumberRatio = 0;
    	
    	//Iterating over array and adding 1/length to respective ratio flags.
    	//This approach saves resource as we do not store values of individual
    	//flags and then take division, instead we increment on with the condition
    	for(int i = 0; i < length; i++) {
    		if(arr[i] > 0) {
    			positiveNumberRatio += ((float)1/(float)length);
    		} else if(arr[i] < 0) {
    			negativeNumberRatio += ((float)1/(float)length);
    		} else {
    			zeroNumberRatio += ((float)1/(float)length);
    		}
    	}
    	System.out.println(
    			String.format("%.6f", positiveNumberRatio) + "\n" + 
    			String.format("%.6f", negativeNumberRatio) + "\n" + 
    			String.format("%.6f", zeroNumberRatio)
    			);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}