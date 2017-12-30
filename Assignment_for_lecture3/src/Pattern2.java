import java.util.Scanner;

public class Pattern2 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter the number");
		int n = scn.nextInt(),row=1,col,value;
		while(row<=n){
			//spaces
			col=1;
			while(col<=n-row){
				System.out.print(" "+"\t");
				col+=1;
			}
			//increasing no.
			value=row;
			col=1;
			while(col<=row){
				System.out.print(value+"\t");
				value+=1;
				col+=1;
			}
			//decreasing no
			value-=2;
			col=1;
			while(col<=row-1){
				System.out.print(value+"\t");
				value-=1;
				col+=1;}
			row+=1;
			System.out.print("\n");
		}


	}

}
