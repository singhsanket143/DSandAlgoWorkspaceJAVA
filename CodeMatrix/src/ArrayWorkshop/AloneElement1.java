package ArrayWorkshop;

import java.util.Scanner;

public class AloneElement1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(AloneElement1(arr));
	}

	public static int AloneElement1(int[] arr) {

		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result = result ^ arr[i];
		}
		return result;
	}

}
