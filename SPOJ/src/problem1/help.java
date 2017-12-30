package problem1;

public class help {
	public static void abcd() {
		int a[] = { 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int l = 0;
		int r = a.length - 1;

		while (l < r) {
			if (a[l] == 1 && a[r] == 0) {
				a[l] = 0;
				a[r] = 1;
				r--;
				l++;
			} else {
				if (a[l] == 0)
					l++;
				if (a[r] == 1)
					r--;
			}
		}

		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);
	}
}
