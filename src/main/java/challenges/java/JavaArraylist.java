package challenges.java;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *Sometimes it's better to use dynamic size arrays. Java's Arraylist can provide you this feature. Try to solve this problem using Arraylist.
 *
 *You are given n lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in yth position of xth line.
 *
 *Take your input from System.in.
 *
 *Input Format
 *The first line has an integer n. In each of the next lines there will be an integer d denoting number of integers on that line and then there will be d space-separated integers. In the next line there will be an integer q denoting number of queries. Each query will consist of two integers x and y.
 *
 *Constraints
 *
 *1 <= n <= 20000
 *0 <= d <= 50000
 *1 <= q <= 1000
 *1 <= x <= n
 *
 *Each number will fit in signed integer.
 *Total number of integers in n lines will not cross 10^5.
 *
 *Output Format
 *In each line, output the number located in yth position of xth line. If there is no such position, just print "ERROR!"
 *
 *Sample Input
 *
 *5
 *5 41 77 74 22 44
 *1 12
 *4 37 34 36 52
 *0
 *3 20 22 33
 *5
 *1 3
 *3 4
 *3 1
 *4 3
 *5 5
 *
 *Sample Output
 *
 *74
 *52
 *37
 *ERROR!
 *ERROR!
 *
 *Explanation
 *
 *The diagram below explains the queries:
 *https://s3.amazonaws.com/hr-assets/0/1489168616-b25dd38013-arraylist.png
 */
public class JavaArraylist {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int listSize = Integer.parseInt(scanner.nextLine());
		ArrayList<ArrayList<Integer>> numList = new ArrayList<>(listSize);
		for (int i = 0; i < listSize; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			int lineNumSize = Integer.parseInt(arrRowItems[0]);
			ArrayList<Integer> tempList = new ArrayList<>(lineNumSize);
			if(lineNumSize != 0) {
				for (int j = 1; j < arrRowItems.length; j++) {
					tempList.add(Integer.parseInt(arrRowItems[j]));
				}
			}
			numList.add(tempList);
        }
		
		int queryLength = Integer.parseInt(scanner.nextLine());
		int[][] queryNums = new int[queryLength][2];
		for(int i = 0; i < queryLength; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			queryNums[i][0] = Integer.parseInt(arrRowItems[0]);
			queryNums[i][1] = Integer.parseInt(arrRowItems[1]);
		}
        scanner.close();
        
        for (int i = 0; i < queryLength; i++) {
        	try {
        		System.out.println(numList.get(queryNums[i][0] - 1).get(queryNums[i][1] - 1));
        	} catch(IndexOutOfBoundsException e) {
        		System.out.println("ERROR!");
        	}
		}
	}
}