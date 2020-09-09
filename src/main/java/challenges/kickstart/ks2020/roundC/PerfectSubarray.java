package challenges.kickstart.ks2020.roundC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PerfectSubarray {

	public static void main(String[] args) {
		try(Scanner s = new Scanner(System.in)) {
			//Taking Number of Test cases
			int t = s.nextInt();
			long startTime = new Date().getTime();

			//Creating squares
			Set<Integer> squares = new HashSet<>(101);
			for(int i = 0; i < 101; i++) {
				squares.add(i * i);
			}
			
			//Taking each case
			for(int i = 1; i <= t; i++) {
				int n = s.nextInt();
				s.nextLine();
				int[] nums = Arrays.stream(s.nextLine().trim().split(" "))
									.mapToInt(a -> Integer.parseInt(a))
									.toArray();
				
				int count = 0;
				List<Integer> prevs = new ArrayList<>();
				List<Integer> next = new ArrayList<>();
				//Iterating over all elements
				for(int j = 0; j < n; j++) {
					//Checking if current element is perfect square
					//if yes, then incrementing counter
					if(squares.contains(nums[j])) {
						count++;
					}
					//Adding current element for next elements reference
					next.add(nums[j]);
					//Iterating over previous sub arrays sums and
					//checking if it is perfect square
					//if yes, then incrementing counter
					for(int k = 0; k < prevs.size(); k++) {
						int temp = nums[j] + prevs.get(k);
						if(squares.contains(temp)) {
							count++;
						}
						next.add(temp);
					}
					
					//setting reference for next elements calculations
					prevs = next;
					next = new ArrayList<>(prevs.size() + 1);
				}
				System.out.println("Case #" + i + ": " + count);
			}
			
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - startTime));
		}
	}
}