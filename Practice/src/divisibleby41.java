import java.math.BigInteger;
import java.util.Scanner;

public class divisibleby41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t > 0) {
			t--;
			int a0 = scn.nextInt();
			int a1 = scn.nextInt();
			int c = scn.nextInt();
			int n = scn.nextInt();
			if(isDivisibleby41(a0, a1, c, n))
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}

	public static boolean isDivisibleby41(int a0, int a1, int c, int n) {
		int[] a=new int[n];
		a[0]=a0;
		if(n>1)
			a[1]=a1;
		for(int i=2;i<n;i++){
			a[i]=(((a[i-1])*c)%10+a[i-2]%10)%10;
		}
		int num=0;
		int pow=1;
		for(int i=n-1;i>=0;i--){
			num=num+(a[i]*pow);
			pow=((pow%41)*10)%41;
		}
		return num%41==0;
	}

}
