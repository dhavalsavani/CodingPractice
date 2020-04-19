package challenges.hackerrank.java;

import java.util.Scanner;
import java.util.Stack;

public class JavaStack {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				String str = sc.next();
				char[] chars = str.toCharArray();
				Stack<Character> characters = new Stack<>();
				boolean flag = true;
				for(int i = 0; i < chars.length; i++) {
					char c = chars[i];
					if(c == '{' || c == '[' || c == '(') {
						characters.push(c);
					} else {
						if(characters.isEmpty()) {
							flag = false;
						} else {
							char cp = characters.pop();
							switch(c) {
							case '}':
								if(cp != '{') {
									flag = false;
								}
								break;
							case ')':
								if(cp != '(') {
									flag = false;
								}
								break;
							case ']':
								if(cp != '[') {
									flag = false;
								}
								break;
							}
						}
					}
					if(!flag) {
						break;
					}
				}
				if(!characters.isEmpty()) {
					flag = false;
				}
				System.out.println(flag);
			}
		}
	}
}