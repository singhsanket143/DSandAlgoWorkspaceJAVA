package Implementation;

public class Matrix_layer_rotation {

	public static void main(String[] args) {

		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int t1 = arr[0][0], t2 = arr[0][0];
		int mincol = 0, minrow = 0, maxcol = arr[0].length - 1, maxrow = arr.length - 1;
		for (int i = 0; i < maxcol; i++) {
			t1 = arr[minrow][i + 1];
			arr[minrow][i + 1] = t2;
			t2 = t1;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
