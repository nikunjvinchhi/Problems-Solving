package geekTrust;

public class Pracxtise {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		A a1 = new B();
		B b1 = (B) new A();
		
		a.get();
		b.get();
		a1.get();
		b1.get();
	}
}

class A{
	public void get() {
		System.out.println("A");
	}
	
	public long add(int a, int b) {
		return b;
		
	}
	public int add(int a, int b, int c) {
		return b;
		
	}
}

class B extends A{
	public void get() {
		System.out.println("B");
	}
}

