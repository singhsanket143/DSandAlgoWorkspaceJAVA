package Hack101_48;

import java.util.ArrayList;
import java.util.Scanner;

public class tightarray {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int result = shortestTightArray(a, b, c);
		System.out.println(result);
	}

	public static int shortestTightArray(int a, int b, int c) {
		ArrayList<Integer> arr = new ArrayList<>();
		if (b >= a && b <= c) {
			for (int i = a; i <= c; i++) {
				arr.add(i);
			}
		} else if(b>c){
			for(int i=a;i<=b;i++){
				arr.add(i);
			}
			for(int i=b-1;i>=c;i--){
				arr.add(i);
			}
		} else {
			for(int i=a;i>=b;i--){
				arr.add(i);
			}
			for(int i=b+1;i<=c;i++){
				arr.add(i);
			}
		}
		return arr.size();
	}

}
