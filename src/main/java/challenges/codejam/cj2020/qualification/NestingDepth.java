package challenges.codejam.cj2020.qualification;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 
input:
4
0000
101
111000
1

output:
Case #1: 0000
Case #2: (1)0(1)
Case #3: (111)000
Case #4: (1) 



input:
4
021
312
4
221

output:
Case #1: 0((2)1)
Case #2: (((3))1(2))
Case #3: ((((4))))
Case #4: ((22)1)

 *
 */
public class NestingDepth {
	
	private static String op;

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			long startTime = new Date().getTime();
			for(int i = 1; i <= t; i++) {
				String n = scanner.next();
				//Splitting each numbers
				int[] nums = Arrays.stream(n.split("|"))
								   .mapToInt(v -> Integer.parseInt(v))
								   .toArray();
				
				//Making output string blank for each test case
				op = "";
				for (int j = 0; j < nums.length; j++) {
					int num = nums[j];
					
					//If number is zero
					//and if it is first character then just append it
					//else close braces and then append it
					if(num == 0) {
						op += "0";
						continue;
					}
					
					//If not zero, then
					//if its first character then append open braces that number times then number then close braces of next numbers difference if its lower
					//else if the previous number is lower then appending open braces and number and close braces of next numbers difference if its lower
					//else just append number and close braces of next numbers difference if its lower
					if(j == 0) {
						appendOpenBraces(num);
						op += num;
					} else {
						appendOpenBraces(num - nums[j -1]);
						op += num;
					}
					//Checking if last number is reached
					//if yes then closing all braces
					//else closing the difference if next number is lower
					if(j == nums.length - 1) {
						appendCloseBraces(num);
					} else {
						appendCloseBraces(num - nums[j + 1]);
					}
				}
				System.out.println("Case #" + i + ": " + op);
			}
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - startTime));
		}
	}
	
	public static void appendOpenBraces(int times) {
		if(times > 0) {
			String str = "";
			for(int i = 0; i < times; i++) {
				str += "(";
			}
			op += str;
		}
	}
	
	public static void appendCloseBraces(int times) {
		if(times > 0) {
			String str = "";
			for(int i = 0; i < times; i++) {
				str += ")";
			}
			op += str;
		}
	}
}