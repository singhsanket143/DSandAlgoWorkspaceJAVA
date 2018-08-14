
public class A {
	public static String str = "abc";
	
	static class B {
		A a = new A();
		a.str = "gy";
		B() {
			System.out.println(str);
		}
	}
	
	public static void main(String[] args) {
		B b = new B();
		
		
	}
}
