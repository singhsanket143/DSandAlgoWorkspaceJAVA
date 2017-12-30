package Implementation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MagicSquare {

	public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);
		
		int[][] arr= new int[3][3];
		int[] b=new int[9];
		int k=0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				arr[i][j]=scn.nextInt();
				b[k]=arr[i][j];
				k++;
			}
		}
		boolean[] a= new boolean[9];
		int d=0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				if(a[arr[i][j]-1]==false){
					a[arr[i][j]-1]=true;
					d++;
				}
			}
		}
		int[] c= new int[9-d];
		Arrays.sort(b);
		int f=0;
		int count=0;
		for(int i=0;i<a.length;i++){
			if(a[i]==false){
				c[f]=i+1;
				f++;
			}
		}
		Arrays.sort(c);
		f=0;
		for(int i=0;i<b.length-1;i++){
			if(b[i]==b[i+1]){
				count+=Math.abs(b[i+1]-c[f]);
				f++;
			}
		}
		System.out.println(count);
	}

}
