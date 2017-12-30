package BitManipulation;
import java.util.*;
public class countergame {

	public static void main(String[] args) {        
	    Scanner scan = new Scanner(System.in);
	    int t = scan.nextInt();
	    String[] winner = {"Richard", "Louise"};
	    for(int i =0; i < t; i++){
	        int w = 0;
	        long n = Long.parseUnsignedLong(scan.next());
	        while(n != 1){
	            if((n & (n - 1)) == 0){                    
	                n = n >> 1;                    
	            } else{                    
	                n = n - Long.highestOneBit(n);                    
	            }               
	            w ^= 1;
	        }
	        System.out.println(winner[w]);
	    }
	}

}
