package challenges.algorithm;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * You will be given two arrays of integers and asked to determine all integers that satisfy the following two conditions:
 * 
 * The elements of the first array are all factors of the integer being considered
 * The integer being considered is a factor of all elements of the second array
 * These numbers are referred to as being between the two arrays. You must determine how many such numbers exist.
 * 
 * For example, given the arrays  and , there are two numbers between them:  and . , ,  and  for the first value. Similarly, ,  and , .
 * 
 * Function Description
 * 
 * Complete the getTotalX function in the editor below. It should return the number of integers that are between the sets.
 * 
 * getTotalX has the following parameter(s):
 * 
 * a: an array of integers
 * b: an array of integers
 * Input Format
 * 
 * The first line contains two space-separated integers,  and , the number of elements in array  and the number of elements in array . 
 * The second line contains  distinct space-separated integers describing  where . 
 * The third line contains  distinct space-separated integers describing  where .
 * 
 * Constraints
 * 
 * Output Format
 * 
 * Print the number of integers that are considered to be between  and .
 * 
 * Sample Input
 * 
 * 2 3
 * 2 4
 * 16 32 96
 * Sample Output
 * 
 * 3
 * Explanation
 * 
 * 2 and 4 divide evenly into 4, 8, 12 and 16. 
 * 4, 8 and 16 divide evenly into 16, 32, 96.
 * 
 * 4, 8 and 16 are the only three numbers for which each element of a is a factor and each is a factor of all elements of b.
 */
public class BetweenTwoSets {
	
	/*
     * Complete the getTotalX function below.
     */
    static int getTotalX(int[] a, int[] b) {
    	int count = 0;
    	for(int i = 0; i <= Arrays.stream(b).min().getAsInt(); i++) {
    		
    	}
    	return count;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        int total = getTotalX(a, b);
        System.out.println(total);
    }
}