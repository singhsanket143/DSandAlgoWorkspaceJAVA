package matrix;

import java.util.Arrays;

public class maxPointsInAGridUsingTwoTraversals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 3, 6, 8, 2 }, { 5, 2, 4, 3 }, { 1, 1, 20, 10 }, { 1, 1, 20, 10 }, { 1, 1, 20, 10 }, };
		System.out.println(getmaxCollection(arr));
	}

	public static int R = 5;
	public static int C = 4;

	public static boolean isValid(int x, int y1, int y2) {
		return (x >= 0 && x < R && y1 >= 0 && y2 >= 0 && y2 < C && y2 < C);
	}

	public static int getmaxCollection(int[][] arr) {
		int[][][] dp = new int[R][C][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				for(int k=0;k<C;k++) {
					dp[i][j][k]=-1;
				}
			}
		}
		return getMaxUtil(arr, dp, 0, 0, C - 1);
	}

	public static int getMaxUtil(int[][] arr, int[][][] dp, int x, int y1, int y2) {
		if (!isValid(x, y1, y2)) {
			return Integer.MIN_VALUE;
		}
		if (x == R - 1 && y1 == 0 && y2 == C - 1) {
			return (y1 == y2) ? (arr[x][y1]) : (arr[x][y1] + arr[x][y2]);
		}
		if (x == R - 1) {
			return Integer.MIN_VALUE;
		}
		if (dp[x][y1][y2] != -1) {
			return dp[x][y1][y2];
		}
		int ans = Integer.MIN_VALUE;
		int temp = (y1 == y2) ? (arr[x][y1]) : (arr[x][y1] + arr[x][y2]);
		ans = Math.max(ans, temp + getMaxUtil(arr, dp, x + 1, y1, y2 - 1));
		ans = Math.max(ans, temp + getMaxUtil(arr, dp, x + 1, y1, y2 + 1));
		ans = Math.max(ans, temp + getMaxUtil(arr, dp, x + 1, y1, y2));
		ans = Math.max(ans, temp + getMaxUtil(arr, dp, x + 1, y1 - 1, y2));
		ans = Math.max(ans, temp + getMaxUtil(arr, dp, x + 1, y1 - 1, y2 - 1));
		ans = Math.max(ans, temp + getMaxUtil(arr, dp, x + 1, y1 - 1, y2 + 1));
		ans = Math.max(ans, temp + getMaxUtil(arr, dp, x + 1, y1 + 1, y2));
		ans = Math.max(ans, temp + getMaxUtil(arr, dp, x + 1, y1 + 1, y2 - 1));
		ans = Math.max(ans, temp + getMaxUtil(arr, dp, x + 1, y1 + 1, y2 + 1));
		return (dp[x][y1][y2] = ans);
	}

}
