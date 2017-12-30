package HackerEarth;

import java.util.Scanner;

public class diagonaldifference {

	public static void main(String[] args) {
		
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int diag1=0,diag2=0;
		int[][] arr=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				int data=scn.nextInt();
				arr[i][j]=data;
				if(i==j && i+j==n-1){
					diag1+=data;
					diag2+=data;
				} else if(i+j==n-1){
					diag2+=data;
				} else if(i==j){
					diag1+=data;
				}
			}
		}
		System.out.println(Math.abs(diag1-diag2));
	}

}
