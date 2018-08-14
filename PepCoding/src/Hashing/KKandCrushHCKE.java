package Hashing;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class KKandCrushHCKE {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			HashMap<Integer, Integer> map = new HashMap();
			for (int i = 0; i < n; i++) {
				int a = scn.nextInt();
				map.put(a, a);
			}
			int q = scn.nextInt();
			while (q-- > 0) {
				int b = scn.nextInt();
				if (map.containsKey(b)) {
					pw.println("Yes");
					pw.flush();
				} else {
					pw.println("No");
					pw.flush();
				}
			}
		}
	}

}
