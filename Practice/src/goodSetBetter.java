import java.util.Arrays;
import java.util.Scanner;

public class goodSetBetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t > 0) {
			t--;
			int n = scn.nextInt();
			int[] arr = new int[n];
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
				if (arr[i] > max)
					max = arr[i];
			}
			System.out.println(goodSets(arr, max));
		}

	}

	public static int goodSets(int[] arr, int max) {
		Arrays.sort(arr);
		int mod = 1000000007;
		int[] sieve = new int[max + 1];
		for (int i = 0; i < arr.length; i++) {
			sieve[arr[i]]++;
		}

		for (int i = 1; i <= max; i++) {
			for (int multiple = 2; i * multiple <= max; multiple++) {
				if (sieve[i * multiple] > 0) {
					sieve[i * multiple] = (sieve[i * multiple] % mod + sieve[i] % mod) % mod;
				}
			}
		}

		int result = 0;
		for (int i = 0; i < sieve.length; i++) {
			result = (result % mod + sieve[i] % mod) % mod;
		}
		return result % mod;

	}

}
