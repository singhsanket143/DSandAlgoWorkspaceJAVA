package Hashing;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class shubhamAndSubarray {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		HashMap<Integer, Long> hash = new HashMap<>();
		HashMap<Long, Long> map=new HashMap<>();
		Random rand = new Random();
		for(int i=0;i<n;i++) {
			arr[i]=scn.nextInt();
		}
		for(int i=0;i<n;i++) {
			TreeSet<Long> set = new TreeSet<>();
			long sum = 0;
			for(int j=i;j<n;j++) {
				long x;
				if(hash.containsKey(arr[j])) {
					x=hash.get(arr[j]);
				} else {
					x = rand.nextLong();
					hash.put(arr[j], x);
				}
				if(!set.contains((long)arr[j])) {
					sum = sum + hash.get(arr[j])*arr[j];
					map.put(sum, sum);
				}
				set.add((long) arr[j]);
			}
		}
		System.out.println(map.size());
	}

}
