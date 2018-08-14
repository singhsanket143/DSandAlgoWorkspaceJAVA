import java.util.Random;
import java.util.Scanner;

public class randomgenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		Random rand=new Random();
		for(int i=1;i<=n;i++){
			int temp2=rand.nextInt(10000)+1;
			int temp = rand.nextInt(1000) + 1 ;
			int temp1 = rand.nextInt(temp) + 1;
			System.out.println(1 + " " +temp1 +" " + temp + " " +temp2);
//			System.out.println(0 + " " + temp);
			
		}

	}

}
