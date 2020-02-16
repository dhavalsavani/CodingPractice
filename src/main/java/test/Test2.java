package test;

public class Test2 {

	
}

interface A extends B,D {
	public void m1();
}

interface B {
	public void m2();
}

interface D {
	public void m3();
}

class C implements A {

	@Override
	public void m1() {
		System.out.println("m1");
	}

	@Override
	public void m2() {
		System.out.println("m2");
	}

	@Override
	public void m3() {
		System.out.println("m3");
	}
}