package challenges.java;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *A prime number is a natural number greater than whose only positive divisors are and itself. For example, the first six prime numbers are 2, 3, 5, 7, 11, and 13.
 *Given a large integer, n, use the Java BigInteger class' isProbablePrime method to determine and print whether it's prime or not prime.
 *
 *Input Format
 *
 *A single line containing an integer, n(the number to be checked).
 *
 *Constraints
 *
 *n contains at most 100 digits.
 *
 *Output Format
 *
 *If n is a prime number, print prime; otherwise, print not prime.
 *
 *Sample Input
 *
 *13
 *
 *Sample Output
 *
 *prime
 *
 *Explanation
 *
 *The only positive divisors of 13 are 1 and 13, so we print prime.
 */
public class JavaPrimalityTest {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String n = scanner.nextLine();

		//
		BigInteger i = new BigInteger(n);
		if(i.isProbablePrime(1))
			System.out.println("prime");
		else
			System.out.println("not prime");
		//
		
		scanner.close();
	}
}