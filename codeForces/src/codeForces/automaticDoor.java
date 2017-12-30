package codeForces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class automaticDoor {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int a = scn.nextInt();
		long d = scn.nextLong();
		ArrayList<Long> client = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			client.add(scn.nextLong());
		}
		System.out.println(result(n, m, a, d, client));
	}

	public static long result(int n, int m, int a, long d, ArrayList<Long> client) {
//		for (int i = 1; i <= n; i++) {
//			client.add((long) i * a);
//		}
//		Collections.sort(client);
		int res = 0;
		int i = 0, j = 0;
//		while (i < client.size()) {
//			int temp = i;
//			long curr = client.get(temp++);
//			res++;
//			while (temp < client.size() && client.get(temp) <= (curr + d)) {
//				temp++;
//			}
//			i = temp;
//		}
//		res = 0;
		for (i = 0; i < m + n && j<m; i++) {

			long curr = Math.min(a, client.get(j));
			long temp = curr;
			if (curr != a) {
				j++;
			} else {
				a += a;
			}
			res++;
			while (i < m + n && j<m && (temp + d) >= curr) {
				if (client.get(j) < a) {
					curr = client.get(j);
					if (j < client.size())
						j++;
				} else {
					curr = a;
					a += a;
				}

			}

		}
		return res;
	}

}
