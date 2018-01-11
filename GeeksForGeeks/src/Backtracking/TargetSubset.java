package Backtracking;

import java.util.*;

public class TargetSubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] w = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(counttargetsubset(w, 0, 10, 0, ""));

	}

	public static int counttargetsubset(int[] arr, int si, int target, int help, String s) {
		if (help == target) {
			System.out.println(s);
			return 1;
		}
		if (si == arr.length) {
			return 0;
		}

		int a = counttargetsubset(arr, si + 1, target, help, s);

		int b = counttargetsubset(arr, si + 1, target, help + arr[si], s + arr[si] + "-");
		return a + b;
	}

	public static ArrayList<ArrayList<Integer>> targetsubset(int[] arr, int si, int sum1) {

		if (si == arr.length) {
			if (sum1 == 0) {
				ArrayList<ArrayList<Integer>> baseresult = new ArrayList<>();
				ArrayList<Integer> check = new ArrayList<>();
				// check.add(arr[si]);
				baseresult.add(check);
				return baseresult;
			} else {
				ArrayList<ArrayList<Integer>> baseresult = new ArrayList<>();
				return baseresult;
			}
		}
		ArrayList<ArrayList<Integer>> myresult = new ArrayList<>();
		ArrayList<ArrayList<Integer>> recresult1 = targetsubset(arr, si + 1, sum1 - arr[si]);
		ArrayList<ArrayList<Integer>> recresult2 = targetsubset(arr, si + 1, sum1);

		for (int i = 0; i < recresult1.size(); i++) {
			ArrayList<Integer> adder = recresult1.get(i);
			adder.add(arr[si]);
			myresult.add(adder);
		}
		for (int i = 0; i < recresult2.size(); i++) {
			ArrayList<Integer> adder = recresult2.get(i);
			// adder.add(arr[si]);
			myresult.add(adder);
		}
		return myresult;
	}

}
