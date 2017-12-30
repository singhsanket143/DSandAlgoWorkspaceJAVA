package problem1;

public class o12sort {

	public static void main(String[] args) {
		int a[] = {2,1,1,1,2,2,2,1,0,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,2,0,1,2,2,1,2,2,1,2,1,2 };
		sort(a);
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);

	}

	public static void sort(int[] a) {
		int l = 0;
		int r = a.length - 1;
		int c = l;
		while (l < r && c < r) {
			if (a[l] == 1 && a[r] == 0) {
				a[l] = 0;
				a[r] = 1;
				l++;
				c = l;
			} else if (a[l] == 2 && a[r] == 1) {
				a[l] = 1;
				a[r] = 2;
				r--;
			} else if (a[l] == 0) {
				l++;
				c = l;
			} else if (a[r] == 2) {
				r--;
			} else {
				c++;
				if (a[c] != a[l]) {
					int temp = a[c];
					a[c] = a[l];
					a[l] = temp;
					c = l;
				}
			}
		}

	}

}
