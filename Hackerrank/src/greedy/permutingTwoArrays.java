package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class permutingTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-- > 0) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			ArrayList<Integer> a = new ArrayList();
			ArrayList<Integer> b = new ArrayList();
			for(int i=0;i<n;i++) {
				a.add(scn.nextInt());
			}
			for(int i=0;i<n;i++) {
				b.add(scn.nextInt());
			}
			a.sort(null);
			b.sort(null);
			Collections.reverse(b);
			boolean bool = false;
			for(int i=0;i<n;i++) {
				if(a.get(i)+b.get(i)>=k) {
					bool = true;
				} else {
					bool = false;
					break;
				}
			}
			if (bool) 
				System.out.println("YES");
			else 
				System.out.println("NO");
		}

	}

}
