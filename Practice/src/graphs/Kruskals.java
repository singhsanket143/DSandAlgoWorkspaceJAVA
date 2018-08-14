package graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Kruskals {

	public static class Edge {
		int source;
		int destination;
		int weight;

		Edge(int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
	}

	public static class finishComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge arg0, Edge arg1) {
			return arg0.weight - arg1.weight;
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		finishComparator f = new finishComparator();
		int n = scn.nextInt();
		int E = scn.nextInt();
		Edge[] input = new Edge[E];
		for (int i = 0; i < E; i++) {
			int s = scn.nextInt();
			int d = scn.nextInt();
			int w = scn.nextInt();
			input[i] = new Edge(s, d, w);
		}
		Arrays.sort(input, f);
		kruskals(input, n, E);

	}

	public static void kruskals(Edge[] input, int n, int E) {
		Edge[] output = new Edge[n - 1];
		int[] parent = new int[n];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		int count = 0;
		int i = 0;
		while (count != n - 1) {
			Edge currentEdge = input[i];
			int sourceParent = findParent(currentEdge.source, parent);
			int destinationParent = findParent(currentEdge.destination, parent);
			if (sourceParent != destinationParent) {
				output[count] = currentEdge;
				count++;
				parent[sourceParent] = destinationParent;
			}
			i++;
		}
		for (int j = 0; j < n - 1; j++) {
			if (output[j].source < output[j].destination)
				System.out.println(output[j].source + " " + output[j].destination + " " + output[j].weight);
			else
				System.out.println(output[j].destination + " " + output[j].source + " " + output[j].weight);
		}
	}

	public static int findParent(int v, int[] parent) {
		if (parent[v] == v) {
			return v;
		}
		return findParent(parent[v], parent);
	}

}
