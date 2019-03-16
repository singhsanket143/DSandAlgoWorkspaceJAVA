package Arrays;

import java.util.Scanner;

public class MaximumSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-- > 0) {
	        int n = scn.nextInt();
	        int arr[] = new int[n];
	        for(int i=0;i<n;i++) {
	            arr[i]=scn.nextInt();
	        }
	        int currentSum = 0;
	        int maxSum = 0;
	        for(int i=0;i<n;i++) {
	            currentSum+=arr[i];
	            if(currentSum < 0) {
	                currentSum = 0;
	            }
	            maxSum = Math.max(currentSum, maxSum);
	        }
	        System.out.println(maxSum);;
	    }

	}

}
