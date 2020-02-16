package test;

import java.util.HashMap;
import java.util.Set;

public class Test3 {

	static HashMap<String, Set<Object>> source = new HashMap<>();
	static HashMap<String, Set<Object>> target = new HashMap<>();

	public static void main(String[] args) {
		
		for (String s : source.keySet()) {
			for (String t : target.keySet()) {
				for(Object o : target.get(t))
				source.get(s).contains(o);
			}
		}
	}
}