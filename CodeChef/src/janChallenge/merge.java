package janChallenge;

import java.util.Scanner;

public class merge {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int m = scn.nextInt();
			int n = scn.nextInt();
			String str1=scn.next();
			String str2=scn.next();
			System.out.println(mergeString(m, n, str1, str2));
		}
	}
	
	public static int mergeString(int m,int n,String str1,String str2) {
		int[][] dp =new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			dp[i][0]=0;
		}
		for(int i=0;i<=n;i++) {
			dp[0][i]=0;
		}
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				int val = Math.max(dp[i-1][j], dp[i][j-1]);
				if(str1.charAt(i-1)!=str2.charAt(j-1)) {
					dp[i][j]=1+val;
				} else {
					dp[i][j]=val;
				}
			}
		}
		
		return dp[m][n]+1;
	}

}
