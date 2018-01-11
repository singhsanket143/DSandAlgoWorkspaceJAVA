package ArrayWorkshop;

public class AloneElement2 {

	public static void main(String[] args) {

		int[] arr = {1,1,1,2,3,3,3};
		System.out.println(AloneElement2(arr));
	}

	public static int AloneElement2(int[] arr) {

		int resultnumber = 0, pow = 0;
		int[] result = new int[32];
		for (int i = 0; i < arr.length; i++) {
			int n = arr[i];
			int j = 0;
			while (n > 0) {
				if ((n & 1) == 1) {
					result[32 - j - 1]++;
				}
				j++;
				n = n >> 1;
			}
		}
		for (int i = 0; i < result.length; i++) {
			result[i] = result[i] % 3;
		}
		for (int i = result.length - 1; i >= 0; i--) {
			int num = 1 << pow;
			resultnumber += num * result[i];
			pow++;
		}
		return resultnumber;

	}
}
