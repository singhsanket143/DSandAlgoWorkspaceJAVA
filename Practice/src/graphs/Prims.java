package graphs;

import java.util.Scanner;

public class Prims {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int e = scn.nextInt();
		int[][] edges = new int[n][n];
		for (int i = 0; i < e; i++) {
			int f = scn.nextInt();
			int s = scn.nextInt();
			int wt = scn.nextInt();
			edges[f][s] = wt;
			edges[s][f] = wt;
		}
		prims(edges, n);

	}

	public static void prims(int[][] edges, int n) {
		int[] parent = new int[n];
		int[] weights = new int[n];
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			visited[i] = false;
			weights[i] = Integer.MAX_VALUE;
		}
		parent[0] = -1;
		weights[0] = 0;
		for (int i = 0; i < n; i++) {
			int minVertex = findMinVertex(weights, visited, n);
			visited[minVertex] = true;
			for (int j = 0; j < n; j++) {
				if (edges[minVertex][j] != 0 && !visited[j]) {
					if (edges[minVertex][j] < weights[j]) {
						weights[j] = edges[minVertex][j];
						parent[j] = minVertex;
					}
				}
			}
		}
		for (int i = 1; i < n; i++) {
			if (parent[i] < i) {
				System.out.println(parent[i] + " " + i + " " + weights[i]);
			} else {
				System.out.println(i + " " + parent[i] + " " + weights[i]);
			}
		}
	}

	public static int findMinVertex(int[] weights, boolean[] visited, int n) {
		int minVertex = -1;
		for (int i = 0; i < n; i++) {
			if (!visited[i] && (minVertex == -1 || weights[i] < weights[minVertex])) {
				minVertex = i;
			}
		}
		return minVertex;
	}

}
