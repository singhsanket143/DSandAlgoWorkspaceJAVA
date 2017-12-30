import java.util.Scanner;

public class Pattern1 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter the number");
		int n = scn.nextInt(),row=1,value=1,col;
		while(row<=n){
			col=1;
			while(col<=row){
				System.out.print(value+"\t");
				value+=1;
				col+=1;
			}
			System.out.print("\n");
			row+=1;
		}
	}

}
