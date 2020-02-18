package challenges.kickstart;

import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000051060/0000000000058a56
 * 
 * Sample Data:

2
2 3 1 2 1 2 1 1 9
10 10 10001 10002 10003 10004 10005 10006 89273

1
1000000 10000 100000 100000 100000 100000 100000 100000 100000
 * 
 * @author sadh8001
 */
public class KickstartAlarm {

	public static void main(String[] args) {
		
		try(Scanner scanner = new Scanner(System.in)){
			int t = scanner.nextInt();
			for(int i = 1; i <= t; i++) {
				//Reading test inputs
				int n = scanner.nextInt();
				int k = scanner.nextInt();
				int x1 = scanner.nextInt();
				int y1 = scanner.nextInt();
				int c = scanner.nextInt();
				int d = scanner.nextInt();
				int e1 = scanner.nextInt();
				int e2 = scanner.nextInt();
				int f = scanner.nextInt();
				
				//Creating parameter array
				int[] array = new int[n];
				array[0] = (x1 + y1) % f;
				int px = x1;
				int py = y1;
				for(int j = 1; j < n; j++) {
					int tx = (c * px + d * py + e1) % f;
					int ty = (d * px + c * py + e2) % f;
					array[j] = (tx + ty) % f;
					px = tx;
					py = ty;
				}
				System.out.println("Array created");
				
				//Creating powers and adding them
				long powerSum = 0;
				for(int powPos = 1; powPos <= k; powPos++) {
					for(int arrPos = 0; arrPos < n; arrPos++) {
						for(int times = arrPos; times < n; times++) {
							powerSum += ((array[times] * Math.pow((arrPos + 1), powPos)) * (n - times));
						}
						System.out.println(arrPos);
					}
				}
				System.out.println("Case #" + i + ": " + (powerSum  % 1000000007));
			}
		}
	}
}