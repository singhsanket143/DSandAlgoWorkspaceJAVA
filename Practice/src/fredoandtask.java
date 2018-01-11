import java.math.BigInteger;
import java.util.Scanner;

public class fredoandtask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		long prod = 1;
		long max = Long.MIN_VALUE;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
			prod *= arr[i];
			max = (arr[i] > max) ? arr[i] : max;
		}
		System.out.println(minNumber(arr, prod, max));

	}

	public static double minNumber(int[] arr, long prod,long max) {
		double ans=0;
		long lo=1,hi=max;
		long val=0;
		for(int i=0;i<arr.length;i++){
			val+=(double)Math.log((double)arr[i]);
		}
		while(lo<=hi){
			long mid=(lo+hi)/2;
			double temp=(double)arr.length*(double)(Math.log((double)mid));
			if(val<temp){
				ans=mid;
				hi=mid-1;
			} else{
				lo=mid+1;
			}
		}
		return ans;
	}

}
