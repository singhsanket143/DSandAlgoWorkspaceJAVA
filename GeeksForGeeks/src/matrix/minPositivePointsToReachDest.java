package matrix;

public class minPositivePointsToReachDest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int points[][] = { {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}
              };
		System.out.println(minPoints(points));

	}
	
	public static int minPoints(int[][] arr) {
		int m=arr.length;
		int n=arr[0].length;
		int[][] dp = new int[m][n];
		dp[m-1][n-1]=(arr[m-1][n-1]<0)?(Math.abs(arr[m-1][n-1])+1):1;
		for(int i=m-2;i>=0;i--) {
			dp[i][n-1]=Math.max(dp[i+1][n-1]-arr[i][n-1], 1);
		}
		for(int i=n-2;i>=0;i--) {
			dp[m-1][i]=Math.max(dp[m-1][i+1]-arr[m-1][i], 1);
		}
		for(int i=m-2;i>=0;i--) {
			for(int j=n-2;j>=0;j--) {
				int min_points = Math.min(dp[i+1][j], dp[i][j+1]);
				dp[i][j]=Math.max(min_points-arr[i][j], 1);
			}
		}
		return dp[0][0];
	}

}
