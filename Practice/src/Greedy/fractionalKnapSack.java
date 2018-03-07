package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class fractionalKnapSack {

	class item {
		int value;
		int weight;

		item(int v, int w) {
			this.value = v;
			this.weight = w;
		}
	}

	class finishComparator implements Comparator<item> {

		@Override
		public int compare(item a, item b) {
			// TODO Auto-generated method stub
			double value1 = ((double) a.value) / (a.weight);
			double value2 = ((double) b.value) / (b.weight);
			return (value1 > value2) ? -1 : 1;
		}
	}

	public static fractionalKnapSack k = new fractionalKnapSack();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int w = 70;
		item[] arr = new item[3];
		arr[0] = k.new item(60, 20);
		arr[1] = k.new item(70, 15);
		arr[2] = k.new item(80, 40);
		System.out.println(fknapsack(arr, w));
	}

	public static double fknapsack(item[] arr, int w) {
		finishComparator f = k.new finishComparator();
		Arrays.sort(arr, f);
		int currW = 0;
		double fvalue = 0;
		for (int i = 0; i < arr.length; i++) {
			if (currW + arr[i].weight <= w) {
				currW += arr[i].weight;
				fvalue += arr[i].value;
			} else {
				int rWeight = w - currW;
				fvalue += arr[i].value * ((double) rWeight / arr[i].weight);
				break;
			}
		}
		return fvalue;
	}

}
