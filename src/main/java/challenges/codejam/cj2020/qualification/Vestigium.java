package challenges.codejam.cj2020.qualification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 
input:
3
4
1 2 3 4
2 1 4 3
3 4 1 2
4 3 2 1
4
2 2 2 2
2 3 2 3
2 2 2 3
2 2 2 2
3
2 1 3
1 3 2
1 2 3

output:
Case #1: 4 0 0
Case #2: 9 4 4
Case #3: 8 0 2
 *
 */
public class Vestigium {

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			long startTime = new Date().getTime();
			for(int i = 1; i <= t; i++) {
				int n = scanner.nextInt();
				scanner.nextLine();
				//Creating grid array
				int array[][] = new int[n][n];
				for(int j = 0; j < n; j++) {
					array[j] = Arrays.stream(scanner.nextLine().split(" "))
									 .mapToInt(s -> Integer.parseInt(s))
									 .toArray();
				}
				
				int rowRepeatCount = 0;
				int columnRepeatCount = 0;
				int sum = 0;
				List<List<Integer>> rowList = new ArrayList<>();
				List<List<Integer>> columnList = new ArrayList<>();
				List<Integer> isColumnRepeatCheckDone = new ArrayList<>();
				
				for (int j = 0; j < array.length; j++) {
					int[] temp = array[j];
					
					//Taking current row list
					List<Integer> rList = new ArrayList<>();
					rowList.add(rList);
					
					//flag for checking if row repeat check is done
					boolean rFlag = false;
					for(int k = 0; k < temp.length; k++) {
						//If diagonal element then adding it to sum
						if(j == k) {
							sum += temp[k];
						}
						
						//Checking if element repeated in row
						if(!rFlag) {
							if(rList.contains(temp[k])) {
								rowRepeatCount++;
								rFlag = true;
							} else {
								rList.add(temp[k]);
							}
						}
						
						//Checking if element repeated in column
						List<Integer> cList = null;
						if(columnList.isEmpty() || columnList.size() <= k) {
							cList = new ArrayList<>();
							columnList.add(cList);
						} else {
							cList = columnList.get(k);
						}
						
						if(!isColumnRepeatCheckDone.contains(k)) {
							if(cList.contains(temp[k])) {
								columnRepeatCount++;
								isColumnRepeatCheckDone.add(k);
							} else {
								cList.add(temp[k]);
							}
						}
					}
				}
				System.out.println("Case #" + i + ": " + sum + " " + rowRepeatCount + " " + columnRepeatCount);
			}
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - startTime));
		}
	}
}