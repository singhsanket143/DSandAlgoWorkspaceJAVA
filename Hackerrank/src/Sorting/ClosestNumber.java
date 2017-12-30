package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ClosestNumber {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n=scn.nextInt();
		int[] arr= new int[n];
		for(int i=0;i<n;i++){
			arr[i]=scn.nextInt();
		}
		Arrays.sort(arr);
		ArrayList<String> a= new ArrayList<>();
		int min=Integer.MAX_VALUE;
		for(int i=0;i<n-1;i++){
			if(Math.abs(arr[i]-arr[i+1])<min){
				min=Math.abs(arr[i]-arr[i+1]);
				a=new ArrayList<>();
				a.add(Integer.toString(arr[i])+" "+Integer.toString(arr[i+1]));
			} else if(Math.abs(arr[i]-arr[i+1])==min){
				a.add(Integer.toString(arr[i])+" "+Integer.toString(arr[i+1]));
			}
		}
		for(int i=0;i<a.size();i++){
			System.out.print(a.get(i)+" ");
		}
	}

}
