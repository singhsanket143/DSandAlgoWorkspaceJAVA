package Strings;

import java.util.HashMap;
import java.util.Scanner;

public class DNAHealth {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String[] arr = new String[n];
		int[] health = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.next();
		}
		for (int i = 0; i < arr.length; i++) {
			health[i] = scn.nextInt();
		}
		int t = scn.nextInt();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int j = 0; j < t; j++) {
			int first = scn.nextInt();
			int last = scn.nextInt();
			String str = scn.next();
			int x=printsubstrings(str, first, last, health, arr);
			if(x<min){
				min=x;
			}
			if(x>max){
				max=x;
			}
		}
		System.out.println(min+" "+max);

	}

	public static int printsubstrings(String str, int f, int l, int[] arr, String[] a) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = f; i <= l; i++) {
			if (map.containsKey(a[i])) {
				int temp = map.get(a[i]);
				map.put(a[i], temp + arr[i]);
			} else {
				map.put(a[i], arr[i]);
			}
		}
		int sum=0;
//		System.out.println(str.substring(0, 0));
		for (int j = 0; j < str.length(); j++) {
			for (int i = j + 1; i <= str.length(); i++) {
				String s=str.substring(j, i);
				if(map.containsKey(s)){
					sum+=map.get(s);
				}
			}
		}
		return sum;
	}

}
