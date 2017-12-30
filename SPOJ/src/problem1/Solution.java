package problem1;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
//		Scanner scn = new Scanner(System.in);
//		String str = scn.nextLine();
//		String s = "";
//		if (str.charAt(str.length() - 2) == 'P') {
//
//			for (int i = 0; i < 2; i++) {
//				s = s + str.charAt(i);
//			}
//			int n = Integer.parseInt(s);
//			if (n == 12) {
//				s = "00";
//			} else {
//				n = n + 12;
//				s = Integer.toString(n);
//			}
//			for (int i = 2; i <= str.length() - 3; i++) {
//				s = s + str.charAt(i);
//			}
//			System.out.println(s);
//		} else {
//			for (int i = 0; i < 2; i++) {
//				s = s + str.charAt(i);
//			}
//			int n = Integer.parseInt(s);
//			if (n == 12) {
//				s = "00";
//				for (int i = 2; i <= str.length() - 3; i++) {
//					s += str.charAt(i);
//
//				}
//				System.out.println(s);
//			} else {
//
//				for (int i = 2; i <= str.length() - 3; i++) {
//					s += str.charAt(i);
//				}
//				System.out.println(s);
//			}
//		}
		
		int[] arr={2,3,1,4,2,3,5,9};
		System.out.println(circularrotation(arr));
	}

	public static ArrayList<Integer> circularrotation(int[] arr){
		Scanner scn=new Scanner(System.in);
		int k=scn.nextInt();
		ArrayList<Integer> scaned=new ArrayList<>();
		for(int i=k;i<arr.length;i++){
			scaned.add(arr[i]);
		}
		for(int i=0;i<arr.length-k;i++){
			scaned.add(arr[i]);
		}
		return scaned;
	}
}
