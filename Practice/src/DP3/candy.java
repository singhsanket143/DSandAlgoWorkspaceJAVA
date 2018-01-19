package DP3;

import java.util.Scanner;

public class candy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int[][] like= new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				like[i][j]=scn.nextInt();
			}
		}
		System.out.println(solve(like, 3));
	}
	
	
	public static long solve(int[][] like,int n) {
		long[] dp=new long[(1<<n)];
		dp[(1<<n)-1]=1;
		for(int mask = (1<<n)-2;mask>=0;mask--) {
			int temp=mask;
			int k=0;
			while(temp>0) {
				int lastbit = temp&1;
				k=k+lastbit;
				temp=temp/2;
			}
			for(int i=0;i<n;i++) {
				int a=(mask & (1<<i));
				if(like[k][i]>0 && a==0) {
					dp[mask]+=dp[mask | (1<<i)];
				}
			}
		}
		return dp[0];
	}

}
