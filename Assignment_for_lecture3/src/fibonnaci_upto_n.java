import java.util.Scanner;

public class fibonnaci_upto_n {

	public static void main(String[] args) {
		int a=0,b=1,sum=0;
		Scanner scn=new Scanner(System.in);
		int n = scn.nextInt();
		while(sum<=n){
			System.out.println(sum);
			sum=a+b;
			b=a;
			a=sum;
		}

	}

}
