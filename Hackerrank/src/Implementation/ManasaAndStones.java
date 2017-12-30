package Implementation;

import java.util.ArrayList;
import java.util.Scanner;

public class ManasaAndStones {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int k = 0; k < n; k++) {
			int s = scn.nextInt();
			int x = scn.nextInt();
			int y = scn.nextInt();
			if(x<y)
				call(s, x, y, 0, 1,new boolean[s+1][(s*Math.max(x, y))+1]);
			else
				call(s, y, x, 0, 1,new boolean[s+1][(s*Math.max(x, y))+1]);
			
			System.out.println();
		}
	}

	public static ArrayList<Integer> arr = new ArrayList<>();

	public static void call(int n, int a, int b, int csv, int si,boolean[][] bool) {
		if(bool[si][csv]){
			return;
		}
		bool[si][csv]=true;
		if(si == n){
			System.out.print(csv);
			return;
		}
		
		call(n, a, b, csv + a, si + 1,bool);
		call(n, a, b, csv + b, si + 1,bool);
		
	}

}
