package Backtracking;

import java.util.Queue;
import java.util.Scanner;

public class RatMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] sol = new int[n][n];
		int[][] maze = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				maze[i][j] = scn.nextInt();
			}
		}
//		System.out.println();
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol.length; j++) {
				sol[i][j] = 0;
			}
		}
		ratmaze(maze, 0, 0, maze.length, maze.length, sol);
//			display(sol);
		

	}

	public static boolean isitsafe(int[][] maze, int x, int y,int[][] sol) {
		return (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1 && sol[x][y]==0);
	}

	public static void display(int[][] sol) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol.length; j++) {
				System.out.print(sol[i][j] + " ");
			}
//			System.out.println();
		}
		System.out.println();
	}

	public static boolean ratmaze(int[][] maze, int cr, int cc, int er, int ec, int[][] sol) {
		
		
		if (cr == er-1 && cc == ec-1) {
			sol[cr][cc] = 1;
			display(sol);
			return true;
		}
		if (cr > er || cc > ec) {
			return false;
		}

		if (isitsafe(maze, cr, cc,sol)) {
			sol[cr][cc] = 1;
			ratmaze(maze, cr + 1, cc, er, ec, sol);
			ratmaze(maze, cr - 1, cc, er, ec, sol);
			ratmaze(maze, cr, cc + 1, er, ec, sol);
			
			ratmaze(maze, cr, cc - 1, er, ec, sol);
			sol[cr][cc] = 0;
			return false;
		}

		return false;
	}

}
