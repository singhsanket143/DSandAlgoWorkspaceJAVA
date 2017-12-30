package Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MissingNumber {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int[] arr = new int[a];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int b = scn.nextInt();
		int[] arr1 = new int[b];
		for (int i = 0; i < b; i++) {
			arr1[i] = scn.nextInt();
		}
		Arrays.sort(arr);
		Arrays.sort(arr1);
		HashMap<Integer, Integer> list = new HashMap<>();
		int i = 0, j = 0;
		while (i < arr.length || j < arr1.length) {
			if (i < arr.length && arr[i] == arr1[j]) {
				i++;
				j++;
			} else if (i < arr.length && arr[i] != arr1[j]) {
				list.put(arr1[j], arr1[j]);
				j++;
			} else{
				list.put(arr1[j], arr1[j]);
				j++;
			}
		}
		i = 0;
		int[] x = new int[list.size()];
		Set<Map.Entry<Integer, Integer>> allEntries = list.entrySet();
		for (Map.Entry<Integer, Integer> entry : allEntries) {
			x[i] = entry.getKey();
			i++;
		}
		Arrays.sort(x);
		for (int k = 0; k < x.length; k++) {
			System.out.print(x[k] + " ");
		}
	}

}
