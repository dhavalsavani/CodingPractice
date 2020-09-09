package challenges.kickstart.ks2020.roundC;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


/**
 * 
2
5 4
1 3 9 8 2
Q 2 4
Q 5 5
U 2 10
Q 1 2
3 3
4 5 5
U 1 2
U 1 7
Q 1 2
 *
 */
public class Candies {

	public static void main(String[] args) {
		try(Scanner s = new Scanner(System.in)) {
			//Taking Number of Test cases
			int t = s.nextInt();
			long startTime = new Date().getTime();

			//Taking each case
			for(int i = 1; i <= t; i++) {
				int n = s.nextInt();
				int q = s.nextInt();
				s.nextLine();
				int[] nums = Arrays.stream(s.nextLine().trim().split(" "))
									.mapToInt(a -> Integer.parseInt(a))
									.toArray();
				long sum = 0;
				for(int j = 0; j < q; j++) {
					String operation = s.next();
					int first = s.nextInt();
					int second = s.nextInt();
					s.nextLine();
					switch(operation) {
					case "U":
						nums[first - 1] = second;
						break;

					case "Q":
						int[] subArray = Arrays.copyOfRange(nums, first - 1, second);
						for(int k = 0; k < subArray.length; k++) {
							sum += (((int)Math.pow(-1, k)) * subArray[k] * (k + 1));
						}
						break;
					}
				}
				System.out.println("Case #" + i + ": " + sum);
			}
			
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - startTime));
		}
	}
}