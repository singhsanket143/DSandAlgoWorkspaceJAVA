package Assignment8a;

import java.util.ArrayList;

public class RecurrsionAssign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 lexicoHstring("bcad", "", false);
//		 lexi(0, 100);
//		int[] arr = { 5, 12, 1, 18, 6, 3, 17,3 };
		// printgrouparray1(arr, 0, 0, 0,"","");
		// System.out.println();
		// System.out.println(countgrouparray(arr, 0, 0, 0));
//		System.out.println(ABcheck("abb", ""));
//		System.out.println(targetsubset(arr, 0, 6));
		// targetSubset(arr, 0, 6, "");
		// System.out.println(getgrouparray(arr, 0, 0, 0,""));

	}

	public static void targetSubset(int[] arr, int si, int target, String osf) {
		if (si == arr.length) {
			if (target == 0) {
				System.out.println(osf);
			}
			return;
		}
		targetSubset(arr, si + 1, target, osf);
		targetSubset(arr, si + 1, target - arr[si], osf + arr[si] + " ");
	}

	public static void lexicoHstring(String str, String osf, boolean bool) {
		if (str.length() == 0) {
			System.out.println(osf);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			if (bool) {
				char ch = str.charAt(i);
				String ros = str.substring(0, i) + str.substring(i + 1);
				lexicoHstring(ros, osf + ch, bool);
			} else {
				if (str.charAt(i) >= str.charAt(0)) {
					char ch = str.charAt(i);
					String ros = str.substring(0, i) + str.substring(i + 1);
					lexicoHstring(ros, osf + ch, bool || ch > str.charAt(0));
				}
			}
		}
	}

	public static void lexi(long s, long num) {
		if (s == num) {
			System.out.println(s);
			return;
		}
		if (s > num) {
			return;
		}

		System.out.println(s);
		for (int i = (s == 0 ? 1 : 0); i <= 9; i++) {

			lexi(10 * s + i, num);

		}
	}

	public static void printgrouparray1(int[] arr, int si, int sum1, int sum2, String osf1, String osf2) {

		if (si == arr.length) {
			if (sum1 == sum2) {
				System.out.println(osf1 + "---" + osf2);

			}
			return;
		}
		printgrouparray1(arr, si + 1, sum1 + arr[si], sum2, osf1 + arr[si], osf2);
		printgrouparray1(arr, si + 1, sum1, sum2 + arr[si], osf1, osf2 + arr[si]);
	}

	public static void printgrouparray(int[] arr, int si, int sum1, int sum2, String osf1) {

		if (si == arr.length) {
			if (sum1 == sum2) {
				System.out.println(osf1);

			}
			return;
		}
		printgrouparray(arr, si + 1, sum1 + arr[si], sum2, osf1 + arr[si] + " ");
		printgrouparray(arr, si + 1, sum1, sum2 + arr[si], osf1);
	}

	public static int countgrouparray(int[] arr, int si, int sum1, int sum2) {
		if (si == arr.length) {
			if (sum1 == sum2) {
				return 1;
			} else
				return 0;
		}

		int count = 0;
		count += countgrouparray(arr, si + 1, sum1 + arr[si], sum2);
		count += countgrouparray(arr, si + 1, sum1, sum2 + arr[si]);
		return count;
	}

	public static ArrayList<String> getgrouparray(int[] arr, int si, int sum1, int sum2, String osf1) {

		if (si == arr.length) {
			if (sum1 == sum2) {
				ArrayList<String> baseresult = new ArrayList<>();
				baseresult.add(osf1);
				return baseresult;
			} else {
				ArrayList<String> baseresult = new ArrayList<>();
				return baseresult;
			}
		}
		ArrayList<String> myresult = new ArrayList<>();
		ArrayList<String> recresult1 = getgrouparray(arr, si + 1, sum1 + arr[si], sum2, osf1 + arr[si]);
		ArrayList<String> recresult2 = getgrouparray(arr, si + 1, sum1, sum2 + arr[si], osf1);

		// myresult.addAll(recresult1);
		// myresult.addAll(recresult2);
		for (int i = 0; i < recresult1.size(); i++) {
			String adder = recresult1.get(i);
			myresult.add(adder);
		}
		for (int i = 0; i < recresult2.size(); i++) {
			String adder = recresult2.get(i);
			myresult.add(adder);

		}
		return myresult;
	}

	public static int[][] helper(int[] arr, int si, int k) {
		ArrayList<ArrayList<Integer>> list = targetsubset(arr, 0, k);
		int[][] retval = null;
		int rows = list.size();
		retval = new int[rows][];

		for (int row = 0; row < retval.length; row++) {
			int cols = list.get(row).size();
			retval[row] = new int[cols];
			for (int col = 0; col < retval[row].length; col++) {
				retval[row][col] = list.get(row).get(col);
			}
		}
		for (int i = 0; i < retval.length; i++) {
			for (int j = 0; j < arr.length; i++) {
				System.out.print(retval[i][j] + " ");
			}
			System.out.println();
		}
		return retval;
	}

	public static ArrayList<ArrayList<Integer>> targetsubset(int[] arr, int si, int sum1) {

		if (si == arr.length) {
			if (sum1 == 0) {
				ArrayList<ArrayList<Integer>> baseresult = new ArrayList<>();
				ArrayList<Integer> check = new ArrayList<>();
				// check.add(arr[si]);
				baseresult.add(check);
				return baseresult;
			} else {
				ArrayList<ArrayList<Integer>> baseresult = new ArrayList<>();
				return baseresult;
			}
		}
		ArrayList<ArrayList<Integer>> myresult = new ArrayList<>();
		ArrayList<ArrayList<Integer>> recresult1 = targetsubset(arr, si + 1, sum1 - arr[si]);
		ArrayList<ArrayList<Integer>> recresult2 = targetsubset(arr, si + 1, sum1);

		for (int i = 0; i < recresult1.size(); i++) {
			ArrayList<Integer> adder = recresult1.get(i);
			ArrayList<Integer> rec=new ArrayList<>();
			rec.add(arr[si]);
			for(int j=0;j<adder.size();j++){
				rec.add(adder.get(j));
			}
			myresult.add(rec);
		}
		for (int i = 0; i < recresult2.size(); i++) {
			ArrayList<Integer> adder = recresult2.get(i);
			// adder.add(arr[si]);
			myresult.add(adder);
		}
		return myresult;
	}

	public static boolean ABcheck(String str, String prev) {
		if(prev.equals("")){
			return str.length()==0 || (str.charAt(0)=='a' && ABcheck(str.substring(1), "a"));
		} else if(prev.equals("a")){
			return str.length()==0 || (str.charAt(0)=='a' &&ABcheck(str.substring(1), "a")) || (str.length()>=2 && str.substring(0, 2).equals("bb") && ABcheck(str.substring(2), "bb"));
		} else if(prev.equals("bb")){
			return str.length()==0 || (str.charAt(0)=='a'&& ABcheck(str.substring(1), "a"));
		} else{
			return false;
		}
	} 
}
