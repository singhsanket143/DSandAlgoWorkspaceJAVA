import java.util.Scanner;

class calculator

{
	public static Scanner scn = new Scanner(System.in);

	public static char operator;

	public static double num1;

	public static double num2;

	/*
	 * public void getval1()
	 * 
	 * {
	 * 
	 * Scanner s= new Scanner(System.in);
	 * 
	 * 
	 * 
	 * System.out.println("Enter the first value:");
	 * 
	 * num1=s.nextDouble();
	 * 
	 * System.out.println("Enter the second value:");
	 * 
	 * num2=s.nextDouble();
	 * 
	 * System.out.println("enter the operator:");
	 * 
	 * operator=s.next().charAt(0);
	 * 
	 * s.close();
	 * 
	 * 
	 * 
	 * }
	 */

	public void getval1()

	{

		Scanner s = new Scanner(System.in);

		System.out.println("Enter the first value:");

		num1 = s.nextDouble();

		s = null;

	}

	public void getval2()

	{

		Scanner s1 = new Scanner(System.in);

		System.out.println("Enter the second value:");

		num2 = s1.nextDouble();

		s1 = null;

	}

	public void getop()

	{

		Scanner s2 = new Scanner(System.in);

		System.out.println("enter the operator:");

		operator = s2.next().charAt(0);

		s2=null;

	}

	public static void main(String[] args)

	{

		calculator ob = new calculator();

		ob.getval1();

		ob.getval2();

		ob.getop();

		double output;

		switch (operator)

		{

		case '+':

			output = num1 + num2;

			break;

		case '-':

			output = num1 - num2;

			break;

		case '*':

			output = num1 * num2;

			break;

		case '/':

			output = num1 / num2;

			break;

		default:

			System.out.println("You have entered a wrong operator");

			return;

		}

		System.out.println("Result =" + output);

	}

}