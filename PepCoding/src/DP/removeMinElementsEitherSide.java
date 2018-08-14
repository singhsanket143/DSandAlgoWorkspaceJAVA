package DP;

public class removeMinElementsEitherSide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4, 5, 100, 9, 10, 11, 12, 15, 200};
		System.out.println(minMax(arr));

	}

	public static int minMax(int[] arr) {
		int longest_end = 0, longest_start = -1;
		for (int i = 0; i < arr.length; i++) {
			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			for (int j = i; j < arr.length; j++) {
				int val = arr[j];
				min = (min > val) ? val : min;
				max = (max < val) ? val : max;
				if (2 * min <= max)
					break;
				if (j - i > longest_end - longest_start || longest_start == -1) {
					longest_start = i;
					longest_end = j;
				}
			}
		}

		if (longest_start == -1)
			return arr.length;
		return (arr.length - (longest_end - longest_start + 1));
	}

}
