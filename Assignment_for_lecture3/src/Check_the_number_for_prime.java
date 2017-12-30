import java.util.Scanner;

public class Check_the_number_for_prime {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter the no. N");
		int N=scn.nextInt();
		int i=2;
		while(i<N){
			if(N%i==0){
				System.out.println("N is not a prime no.");
				return;
			}
			else{
				i+=1;
			}
			
		}
		System.out.println("N is a prime no.");

	}

}
