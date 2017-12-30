package Implementation;

import java.util.Scanner;

public class ServiceLane {

	public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int t=scn.nextInt();
		int[] arr= new int[n];
		for(int i=0;i<arr.length;i++){
			arr[i]=scn.nextInt();
		}
		for(int i=0;i<t;i++){
			int entry=scn.nextInt();
			int exit=scn.nextInt();
			int min=3;
			for(int j=entry;j<=exit;j++){
				if(arr[j]<min){
					min=arr[j];
				}
			}
			System.out.println(min);
		}
		
	}

}
