package NumberThoery2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ChefAndCoprime {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int arr[] = new int[n];
		HashMap<Integer, Integer> map = new HashMap();
		boolean check[] = new boolean[1000005];
		for(int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
			check[arr[i]] = true;
		}
		Arrays.sort(arr);
		for(int i = 0; i < n; i++) {
			map.put(arr[i], i);
		}
		int result[] = eulerTotitent(100, map);
		for(int i = 0; i < 100; i++) {
			System.out.println(i+" "+result[i]);
		}
		
	}
	
	
	
	public static int[] eulerTotitent(int n, HashMap<Integer, Integer> map) {
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}
		
		for (int i = 2; i <= n; i++) {
			if (arr[i] == i && map.containsKey(arr[i])) {
				arr[i] = map.get(arr[i]);
				for (int j = 2 * i; j <= n ; j += i) {
					if(map.containsKey(j))
						arr[j] = (arr[j] * (i - 1)) / i;
				}
			}
		}
		return arr;
	}

}
