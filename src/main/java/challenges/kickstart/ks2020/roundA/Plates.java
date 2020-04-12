package challenges.kickstart.ks2020.roundA;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Plates {

	public static void main(String[] args) {

		try(Scanner s = new Scanner(System.in)) {
			//Taking Number of Test cases
			int t = s.nextInt();
			long startTime = new Date().getTime();

			//Taking each case
			for(int i = 1; i <= t; i++) {
				int n = s.nextInt();
				int k = s.nextInt();
				int p = s.nextInt();
				s.nextLine();
				
				int[][] plates = new int[n][k];
				for(int j = 0; j < n; j++) {
					plates[j] = Arrays.stream(s.nextLine().trim().split(" "))
									  .mapToInt(a -> Integer.parseInt(a))
									  .toArray();
				}
			}
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - startTime));
		}
	}
}