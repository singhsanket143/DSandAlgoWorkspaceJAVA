package Lecture4;

import java.util.Scanner;

public class Fahrenheit_2_celcius {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int min = scn.nextInt();
		
		int max = scn.nextInt();
		
		int step = scn.nextInt();
		int c;
		for (min = 0; min <= max; min += step) {
			c = (int) ((5.0 / 9)*(min - 32));
			System.out.println(min + "\t" + c);
		}	
	}
}
