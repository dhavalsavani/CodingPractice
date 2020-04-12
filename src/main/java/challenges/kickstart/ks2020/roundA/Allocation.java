package challenges.kickstart.ks2020.roundA;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 
input:
3
4 100
20 90 40 90
4 50
30 30 10 10
3 300
999 999 999 

output:
Case #1: 2
Case #2: 3
Case #3: 0
 * 
 *
 */
public class Allocation {

	public static void main(String[] args) {
		
		try(Scanner s = new Scanner(System.in)) {
			//Taking Number of Test cases
			int t = s.nextInt();
			long startTime = new Date().getTime();
			
			//Taking each case
			for(int i = 1; i <= t; i++) {
				int n = s.nextInt();
				int b = s.nextInt();
				s.nextLine();
				int[] costs = Arrays.stream(s.nextLine().trim().split(" "))
									.mapToInt(a -> Integer.parseInt(a))
									.toArray();
				
				//
//				int costs[] = new int[n];
//				try(Scanner scanner = new Scanner(new File("src/main/resources/kickstart/ks2020/allocation.txt"))) {
//					costs = Arrays.stream(scanner.nextLine().split(" "))
//									.mapToInt(a -> Integer.parseInt(a))
//									.toArray();
//				}
//				catch (FileNotFoundException e) {
//					e.printStackTrace();
//				}
				//
				
				//Sorting Cost to ascending
				Arrays.sort(costs);
				
				//If user does not have budget for lowest priced
				//house then printing '0'
				if(costs[0] > b) {
					System.out.println("Case #" + i + ": " + 0);
					continue;
				}
				
				//Else summing cost which fits in user's budget
				int numberOfHouses = 0;
				for(int j = 0; j < costs.length; j++) {
					if(b >= costs[j]) {
						b -= costs[j];
						numberOfHouses++;
					} else {
						break;
					}
				}
				System.out.println("Case #" + i + ": " + numberOfHouses);
				
			}
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - startTime));
		}
	}
}