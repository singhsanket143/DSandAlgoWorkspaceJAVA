package Implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class NonDivisibleSubset {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		ArrayList<ArrayList<Integer>> r = nondivisiblesubset(arr, k, 0);

	
		if (r.size() > 0) {
			int max = r.get(0).size();
			
			for(int i = 1; i < r.size(); i++){
				if(r.get(i).size() > max){
					max = r.get(i).size();
				}
			}
			System.out.println(max);
		} else {
			System.out.println(0);
		}
	}

	public static ArrayList<ArrayList<Integer>> nondivisiblesubset(int[] arr, int k, int si) {
		if (si == arr.length) {
			ArrayList<ArrayList<Integer>> br = new ArrayList<>();

			br.add(new ArrayList<>());

			return br;
		}

		ArrayList<ArrayList<Integer>> rr = nondivisiblesubset(arr, k, si + 1);
		ArrayList<ArrayList<Integer>> mr = new ArrayList<>();

		mr.addAll(rr);
		for (ArrayList<Integer> rs : rr) {
			ArrayList<Integer> ms = new ArrayList<>();
			ms.addAll(rs);

			boolean flag = true;
			for (int item : ms) {
				if ((item + arr[si]) % k == 0) {
					flag = false;
					break;
				}
			}

			if (flag) {
				ms.add(arr[si]);
				mr.add(ms);
			}
		}

		return mr;
	}
}
