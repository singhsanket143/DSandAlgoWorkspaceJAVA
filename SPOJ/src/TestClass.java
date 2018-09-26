import java.util.Random;
import java.util.Scanner;

interface areashape {
	void calarea();
}

class rectangle implements areashape {
	int a, b;

	void getsides(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public void calarea() {
		int area = a * b;
		System.out.println("sides of rectangle are side 1 = " + a + " side 2 = " + b + " area = " + area);
	}
}

class circle implements areashape {
	int r;

	void getradius(int r) {
		this.r = r;
	}

	@Override
	public void calarea() {
		double area = 3.14 * r * r;
		System.out.println("radius of the circle = " + r + " area = " + area);
	}

}

class TestClass{

	public static void main(String args[]) {
		rectangle obj = new rectangle();
		obj.getsides(3, 4);
		obj.calarea();
		circle obj1 = new circle();
		obj1.getradius(3);
		obj1.calarea();
	}
}
