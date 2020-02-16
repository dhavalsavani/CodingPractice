package challenges.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 *You are given a class Solution and its main method in the editor. Your task is to create a class Prime. The class Prime should contain a single method checkPrime.
 *
 *The locked code in the editor will call the checkPrime method with one or more integer arguments. You should write the checkPrime method in such a way that the code prints only the prime numbers.
 *
 *Please read the code given in the editor carefully. Also please do not use method overloading!
 *
 *Note: You may get a compile time error in this problem due to the statement below:
 *
 *  BufferedReader br=new BufferedReader(new InputStreamReader(in));
 *
 *This was added intentionally, and you have to figure out a way to get rid of the error.
 *
 *Input Format
 *
 *There are only five lines of input, each containing one integer.
 *
 *Output Format
 *
 *There will be only four lines of output. Each line contains only prime numbers depending upon the parameters passed to checkPrime in the main method of the class Solution. In case there is no prime number, then a blank line should be printed.
 *
 *Sample Input
 *
 *2
 *1
 *3
 *4
 *5
 *
 *Sample Output
 *
 *2 
 *2 
 *2 3 
 *2 3 5 
 */
public class PrimeChecker {

	public static void main(String[] args) {
		try{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n1=Integer.parseInt(br.readLine());
		int n2=Integer.parseInt(br.readLine());
		int n3=Integer.parseInt(br.readLine());
		int n4=Integer.parseInt(br.readLine());
		int n5=Integer.parseInt(br.readLine());
		Prime ob=new Prime();
		ob.checkPrime(n1);
		ob.checkPrime(n1,n2);
		ob.checkPrime(n1,n2,n3);
		ob.checkPrime(n1,n2,n3,n4,n5);	
		Method[] methods=Prime.class.getDeclaredMethods();
		Set<String> set=new HashSet<>();
		boolean overload=false;
		for(int i=0;i<methods.length;i++)
		{
			if(set.contains(methods[i].getName()))
			{
				overload=true;
				break;
			}
			set.add(methods[i].getName());
			
		}
		if(overload)
		{
			throw new Exception("Overloading not allowed");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
		}
	}
}

class Prime{

	public void checkPrime(int... numbers) {
		for (int i = 0; i < numbers.length; i++) {
			if(new BigInteger(String.valueOf(numbers[i])).isProbablePrime(1)) {
				System.out.print(numbers[i] + " ");
			}
		}
		System.out.println();
	}
}