package assignment_6;

public class ques_2 {

	public static void main(String[] args) {
		starrecurrsive(5, 1, 1);

	}

	public static void starrecurrsive(int n, int row, int col) {
		// row=0;
		// col=0;
		if (row>n) {
			return;
		}
		else if (row == col) {
			System.out.print("*");
			System.out.println();
			col = 1;
			starrecurrsive(n, row + 1, col);

		}

		else if (col < row) {
			System.out.print("*");
			starrecurrsive(n, row, col + 1);
		}

	}

}
