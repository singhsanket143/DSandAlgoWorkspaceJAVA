package Array;

import java.util.Arrays;

public class numberOfTriangles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 21, 22, 100, 101, 200, 300};
		System.out.println(noOfTriangles(arr));
	}
	
	public static int noOfTriangles(int[] arr) {
		Arrays.sort(arr);
		int result=0;
		for(int i=0;i<arr.length-2;i++) {
			int k=i+2;
			for(int j=i+1;j<arr.length;j++) {
				while(k<arr.length && arr[i]+arr[j]>arr[k]) {
					++k;
				}
				result+=k-j-1;
			}
		}
		return result;
	}

}
