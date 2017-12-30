package Mathematical;

import java.util.Scanner;

public class FibonacciBest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int[] arr=new int[n+1];
		System.out.println(fibBest(n,arr));

	}
	
	public static int fibBest(int n,int[] arr){
		if(n==0){
			arr[n]=0;
			return 0;
		} else if(n==1 || n==2){
			arr[n]=1;
			return 1;
		}
		
		if(arr[n]!=0){
			return arr[n];
		}
		
		int k=(n%2!=0)?(n+1)/2:n/2;
		arr[n]=(n%2!=0)?(fibBest(k,arr)*fibBest(k,arr)+fibBest(k-1,arr)*fibBest(k-1,arr)):(2*fibBest(k-1,arr)+fibBest(k,arr)*fibBest(k,arr));
		return arr[n];
	}

}
