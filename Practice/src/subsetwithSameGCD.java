import java.util.HashMap;
import java.util.Scanner;

public class subsetwithSameGCD {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t > 0) {
			int n = scn.nextInt();
			;
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			System.out.println(goodSets(arr));
			t--;
		}
	}

	public static int goodSets(int[] arr) {
		int max = Integer.MIN_VALUE;
		int result = 0;
		HashMap<Integer, Integer> freqmap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			freqmap.put(arr[i], 1);
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = max; i >= 1; i--) {
			int add = 0;
//			if (freqmap.containsKey(i))
//				add = freqmap.get(i);
			int sub = 0;
			for (int j = 2; j * i <= max; j++) {
				if (freqmap.containsKey(j * i))
					add += freqmap.get(j * i);
				if (map.containsKey(j * i)) {
					sub += map.get(j * i);
				}
			}
			int value = (1 << add) - 1 - sub;
			if (value > 0)
				map.put(i, value);
			else
				map.put(i, 0);
		}
		for (int i = 2; i <= max; i++) {
			if (map.containsKey(i))
				result += map.get(i);
		}
		return ++result;
	}

}
