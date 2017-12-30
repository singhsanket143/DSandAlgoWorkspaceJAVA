package Implementation;

import java.util.Scanner;

public class FairRations {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int j = 1, k = n;
		if (arr.length == 2) {
			System.out.println("no");
		} else {
			while (j < n - 2 && k != 0) {
				if (arr[j] % 2 == 0) {
					if (arr[j - 1] % 2 != 0 && arr[j + 1] % 2 != 0) {
						arr[j] -= 2;
						arr[j - 1]--;
						arr[j + 1]--;
						k -= 4;
					}
				}
				if (iseven(arr)) {
					System.out.println(n - k);
					break;
				} else {
					j++;
				}
			}
		}
		if(!iseven(arr)){
			System.out.println("NO");
		}
		
	}

	public static boolean iseven(int[] arr) {
		boolean bool = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				bool = true;
			} else {
				bool = false;
				break;
			}
		}
		return bool;
	}

}
