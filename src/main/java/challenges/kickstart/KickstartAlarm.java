package challenges.kickstart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000051060/0000000000058a56
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
				
				//creating sub arrays
				List<int[]> subArrays = new ArrayList<int[]>();
				for(int b = 0; b < n; b++) {
					for(int e = b; e < n; e++) {
						int[] intArray = new int[e + 1 - b];
						for(int g = 0; g <= (e - b); g++) {
							intArray[g] = array[b + g];
						}
						subArrays.add(intArray);
					}
				}
				System.out.println("Sub-Arrays created");
				
				//Calculating power
				long powerSum = 0;
				for(int h = 1; h <= k; h++) {
					long sum = 0;
					for(int l = 0; l < subArrays.size(); l++) {
						int[] temp = subArrays.get(l);
						for(int m = 0; m < temp.length; m++) {
							sum += (temp[m] * (Math.pow((m + 1), h)));
						}
					}
					powerSum += sum;
				}
				
				System.out.println("Case #" + i + ": " + (powerSum % 1000000007));
			}
		}
	}
}