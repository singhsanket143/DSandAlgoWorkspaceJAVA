package DP1;

import java.util.Scanner;

public class AlphaCode {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		while (str.charAt(0) - '0' != 0) {
			long[] arr=new long[str.length()];
			for(int i=0;i<str.length();i++){
				arr[i]=str.charAt(i)-'0';
			}
			long[] dp=new long[arr.length+1];
			System.out.println(num_codes2(arr, arr.length,dp));
			str=scn.next();
		}
	}
	
	public static long num_codes_i(long[] arr,int si){
		long[] output=new long[si+1];
		long mod=((long)Math.pow(10, 9))+7;
		output[0]=1;
		output[1]=1;
		for(int i=2;i<=si;i++){
			output[i]=output[i-1];
			if(arr[i-2]*10+arr[i-1]<=26){
				output[i]=((output[i]%mod)+(output[i-2]%mod))%mod;
			}
		}
		long ans=output[si];
		output=null;
		return ans;
	}
	public static long num_codes2(long[] arr,int si,long[] dp){
		long mod=1000000007L;
		if(si==1){
			return 1;
		}
		if(si==0){
			return 1;
		}
		if(dp[si]>0){
			return dp[si]%mod;
		}
		long output=0;
		if(arr[si-1]>0)
			output=num_codes2(arr, si-1,dp)%mod;
		if(arr[si-2]>0&&(arr[si-2]*10+arr[si-1])<=26){
			output=((output%mod)+(num_codes2(arr, si-2,dp)%mod))%mod;
		}
		dp[si]=output%mod;
		return output%mod;
	}
	public static int num_codes(int[] arr,int si){
		if(si==1){
			return 1;
		}
		if(si==0){
			return 1;
		}
		
		int output=num_codes(arr, si-1);
		if(arr[si-2]*10+arr[si-1]<=26){
			output+=num_codes(arr, si-2);
		}
		return output;
	}

}
