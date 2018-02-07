package janCookOff;

import java.util.Scanner;

public class multipleOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int N = scn.nextInt();
			int K = scn.nextInt();
			int S = scn.nextInt();
			System.out.println(fun(N, K, S));
		}

	}

	public static int fun(int n, int k, int s) {
		boolean[] arr = new boolean[s + 1];
		arr[1] = true;
		int count = 1;
		int chocoLeft = n;
		int i = 2;
		chocoLeft -= k;
		while (i <= s) {
			if (chocoLeft <= k && i % 7 == 0) {
				// some work
				if (arr[i - 1] == true) {
					return -1;
				} else {
					i--;
					arr[i] = true;
					chocoLeft += n;
					count++;
					i++;
					continue;
				}
			} else if (chocoLeft <= k) {
				arr[i] = true;
				chocoLeft += n;
				count++;
			}
			if (chocoLeft >= k)
				chocoLeft -= k;
			i++;
		}
		return count;
	}

}
