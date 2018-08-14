package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class jimAndOrders {
	
	static class orders {
		int serial;
		int startTime;
		int total;
		int endTime;
		
		orders(int a, int b, int i) {
			this.serial = i;
			this.startTime = a;
			this.total = b;
			this.endTime = a+b;
		}
	}
	
	static class finishComparator implements Comparator<orders> {

		@Override
		public int compare(orders a, orders b) {
			// TODO Auto-generated method stub
			return a.endTime - b.endTime;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		orders[] arr = new orders[n];
		for(int i=0;i<arr.length;i++) {
			arr[i] = new orders(scn.nextInt(), scn.nextInt(), i+1);
		}
		finishComparator f = new finishComparator();
		Arrays.sort(arr, f);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i].serial+" ");
		}

	}

}
