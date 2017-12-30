package Array;

public class MinimumElementInSortedRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 3, 4, 1 };
		System.out.println(minElement(arr));
	}

	public static int minElement(int[] arr) {
		int hi = arr.length - 1;
		int lo = 0;

		int mid = (hi + lo) / 2;
		while (mid != 0 && lo <= hi) {
			mid = (hi + lo) / 2;
			if (mid == 0 || mid == arr.length - 1 || arr[mid] < arr[mid - 1]) {
				return arr[mid];
			} else if (arr[mid] > arr[hi]) {
				lo = mid + 1;
			} else if (arr[mid] < arr[hi]) {
				hi = mid - 1;
			}
		}

		return arr[mid];
	}

}
