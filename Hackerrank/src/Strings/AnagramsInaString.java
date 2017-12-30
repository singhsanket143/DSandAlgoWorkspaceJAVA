package Strings;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.math.*;

public class AnagramsInaString {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int m = 0; m < t; m++) {
			String str = scn.next();
			HashMap<String, Integer> map = new HashMap<>();
			for (int i = 0; i < str.length(); i++) {
				for (int j = i; j <= str.length(); j++) {
					String x = str.substring(i, j);
					char[] arr = new char[x.length()];
					arr = x.toCharArray();
					Arrays.sort(arr);
					String y = new String(arr);
					if (y.length() == 0)
						continue;
					if (!map.containsKey(y)) {
						map.put(y, 1);
					} else {
						int temp = map.get(y);
						map.put(y, temp += 1);
					}
				}
			}
			long sum = 0;

			Set<Map.Entry<String, Integer>> allEntries = map.entrySet();
			for (Map.Entry<String, Integer> entry : allEntries) {
				int x = entry.getValue();
				BigInteger a = factorial(x);
				BigInteger b = factorial(x - 2);
				BigInteger c = new BigInteger("2");
				BigInteger ncr = (a).divide((b.multiply(c)));

				sum += ncr.intValueExact();
			}
			System.out.println(sum);

		}
	}

	public static BigInteger factorial(int n) {
		BigInteger x = new BigInteger("1");
		for (int i = 2; i <= n; i++) {
			x = x.multiply(BigInteger.valueOf(i));
		}
		return x;
	}

}
