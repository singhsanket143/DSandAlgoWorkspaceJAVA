package INTERMEDIATE;

public class waysToReachDestinationInMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maze[][] = { { 0, 0, 0, 0 }, { 0, -1, 0, 0 }, { -1, 0, 0, 0 }, { 0, 0, 0, 0 } };
		System.out.println(countWays(maze));

	}

	public static int countWays(int[][] path) {
		for (int i = 0; i < path.length; i++) {
			if (path[i][0] == 0) {
				path[i][0] = 1;
			} else {
				break;
			}
		}
		for (int i = 1; i < path[0].length; i++) {
			if (path[0][i] == 0) {
				path[0][i] = 1;
			} else {
				break;
			}
		}
		for (int i = 1; i < path.length; i++) {
			for (int j = 1; j < path[0].length; j++) {
				if (path[i][j] == -1)
					continue;
				if (path[i - 1][j] > 0)
					path[i][j] += path[i - 1][j];
				if (path[i][j - 1] > 0)
					path[i][j] += path[i][j - 1];
			}
		}

		return (path[path.length - 1][path[0].length - 1] < 0) ? 0 : path[path.length - 1][path[0].length - 1];
	}

}
