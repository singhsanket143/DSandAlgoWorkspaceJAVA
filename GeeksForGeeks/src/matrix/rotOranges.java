package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class rotOranges {

	public static class element {
		int x;
		int y;

		element(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static boolean isValid(int i, int j, int[][] arr) {
		if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isDelim(element temp) {
		return (temp.x == -1 && temp.y == -1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };
		int ans = rotOrange(arr);
		if (ans == -1)
			System.out.println("All oranges cannot rot");
		else
			System.out.println("Time required for all oranges to rot = " + ans);

	}

	public static boolean checkAll(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1) {
					return true;
				}
			}
		}
		return false;
	}

	public static int rotOrange(int[][] arr) {
		Queue<element> q = new LinkedList<>();
		element temp;
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 2) {
					q.add(new element(i, j));
				}
			}
		}
		q.add(new element(-1, -1));
		while (!q.isEmpty()) {
			boolean flag = false;
			while (!isDelim(q.peek())) {
				temp = q.peek();
				if (isValid(temp.x + 1, temp.y, arr) && arr[temp.x + 1][temp.y] == 1) {
					if (!flag) {
						flag = true;
						ans++;
					}
					arr[temp.x + 1][temp.y] = 2;
					temp.x++;
					q.add(new element(temp.x, temp.y));
					temp.x--;
				}
				if (isValid(temp.x - 1, temp.y, arr) && arr[temp.x - 1][temp.y] == 1) {
					if (!flag) {
						flag = true;
						ans++;
					}
					arr[temp.x - 1][temp.y] = 2;
					temp.x--;
					q.add(new element(temp.x, temp.y));
					temp.x++;
				}
				if (isValid(temp.x, temp.y + 1, arr) && arr[temp.x][temp.y + 1] == 1) {
					if (!flag) {
						flag = true;
						ans++;
					}
					arr[temp.x][temp.y++] = 2;
					temp.y++;
					q.add(new element(temp.x, temp.y));
					temp.y--;
				}
				if (isValid(temp.x, temp.y - 1, arr) && arr[temp.x][temp.y - 1] == 1) {
					if (!flag) {
						flag = true;
						ans++;
					}
					arr[temp.x][temp.y - 1] = 2;
					temp.y--;
					q.add(new element(temp.x, temp.y));
					temp.y++;
				}
				q.remove();
			}
			if (!q.isEmpty()) {
				q.add(new element(-1, -1));
			}
		}
		return (checkAll(arr)) ? -1 : ans;
	}

}
