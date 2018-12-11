import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		 int n = scn.nextInt();
	        int m = scn.nextInt();
	        int[][] board = new int[n][m];
	        for (int i = 0; i < n; i++) {
	            String str = scn.next();
	            assert str.length() == m;
	            for (int j = 0; j < m; j++)
	                board[i][j] = str.charAt(j) - '0';
	        }
	        int[][] arr = new int[n][m];
	        arr[0][0] = board[0][0];
	        for (int i = 1; i < n; i++)
	            arr[i][0] = arr[i - 1][0] + (i % 2 == board[i][0] ? 0 : 1);
	        for (int i = 1; i < m; i++)
	            arr[0][i] = arr[0][i - 1] + (i % 2 == board[0][i] ? 0 : 1);
	        for (int i = 1; i < n; i++)
	            for (int j = 1; j < m; j++)
	                arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + ((i + j) % 2 == board[i][j] ? 0 : 1);
	        int maxLength = Math.min(n, m);
	        int[] minMoves = new int[maxLength + 1];
	        for (int i = 0; i < maxLength; i++)
	            minMoves[i + 1] = Math.min(arr[i][i], (i + 1) * (i + 1) - arr[i][i]);
	        for (int i = 1; i < n; i++)
	            for (int j = 0; j < maxLength; j++)
	                if (i + j < n) {
	                    int temp = arr[i + j][j] - arr[i - 1][j];
	                    minMoves[j + 1] = Math.min(minMoves[j + 1], Math.min(temp, (j + 1) * (j + 1) - temp));
	                } else break;
	        for (int i = 1; i < m; i++)
	            for (int j = 0; j < maxLength; j++)
	                if (i + j < m) {
	                    int temp = arr[j][i + j] - arr[j][i - 1];
	                    minMoves[j + 1] = Math.min(minMoves[j + 1], Math.min(temp, (j + 1) * (j + 1) - temp));
	                } else break;
	        for (int i = 1; i < n; i++)
	            for (int j = 1; j < m; j++)
	                for (int k = 0; k < maxLength; k++)
	                    if (i + k < n && j + k < m) {
	                        int temp = arr[i + k][j + k] - arr[i - 1][j + k] - arr[i + k][j - 1] + arr[i - 1][j - 1];
	                        minMoves[k + 1] = Math.min(minMoves[k + 1], Math.min(temp, (k + 1) * (k + 1) - temp));
	                    } else break;
	        int q = scn.nextInt();
	        while (q-- > 0) {
	            int c = scn.nextInt();
	            for (int i = minMoves.length - 1; i >= 0; i--)
	                if (minMoves[i] <= c) {
	                    System.out.println(i);
	                    break;
	                }
	        }
	}
	
	

}
