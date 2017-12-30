package BitManipulation;

import java.util.Scanner;

public class newfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t > 0) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			long n1 = largest_power((int)Math.abs(a-1))-1;
			long n2 = largest_power((int)Math.abs(b))-1;
			
			
			if(a>=0 && b>=0){
				long suma=(n1)*(1<<(n1-1));
				for(int i=(1<<n1);i<=a-1;i++){
					suma+=brianKernighan(i);
				}
				long sumb=n2*(1<<(n2-1));
				for(int i=(1<<n2);i<=b;i++){
					sumb+=brianKernighan(i);
				}
				System.out.println(Math.abs(suma-sumb));
				
			} else if( a<0 && b>=0){
				int totalbits=allbits(Math.abs(a));
				int ones=allbits(Math.abs(a));
				int zeroes=totalbits-ones;
				long sumb=n2*(1<<(n2-1));
				for(int i=(1<<n2);i<=b;i++){
					sumb+=brianKernighan(i);
				}
//				System.out.println(sumb);
				System.out.println(sumb+zeroes);
			} else{
				n1 = largest_power((int)Math.abs(a))-1;
				int total_bits=(1<<(n1))*4;
				for(int i=(1<<n1);i<=a-1;i++){
					total_bits+=4;
				}
				n2 = largest_power((int)Math.abs(b))-1;
				total_bits+=(1<<(n2))*4;
				for(int i=(1<<n2);i<=b-1;i++){
					total_bits+=4;
				}
				System.out.println(total_bits);
			}
			// loop for a
//			long sum=n1*(1<<(n1-1));
//			for(int i=(1<<n1);i<=a;i++){
//				sum+=brianKernighan(i);
//			}
//			System.out.println(sum);
//			//total bits
//			int total_bits=(1<<(n1))*32;
//			for(int i=(1<<n1);i<=a;i++){
//				total_bits+=32;
//			}
//			System.out.println(total_bits-sum);
			
			t--;
		}

	}

	public static long largest_power(long n) {
		long temp = n;
		long count = 0;
		int log_val = 0;
		while (temp > 0) {
			log_val++;
			temp >>= 1;
		}
		return log_val;
	}
	
	public static int allbits(int num){
		long k=largest_power(num);
		int retval=(1<<k)*32;
		for(int i=(1<<k)+1;i<=num;i++){
			retval+=32;
		}
		return retval;
	}
	
	public static int brianKernighan(int num) {
		int count = 0;
		while (num > 0) {
			num = num & (num - 1);
			count++;
		}
		return count;
	}

}
