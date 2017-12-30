package Implementation;

import java.util.ArrayList;
import java.util.Scanner;

public class pickingnumbers {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		int[] arrc = new int[100];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
			arrc[a[a_i]]++;
		}
		int max = 0, temp;
		for (int i = 0; i < 99; i++) {
			temp = arrc[i] + arrc[i + 1];
			if (temp > max)
				max = temp;
		}

		System.out.println(max);
	}

}
