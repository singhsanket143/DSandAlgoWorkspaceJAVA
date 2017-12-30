import java.util.Scanner;

public class Pattern3 {

	public static void main(String[] args) {
		int a=0,b=1,sum,j=1,i=1;
		Scanner scn=new Scanner(System.in);
		System.out.println("enter the number");
		int n = scn.nextInt();
		while(i<=n){
			while(j<=i){
				
					System.out.print(a+"\t");
					sum=a+b;
					b=a;
					a=sum;
					j++;
					
		}
			i++;
			j=1;
			System.out.print("\n");
		}
	}
}


