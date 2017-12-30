package Lecture5;

public class FunWithFunctions {

	public static int GLOBAL = -100;

	public static void main(String[] args) {
		// Part1
//		System.out.println("Hello main");
//		HelloFun();
//		System.out.println("Hello main");
//		HelloFun();
//		System.out.println("****************************");

		// Part2
//		System.out.println("Hello main");
//		HelloFun();
//		System.out.println("Hello main");
//		HelloGun();
//		System.out.println("****************************");

		// Part3
//		HelloMultiFun();
//		HelloMultiFun();
//		System.out.println("****************************");

		// Part4
//		System.out.println("****************************");
//		HelloMsg("Drop the gun");

		// Part5
//		System.out.println("****************************");
//		int len = HelloFunWithRet("kuch bhi");
//		System.out.println("The length of message was - " + len);

		// Part6
//		System.out.println("****************************");
		int one = 10;
		int two = 20;
		System.out.println(one+","+two);
		int temp=one;
		one=two;
		two=temp;
		System.out.println(one+","+two);
//
//		int sum = Add(one, two);
//		System.out.println(sum);
//
//		System.out.println(Add(one, two));

		// Part7
//		System.out.println("****************************");
//		sum = one + GLOBAL;
//		System.out.println(sum);
//		System.out.println(DemoGlobal(one, two));
//
//		GLOBAL = 100;
//		System.out.println(DemoGlobal(one, two));
//		System.out.println(GLOBAL);

		// Part8
//		System.out.println("****************************");
//		int GLOBAL = 1000;
//		System.out.println(GLOBAL);
//		System.out.println(FunWithFunctions.GLOBAL);

		// Part9
//		System.out.println("****************************");
//		if (one < two) {
			// int one = 20; not allowed
//			int three = 30;
//			System.out.println(three);
//		}

		// System.out.println(three); // not allowed
//		int three = 30;
//		System.out.println(three);

		// Part10
//		System.out.println("****************************");
//		System.out.println(one + ", " + two);
//		Swap(one, two);
//		System.out.println(one + ", " + two);
	}

	public static void HelloFun() {
		System.out.println("Hello Fun");
	}

	public static void HelloGun() {
		System.out.println("Hello Gun");
	}

	public static void HelloMultiFun() {
		System.out.println("Hello multi fun");
		HelloFun();

		System.out.println("Hello multi fun");
		HelloGun();
	}

	public static void HelloMsg(String msg) {
		System.out.println("Your message is: " + msg);
	}

	public static int HelloFunWithRet(String msg) {
		HelloMsg(msg);
		return msg.length();
	}

	public static int Add(int a, int b) {
		int retVal = 0;

		// retVal = one + two;
		retVal = a + b;

		return retVal;
	}

	public static int DemoGlobal(int a, int b) {
		int rv = a + b + GLOBAL;

		GLOBAL = 0;

		return rv;
	}

	public static void Swap(int a, int b) {
		System.out.println(a + ", " + b);
		
		int temp = a;
		a = b;
		b = temp;
		
		System.out.println(a + ", " + b);
	}
}
