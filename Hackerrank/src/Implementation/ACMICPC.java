package Implementation;

import java.util.*;

public class ACMICPC {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.next();
		}
		int c = 0, cm = 0,th=0;
		for (int i = 0; i < n; i++) {
			for (int k = i + 1; k < n; k++) {
				c = 0;
				for (int j = 0; j < m; j++) {
					if (arr[i].charAt(j) == '1' || arr[k].charAt(j) == '1') {
						c++;
					}
				}
				if (cm < c) {
					cm = c;
					th=1;
				} else if(cm==c){
					th++;
				}
				
			}

		}
		System.out.println(cm);
		System.out.println(th);

	}
}