package challenges.java;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-1d-array/problem?h_r=next-challenge&h_v=zen
 * 
 * Java 1D Array (Part 2)
 */
public class Java1DArray {

	public static boolean canWin(int leap, int[] game) {
		int i = 0;
		while(true) {
			if((i + leap > game.length-1) || (i == game.length-1)) {
				return true;
			} else if(game[i + leap] == 0) {
				i += leap;
			} else if(game[i + 1] == 0) {
				i += 1;
			} 
			else if(((i-1) > 0) && game[i-1] == 0) {
				game[i] = 1;
				i -= 1;
			} 
			else {
				return false;
			}
		}
    }

    public static void main(String[] args) {
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
    }
}