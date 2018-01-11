package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;


public class graph {
//	public static ArrayList<Integer> result=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int e = scn.nextInt();
		int[][] edges = new int[n][n];
		for (int i = 0; i < e; i++) {
			int f = scn.nextInt();
			int s = scn.nextInt();
			edges[f][s] = 1;
			edges[s][f] = 1;
		}
//		boolean[] visited=new boolean[n];
//		HashMap<Integer, Integer> via = new HashMap<>();
//		ArrayList<Integer> result=new ArrayList<>();
//		int v1=scn.nextInt();
//		int v2=scn.nextInt();
//		getbfs(edges, n, v1,v2,via);
//		int ci=v2;
////		System.out.print(ci+" ");
//		result.add(ci);
//		while(ci!=v1){
//			int temp=0;
//			if(via.get(ci)==null)
//				return;
//			else
//				temp=via.get(ci);
////			System.out.print(temp+" ");
//			result.add(temp);
//			ci=temp;
//		}
//		for(int i=0;i<result.size();i++){
//			System.out.print(result.get(i)+" ");
//		}
		ArrayList<ArrayList<Integer>> result=connectedComponents(edges,n);
		for(int i=0;i<result.size();i++){
			ArrayList<Integer> c = result.get(i);
			c.sort(null);
			for(int j=0;j<c.size();j++){
				System.out.print(c.get(j)+" ");
			}
			System.out.println();
		}
	}

	public static void bfs(int[][] edges, int n, int start) {
		LinkedList<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[n];
		queue.addLast(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			int currentVertex = queue.removeFirst();
			System.out.print(currentVertex + " ");
			for (int i = 0; i < n; i++) {
				if (i == currentVertex)
					continue;
				if (edges[currentVertex][i] == 1 && !visited[i]) {
					queue.addLast(i);
					visited[i] = true;
				}
			}
		}
	}

	public static void dfs(int[][] edges, int n, int start,boolean[] visited) {
		System.out.print(start + " ");
		visited[start]=true;
		for (int i = 0; i < n; i++) {
			if(i==start)
				continue;
			if (edges[start][i] == 1) {
				if(visited[i])
					continue;
				dfs(edges, n, i,visited);
			}
		}
	}
	public static ArrayList<Integer> getdfs(int[][] edges, int n, int start,int end,boolean[] visited) {
//		System.out.print(start + " ");
		if(start==end){
			ArrayList<Integer> arr=new ArrayList<>();
			arr.add(end);
			return arr;
		}
		ArrayList<Integer> r=null;
//		System.out.print(start + " ");
		visited[start]=true;
		for (int i = 0; i < n; i++) {
			if(i==start)
				continue;
			if (edges[start][i] == 1) {
				if(visited[i])
					continue;
				r=getdfs(edges, n, i,end,visited);
				if(r!=null){
					r.add(start);
					return r;
				}
			}
		}
		
		return r;
	}
	public static void getbfs(int[][] edges, int n, int start, int end,HashMap<Integer, Integer> via ) {
		LinkedList<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[n];
		
		
		queue.addLast(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			int currentVertex = queue.removeFirst();
//			System.out.print(currentVertex + " ");
			for (int i = 0; i < n; i++) {
				if (i == currentVertex)
					continue;
				if (edges[currentVertex][i] == 1 && !visited[i]) {
					queue.addLast(i);
					via.put(i, currentVertex);
					visited[i] = true;
				}
			}
		}
	}
	
	public static ArrayList<ArrayList<Integer>> connectedComponents(int[][] edges, int n){
		LinkedList<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[n];
		ArrayList<ArrayList<Integer>> result=new ArrayList<>();
		
		for(int j=0;j<visited.length;j++){
			if(visited[j])
				continue;
			queue.addLast(j);
			visited[j] = true;
			ArrayList<Integer> a=new ArrayList<>();
			while (!queue.isEmpty()) {
				int currentVertex = queue.removeFirst();
				a.add(currentVertex);
				for (int i = 0; i < n; i++) {
					if (i == currentVertex)
						continue;
					if (edges[currentVertex][i] == 1 && !visited[i]) {
						queue.addLast(i);
						visited[i] = true;
					}
				}
			}
			result.add(a);
		}
		return result;
		
	}

}
