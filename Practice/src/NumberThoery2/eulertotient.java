package NumberThoery2;

public class eulertotient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = eulerTotitent(10);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	public static int[] eulerTotitent(int n) {
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}

		for (int i = 2; i <= n; i++) {
			if (arr[i] == i) {
				arr[i] = i - 1;
				for (int j = 2 * i; j <= n; j += i) {
					arr[j] = (arr[j] * (i - 1)) / i;
				}
			}
		}
		return arr;
	}

}
