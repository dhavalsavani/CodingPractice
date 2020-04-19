package challenges.hackerrank.java;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JavaList {

	public static void main(String[] args) {
		try(Scanner s = new Scanner(System.in)) {
			int n  = s.nextInt();
			s.nextLine();
			List<Integer> integers = Arrays.stream(s.nextLine().split(" "))
										   .map(str -> new Integer(str))
										   .collect(Collectors.toList());
			int q = s.nextInt();
			for(int j = 0; j < q; j++) {
				s.nextLine();
				String query = s.nextLine().toLowerCase();
				if(query.contains("insert")) {
					int index = s.nextInt();
					int value = s.nextInt();
					integers.add(index, value);
				} else if(query.contains("delete")) {
					int index = s.nextInt();
					integers.remove(index);
				}
			}
			System.out.println(integers.stream().map(it -> it.toString()).collect(Collectors.joining(" ")));
		}
	}
}