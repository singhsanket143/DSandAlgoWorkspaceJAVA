package DP;

public class uglyNumber {

	public static void main(String[] args) {

		System.out.println(ugly(150));
	}

	public static int ugly(int n) {
		int[] dp = new int[n + 1];
		int i2 = 0, i3 = 0, i5 = 0;
		int next_multiple_of_2 = 2;
		int next_multiple_of_3 = 3;
		int next_multiple_of_5 = 5;
		int next_ugly_no=1;
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			next_ugly_no = Math.min(next_multiple_of_2, Math.min(next_multiple_of_3, next_multiple_of_5));
			dp[i]=next_ugly_no;
			if(next_multiple_of_2==next_ugly_no) {
				i2++;
				next_multiple_of_2=dp[i2]*2;
			}
			if(next_multiple_of_3==next_ugly_no) {
				i3++;
				next_multiple_of_3=dp[i3]*3;
			}
			if(next_multiple_of_5==next_ugly_no) {
				i5++;
				next_multiple_of_5=dp[i5]*5;
			}
		}
		return next_ugly_no;
	}

}
