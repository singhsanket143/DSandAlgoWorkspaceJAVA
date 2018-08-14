package TwoPointer;

import java.util.Scanner;

public class productExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n=scn.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=scn.nextInt();
		}
		long[] res=productExceptSelf(arr);
		for(int i=0;i<n;i++) {
			System.out.print(res[i]+" ");
		}
	}
	public static long[] productExceptSelf(int[] nums) {
		int mod=1000_000_007;
	    int n = nums.length;
	    long[] res = new long[n];
	    res[0] = 1;
	    for (int i = 1; i < n; i++) {
	        res[i] = (res[i - 1]%mod * nums[i - 1]%mod)%mod;
	    }
	    long right = 1;
	    for (int i = n - 1; i >= 0; i--) {
	        res[i] = (res[i]%mod * right%mod)%mod;
	        right =  (res[i]%mod * nums[i]%mod)%mod;
	    }
	    return res;
	}


}
