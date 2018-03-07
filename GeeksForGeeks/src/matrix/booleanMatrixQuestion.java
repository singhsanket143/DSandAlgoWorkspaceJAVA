package matrix;

public class booleanMatrixQuestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[][] = { { 1, 0, 0, 1 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };
		booleanMatrix(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void booleanMatrix(int[][] arr) {
		boolean row_flag = false;
		boolean col_flag = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (i == 0 && arr[i][j] == 1) {
					row_flag = true;
				}
				if (j == 0 && arr[i][j] == 1) {
					col_flag = true;
				}
				if (arr[i][j] == 1) {
					arr[0][j] = 1;
					arr[i][0] = 1;
				}
			}
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[0].length; j++) {
				if (arr[0][j] == 1 || arr[i][0] == 1) {
					arr[i][j] = 1;
				}
			}
		}

		if (row_flag) {
			for (int i = 0; i < arr[0].length; i++) {
				arr[0][i] = 1;
			}
		}
		if (col_flag) {
			for (int i = 0; i < arr.length; i++) {
				arr[i][0] = 1;
			}
		}
	}

}
