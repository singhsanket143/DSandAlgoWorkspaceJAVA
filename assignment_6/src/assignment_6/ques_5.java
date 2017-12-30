package assignment_6;

public class ques_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void sumtrianglerecurrsive(int n) {
		// row=0;
		// col=0;
		if (row>n) {
			return;
		}
		else if (row == col) {
			System.out.println();
			col = 1;
			sumtrianglerecurrsive(n-);

		}

		else if (col < row) {
			System.out.print("*");
			sumtrianglerecurrsive(n);
		}

	}

}
