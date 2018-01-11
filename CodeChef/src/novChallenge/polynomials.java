package novChallenge;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
 
class polynomials {
 
	public static void main(String[] args) {
 
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int[] arr=new int[4];
			int[] f =new int[4];
			for(int i=0;i<4;i++){
				f[i]=Integer.MAX_VALUE;
			}
			for(int i=0;i<n;i++){
				int a0=scn.nextInt();
				int a1=scn.nextInt();
				int a2=scn.nextInt();
				int a3=scn.nextInt();
				if(a2==0 && a3==0){
					if(a0==0){
						if(a1<f[1]){
							f[0]=a0;
							f[1]=a1;
							f[2]=a2;
							f[3]=a3;
						}
					} else {
						
					}
				}
			}
			
			int q = scn.nextInt();
			while (q-- > 0) {
				int r = scn.nextInt();
				System.out.println(poly(f, r));
			}
		}
	}
 
	public static BigInteger poly(int[] arr, int r) {
		BigInteger a0=new BigInteger(""+arr[0]);
		BigInteger a1=new BigInteger(""+arr[1]);
		BigInteger a2=new BigInteger(""+arr[2]);
		BigInteger a3=new BigInteger(""+arr[3]);
		BigInteger t=new BigInteger(""+r);
		BigInteger x=t.multiply(t);
		BigInteger y=x.multiply(t);
		a1=a1.multiply(t);
		a2=a2.multiply(x);
		a3=a3.multiply(y);
		BigInteger result=a0.add(a1.add(a2.add(a3)));
		
		return result;
	}
 
} 