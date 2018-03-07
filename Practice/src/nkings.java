
public class nkings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countNkings(14));

	}

	public static int countNkings(int n) {
		boolean[][] board = new boolean[n][n];
		return countNkings(board, 0);
	}

	public static int countNkings(boolean[][] board, int row) {
		if (row == board.length) {
			return 1;
		}
		int count = 0;
		for (int col = 0; col < board[row].length; col++) {
			if (isitsafetpq(board, row, col)) {
				board[row][col] = true;
				count += countNkings(board, row + 1);
				board[row][col] = false;
			}
		}
		return count;
	}

	public static boolean isitsafetpq(boolean[][] board, int row, int col) {// check
																			// col
		if (col - 1 >= 0 && row - 1 >= 0) {
			if (board[row - 1][col - 1]) {
				return false;
			}
		}
		if (col + 1 < board.length && row - 1 >= 0) {
			if (board[row - 1][col + 1]) {
				return false;
			}
		}
		for (int i = row - 1; i >= 0; i--) {
			if (board[i][col]) {
				return false;
			}
		}
		return true;
	}

}
