import java.util.HashMap;
import java.util.Scanner;

public class extra_sweet_english {
	public static int min = Integer.MAX_VALUE;
	public static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		// int[] arr = new int[n];
		// for (int i = 0; i < n; i++) {
		// arr[i] = i;
		// }
		HashMap<Integer, Integer> map = new HashMap<>();
		int t = scn.nextInt();
		while (t-- > 0) {
			int x = scn.nextInt();
			int y = scn.nextInt();
			System.out.println(calcSweet(x, y, map, n));

		}
	}

	public static long calcSweet(int x, int y, HashMap<Integer, Integer> map, int n) {
		long result = 0;
//		if (!map.containsKey(y))
			result += (y * (y + 1)) / 2;
//		if (!map.containsKey(x))
			result -= (x * (x - 1)) / 2;
		map.put(x, y);
		
		if (x < min)
			min = x;
		if (y > max)
			max = y;
		if(min>0){
			min--;
			result+=min;
		}
		if(max<n-1){
			max++;
			result+=max;
		}
		
		return result;
	}

}
