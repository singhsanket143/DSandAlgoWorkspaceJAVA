package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class wallPainting {

	class worker {
		int time;
		int cost;
		int wall;

		worker(int t, int c, int w) {
			this.time = t;
			this.cost = c;
			this.wall = w;
		}
	}

	class finishComparator implements Comparator<worker> {

		@Override
		public int compare(worker a, worker b) {
			return a.time-b.time;
		}
	}
	public static wallPainting w=new wallPainting(); 
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		long d=scn.nextLong();
		
		worker[] arr = new worker[n];
		for(int i=0;i<n;i++) {
			int a=scn.nextInt();
			int b=scn.nextInt();
			int c=scn.nextInt();
			arr[i]=w.new worker(a,b,c);
		}
		System.out.println(wallPaint(arr, d));
	}
	
	public static long wallPaint(worker[] arr, long d) {
		finishComparator f = w.new finishComparator();
		Arrays.sort(arr,f);
		long ans=0;
		for(int i=0;i<arr.length && d>0;i++) {
			if(arr[i].wall<=d) {
				ans+=arr[i].cost;
			}
		}
		return ans;
	}

}
