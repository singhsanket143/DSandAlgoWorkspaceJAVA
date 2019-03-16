package Arrays;

import java.util.Scanner;

public class KthRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
	    while(t-- > 0) {
	        long n = scn.nextLong(), k = scn.nextLong();
	        
	        if(k==1){
	            System.out.println(n);;
	            continue;
	        }
	        long lo = 1, hi = 1000000, ans = -1;
	        while(lo<=hi) {
	            long mid = (lo+hi)/2;
	            long var=1;
				for(int i=1;i<=k;i++)
				{
					var*=mid;
					if(var>n)
					{
						break;
					}
				}
	            if(var == n) {
	                ans = mid;
	                break;
	            } else if (var < n) {
	                ans = mid;
	                lo=mid+1;
	            } else {
	                hi=mid-1;
	            }
	        }
	        System.out.println(ans);;
	    }

	}

}
