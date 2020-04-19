package challenges.hackerrank.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JavaDequeue {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		Deque<Integer> deque = new ArrayDeque<>(m);
		Set<Integer> set = new HashSet<>();
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			deque.add(num);
			set.add(num);
			if(deque.size() == m) {
				max = set.size() > max ? set.size() : max;
				Integer first = deque.pollFirst();
				if(first != null && !deque.contains(first)) {
					set.remove(first);
				}
			}
			
		}
		in.close();
		System.out.println(max);
	}
}