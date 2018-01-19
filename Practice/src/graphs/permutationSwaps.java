package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class permutationSwaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n=scn.nextInt();
			int m=scn.nextInt();
			List<Integer>[] edges =new List[n];
			for(int i=0;i<edges.length;i++) {
				edges[i]=new ArrayList();
			}
			int[] p = new int[n];
			int[] q = new int[n];
			for (int i = 0; i < n; i++) {
				p[i] = scn.nextInt();
			}
			for (int i = 0; i < n; i++) {
				q[i] = scn.nextInt();
			}
			for(int i=0;i<m;i++) {
				int j=scn.nextInt();
				int k=scn.nextInt();
				edges[j-1].add(k-1);
				edges[k-1].add(j-1);
			}
			
			ArrayList<ArrayList<Integer>> result = connectedComponents(edges, n);
			boolean r = false;
			for (int i = 0; i < result.size(); i++) {
				ArrayList<Integer> c = result.get(i);
				boolean bool = false;
				HashMap<Integer,Integer> a1 = new HashMap();
				for (int j = 0; j < c.size(); j++) {
					a1.put(p[c.get(j)],1);
				}
				for(int j=0;j<c.size();j++) {
					if(!a1.containsKey(q[c.get(j)])) {
						System.out.println("NO");
						r=true;break;
					}
				}
				if(r) {
					break;
				}
			}
			if (!r) {
				System.out.println("YES");
			} 
		}

	}

	public static ArrayList<ArrayList<Integer>> connectedComponents(List<Integer>[] edges, int n) {
		boolean[] visited = new boolean[n];
		ArrayList<ArrayList<Integer>> output = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				ArrayList<Integer> component = new ArrayList();
				dfs(edges, i, component, visited);
				output.add(component);
			}
		}
		return output;
	}

	public static void dfs(List<Integer>[] edges, int start, ArrayList<Integer> component, boolean[] visited) {
		visited[start] = true;
		component.add(start);
		for (int i = 0; i < edges[start].size(); i++) {
			int next = edges[start].get(i);
			if (!visited[next]) {
				dfs(edges, next, component, visited);
			}
		}
	}
}
