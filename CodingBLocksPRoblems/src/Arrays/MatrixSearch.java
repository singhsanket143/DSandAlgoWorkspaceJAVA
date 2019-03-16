package Arrays;

import java.util.Scanner;

public class MatrixSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n=scn.nextInt(), m=scn.nextInt();
	    int arr[][] = new int[n][m];
	    for(int i=0;i<n;i++) {
	        for(int j=0;j<m;j++) {
	            arr[i][j]=scn.nextInt();
	        }
	    }
	    int key=scn.nextInt();
	    int i = 0, j = m-1;
	    while(i<n && j >=0) {
	        if(arr[i][j] == key) {
	            System.out.println("1");;
	            return;
	        } else if (arr[i][j]<key){
	            i++;
	        } else {
	            j--;
	        }
	    }
	    System.out.println("0");;

	}

}
