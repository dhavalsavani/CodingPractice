package challenges.hackerrank.java;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * https://www.hackerrank.com/challenges/java-1d-array/problem?h_r=next-challenge&h_v=zen
 * 
 * Java 1D Array (Part 2)

 48		YES
108 	YES
188		YES
355		YES
493		YES
691		YES
761		YES
1001	YES
1107	YES
1378	YES
1379	YES

 */
public class Java1DArray {

	public static boolean canWin(int leap, int[] game) {
		return canWin(leap, game, 0);
	}

	public static boolean canWin(int leap, int[] game, int pos) {
		if(pos < 0) {
			return false;
		} else if(pos >= game.length) {
			return true;
		} else if(game[pos] == 1) {
			return false;
		} else {
			game[pos] = 1;
			return (canWin(leap, game, pos - 1) || canWin(leap, game, pos + leap) || canWin(leap, game, pos + 1));
		}
	}

	public static void main(String[] args) {
		long startTime = new Date().getTime();
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		while (q-- > 0) {
			int n = scan.nextInt();
			int leap = scan.nextInt();

			int[] game = new int[n];
			for (int i = 0; i < n; i++) {
				game[i] = scan.nextInt();
			}

			System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
		}
		scan.close();
		System.out.println(TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - startTime));
	}
}