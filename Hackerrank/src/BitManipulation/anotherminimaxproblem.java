package BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class anotherminimaxproblem {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		Arrays.sort(arr);
		ArrayList<Integer> m=new ArrayList<>();
		int lo = 0, hi = n - 1, result = 0;
		while (lo <= hi) {
			result ^= (arr[lo] ^ arr[hi]);
			m.add(result);
			lo++;
			hi--;
		}
		m.sort(null);
		System.out.println(m.get(m.size()-1));
	}

}
