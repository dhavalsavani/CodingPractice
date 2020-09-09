package challenges.kickstart.ks2020.roundD;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**

2
5 4
90 30 40 60
3 4
3 1
1 5
4 3
10 2
6 2 4 5 9 30 7 1 8
6 8
6 8

Case #1: 5 3 5 2
Case #2: 8 8

 */
public class LockedDoors {

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
				int[] doorValues = Arrays.stream(s.nextLine().trim().split(" "))
									.mapToInt(a -> Integer.parseInt(a))
									.toArray();
				
				//Calculating traversal path starting with each door
				Map<Integer, int[]> traversalMap = new HashMap<>(n);
				for(int j = 1; j < n - 1; j++) {
					int[] path = new int[n];
					int rhs = doorValues[j];
					int lhs = doorValues[j-1];
					while(true) {
						
					}
				}
				
			}
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - startTime));
		}
	}
}