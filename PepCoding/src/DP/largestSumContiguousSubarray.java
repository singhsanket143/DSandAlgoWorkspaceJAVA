package DP;

public class largestSumContiguousSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-2, -3, -1};
		System.out.println(modifiedKadane(arr));

	}
	
	public static int modifiedKadane(int[] arr) {
		int max_so_far = arr[0];
		int curr_max = arr[0];
		for(int i=1;i<arr.length;i++) {
			curr_max = Math.max(curr_max + arr[i], arr[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far;
	}

}
