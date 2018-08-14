package TwoPointer;

import java.util.ArrayList;
import java.util.Scanner;

public class minimumAbsoluteDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();
		int c = scn.nextInt();
		ArrayList<Integer> A = new ArrayList();
		ArrayList<Integer> B = new ArrayList();
		ArrayList<Integer> C = new ArrayList();
		for (int i = 0; i < a; i++) {
			A.add(scn.nextInt());
		}
		for (int i = 0; i < b; i++) {
			B.add(scn.nextInt());
		}
		for (int i = 0; i < c; i++) {
			C.add(scn.nextInt());
		}
		System.out.println(solve(A,B,C));

	}

	public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
		int i = 0, j = 0, k = 0;
		int ans = Integer.MAX_VALUE;

		int max, min;

		while (i < A.size() && j < B.size() && k < C.size()) {

			max = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
			min = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));

			ans = Math.min(ans, max - min);
			if (ans == 0)
				break;

			if (A.get(i) == min)
				i++;
			else if (B.get(j) == min)
				j++;
			else
				k++;
		}

		return ans;
	}

}
