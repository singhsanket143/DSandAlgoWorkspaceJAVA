package Array;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSumOfConsecutivedifferencesinAcircularArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={4,2,1,8};
		System.out.println(maxSum(arr));
		

	}
	
	public static int maxSum(int[] arr){
		int sum=0;
		Arrays.sort(arr);
		for(int i=0;i<arr.length/2;i++){
			sum-=2*arr[i];
			sum+=2*arr[arr.length-i-1];
		}
		return sum;
	}

}
