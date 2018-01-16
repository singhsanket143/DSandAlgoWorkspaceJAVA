package DP;

public class allPossiblePathinAmatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(paths(3, 3));

	}
	
	public static int paths(int row, int col) {
		int[][] dp = new int[row][col];
		for(int i=0;i<row;i++) {
			dp[i][0]=1;
		}
		for(int i=0;i<col;i++) {
			dp[0][i]=1;
		}
		for(int i=1;i<row;i++) {
			for(int j=1;j<col;j++) {
				dp[i][j]=dp[i-1][j]+dp[i][j-1];
			}
		}
		return dp[row-1][col-1];
	}

}
