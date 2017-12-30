package problem1;

import java.util.Scanner;

public class client {

	public static void main(String[] args) {
		pattern1(5);
	}
	
	public static void pattern1(int row){
		int temp=row;

		if(row==0){
			return ;
		}
		int col=row;
		if(col==0){
			return;
		}
		
//		while(col!=0){
//			System.out.print("*");
//			col--;
//		}
		System.out.print('*');
		pattern1(col-1);
		System.out.println();
		row=col;
		pattern1(row-1);
		
	}

}
