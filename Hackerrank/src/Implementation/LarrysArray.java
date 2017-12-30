package Implementation;

import java.util.Arrays;
import java.util.Scanner;

public class LarrysArray {

	public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		while(t>0){
			int n=scn.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++){
				arr[i]=scn.nextInt();
			}
			int si=0,ei=0;
			boolean bool=false;
			for(int i=0;i<=n-3;i++){
				if(arr[i]>arr[i-1]){
					si=i;
				}
				bool=rotate(arr, si, si+2);
				if(bool==true){
					System.out.println("YES");
					break;
				} else {
					continue;
				}
			}
			if(bool==false)
				System.out.println("NO");
			t--;
		}
	}
	
	public static boolean rotate(int[] arr,int si,int ei){
		int[] cc=new int[3];
		int j=0;
		for(int i=si;i<=ei;i++){
			cc[j]=arr[i];
			j++;
		}
		Arrays.sort(cc);
		for(int i=0;i<3;i++){
			arr[i+si]=cc[i];
		}
		return issortedsmarter(arr, 0);
	}
	public static boolean issortedsmarter(int[] arr, int si) {
		if (si == arr.length - 1)
			return true;
		if (arr[si] > arr[si + 1])
			return false;
		else {
			boolean issasorted = issortedsmarter(arr, si + 1);
			return issasorted;
		}
	}

}
