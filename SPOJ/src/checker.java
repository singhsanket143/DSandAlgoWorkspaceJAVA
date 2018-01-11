import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class checker {

	public static void main(String args[]) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		while(t-- > 0){
		int n=scn.nextInt();
		System.out.println(sum(n));
		}
	}
	
	public static int sum(int n){
		int a=n%10;
		int b=a;
		while(n > 9){
			n=n/10;
			b=n;
		}
		return b+a;
	}
}