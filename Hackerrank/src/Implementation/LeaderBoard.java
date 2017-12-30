package Implementation;

import java.util.Scanner;

public class LeaderBoard {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		arr[0] = scn.nextInt();
		int i=1,q=1;
		while(i<n && q<n){
			int data=scn.nextInt();
			if(data!=arr[i-1]){
				arr[i]=data;
			} else{
				q++;
				continue;
			}
			q++;
			i++;
		}
		int k = scn.nextInt();
		int c=arr.length-1;
		for (int m = 0; m < k; m++) {
			int a = scn.nextInt();
			for (int j = c; j >= 0; j--) {
				if(a>=arr[j]){
					arr[j]=a;	
					c=j;
				} else{
					break;
				}
			}
			System.out.println(c+1);
		}
	}
}
