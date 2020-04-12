package challenges.hackerrank.java;

import java.util.Scanner;

public class JavaEndofFile {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i = 0;
		while(scanner.hasNext()) {
			String s = scanner.nextLine();
			System.out.println(++i + " " + s);
		}
		scanner.close();
	}
}
