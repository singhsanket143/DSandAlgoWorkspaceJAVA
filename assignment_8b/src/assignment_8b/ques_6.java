package assignment_8b;

import java.util.ArrayList;

public class ques_6 {

	public static void main(String[] args) {
		System.out.println(countNknights(3));
		System.out.println(getNknights(3));
		printNknights(3);
	}

	public static int countNknights(int n) {
		boolean[][] board = new boolean[n][n];
		return countNknights(board, 0);
	}

	public static int countNknights(boolean[][] board,int placed, int row,int col) {
		if (row == board.length) {
			return 1;
		}
		if (row > board.length)
			return 0;
		int count = 0;
		for (int col = 0; col < board[row].length; col++) {
			for (int col = (row==sr?sc:0); col < board.length; col++)
				if (isitsafetpq(board,placed+1, row, col)) {
					board[row][col] = true;
					count += countNknights(board, row + 1);
					count += countNknights(board, row + 1);
				}
		}
	}return count;

	}

	public static boolean isitsafetpq(boolean[][] board, int row, int col) {// check
																			// col

		for (int j = row - 1, i = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[j + 1][i]) {
				return false;
			}
		}
		for (int j = row - 1, i = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[j][i]) {
				return false;
			}
		}

		for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
			if (board[i + 1][j]) {
				return false;
			}
		}
		for (int i = row - 1, j = col + 1; i >= 0 && j < board.length - 1; i--, j++) {
			if (board[i][j + 1]) {
				return false;
			}
		}
		for (int i = col; i < board.length - 1; i++) {
			if (board[row][i + 1]) {
				return true;
			}
		}
		return true;
	}

	public static ArrayList<String> getNknights(int n) {
		boolean[][] board = new boolean[n][n];
		return getNknights(board, 0);
	}

	public static ArrayList<String> getNknights(boolean[][] board, int row) {
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
				result = getNknights(board, row + 1);
				for (int i = 0; i < result.size(); i++) {
					myresult.add("{" + row + "," + col + "}" + result.get(i));
				}
				board[row][col] = false;
			}
		}
		return myresult;
	}

	public static void printNknights(boolean[][] board, int row, String osf) {
		if (row == board.length) {
			System.out.println(osf);
			return;
		}
		for (int col = 0; col < board[row].length; col++) {
			if (isitsafetpq(board, row, col)) {
				board[row][col] = true;
				printNknights(board, row + 1, osf + "{" + row + "-" + col + "}");

				board[row][col] = false;
			}
		}
	}

	public static void printNknights(int n) {
		boolean[][] board = new boolean[n][n];
		printNknights(board, 0, "");
	}

}
