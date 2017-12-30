import java.util.Scanner;

public class reverse_of_a_number {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter the no. N");
		int N=scn.nextInt(),rev=0,rem;
		while(N!=0){
			rem=N%10;
			rev=rev*10+rem;
			N=N/10;
		}
		System.out.println("reverse of the number is "+rev);

	}

}
