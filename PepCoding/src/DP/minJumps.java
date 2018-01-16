package DP;

public class minJumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 3, 6, 1, 0, 9};
		System.out.println(jumps(arr));
	}

	public static int jumps(int[] arr) {
		if (arr.length == 0 || arr[0] == 0) {
			return Integer.MAX_VALUE;
		}
		int[] jumps = new int[arr.length];
		jumps[0] = 0;
		for (int i = 1; i < arr.length; i++) {
			jumps[i]=Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if(jumps[j]!=Integer.MAX_VALUE && i<=j+arr[j]) {
					jumps[i]=Math.min(jumps[i], jumps[j]+1);
				}
			}
		}
		return jumps[arr.length-1];
	}

}
