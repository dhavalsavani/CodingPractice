package challenges.hackerrank.java;

/**
 *    "The singleton pattern is a design pattern that restricts the instantiation of a class to one object. This is useful when exactly one object is needed to coordinate actions across the system."
 *    - Wikipedia: Singleton Pattern
 *
 *Complete the Singleton class in your editor which contains the following components:
 *
 *    A private Singleton non parameterized constructor.
 *    A public String instance variable named str.
 *    Write a static method named getSingleInstance that returns the single instance of the Singleton class.
 *
 *Once submitted, our hidden Solution class will check your code by taking a String as input and then using your Singleton class to print a line.
 *
 *Input Format
 *
 *You will not be handling any input in this challenge.
 *
 *Output Format
 *
 *You will not be producing any output in this challenge.
 *
 *Sample Input
 *
 *hello world
 *
 *Sample Output
 *
 *Hello I am a singleton! Let me say hello world to you
 */
public class JavaSingletonPattern {
	
	public String str;
	private static JavaSingletonPattern javaSingletonPattern;
	
	private JavaSingletonPattern() {}
	
	public static JavaSingletonPattern getSingleInstance() {
		if(javaSingletonPattern == null)
			javaSingletonPattern = new JavaSingletonPattern();
		return javaSingletonPattern;
	}
}