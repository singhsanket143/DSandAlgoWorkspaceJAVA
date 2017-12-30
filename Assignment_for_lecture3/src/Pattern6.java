import java.util.Scanner;

public class Pattern6 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter the number");
		int n = scn.nextInt(),row,value=1,col;
		for(row=1;row<=n;row++){
			for(col=1;col<=row;col++){
				if(col==1 || col==row){
					System.out.print(value);}
				else{
					System.out.print("0");}
				}
			value++;
			System.out.println();
		}
	}
}
