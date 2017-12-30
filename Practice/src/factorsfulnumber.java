import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class factorsfulnumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		ArrayList<Integer> result = new ArrayList<>();
		int n = 1000006;
		boolean[] primes = new boolean[n + 1];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < primes.length; i++) {
			primes[i] = true;
		}
		map.put(1, 0);
		for (int div = 2; div < n; div++) {
			if (primes[div]) {
				for (int multiple = 1; div * multiple <= n; multiple++) {
					primes[div * multiple] = false;
					if (map.containsKey(div * multiple)) {
						map.put(div * multiple, map.get(div * multiple) + 1);
					} else {
						map.put(div * multiple, 1);
					}
				}
			}
		}
		for (int i = 2; i < primes.length; i++) {
			if (primes[i])
				result.add(i);
		}
		while (t > 0) {

			int a = scn.nextInt();
			int b = scn.nextInt();
			int num = scn.nextInt();
			System.out.println(factorful(map, a, b, num));
			t--;
		}

	}

	public static long factorful(HashMap<Integer, Integer> arr, int a, int b, int n) {
		int r = 0;
		for (int i = a; i <= b; i++) {
			if (arr.containsKey(i)) {
				if (arr.get(i) == n)
					r++;
			}
		}
		return r;
	}

}
