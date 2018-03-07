package matrix;

public class diagonalTraversalOfMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		diagonal(M);

	}

	public static void diagonal(int[][] arr) {
		int row = -1, col = 0, iterator = 0;
		int tempcol=0;
		while (iterator < arr.length * arr[0].length) {
			if (row < arr.length) {
				row++;
			}
			
			if(row==arr.length) {
				tempcol++;
			} else {
				tempcol=0;
			}
			int temprow = row;
			if(!(row==arr.length)) {
				while (temprow >= 0 && col < arr[0].length) {
					System.out.print(arr[temprow][col]+" ");
					iterator++;
					col++;
					temprow--;
				}
			} else {
				temprow--;
				col=tempcol;
				while(temprow >= 0 && col < arr[0].length) {
					System.out.print(arr[temprow][col]+" ");
					iterator++;
					col++;
					temprow--;
				}
			}
			
			System.out.println();
			col = 0;

		}
	}

}
