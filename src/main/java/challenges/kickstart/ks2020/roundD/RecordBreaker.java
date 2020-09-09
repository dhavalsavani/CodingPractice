package challenges.kickstart.ks2020.roundD;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**

4
8
1 2 0 7 2 0 2 0
6
4 8 15 16 23 42
9
3 1 4 1 5 9 2 6 5
6
9 9 9 9 9 9

Case #1: 2
Case #2: 1
Case #3: 3
Case #4: 0

 */
public class RecordBreaker {

	public static void main(String[] args) {
		try(Scanner s = new Scanner(System.in)) {
			//Taking Number of Test cases
			int t = s.nextInt();
			long startTime = new Date().getTime();

			//Taking each case
			for(int i = 1; i <= t; i++) {
				int n = s.nextInt();
				s.nextLine();
				int[] nums = Arrays.stream(s.nextLine().trim().split(" "))
									.mapToInt(a -> Integer.parseInt(a))
									.toArray();
				
				int recordBreakingDays = 0;
				int prevMax = 0;
				if(n > 1) {
					for(int j = 0; j < n; j++) {
						if(j == 0 && nums[j+1] < nums[j]) {
							recordBreakingDays++;
						} else if(j < n - 1 && nums[j] > prevMax && nums[j] > nums[j+1]) {
							recordBreakingDays++;
						} else if(j == n - 1 && nums[j] > prevMax) {
							recordBreakingDays++;
						}
						if(nums[j] > prevMax) {
							prevMax = nums[j];
						}
					}
				} else {
					recordBreakingDays++;
				}
				
				System.out.println("Case #" + i + ": " + recordBreakingDays);
			}
			
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - startTime));
		}
	}
}