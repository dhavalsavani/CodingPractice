package challenges.hackerrank.java;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-md5/problem
 */
public class JavaMD5 {

	public static void main(String[] args) {
		try(Scanner s = new Scanner(System.in)) {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] b = md.digest(s.next().getBytes());
//			String hash = new BigInteger(1, b).toString(16);
			StringBuilder hash = new StringBuilder(new BigInteger(1, b).toString(16));
			while(hash.length() < 64) {
				hash.insert(0, '0');
			}
			System.out.println(hash.toString());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}