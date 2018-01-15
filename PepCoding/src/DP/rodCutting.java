package DP;

public class rodCutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int values[] = {1, 5, 8, 9, 10, 17, 17, 20};
		int[] lengths= {1,2,3,4,5,6,7,8};
		System.out.println(CuttingRod(lengths, values, 8));
	}
	
	public static int CuttingRod(int[] lengths, int[] values, int target) {
		int[][] dp=new int[values.length+1][target+1];
		for(int i=1;i<=values.length;i++) {
			for(int j=1;j<=target;j++) {
				if(lengths[i-1]<=j) {
					dp[i][j]=Math.max(dp[i-1][j], values[i-1]+dp[i][j-lengths[i-1]]);
				} else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[values.length][target];
	}

}
