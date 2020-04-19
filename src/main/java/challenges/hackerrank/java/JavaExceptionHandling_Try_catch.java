package challenges.hackerrank.java;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-exception-handling-try-catch/problem
 */
public class JavaExceptionHandling_Try_catch {

	public static void main(String[] args) {
		try(Scanner s = new Scanner(System.in)) {
			int a = s.nextInt();
			int b = s.nextInt();
			
			System.out.println(a/b);
		} catch(InputMismatchException e) {
			System.out.println(e.getClass().getName());
		} catch(ArithmeticException ae) {
			System.out.println(ae.toString());
		} catch (Exception ee) {
			System.out.println(ee.toString());
		}
	}
}