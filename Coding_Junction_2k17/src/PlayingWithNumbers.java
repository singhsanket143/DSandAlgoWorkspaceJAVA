import java.util.*;

public class PlayingWithNumbers {

   public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);

		
		int source = scn.nextInt();
       int dest2 = scn.nextInt();
		
		int dest = 10;
	
		int n = scn.nextInt();
		int destno=0, pow=1;
		while(n!=0)
		{
			int rem=n%dest;
			destno=destno+pow*rem;
			pow*=source;
			n/=dest;
			
		}
	
		
		
		int source2 = 10;
		
		
		
		int n2 = destno;
		int destno2=0, pow2=1;
		while(n2!=0)
		{
			int rem2=n2%dest2;
			destno2=destno2+pow2*rem2;
			pow2*=source2;
			n2/=dest2;
			
		}
		System.out.println(destno2);

	}

}