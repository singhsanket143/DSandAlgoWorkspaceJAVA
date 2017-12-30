import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class strangeOrder {

	public static HashMap<Integer, Integer> smap = new HashMap<>();

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> sieve = printprimesoe(n);
		strangeOrderprint(n, sieve);
	}

	public static void strangeOrderprint(int n, ArrayList<Integer> sieve) {
		boolean[] arr = new boolean[n + 1];
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i] == true)
				continue;
			int lcd = primefactor(sieve, i);
			int x = i;
			int temp = i;
			ArrayList<Integer> printer = new ArrayList<>();
			while (lcd != 1) {
				x = i;
				while (x > 1) {
					if (arr[x] == false) {
						arr[x] = true;
						printer.add(x);
					}
					x -= lcd;
				}

				while (temp % lcd == 0) {
					temp = temp / lcd;
				}
				lcd = primefactor(sieve, temp);
			}
			Collections.sort(printer);
			for (int j = printer.size() - 1; j >= 0; j--) {
				System.out.print(printer.get(j) + " ");
			}
		}
		System.out.print(1);
	}

	public static int primefactor(ArrayList<Integer> sieve, int num) {
		if(smap.containsKey(num)){
			return num;
		}
		for (int i = 0; i * i < num; i++) {
			if (num % sieve.get(i) == 0)
				return sieve.get(i);
		}
		return 1;
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
		int c = 0;
		for (int i = 2; i < primes.length; i++) {
			if (primes[i]) {
				sieve.add(i);
				smap.put(i, i);
			}
		}
		return sieve;
	}

}
