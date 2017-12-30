import java.util.Scanner;

public class Pattern10 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter the no. N");
		int N=scn.nextInt(),row=1,numspaces=N/2,numstar=1,col;
		while(row<=N){
			//spaces
			
			for(col=1;col<=numspaces;col++)
				System.out.print(" "+"\t");
				
			//stars
			col=1;
			while(col<=numstar){
				System.out.print("*"+"\t");
				col++;
			}
			if(row<=N/2){
				numspaces--;
				numstar+=2;
			}
			else{
				numspaces++;
				numstar-=2;
			}
			row++;
			System.out.print("\n");
		}



	}

}
