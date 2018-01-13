package janChallenge;

import java.util.ArrayList;
import java.util.Scanner;

public class squaregood {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = printprimesoe(1);
		Scanner scn=new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(arr.get(n-1));
	}
	
	public static ArrayList<Integer> printprimesoe(int n) {
		boolean[] primes = new boolean[10000002 + 1];
		ArrayList<Integer> arr = new ArrayList();
		for (int i = 0; i < primes.length; i++) {
			primes[i] = true;
		}
		for(int i =2;i*i<10000002;i++) {
			arr.add(i*i);
		}
		for (int div = 0;div<arr.size() && arr.get(div)  < 10000002; div++) {
			if (primes[div]) {
				for (int multiple = 1; arr.get(div) * multiple <= 10000002; multiple++) {
					primes[arr.get(div)  * multiple] = false;
				}
			}
		}
		
		ArrayList<Integer> res = new ArrayList();
		for (int i = 2; i < primes.length; i++) {
			if (!primes[i])
				res.add(i);
		}
		return res;
	}

}
