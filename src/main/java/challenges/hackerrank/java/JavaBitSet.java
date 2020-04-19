package challenges.hackerrank.java;

import java.util.BitSet;
import java.util.Scanner;

public class JavaBitSet {

	public static void main(String[] args) {
		try(Scanner s = new Scanner(System.in)) {
			int n = s.nextInt();
			int m = s.nextInt();
			s.nextLine();
			
			BitSet b1 = new BitSet(n);
			BitSet b2 = new BitSet(n);
			
			for(int i = 0; i < m; i++) {
				String operation = s.next().toLowerCase();
				int fOperand = s.nextInt();
				int sOperand = s.nextInt();
				if(s.hasNext()) {
					s.nextLine();
				}
				operate(operation, fOperand, sOperand, b1, b2);
				System.out.println(b1.cardinality() + " " + b2.cardinality());
			}
		}
	}

	private static void operate(String operation, int fOperand, int sOperand, BitSet b1, BitSet b2) {
		switch(operation) {
		case "and":
			if(fOperand == 1) {
				b1.and(b2);
			} else {
				b2.and(b1);
			}
			break;
		case "or":
			if(fOperand == 1) {
				b1.or(b2);
			} else {
				b2.or(b1);
			}
			break;
		case "flip":
			if(fOperand == 1) {
				b1.flip(sOperand);
			} else {
				b2.flip(sOperand);
			}
			break;
		case "set":
			if(fOperand == 1) {
				b1.set(sOperand);
			} else {
				b2.set(sOperand);
			}
			break;
		case "xor":
			if(fOperand == 1) {
				b1.xor(b2);
			} else {
				b2.xor(b1);
			}
			break;
		}
	}
}