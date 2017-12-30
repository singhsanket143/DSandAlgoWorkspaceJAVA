import java.util.Scanner;

public class sum_of_odd_and_even_digits_of_a_no {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n = scn.nextInt(),odd=0,even=0,i;
		while(){
			i=n%10;
			if(i%2==0){
				even=even+i;
			}
			else{
				odd=odd+i;
			}
			n=n/10;
		}
		System.out.println(odd);
		System.out.println(even);
	}

}
