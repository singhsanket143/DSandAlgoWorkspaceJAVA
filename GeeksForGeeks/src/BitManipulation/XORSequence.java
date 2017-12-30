package BitManipulation;

import java.util.Scanner;

public class XORSequence {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[1000000000];
		int a = 0;
		for (int i = 0; i < arr.length; i++) {
			a = a ^ i;
			arr[i] = a;
		}
		int q = scn.nextInt();
		for (int i = 0; i < q; i++) {
			int l = scn.nextInt();
			int r = scn.nextInt();
//			if(l>100000){
//				System.out.println(l);
//				continue;
//			}
			int b = arr[l];
			for (int j = l + 1; j <= r; j++) {
				b = b ^ arr[j];
			}
			System.out.println(b);

		}

	}

}
