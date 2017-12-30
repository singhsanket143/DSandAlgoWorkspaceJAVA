package Implementation;

import java.util.Scanner;

public class DynamicData {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int Q = scn.nextInt();
		int last = 0;
		int[][] seq = new int[N][0];
		for (int i = 0; i < Q; i++) {
			int query = scn.nextInt();
			int x = scn.nextInt();
			int y = scn.nextInt();
			if (query == 1) {
				int index = ((x ^ last) % N);
				int[] arr = new int[seq[index].length+ 1];
				for (int j = 0; j < seq[index].length; j++) {
					arr[j] = seq[index][j];
				}
				arr[seq[index].length] = y;
				seq[index] = arr;

			} else if (query == 2) {
				int index = ((x ^ last) % N);
				last = seq[index][y % seq[index].length];
				System.out.println(last);
			}

		}
	}

}
