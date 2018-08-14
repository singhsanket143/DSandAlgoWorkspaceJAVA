package Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class theElectricTypeHCKE {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n=scn.nextInt();
		HashMap<Integer, Integer> map=new HashMap<>();
		while(n-- > 0) {
			int a=scn.nextInt();
			map.put(a, a);
		}
		long m = map.size();
		long m1 = map.size()-1;
		long result = (long)(m*m1);
		System.out.println(result);
	}

}
