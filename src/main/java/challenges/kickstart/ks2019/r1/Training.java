package challenges.kickstart.ks2019.r1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050e01/00000000000698d6
 * 

1
4 3
3 100 1 9
--------------------------
3
4 3
3 1 9 100
6 2
5 5 1 2 3 4
5 5
7 7 1 7 7

Case #1: 14
Case #2: 0
Case #3: 6
 */
public class Training {

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			long startTime = new Date().getTime();
			for(int i = 1; i <= t; i++) {
//				int n = scanner.nextInt();
//				int p = scanner.nextInt();
//				scanner.nextLine();
//				int[] skills = Arrays.stream(scanner.nextLine().split(" "))
//											.mapToInt( s -> Integer.parseInt(s))
//											.toArray();
				//
				int n = 100000;
				int p = 100000;
				Scanner sc = null;
				try {
					sc = new Scanner(new File("src/main/resources/training.txt"));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				int[] skills = Arrays.stream(sc.nextLine().split(" "))
										.mapToInt( s -> Integer.parseInt(s))
										.toArray();
				//
				
				Arrays.sort(skills);
				int hoursRequired = Integer.MAX_VALUE;
				for(int k = 0; k <= n - p; k++) {
					int hours = 0;
					for(int j = 0; j < p - 1; j++) {
						hours += skills[k + p - 1] - skills[k + j];
					}
					if(hoursRequired > hours) {
						hoursRequired = hours;
					}
				}
				
				System.out.println("Case #" + i + ": " + hoursRequired);
			}
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - startTime));
		}
	}

}