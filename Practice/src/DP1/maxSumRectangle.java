package DP1;

import java.util.Scanner;

public class maxSumRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int m = scn.nextInt();
		int n = scn.nextInt();
		int[][] hm = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				hm[i][j] = scn.nextInt();
			}
		}
		findMaxSubMatrix(hm);
	}

	public static int[] kadane(int[] a) {
		int[] result = new int[] { Integer.MIN_VALUE, 0, -1 };
		int currentSum = 0;
		int localStart = 0;
		for (int i = 0; i < a.length; i++) {
			currentSum += a[i];
			if (currentSum < 0) {
				currentSum = 0;
				localStart = i + 1;
			} else if (currentSum > result[0]) {
				result[0] = currentSum;
				result[1] = localStart;
				result[2] = i;
			}
		}
		if (result[2] == -1) {
			result[0] = 0;
			for (int i = 0; i < a.length; i++) {
				if (a[i] > result[0]) {
					result[0] = a[i];
					result[1] = i;
					result[2] = i;
				}
			}
		}
		return result;
	}

	public static void findMaxSubMatrix(int[][] a) {
		int cols = a[0].length;
		int rows = a.length;
		int[] currentResult;
		int maxSum = Integer.MIN_VALUE;
		for (int leftCol = 0; leftCol < cols; leftCol++) {
			int[] tmp = new int[rows];
			for (int rightCol = leftCol; rightCol < cols; rightCol++) {
				for (int i = 0; i < rows; i++) {
					tmp[i] += a[i][rightCol];
				}
				currentResult = kadane(tmp);
				if (currentResult[0] > maxSum) {
					maxSum = currentResult[0];
				}
			}
		}
		System.out.println(maxSum);
	}
}
