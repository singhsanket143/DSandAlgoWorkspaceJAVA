package greedy;

import java.util.HashMap;
import java.util.Scanner;

public class largestPermutation {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k=scn.nextInt();
		int[] arr = new int[n];
		HashMap<Integer, Integer> map = new HashMap();
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
			map.put(arr[i], i);
		}
		int num=n;
		int m=0;
		while(m<n && k>0) {
			int hold = map.get(n-m);
			if(hold==m) {
				m++;
				continue;
			} else {
				int temp=arr[m];
				arr[m]=arr[hold];
				arr[hold]=temp;
				m++;
				k--;
			}
		}
//		while(k-- > 0) {
//			if(map.get(num)==n-num) {
//				continue;
//			} else {
//				int a=map.get(num);
//				int b=n-num;
//				int temp=arr[a];
//				arr[a]=arr[b];
//				arr[b]=temp;
//				map.put(arr[a], a);
//				map.put(arr[b], b);
//			}
//			num--;
//		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
