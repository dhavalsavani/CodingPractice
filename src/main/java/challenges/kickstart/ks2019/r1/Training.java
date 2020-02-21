package challenges.kickstart.ks2019.r1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050e01/00000000000698d6
 * 
 * @author sadh8001
 */
public class Training {

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			for(int i = 1; i <= t; i++) {
				int n = scanner.nextInt();
				int p = scanner.nextInt();
				scanner.nextLine();
				Integer[] skills = Arrays.stream(scanner.nextLine().split(" "))
											.map( s -> Integer.parseInt(s))
											.collect(Collectors.toList())
											.toArray(new Integer[n]);

				Arrays.sort(skills);
				int hoursRequired = 0;
				for(int j = 0; j < p; j++) {
					hoursRequired += skills[p-1] - skills[j];
				}
				
				System.out.println("Case #" + i + ": " + hoursRequired);
			}
		}
	}

}
