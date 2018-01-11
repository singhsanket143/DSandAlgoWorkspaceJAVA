package testpackage;

import java.util.Scanner;

public class convertclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scanner s=new Scanner(system.in);
		int f = 0;
		while (f <= 300) {
			int c =(int)((5.0/9) * (f - 32));

			System.out.println(f + "\t" + c);
			f = f + 20;
		}

	}

}
