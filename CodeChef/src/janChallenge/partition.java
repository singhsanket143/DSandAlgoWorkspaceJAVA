package janChallenge;

import java.util.HashMap;
import java.util.Scanner;

public class partition {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			long x = scn.nextLong();
			int n = scn.nextInt();
			if (n <= 3) {
				System.out.println("impossible");
				continue;
			}
			part(x, n);
		}
	}

	public static void part(long x, int n) {
		long sum = ((long)(n) * (n + 1)) / 2;
		sum -= x;
		System.out.println(sum);
		if (sum % 2 != 0 || sum == 0) {
			System.out.println("impossible");
			return;
		}
		long[] arr = new long[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (i != x - 1) ? (i + 1) : 0;
		}
		boolean[] bool = new boolean[n + 1];
		long tar = sum / 2;
		HashMap<Long, Boolean> map = new HashMap();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (tar == 0)
				break;
			if (arr[i] == 0)
				continue;
			if (tar == arr[i]) {
				map.put(arr[i], true);
				tar = 0;
				continue;
			}
			if (arr[i] == x || tar - arr[i] == x)
				continue;
			if (arr[i] + tar - arr[i] <= tar) {
				if (tar - arr[i] < 0)
					continue;
				long a = tar - arr[i];
				if (!map.containsKey(arr[i])) {
					map.put(arr[i], true);
					tar = tar - arr[i];
				}
				if (tar-a>0) {
					if (tar - a < 0)
						continue;
					if (!map.containsKey(a)) {
						map.put(a, true);
						tar = tar - a;
					}
				}
			}
		}
		for (long i = 1; i < bool.length; i++) {
			if (map.containsKey(i))
				bool[(int) i] = true;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < bool.length; i++) {
			if (i == x) {
				sb.append('2');
			} else if (bool[i]) {
				sb.append('0');
			} else {
				sb.append('1');
			}
		}
		System.out.println(sb.toString());
	}

}
