package Backtracking;

import java.util.Scanner;

public class KnightTour {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] sol = new int[n][n];
		System.out.println();
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol.length; j++) {
				sol[i][j] = -1;
			}
		}
		sol[0][0] = 0;
		if (knighttour(0, 0, sol, 1)) {
			display(sol);
		} else {
			System.out.println("no");
		}
	}

	public static boolean isitsafe(int x, int y, int[][] sol) {
		return (x >= 0 && x < sol.length && y >= 0 && y < sol.length && sol[x][y] == -1);
	}

	public static void display(int[][] sol) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol.length; j++) {
				System.out.print(sol[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static boolean knighttour(int cr, int cc, int[][] sol, int csf) {
		if (csf == sol.length * sol.length) {
			return true;
		}
		if (isitsafe(cr + 2, cc + 1, sol)) {
			sol[cr + 2][cc + 1] = csf;
			if (knighttour(cr + 2, cc + 1, sol, csf + 1))
				return true;
			else
				sol[cr + 2][cc + 1] = -1;

		}
		if (isitsafe(cr + 1, cc + 2, sol)) {
			sol[cr + 1][cc + 2] = csf;
			if (knighttour(cr + 1, cc + 2, sol, csf + 1))
				return true;
			else
				sol[cr + 1][cc + 2] = -1;

		}
		if (isitsafe(cr + 1, cc - 2, sol)) {
			sol[cr + 1][cc - 2] = csf;
			if (knighttour(cr + 1, cc - 2, sol, csf + 1))
				return true;
			else
				sol[cr + 1][cc - 2] = -1;

		}
		
		if (isitsafe(cr + 2, cc - 1, sol)) {
			sol[cr + 2][cc - 1] = csf;
			if (knighttour(cr + 2, cc - 1, sol, csf + 1))
				return true;
			else
				sol[cr + 2][cc - 1] = -1;

		}
		if (isitsafe(cr - 1, cc + 2, sol)) {
			sol[cr - 1][cc + 2] = csf;
			if (knighttour(cr - 1, cc + 2, sol, csf + 1))
				return true;
			else
				sol[cr - 1][cc + 2] = -1;

		}
		if (isitsafe(cr - 1, cc - 2, sol)) {
			sol[cr - 1][cc - 2] = csf;
			if (knighttour(cr - 1, cc - 2, sol, csf + 1))
				return true;
			else
				sol[cr - 1][cc - 2] = -1;

		}
		if (isitsafe(cr - 2, cc + 1, sol)) {
			sol[cr - 2][cc + 1] = csf;
			if (knighttour(cr - 2, cc + 1, sol, csf + 1))
				return true;
			else
				sol[cr - 2][cc + 1] = -1;

		}
		if (isitsafe(cr - 2, cc - 1, sol)) {
			sol[cr - 2][cc - 1] = csf;
			if (knighttour(cr - 2, cc - 1, sol, csf + 1))
				return true;
			else
				sol[cr - 2][cc - 1] = -1;

		}
		return false;
	}

}
