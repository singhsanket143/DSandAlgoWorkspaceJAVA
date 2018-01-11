import java.math.BigInteger;
import java.util.Scanner;

public class advancedGCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		while(t>0){
			t--;
			String a=scn.next();
			String b=scn.next();
			System.out.println(gcd(a, b));
		}

	}
	
	public static BigInteger gcd(String a,String b){
		BigInteger first=new BigInteger(a);
		BigInteger second=new BigInteger(b);
		BigInteger zero=new BigInteger("0");
		BigInteger gcd=new BigInteger("0");
		BigInteger m=new BigInteger("0");
		if(second.compareTo(first)<=0){
			while(second.compareTo(zero)!=0){
				gcd=first.mod(second);
				first=second;
				second=gcd;
				if(second.compareTo(zero)==0){
					m=first;
				}
			}
		} else {
			while(first.compareTo(zero)!=0){
				gcd=second.mod(first);
				second=first;
				first=gcd;
				if(first.compareTo(zero)==0){
					m=second;
				}
			}
		}
		return m;
	}

}
