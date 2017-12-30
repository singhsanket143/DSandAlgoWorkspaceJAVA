package ArrayWorkshop;

import java.util.Scanner;

public class TotalDivisibleSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 1; i <= arr.length; i++) {
			arr[i-1] = i;
		}
		System.out.println(DivisibleSubArraybtr(arr));

	}

	public static int DivisibleSubArray(int[] arr) {
		int n = arr.length;
		int[] prefixArray = new int[arr.length + 1];
		for (int i = 1; i <= arr.length; i++) {
			int sum = arr[i - 1];
			prefixArray[i] += prefixArray[i - 1] + sum;
		}
		for (int i = 0; i < prefixArray.length; i++) {
			if (prefixArray[i] > 0)
				prefixArray[i] %= n;
			else {
				prefixArray[i] += n;
				prefixArray[i] %= n;
			}
		}
		int[] result = new int[n + 1];
		for (int i = 0; i < prefixArray.length; i++) {
			result[prefixArray[i]]++;
		}
		int reusultOfCode = 0;
		for (int i = 0; i < result.length; i++) {
			if (result[i] > 1) {
				int comb = (result[i] * (result[i] - 1)) / 2;
				reusultOfCode += comb;
			}
		}
		return reusultOfCode;
	}
	
	public static int DivisibleSubArraybtr(int[] arr){
		int[] prefixSum=new int[arr.length];
		int sum=0;
		prefixSum[0]=1;
		for(int i=0;i<arr.length;i++){
			int temp=arr[i];
			sum+=temp;
			sum%=arr.length;
			sum=(sum+arr.length)%arr.length;
			prefixSum[sum]++;
		}
		int ans=0;
		for(int i=0;i<arr.length;i++){
			int no=prefixSum[i];
			ans+=((no)*(no-1))/2;
		}
		return ans;
	}

}
