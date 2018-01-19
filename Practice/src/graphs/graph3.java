package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class graph3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		List<Integer>[] edges =new List[n];
		for(int i=0;i<edges.length;i++) {
			edges[i]=new ArrayList();
		}
		int m=scn.nextInt();
		for(int i=0;i<m;i++) {
			int j=scn.nextInt();
			int k=scn.nextInt();
			edges[j-1].add(k-1);
			edges[k-1].add(j-1);
		}
		System.out.println(connectedComponents(edges, n));
	}
	
	public static ArrayList<ArrayList<Integer>> connectedComponents(List<Integer>[] edges, int n) {
		boolean[] visited=new boolean[n];
		ArrayList<ArrayList<Integer>> output=new ArrayList<>();
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				ArrayList<Integer> component=new ArrayList();
				dfs(edges,i,component,visited);
				output.add(component);
			}
		}
		return output;
	}
	
	public static void dfs(List<Integer>[] edges, int start, ArrayList<Integer> component,boolean[] visited) {
		visited[start]=true;
		component.add(start);
		for(int i=0;i<edges[start].size();i++) {
			int next = edges[start].get(i);
			if(!visited[next]) {
				dfs(	edges, next, component, visited);
			}
		}
	}

}
