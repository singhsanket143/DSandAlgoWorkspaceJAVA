import java.util.ArrayList;
import java.util.Scanner;

public class theCardgame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int[] arr = new int[n];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			max = (arr[i] > max) ? arr[i] : max;
		}
		System.out.println(divisibleproduct(arr, k, max));
	}

	public static int divisibleproduct(int[] arr, int k, int max) {
		int result = 0;

		return result;
	}

	public static ArrayList<Integer> printprimesoe(int n) {
		ArrayList<Integer> sieve = new ArrayList<>();
		boolean[] primes = new boolean[n + 1];
		for (int i = 0; i < primes.length; i++) {
			primes[i] = true;
		}
		for (int div = 2; div * div < n; div++) {
			if (primes[div]) {
				for (int multiple = 2; div * multiple <= n; multiple++) {
					primes[div * multiple] = false;
				}
			}
		}
		for (int i = 2; i < primes.length; i++) {
			if (primes[i]) {
				sieve.add(i);
			}
		}
		return sieve;
	}

}
