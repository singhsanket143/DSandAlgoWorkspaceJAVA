package Lecture14;

import java.util.ArrayList;

public class recurrsioncontinued {

	public static void main(String[] args) {
//		 maxsumsubarray(new int[] { -18, 1, 3, 5, -5, 6 });
//		ArrayList<String> a = getNqueens(10);
//		System.out.println(a);
		System.out.println(countNquens(4));
		// int[] arr = { 3, 5, 0, 2, 1, 4 };
		// inverseArray(arr, 0);
		// for (int i = 0; i < arr.length; i++) {
		// System.out.println(arr[i]);
		// }
	}

	public static void inverseArray(int[] arr, int si) {
		if (si == arr.length) {
			return;
		}
		int count = arr[si];
		inverseArray(arr, si + 1);
		arr[count] = si;
		return;
	}

	public static void maxsumsubarray(int[] arr) {
		int maxsum = Integer.MIN_VALUE;
		int maxsi = 0, maxli = 0;
		for (int si = 0; si < arr.length; si++) {
			int sum = 0;
			for (int li = si; li < arr.length; li++) {
				sum += arr[li];

				if (sum > maxsum) {
					maxsum = sum;
					maxsi = si;
					maxli = li;
				}
			}
		}
		System.out.println(maxsi + " " + maxli);

	}

	public static int countNquens(int n) {
		boolean[][] board = new boolean[n][n];
		return countNqueens(board, 0);
	}

	public static int countNqueens(boolean[][] board, int row) {
		if (row == board.length) {
			return 1;
		}
		int count = 0;
		for (int col = 0; col < board[row].length; col++) {
			if (isitsafetpq(board, row, col)) {
				board[row][col] = true;
				count += countNqueens(board, row + 1);
				board[row][col] = false;
			}
		}
		return count;
	}

	public static boolean isitsafetpq(boolean[][] board, int row, int col) {// check
																			// col
		for (int i = row - 1; i >= 0; i--) {
			if (board[i][col]) {
				return false;
			}
		}
		// check diagnol
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j]) {
				return false;
			}
		}

		for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
			if (board[i][j]) {
				return false;
			}
		}

		return true;
	}

	public static ArrayList<String> getNqueens(boolean[][] board, int row) {
		if (row == board.length) {
			ArrayList<String> baseresult = new ArrayList<>();
			baseresult.add("\n");
			return baseresult;
		}
		ArrayList<String> myresult = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();
		for (int col = 0; col < board[row].length; col++) {
			if (isitsafetpq(board, row, col)) {
				board[row][col] = true;
				result = getNqueens(board, row + 1);
				for (int i = 0; i < result.size(); i++) {
					myresult.add(row + "," + col + "." + result.get(i));
				}
//				if (row == board.length - 1) {
//					for (int i = 0; i < board.length; i++) {
//						for (int j = 0; j < board.length; j++) {
//							if (board[i][j] == false)
//								System.out.print(0 + " ");
//							else
//								System.out.print(1 + " ");
//						}
//						
//					}
//					System.out.println();
//				}
				board[row][col] = false;
			}
		}
		return myresult;
	}

	public static ArrayList<String> getNqueens(int n) {
		boolean[][] board = new boolean[n][n];
		return getNqueens(board, 0);
	}

	public static void printNqueens(boolean[][] board, int row, String osf) {
		if (row == board.length) {
			System.out.println(osf);
			return;
		}
		for (int col = 0; col < board[row].length; col++) {
			if (isitsafetpq(board, row, col)) {
				board[row][col] = true;
				printNqueens(board, row + 1, osf + "{" + row + "-" + col + "}");
				board[row][col] = false;
			}
		}
	}

	public static void printNqueens(int n) {
		boolean[][] board = new boolean[n][n];
		printNqueens(board, 0, "");
	}

}
