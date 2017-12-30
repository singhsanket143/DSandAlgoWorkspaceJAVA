package Array;

import java.util.Scanner;

public class ArrayRotation {

	public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=scn.nextInt();
		}
		int d=scn.nextInt();
		boolean LorR=scn.nextBoolean();
		//rotate
		if(LorR==true){
			//leftrotate
			rotate(arr, 0, d-1);
			rotate(arr, d, arr.length-1);
			rotate(arr, 0, arr.length-1);
		} else{
			//rightrotate
			rotate(	arr, arr.length-d, arr.length-1);
			rotate(arr, 0, arr.length-d-1);
			rotate(arr, 0, arr.length-1);
		}
		//rotate
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
	}
	
	public static void rotate(int[] arr,int si,int li){
		while(si<=li){
			int temp=arr[si];
			arr[si]=arr[li];
			arr[li]=temp;
			si++;
			li--;
		}
		return;
	}

}
