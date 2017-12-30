package Implementation;

import java.util.Scanner;

public class catsandmouse {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int q = scn.nextInt();
		for (int i = 0; i < q; i++) {
			int ca = scn.nextInt();
			int cb = scn.nextInt();
			int m = scn.nextInt();
			if (m > ca && m > cb) {
				if (ca > cb) {
					System.out.println("Cat A");
				} else {
					System.out.println("Cat B");
				}
			} else if ((m > ca && m < cb) || (m < ca && m > cb) || (m<ca && m<cb)) {
				int a=Math.abs(m-ca);
				int b=Math.abs(m-cb);
				int c=Math.min(a, b);
				if(c==a && c!=b){
					System.out.println("Cat A");
				} else if(c==b && c!=a){
					System.out.println("Cat B");
				} else if(c==a && c==b){
					System.out.println("Mouse C");
				}
			}
		}
	}

}
