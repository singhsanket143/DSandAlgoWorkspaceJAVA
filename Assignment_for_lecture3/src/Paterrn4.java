import java.util.Scanner;

public class Paterrn4 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter the number");
		int n = scn.nextInt(),row,value=1,col;
		for(row=1;row<=n;row++){
			for(col=1;col<=row;col++){
				System.out.print(value);}
			value++;
			System.out.println();
		}
		
	}
			

}
