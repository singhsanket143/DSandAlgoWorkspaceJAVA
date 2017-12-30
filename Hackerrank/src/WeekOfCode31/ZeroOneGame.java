package WeekOfCode31;

import java.util.ArrayList;
import java.util.Scanner;

public class ZeroOneGame {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int g = scn.nextInt();
		for (int k = 0; k < g; k++) {
			int n = scn.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				int data = scn.nextInt();
				arr.add(data);

			}
			int d = arr.size() - 2;
			int c = 0;
			int i = arr.size() - 2;
			while (i >= 1) {

				if (arr.get(i + 1) == 0 && arr.get(i - 1) == 0) {
					c++;
					arr.remove(i);
					if (arr.size() > 2 && i < arr.size() - 2) {
						i++;
					} else {
						i = arr.size() - 2;
					}
				} else {
					i--;
				}
			}
			if (c % 2 == 0) {
				System.out.println("Bob");
			} else {
				System.out.println("Alice");
			}
		}
	}

}
