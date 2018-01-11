package ArrayWorkshop;

public class squareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(squareRoot(24));

	}

	public static int squareRoot(int n) {
		int[] arr = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			arr[i] = i;
		}
		int lo = 0, hi = arr.length - 1, result = 0;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			int helper = arr[mid];
			if (helper * helper > n) {
				hi = mid - 1;
			} else if (helper * helper <= n) {
				result = helper;
				lo = mid+1;
			}

		}
		return result;

	}

}
