package challenges.kickstart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000051060/0000000000058b89
 * @author sadh8001
 *
 */
public class Mural {

	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().freeMemory());
		System.out.println(Runtime.getRuntime().maxMemory());
		System.out.println(Runtime.getRuntime().totalMemory());
		
//		test1();
		test2();
		
		System.out.println(Runtime.getRuntime().freeMemory());
		System.out.println(Runtime.getRuntime().maxMemory());
		System.out.println(Runtime.getRuntime().totalMemory());
	}
	
	public static void test2() {
		try(Scanner s = new Scanner(System.in)) {
			int t = s.nextInt();
			List<String> tests = new ArrayList<>(t);
			for(int i = 0; i < t; i++) {
				s.nextInt();
//				tests.add(s.next());
				Scanner scanner = new Scanner(new File("src/main/resources/mural.txt"));
				tests.add(scanner.nextLine());
				scanner.close();
			}
			
			long start = new Date().getTime();
			int testCount = 1;
			for(String test : tests) {
				int count = 0;
				int max = 0;
				int sum = 0;
				List<Integer> nums = test.chars().mapToObj(i -> Character.getNumericValue(i)).collect(Collectors.toList());
				int mid = (int) Math.ceil(((double)nums.size())/2);
				for(int num : nums) {
					sum += num;
					if(count >= mid)
						sum -= nums.get(count - mid);
					if(++count >= mid)
						max = Math.max(max, sum);
						
				}
				System.out.println("Case #" + testCount++ + ": " + max);
			}
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - start));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void test1() {
		try(Scanner s = new Scanner(System.in)) {
			int t = s.nextInt();
			List<String> tests = new ArrayList<>(t);
			for(int i = 0; i < t; i++) {
				s.nextInt();
//				tests.add(s.next());
				Scanner scanner = new Scanner(new File("src/main/resources/mural.txt"));
				tests.add(scanner.nextLine());
				scanner.close();
			}
			
			long start = new Date().getTime();
			int count = 0;
			for(String test : tests) {
				int max = 0;
				List<Integer> nums = test.chars().mapToObj(i -> Character.getNumericValue(i)).collect(Collectors.toList());
				int limit = (int) Math.ceil(((double)nums.size())/2);
				for(int i = 0; i < limit; i++) {
					int sum = nums.subList(i, i+limit).stream().mapToInt(a -> a).sum();
					if(sum > max) {
						max = sum;
					}
				}
				System.out.println("Case #" + ++count + ": " + max);
			}
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - start));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}