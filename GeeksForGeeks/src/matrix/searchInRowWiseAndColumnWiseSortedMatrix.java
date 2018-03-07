package matrix;

public class searchInRowWiseAndColumnWiseSortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		search(mat, 29);
	}

	public static int search(int[][] arr, int key) {
		int i = 0, j = arr.length - 1;
		while (i < arr[0].length && j > 0) {
			if (arr[i][j] == key) {
				System.out.println(i + "," + j);
				return 1;
			}
			if (arr[i][j] > key) {
				j--;
			} else {
				i++;
			}
		}
		System.out.println("not found");
		return -1;
	}

}
