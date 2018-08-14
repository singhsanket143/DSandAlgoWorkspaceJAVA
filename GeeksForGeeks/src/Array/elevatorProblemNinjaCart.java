package Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class elevatorProblemNinjaCart {

	public static class emp {
		int dest;
		long weight;

		emp(int d, long w) {
			this.dest = d;
			this.weight = w;
		}
	}

	class finishComparator implements Comparator<emp> {

		@Override
		public int compare(emp arg0, emp arg1) {
			if (arg0.dest <= arg1.dest) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	public static elevatorProblemNinjaCart e = new elevatorProblemNinjaCart();
	public static finishComparator f = e.new finishComparator();

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {

			int n = scn.nextInt();
			int P = scn.nextInt();
			long W = scn.nextLong();
			boolean bool = false;
			int[] floorWaiting = new int[n];

			int sum = 0;
			for (int i = 1; i <= n - 1; i++) {
				floorWaiting[i] = scn.nextInt();
				sum += floorWaiting[i];
			}
			emp[] arr = new emp[sum];
			int temp = 0;
			long floorsumW = 0;
			long floorsumP = 0;
			for (int i = 1; i <= n - 1; i++) {
				int data = floorWaiting[i];
				int[] destination = new int[data];
				long[] weights = new long[data];
				if (i != 1) {
					for (int m = 0; m < temp; m++) {
						if (arr[m].dest == i) {
							floorsumW -= arr[m].weight;
							arr[m].dest = -2;
							floorsumP -= 1;
						}
					}
				}
				floorsumP += data;
				for (int k = 0; k < destination.length; k++) {
					destination[k] = scn.nextInt();
				}
				for (int k = 0; k < weights.length; k++) {
					weights[k] = scn.nextLong();
					floorsumW += weights[k];
					if (floorsumW > W || floorsumP > P) {
						if(bool==false) {
							System.out.println(i);
							bool = true;
						}
					}
				}
				
				for (int k = 0; k < data; k++) {
					arr[temp] = new emp(destination[k], weights[k]);
					temp++;
				}
				destination = null;
				weights = null;
			}
			if (bool == false) {
				System.out.println(n);		
			}
		}
	}

}
