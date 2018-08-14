package TwoPointer;

import java.util.Scanner;

public class BobAndthecontainer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n=scn.nextInt();
		long[]arr = new long[n];
		for(int i=0;i<n;i++) {
			arr[i]=scn.nextInt();
		}
		System.out.println(maxArea(arr));

	}
	
	public static long maxArea(long[] height) {
        long maxarea = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }

}
