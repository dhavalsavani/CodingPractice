package challenges.kickstart.ks2020.roundC;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


/**
 * 
3
12 3
1 2 3 7 9 3 2 1 8 3 2 1
4 2
101 100 99 98
9 6
100 7 6 5 4 3 2 1 100

 *
 */
public class Countdown {

	public static void main(String[] args) {
		
		try(Scanner s = new Scanner(System.in)) {
			//Taking Number of Test cases
			int t = s.nextInt();
			long startTime = new Date().getTime();

			//Taking each case
			for(int i = 1; i <= t; i++) {
				int n = s.nextInt();
				int k = s.nextInt();
				s.nextLine();
				int[] nums = Arrays.stream(s.nextLine().trim().split(" "))
						.mapToInt(a -> Integer.parseInt(a))
						.toArray();
				
				//Creating expected countdown array
				int[] expected = new int[k];
				for(int j = 0; j < k; j++) {
					expected[j] = (k - j);
				}
				
				//counting countdown arrays
				int counter = 0;
				for(int j = 0; j <= (n - k); j++) {
					boolean flag = true;
					for(int l = 0; l < k; l++) {
						if(nums[j + l] != expected[l]) {
							flag= false;
							break;
						}
					}
					if(flag) {
						counter++;
					}
				}
				System.out.println("Case #" + i + ": " + counter);
			}
			
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - startTime));
		}
	}
}