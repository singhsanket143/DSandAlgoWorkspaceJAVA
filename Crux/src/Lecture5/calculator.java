package Lecture5;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class calculator {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		char ch = '\0';
		int N1 = 0, N2 = 0, output = 0;

		// Write your code here.

		while (1 == 1) {
			char o = scn.next().charAt(0);

			if (o == '+' || o == 'x' || o == '%' || o == '-' || o == '/' || o == '*' || o == 'X') {

				int a = scn.nextInt();

				int b = scn.nextInt();

				if (o == 'x' || a == 'X')
					break;

				else if (o == '+')
					System.out.println(a + b);

				else if (o == '-')
					System.out.println(a - b);

				else if (o == '*')
					System.out.println(a * b);

				else if (o == '/')
					System.out.println(a / b);

				else if (o == '%')
					System.out.println(a % b);

			} else
				System.out.println("Invalid operation. Try again.");
		}
	}
}