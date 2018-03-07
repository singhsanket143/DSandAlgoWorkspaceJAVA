package matrix;

public class rowwothmaximumOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int mat[][] = { { 0, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };
		System.out.println(maxOnes(mat));

	}

	public static int maxOnes(int[][] arr) {
		int i = 0, j = 0;
		int result = 0;
		for (int m = 0; m < arr[0].length; m++) {
			if (arr[0][m] == 1) {
				j = m;
				result = 0;
				break;

			}
		}

		for (int m = 1; m < arr.length; m++) {
			while (j >= 0 && arr[m][j] == 1) {
				j--;
				result = m;
			}
		}
		return result;
	}

}
