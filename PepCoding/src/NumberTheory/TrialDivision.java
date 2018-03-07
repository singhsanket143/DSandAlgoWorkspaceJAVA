package NumberTheory;

import java.util.ArrayList;

public class TrialDivision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> Primes = Sieve(1000);
		System.out.println(PrimesByTrialDivision(27, Primes));

	}

	public static ArrayList<Integer> PrimesByTrialDivision(int N, ArrayList<Integer> Primes) {
		ArrayList<Integer> factor = new ArrayList<>();
		int PF_idx = 0, PF = Primes.get(PF_idx);
		while (PF * PF <= N) {
			while (N % PF == 0) {
				N /= PF;
				factor.add(PF);
			}
			PF = Primes.get(++PF_idx);
		}
		if (N != 1) {
			factor.add(N);
		}
		return factor;
	}

	public static ArrayList<Integer> Sieve(int n) {
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
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 2; i < primes.length; i++) {
			if (primes[i])
				arr.add(i);
		}
		return arr;
	}

}
