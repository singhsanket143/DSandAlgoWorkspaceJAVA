package Greedy;

import java.util.Scanner;

public class HimaniAndStocks {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n=scn.nextInt();
		long m=scn.nextLong();
		long a=scn.nextLong();
		long b=scn.nextLong();
		long v=4_294_967_296L;
		long[] arr = new long[n];
		long x = 0;
		for(int i=0;i<arr.length;i++) {
			x = (((x%m)*a)+b)%v;
			arr[i]=x/256;
		}
		long best = -1, curr=arr[0], ans=0;
		for(int i=0;i<arr.length;i++) {
			curr=arr[i];
			if(best > -1 && best<curr) {
				ans+=curr-best;
				best=curr;
			} else {
				best=curr;
			}
		}
		System.out.println(ans);
	}

}
