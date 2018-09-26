import java.util.*;
import java.util.HashMap;
import java.util.Scanner;

public class cn {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int x = scn.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		Arrays.sort(arr);
		long r = countTriplets(arr, n, x);
		System.out.println(r);
	}

	static class Pair {
		int num;
		int idx;

		Pair(int n, int i) {
			this.num = n;
			this.idx = i;
		}
	}
	

	public static long countTriplets(int arr[], int n, int m) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(n);
		HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>(n);
		for (int i = 0; i < n; i++) {
			mp.put(arr[i], i);
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		long res = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((arr[i] * arr[j] <= m) && (arr[i] * arr[j] != 0) && (m % (arr[i] * arr[j]) == 0)) {
					int check = m / (arr[i] * arr[j]);
					map.containsKey(check);
					if (check != arr[i] && check != arr[j] && map.containsKey(check) && mp.get(check) > i
	                        && mp.get(check) > j)
						res = res + map.get(check);
				}
			}
		}
		return res;
	}

}
