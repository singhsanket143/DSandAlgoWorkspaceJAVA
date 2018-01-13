package DP;

public class subsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,3,7,8,10};
		int tar=11;
		subset(arr, tar);
	}
	
	public static boolean subset(int[] arr, int tar) {
		boolean[][] dp =new boolean[arr.length+1][tar+1];
		for(int i=0;i<=arr.length;i++) {
			dp[i][0]=true;
		}
		for(int i=1;i<=arr.length;i++) {
			for(int j=1;j<=tar;j++) {
				if(arr[i-1]>j) {
					dp[i][j]=dp[i-1][j];
				} else {
					dp[i][j]=dp[i-1][j] || dp[i-1][j-arr[i-1]];
				}
			}
		}
		for(int i=0;i<=arr.length;i++) {
			for(int j=0;j<=tar;j++) {
				System.out.print(dp[i][j]+"\t");
			}
			System.out.println();
		}
		return dp[arr.length][tar];
	}

}
