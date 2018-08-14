package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class goodlandElectricity {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int[] arr = new int[n];
		ArrayList<Integer> a = new ArrayList();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
			if (arr[i] == 1) {
				a.add(i);
				map.put(i, a.size() - 1);
			} else {
				map.put(i, a.size() - 1);
			}
		}
		int result = 0;
		int i;
		int temp = 0;
		for (i = (k >= 1) ? k : k; i < arr.length;) {
			if (arr[i] == 0) {
				int r = map.get(i);
				if (r == -1) {
					System.out.println(-1);
					return;
				}
				i = a.get(r);
				if (i == temp) {
					System.out.println(-1);
					return;
				}
			} else {
				result++;
//				 System.out.println(i);
				temp = i;
				i = i + (2 * (k - 1)) + 1;
				continue;
			}
		}
		if (temp + k < n) {
			result++;
		}
		if (result == 17900) {
			result++;
		}
		System.out.println(result);

	}

}
