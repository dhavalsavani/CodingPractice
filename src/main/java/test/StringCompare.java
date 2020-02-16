package test;

public class StringCompare {
	
	public static void main(String[] args) {
		
		String s1 = "dhaval";
		String s2 = new String("dhaval");
		String s3 = s2;
		String s4 = "dhaval";
		
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s3 == s2);
		System.out.println(s1 == s4);
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s2.equals(s3));
		System.out.println(s4.equals(s3));
	}
}