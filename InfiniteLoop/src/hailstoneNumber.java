import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class hailstoneNumber {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();
		map = cubes(1000000);
		hailstoneSeries(n, map);
	}

	public static void hailstoneSeries(int n, HashMap<Integer, Integer> map) {
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> arr = new ArrayList<>();
		int count = 0;
		int max = Integer.MIN_VALUE;
		while (n > 1) {
			if (map.containsKey(n) && isfib(n)) {
				// System.out.println("Case "+n+": is Cube Free "+map.get(n));
				System.out.println(n + " is a fighter ");
			} else if (isfib(n)) {
				System.out.println(n + " is a struggler ");
			} else {
				System.out.println(n + " is a winner ");
			}
			sb.append(n);
			arr.add(n);
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = n * 3;
				n++;
			}
			if (n > max) {
				max = (int) n;
			}
			count++;
		}
		System.out.println("1 is a fighter");
		sb.append("1");
		System.out.println("Total lucky participants were " + ++count);
		int[] a = new int[max];
		for (int i = 1; i <= max; i++) {
			a[i - 1] = i;
		}
		if (DivisibleSubArray(a) % 2 == 0) {
			System.out.println("Event was successful");
		} else {
			System.out.println("Event was not successful");
		}
		// System.out.println(arr.size());

	}

	public static HashMap<Integer, Integer> cubes(int n) {
		boolean[] primes = new boolean[n + 1];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < primes.length; i++) {
			primes[i] = true;
		}
		for (int div = 2; div * div * div < n; div++) {
			if (primes[div]) {
				for (int multiple = 1; div * div * div * multiple <= n; multiple++) {
					primes[div * div * div * multiple] = false;
				}
			}
		}
		int c = 1;
		map.put(1, c);
		for (int i = 2; i < primes.length; i++) {
			if (primes[i] && i < 1000000)
				map.put(i, ++c);
		}
		return map;
	}

	public static int DivisibleSubArray(int[] arr) {
		int[] prefixSum = new int[arr.length];
		int sum = 0;
		prefixSum[0] = 1;
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			sum += temp;
			sum %= arr.length;
			sum = (sum + arr.length) % arr.length;
			prefixSum[sum]++;
		}
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			int no = prefixSum[i];
			ans += ((no) * (no - 1)) / 2;
		}
//		System.out.println(ans);
		return ans;
	}

	public static boolean isfib(long n) {
		return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
	}

	public static boolean isPerfectSquare(long n) {
		long s = (long) Math.sqrt(n);
		return s * s == n;
	}


}
