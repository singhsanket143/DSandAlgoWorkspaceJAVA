package Strings;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class FindStrings {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<String> arr = new ArrayList<>();
		for (int m = 0; m < n; m++) {
			String str = scn.next();
			ArrayList<String> popmap = new ArrayList<>();
			popmap = printsubstrings(str);
			for (int i = 0; i < popmap.size(); i++) {
				if(!binarysearch(arr, popmap.get(i))){
					arr.add(popmap.get(i));
				}
			}
		}
		String[] x = new String[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			x[i] = arr.get(i);
		}
		Arrays.sort(x);
		int q = scn.nextInt();
		for (int i = 0; i < q; i++) {
			int a = scn.nextInt();
			if (a > arr.size()) {
				System.out.println("INVALID");
			} else {
				System.out.println(x[a - 1]);
			}
		}
	}

	public static boolean binarysearch(ArrayList<String> arr,String data){
		int left=0,right=arr.size()-1;
		while(left<=right){
			int mid=(left+right)/2;
			if(data.compareTo(arr.get(mid))>0){
				left=mid+1;
			}
			else if(data.compareTo(arr.get(mid))<0){
				right=mid-1;
			}
			else
				return true;
		}
		return false;
		
	}

	public static ArrayList<String> printsubstrings(String str) {
		HashMap<String, String> map = new HashMap<>();
		ArrayList<String> a = new ArrayList<>();
		// System.out.println(str.substring(0, 0));
		for (int j = 0; j < str.length(); j++) {
			for (int i = j + 1; i <= str.length(); i++) {
				String v = str.substring(j, i);
				if (!map.containsKey(v)) {
					a.add(v);
					map.put(v, v);
				}

			}
		}
		return a;
	}

}
