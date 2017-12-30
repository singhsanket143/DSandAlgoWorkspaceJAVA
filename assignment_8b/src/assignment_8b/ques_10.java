package assignment_8b;

import java.util.Scanner;

public class ques_10 {

	public static void main(String[] args) {
		
		System.out.println("count is"+mining(3));
	}
	public static int[][] takeinput() {
		Scanner scn = new Scanner(System.in);
		int[][] retval = null;
		System.out.println("enter no of rows");
		int rows = scn.nextInt();
		retval = new int[rows][];

		for (int row = 0; row < retval.length; row++) {
			System.out.println("enter row" + row + "th row");
			int cols = scn.nextInt();
			retval[row] = new int[cols];
			for (int col = 0; col < retval[row].length; col++) {
				System.out.println("enter value for col" + (row + "," + col));
				retval[row][col] = scn.nextInt();
			}
		}
		return retval;

	}

	public static int countmazepathWdiagonalsuper(int endrow, int endcol, int currentrow, int currentcol) {
		if (currentrow == endrow && currentcol == endcol) {
			return 1;
		}
		if (currentrow > endrow || currentcol > endcol) {
			return 0;
		}
		int myresult = 0, dresult = 0, hresult = 0, vresult = 0,r1result=0,r2result=0,r3result=0,r4result=0;
		r1result=countmazepathWdiagonalsuper(endrow, endcol, currentrow+1, currentcol+2);
		r2result=countmazepathWdiagonalsuper(endrow, endcol, currentrow+2, currentcol-1);
		r3result=countmazepathWdiagonalsuper(endrow, endcol, currentrow+2, currentcol+1);
		r4result=countmazepathWdiagonalsuper(endrow, endcol, currentrow+1, currentcol-2);
		if (currentcol == 0 || currentrow == 0 || currentcol == endcol || currentrow == endrow) {
			hresult = countmazepathWdiagonalsuper(endrow, endcol, currentrow, currentcol + 1);

			vresult = countmazepathWdiagonalsuper(endrow, endcol, currentrow + 1, currentcol);
		}
		if (currentrow == currentcol || currentrow + currentcol == endcol) {
			dresult = countmazepathWdiagonalsuper(endrow, endcol, currentrow + 1, currentcol + 1);
		} else
			dresult = 0;
		myresult = hresult + vresult + dresult+r1result+r2result+r3result+r4result;
		return myresult;
	}

	public static int display(int[][] arr) {
		int c=0;
		if (arr == null) {
			System.out.println("nothing");
		} else {
			System.out.println("row=" + arr.length);
			int col=0;
			for (int row = 0; row < arr.length; row++) {
				if (arr[row] == null) {
					System.out.print("blank");
				} else {
					for (col = 0; col < arr[row].length; col++) {
						c= arr[row][col];
					}
				}
//				r3rn arr[row][col];
			}
		}
		return c;
	}
	
	public static boolean IsPrimeNumber(int number){
		 
		for(int i=2; i*i<= number; i++){
			if( number % i == 0)
				return false;
		}
		
		return true;
	}
	public static int mining(int n){
		int count=0;
		int[][] arr=takeinput();
		
			if(IsPrimeNumber(display(arr))==false){
				count+=countmazepathWdiagonalsuper(n, n, 0, 0);
			}
			else{
				for(int i=0;i<=n*n;i++){
					if(i%2==0)
						count++;
					

				}
			
		}
		return count;
		
	}
}
