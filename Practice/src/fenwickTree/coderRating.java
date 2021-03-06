package fenwickTree;

import java.util.Arrays;
import java.util.Scanner;

public class coderRating {

	public static int[] bit = new int[100001];

	public class coder implements Comparable<coder> {
		int x;
		int y;
		int index;

		coder(int x, int y, int index) {
			this.x = x;
			this.y = y;
			this.index = index;
		}

		@Override
		public int compareTo(coder o) {
			// TODO Auto-generated method stub
			if (this.x == o.x) {
				return this.y - o.y;
			}
			return this.x - o.x;

		}
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		coderRating c = new coderRating();
		coder[] coder = new coder[n];
		for (int i = 0; i < n; i++) {
			int x = scn.nextInt();
			int y = scn.nextInt();
			
			coder[i] = c.new coder(x, y, i);
		}
		
		Arrays.sort(coder);
		int[] ans = new int[n];
		// for(int i=0;i<coder.length;i++){
		// System.out.println(coder[i].x+","+coder[i].y+","+coder[i].index);
		// }
		for (int i = 0; i < n;) {
			int endIndex = i;
			while ((endIndex < n) && (coder[endIndex].x == coder[i].x) && (coder[endIndex].y == coder[i].y)){
				endIndex++;
			}
			for(int j=i;j<endIndex;j++){
				ans[coder[j].index] = query(coder[j].y);
			}
			for(int j=i;j<endIndex;j++){
				update(coder[j].y);
			}
			i = endIndex;
		}
		for (int i = 0; i < coder.length; i++) {
			System.out.println(ans[i]);
		}
	}

	public static void update(int y) {
		for (; y <= 100000; y += (y & (-y))) {
			bit[y]++;
		}
	}

	public static int query(int y) {
		int value = 0;
		for (; y > 0; y -= (y & (-y))) {
			value += bit[y];
		}
		return value;
	}

}
