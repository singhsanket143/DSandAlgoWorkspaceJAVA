import java.util.Random;
import java.util.Scanner;

public class randomgenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		Random rand=new Random();
		for(int i=1;i<=n;i++){
//			int temp=rand.nextInt(10000)+1;
			System.out.println(i);
		}

	}

}
