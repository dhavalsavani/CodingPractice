package challenges.java;

import java.util.Scanner;

/**
 * Two strings,  and , are called anagrams if they contain all the same characters in the same frequencies. For example, the anagrams of CAT are CAT, ACT, TAC, TCA, ATC, and CTA.
 * 
 * Complete the function in the editor. If  and  are case-insensitive anagrams, print "Anagrams"; otherwise, print "Not Anagrams" instead.
 * 
 * Input Format
 * 
 * The first line contains a string denoting . 
 * The second line contains a string denoting .
 * 
 * Constraints
 * 
 * Strings  and  consist of English alphabetic characters.
 * The comparison should NOT be case sensitive.
 * Output Format
 * 
 * Print "Anagrams" if  and  are case-insensitive anagrams of each other; otherwise, print "Not Anagrams" instead.
 * 
 * Sample Input 0
 * 
 * anagram
 * margana
 * Sample Output 0
 * 
 * Anagrams
 * Explanation 0
 * 
 * Character	Frequency: anagram	Frequency: margana
 * A or a	3	3
 * G or g	1	1
 * N or n	1	1
 * M or m	1	1
 * R or r	1	1
 * The two strings contain all the same letters in the same frequencies, so we print "Anagrams".
 * 
 * Sample Input 1
 * 
 * anagramm
 * marganaa
 * Sample Output 1
 * 
 * Not Anagrams
 * Explanation 1
 * 
 * Character	Frequency: anagramm	Frequency: marganaa
 * A or a	3	4
 * G or g	1	1
 * N or n	1	1
 * M or m	2	1
 * R or r	1	1
 * The two strings don't contain the same number of a's and m's, so we print "Not Anagrams".
 * 
 * Sample Input 2
 * 
 * Hello
 * hello
 * Sample Output 2
 * 
 * Anagrams
 * Explanation 2
 * 
 * Character	Frequency: Hello	Frequency: hello
 * E or e	1	1
 * H or h	1	1
 * L or l	2	2
 * O or o	1	1
 * The two strings contain all the same letters in the same frequencies, so we print "Anagrams".
 */
public class JavaAnagrams {

	static boolean isAnagram(String a, String b) {
		
		//Flag to track Anagram status
		boolean anagramsFlag = true;
		
		//Map of character occurrence count of each string
		java.util.Map<Character, Integer> mapOfFirstStringCharacters = mapCharIterations(a.toLowerCase());
		java.util.Map<Character, Integer> mapOfSecondStringCharacters	= mapCharIterations(b.toLowerCase());
		
		//if size of each map is different then Not Anagrams
		if(mapOfFirstStringCharacters.keySet().size() != mapOfSecondStringCharacters.keySet().size()) {
			anagramsFlag = false;
		} else {
			for(char c : mapOfFirstStringCharacters.keySet()) {
				//check if the first map character contains in second
				if(mapOfSecondStringCharacters.containsKey(c)) {
					//check if count is same, else Not Anagrams
					if(mapOfFirstStringCharacters.get(c) != mapOfSecondStringCharacters.get(c)) {
						anagramsFlag = false;
						break;
					}
				//if not, Not Anagrams 
				} else {
					anagramsFlag = false;
					break;
				}
			}
		}
		return anagramsFlag;
	}
	
	static java.util.Map<Character, Integer> mapCharIterations(String s) {
		char[] charArray = s.toCharArray();
		java.util.Map<Character, Integer> map = new java.util.HashMap<>();
		
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		return map;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		scan.close();
		boolean ret = isAnagram(a, b);
		System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
	}

}
