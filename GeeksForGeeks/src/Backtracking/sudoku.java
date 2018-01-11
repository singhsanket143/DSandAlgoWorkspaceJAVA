package Backtracking;

public class sudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] grid = {{2,0,0,0,0,0,0,6,7},
                {4,5,0,0,0,0,0,0,1},
                {0,9,0,7,0,0,0,0,0},
                {0,0,0,3,0,0,0,0,0},
                {0,0,4,0,0,0,2,8,0},
                {0,1,0,0,2,4,0,0,0},
                {0,8,3,9,0,7,0,0,0},
                {6,2,0,0,5,0,4,1,0},
                {0,0,0,0,0,0,0,9,0}};

		if (sudokuplay(grid))
			if(checkifsudokuiscorrect(grid))
				display(grid);
			else
				System.out.println("no");
		else {
			System.out.println("no");
			// display(grid);
		}

	}
	
	public static boolean checkifsudokuiscorrect(int[][] arr){
		for(int i=0;i<arr.length;i++){
			int sumr=0;
			for(int j=0;j<arr.length;j++){
				sumr+=arr[i][j];
			}
			if(sumr!=45){
				return false;
			}
		}
		
		for(int i=0;i<arr.length;i++){
			int sumc=0;
			for(int j=0;j<arr.length;j++){
				sumc+=arr[j][i];
			}
			if(sumc!=45){
				return false;
			}
		}
		return true;
		
	}

	public static void display(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				System.out.print(grid[i][j] + "\t");
			}
			System.out.println();
			System.out.println();
		}
	}

	public static boolean saferow(int[][] grid, int row, int num) {
		for (int i = 0; i < grid.length; i++) {
			if (grid[row][i] == num)
				return true;
		}
		return false;
	}

	public static boolean safecol(int[][] grid, int col, int num) {
		for (int i = 0; i < grid.length; i++) {
			if (grid[i][col] == num)
				return true;
		}
		return false;
	}

	public static boolean safebox(int[][] grid, int row, int col, int num) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[i + row][j + col] == num)
					return true;
			}

		}
		return false;
	}

	public static boolean isitsafe(int[][] grid, int row, int col, int num) {
		boolean b1 = saferow(grid, row, num);
		boolean b2 = safecol(grid, col, num);
		boolean b3 = safebox(grid, row - row % 3, col - col % 3, num);
		return (!b1 && !b2 && !b3);
	}

	public static boolean findempty(int[][] grid, int[] check) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] == 0) {
					check[0] = i;
					check[1] = j;
					return true;
				}
			}
		}
		return false;
	}

	public static boolean sudokuplay(int[][] grid) {
		int cr = -1, cc = -1;
		int[] arr = new int[2];
		arr[0] = cr;
		arr[1] = cc;
		if (findempty(grid, arr) == false) {
			return true;
		}

		for (int i = 1; i <= 9; i++) {

			if (isitsafe(grid, arr[0], arr[1], i)) {
				grid[arr[0]][arr[1]] = i;
				if (sudokuplay(grid))
					return true;

				grid[arr[0]][arr[1]] = 0;
			}

		}
		return false;

	}

}
