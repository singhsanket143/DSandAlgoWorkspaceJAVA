package Array;

public class rearrangePositiveandNegativeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
		rearrange(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void rearrange(int[] arr) {
		int i = -1;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] < 0) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int neg = 0, pos = i + 1;
		while (pos < arr.length && neg < arr.length && arr[neg] < 0) {
			int temp = arr[neg];
			arr[neg] = arr[pos];
			arr[pos] = temp;
			pos++;
			neg += 2;
		}
	}

}
