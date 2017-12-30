package HackerEarth;

import java.util.Scanner;

public class MiniMax {

	public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);
		long[] arr=new long[5];
		for(int i=0;i<5;i++){
			long data=scn.nextLong();
			arr[i]=data;
		}
		long min = Integer.MAX_VALUE;
		long max = Integer.MIN_VALUE;
		long sum = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (j == i) {
					continue;
				}
				sum += arr[j];
			}
			if (sum > max) {
				max = sum;
			}
			if (sum < min)
				min = sum;
			sum=0;
		}
		System.out.print(min+" ");
		System.out.print(max);
	}

}
