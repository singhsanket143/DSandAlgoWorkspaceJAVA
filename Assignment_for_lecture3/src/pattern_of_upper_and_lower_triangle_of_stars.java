import java.util.Scanner;

public class pattern_of_upper_and_lower_triangle_of_stars {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter the no. N");
		int N=scn.nextInt(),row=1,numspaces=1,numstar=N / 2 + 1,col;
		while(row<=N){
			//spaces
			
			for(col=1;col<=numstar;col++)
				System.out.print("*"+"\t");
				
			//stars
			col=1;
			while(col<=numspaces){
				System.out.print("\t");
				col++;
			}
			//upper right star
			for(col=1;col<=numstar;col++){
				System.out.print("*"+"\t");
			}
			
			if(row>N / 2){
				numstar+=1;
				numspaces-=2;
			}
			else{
				numstar-=1;
				numspaces+=2;
			}
			row++;
			System.out.print("\n");
		}

	}

}
