package challenges.codejam.cj2020.qualification;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 
input:
2
3 6
2 3

output:  
Case #1: POSSIBLE
2 1 3
3 2 1
1 3 2
Case #2: IMPOSSIBLE

 *
 */
public class Indicium {

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			long startTime = new Date().getTime();
			for(int i = 1; i <= t; i++) {
				int n = scanner.nextInt();
				int k = scanner.nextInt();
				
				String op = "";
				if((k % n == 0) && ((k/n) <= n)) {
					op = "POSSIBLE";
				} else {
					op = "IMPOSSIBLE";
				}
				System.out.println("Case #" + i + ": " + op);
				if(op.equals("POSSIBLE")) {
					printMatrix(n, k);
				}
			}
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - startTime));
		}
	}
	
	private static void printMatrix(int n, int k) {
		int num = k/n;
		for(int i = 0; i < n; i++) {
			String str = "";
			for(int j = 0; j < n; j++) {
				if(num <= n) {
					str += num + (j == n-1 ? "" : " ");
				} else {
					num = 1;
					str += num + (j == n-1 ? "" : " ");
				}
				num++;
			}
			System.out.println(str);
			num--;
		}
	}
}