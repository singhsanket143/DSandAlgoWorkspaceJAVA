package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class luckChallenge {

	static class contest {
		int luck;
		int importance;
		boolean taken;

		contest(int luck, int imp) {
			this.luck = luck;
			this.taken = false;
			this.importance = imp;
		}

	}

	static class finishComparator implements Comparator<contest> {

		@Override
		public int compare(contest a, contest b) {
			if (a.importance == b.importance) {
				return a.luck - b.luck;
			} else {
				return a.importance - b.importance;
			}
		}

	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		contest[] arr = new contest[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new contest(scn.nextInt(), scn.nextInt());
		}
		finishComparator f = new finishComparator();
		Arrays.sort(arr, f);
		int ans=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i].importance==1)
				break;
			ans+=arr[i].luck;
			arr[i].taken = true;
		}
		for(int i=arr.length-1;i>=0;i--) {
			if(arr[i].importance==0)
				break;
			if(k>0) {
				k--;
				ans+=arr[i].luck;
				arr[i].taken=true;
			} 
		}
		for(int i=0;i<arr.length;i++) {
			if(arr[i].taken == true) {
				continue;
			} else {
				ans-=arr[i].luck;
			}
		}
		System.out.println(ans);
	}

}
