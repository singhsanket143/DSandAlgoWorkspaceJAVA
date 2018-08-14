package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class wallPainting {

	class worker {
		int time;
		int cost;
		int speed;

		worker(int t, int c, int w) {
			this.time = t;
			this.cost = c;
			this.speed = w;
		}
	}

	class finishComparator implements Comparator<worker> {

		@Override
		public int compare(worker a, worker o) {
			int x = a.time - o.time;
			if (x == 0) {
				x = o.speed - a.speed;
				if (x == 0) {
					x = a.cost - o.cost;
				}
			}
			return x;
		}
	}

	public static wallPainting w = new wallPainting();

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		long d = scn.nextLong();

		worker[] arr = new worker[n];
		for (int i = 0; i < n; i++) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			int c = scn.nextInt();
			arr[i] = w.new worker(a, b, c);
		}
		System.out.println(wallPaint(arr, d));
	}

	public static long wallPaint(worker[] worker, long d) {
		finishComparator f = w.new finishComparator();
		Arrays.sort(worker, f);
		worker opt = worker[0];
		long cost = opt.cost;

		for (int i = 1; (i < worker.length) && (d > 0); i++) {
			worker curr = worker[i];
			d = d - (curr.time - opt.time) * opt.speed;

			if ((curr.speed > opt.speed) && (d > 0)) {
				cost = cost + curr.cost;
				opt = curr;
			}
			opt.time = curr.time;
		}
		return cost;
	}

}
