import java.util.HashMap;
import java.util.Scanner;

public class removeDuplicates {
	public static void main(String args[]) {
		// Your Code Here
		// System.out.println(sumOfString("145", 0, 0));
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int[] result = removeDuplicates(arr);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}

	public static int[] removeDuplicates(int[] arr) {
		HashMap<Integer, Integer> popmap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!popmap.containsKey(arr[i])) {
				popmap.put(arr[i], 1);
			}
		}
		int[] result = new int[popmap.size()];
		int c = 0;
		for (int i = 0; i < arr.length; i++) {
			int check = popmap.get(arr[i]);
			if (check == 1) {
				result[c] = arr[i];
				c++;
				popmap.put(arr[i], popmap.get(arr[i]) - 1);
			}
		}
		return result;
	}

}
