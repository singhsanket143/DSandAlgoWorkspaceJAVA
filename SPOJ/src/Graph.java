
import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import java.util.Set;

public class Graph {

	private class Edge {
		Vertex one;
		Vertex two;
		int weight;

		Edge(Vertex one, Vertex two, int weight) {
			this.one = one;
			this.two = two;
			this.weight = weight;
		}
	}

	private class Vertex {
		String name;
		HashMap<Vertex, Edge> neightbours;

		Vertex(String name) {
			this.name = name;
			this.neightbours = new HashMap<>();
		}

		@Override
		public boolean equals(Object other) {
			Vertex ov = (Vertex) other;
			return this.name.equals(ov.name);
		}

		@Override
		public int hashCode() {
			return this.name.hashCode();
		}
	}

	private HashMap<String, Vertex> vertices;

	public Graph() {
		this.vertices = new HashMap<>();
	}

	public int numVertices() {
		return this.vertices.size();
	}

	private Vertex getVertex(String v) {
		return this.vertices.get(v);
	}

	public boolean containsvertex(String v) {
		Vertex vtx = this.getVertex(v);
		if (vtx != null)
			return true;
		else
			return false;
	}

	public void addVertex(String v) {
		if (this.containsvertex(v)) {
			return;
		}
		Vertex vtx = new Vertex(v);
		this.vertices.put(v, vtx);
	}

	public void removeVertex(String v) {
		if (!this.containsvertex(v)) {
			return;
		}
		Vertex vtx = this.getVertex(v);
		Set<Vertex> nbrvertices = vtx.neightbours.keySet();
		for (Vertex nbrvtx : nbrvertices) {
			nbrvtx.neightbours.remove(vtx);
		}
		this.vertices.remove(v);
	}

	public int numEdges() {
		int rv = 0;
		Collection<Vertex> allVertices = this.vertices.values();
		for (Vertex vtx : allVertices) {
			rv += vtx.neightbours.size();
		}
		return rv / 2;
	}

	public boolean containsEdge(String v1, String v2) {
		Vertex vtx1 = this.getVertex(v1), vtx2 = this.getVertex(v2);
		if (vtx1 == null || vtx2 == null) {
			return false;
		}

		return vtx1.neightbours.containsKey(vtx2);

	}

	public void addEdge(String v1, String v2, int weight) {
		Vertex vtx1 = this.getVertex(v1), vtx2 = this.getVertex(v2);
		if (vtx1 == null || vtx2 == null || this.containsEdge(v1, v2)) {
			return;
		}
		Edge commonedge = new Edge(vtx1, vtx2, weight);
		vtx1.neightbours.put(vtx2, commonedge);
		vtx2.neightbours.put(vtx1, commonedge);

	}

	public void removeEdge(String v1, String v2) {
		Vertex vtx1 = this.getVertex(v1), vtx2 = this.getVertex(v2);
		if (vtx1 == null || vtx2 == null || !this.containsEdge(v1, v2)) {
			return;
		}
		vtx1.neightbours.remove(vtx2);
		vtx2.neightbours.remove(vtx1);
	}

	public void display() {
		Set<Map.Entry<String, Vertex>> allEntries = this.vertices.entrySet();
		for (Map.Entry<String, Vertex> entry : allEntries) {
			Vertex vtx = entry.getValue();
			String toPrint = vtx.name + "=>";
			Set<Vertex> nbrs = vtx.neightbours.keySet();
			for (Vertex nbr : nbrs) {
				toPrint += nbr.name + ", ";
			}
			toPrint += "END";
			System.out.println(toPrint);
		}
	}

	HashMap<Vertex, Boolean> check = new HashMap<>();

	public boolean haspath1(String v1, String v2) {

		Vertex vtx1 = this.getVertex(v1), vtx2 = this.getVertex(v2);

		if (this.containsEdge(v1, v2))
			return true;
		else {
			check.put(vtx1, true);
			Set<Vertex> nbrs = vtx1.neightbours.keySet();
			for (Vertex nbr : nbrs) {
				if (!check.containsKey(nbr)) {
					check.put(nbr, true);
					if (haspath1(nbr.name, v2))
						return true;
				}

			}

		}
		return false;
	}

	public boolean HasPath(String v1, String v2) throws Exception {
		Vertex vtx1 = this.getVertex(v1);
		Vertex vtx2 = this.getVertex(v2);

		if (vtx1 == null || vtx2 == null)
			return false;
		else {
			// HashMap<Vertex, Boolean> visited = new HashMap<>();
			// visited = new HashMap<>();
			// visited.put(vtx1, true);
			return this.HasPathDFSI(vtx1, vtx2);
		}
	}

	private boolean HasPathDFS(Vertex v1, Vertex v2, HashMap<Vertex, Boolean> visited) {
		if (v1.neightbours.containsKey(v2)) {
			return true;
		}
		Set<Vertex> nbrs = v1.neightbours.keySet();
		for (Vertex nbr : nbrs) {
			if (!visited.containsKey(nbr)) {
				visited.put(nbr, true);
				if (this.HasPathDFS(nbr, v2, visited)) {
					return true;

				}
			}
		}
		return false;

	}

	private boolean HasPathBFS(Vertex v1, Vertex v2) throws Exception {
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> Queue = new LinkedList<>();
		visited.put(v1, v1);
		Queue.addLast(v1);

		while (!Queue.isEmpty()) {
			Vertex vtx = Queue.removeFirst();
			if (vtx.neightbours.containsKey(v2))
				return true;
			Set<Vertex> nbrs = vtx.neightbours.keySet();
			for (Vertex nbr : nbrs) {
				if (!visited.containsKey(nbr)) {
					visited.put(nbr, nbr);
					Queue.addLast(nbr);
				}
			}
		}
		return false;
	}

	private boolean HasPathDFSI(Vertex v1, Vertex v2) throws Exception {
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> Stack = new LinkedList<>();
		visited.put(v1, v1);
		Stack.addFirst(v1);

		while (!Stack.isEmpty()) {
			Vertex vtx = Stack.removeFirst();
			if (vtx.neightbours.containsKey(v2))
				return true;
			Set<Vertex> nbrs = vtx.neightbours.keySet();
			for (Vertex nbr : nbrs) {
				if (!visited.containsKey(nbr)) {
					visited.put(nbr, nbr);
					Stack.addFirst(nbr);
				}
			}
		}
		return false;
	}

	public void bft() throws Exception {
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> Queue = new LinkedList<>();
		Collection<Vertex> allVertices = this.vertices.values();
		for (Vertex vtx : allVertices) {
			if (!visited.containsKey(vtx)) {
				visited.put(vtx, vtx);
				Queue.addLast(vtx);
			}
			while (!Queue.isEmpty()) {
				Vertex vtx2 = Queue.removeFirst();
				System.out.println(vtx2.name);

			}
		}

	}

	public void dft() throws Exception {
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> Stack = new LinkedList<>();
		Collection<Vertex> allVertices = this.vertices.values();
		for (Vertex vtx : allVertices) {
			if (!visited.containsKey(vtx)) {
				visited.put(vtx, vtx);
				Stack.addFirst(vtx);
			}
			while (!Stack.isEmpty()) {
				Vertex vtx2 = Stack.removeFirst();
				System.out.println(vtx2.name);
				Set<Vertex> nbrs = vtx2.neightbours.keySet();
				for (Vertex nbr : nbrs) {
					if (!visited.containsKey(nbr)) {
						visited.put(nbr, nbr);

						Stack.addFirst(nbr);
					}
				}

			}
		}

	}

	public boolean isConnected() {
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();
		Vertex[] allvertices = new Vertex[this.vertices.size()];
		this.vertices.values().toArray(allvertices);
		visited.put(allvertices[0], allvertices[0]);
		queue.addLast(allvertices[0]);
		while (!queue.isEmpty()) {
			Vertex vtx = queue.removeFirst();

			Set<Vertex> nbrs = vtx.neightbours.keySet();
			for (Vertex nbr : nbrs) {
				if (!visited.containsKey(nbr)) {
					visited.put(nbr, nbr);
					queue.addLast(nbr);
				}
			}
		}
		return this.vertices.size() == visited.size();
	}

	public ArrayList<ArrayList<String>> getConnected() {
		ArrayList<ArrayList<String>> rv = new ArrayList<>();

		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> Stack = new LinkedList<>();
		Collection<Vertex> allVertices = this.vertices.values();
		for (Vertex vtx : allVertices) {
			if (!visited.containsKey(vtx)) {
				ArrayList<String> x = new ArrayList<>();

				visited.put(vtx, vtx);

				Stack.addFirst(vtx);

				while (!Stack.isEmpty()) {
					Vertex vtx2 = Stack.removeFirst();
					x.add(vtx2.name);
					Set<Vertex> nbrs = vtx2.neightbours.keySet();
					for (Vertex nbr : nbrs) {
						if (!visited.containsKey(nbr)) {
							visited.put(nbr, nbr);

							Stack.addFirst(nbr);
						}
					}
				}
				rv.add(x);

			}
		}

		return rv;
	}

	public boolean isBipartite() {
		HashMap<Vertex, String> visited = new HashMap<>();
		LinkedList<Vertex> Stack = new LinkedList<>();
		Collection<Vertex> allVertices = this.vertices.values();
		for (Vertex vtx : allVertices) {
			if (!visited.containsKey(vtx)) {
				visited.put(vtx, "RED");
				Stack.addFirst(vtx);
			}
			while (!Stack.isEmpty()) {
				Vertex vtx2 = Stack.removeFirst();
				Set<Vertex> nbrs = vtx2.neightbours.keySet();
				for (Vertex nbr : nbrs) {
					String covtx = visited.get(vtx2);
					String CtoApplyonNbr = covtx.equals("RED") ? "GREEN" : "RED";
					if (!visited.containsKey(nbr)) {
						visited.put(nbr, CtoApplyonNbr);

						Stack.addFirst(nbr);
					} else {
						String actualAcoNbr = visited.get(nbr);
						if (actualAcoNbr.equals(CtoApplyonNbr))
							continue;
						else
							return false;
					}
				}

			}
		}
		return true;
	}

	public boolean IsBipartite1() {

		Boolean b = true;
		HashMap<Vertex, Boolean> visited = new HashMap<>();
		LinkedList<Vertex> Stack = new LinkedList<>();
		Collection<Vertex> allVertices = this.vertices.values();
		for (Vertex vtx : allVertices) {
			if (!visited.containsKey(vtx)) {
				visited.put(vtx, b);
				Stack.addFirst(vtx);
				while (!Stack.isEmpty()) {
					vtx = Stack.removeFirst();

					b = visited.get(vtx);

					Set<Vertex> nbrs = vtx.neightbours.keySet();
					for (Vertex nbr : nbrs) {
						if (!visited.containsKey(nbr)) {
							visited.put(nbr, !b);
							Stack.addFirst(nbr);
						} else if (visited.get(nbr) != (!b))
							return false;
					}
				}
			}

		}
		return true;
	}

	public boolean IsAcyclic() throws Exception {
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> Stack = new LinkedList<>();
		Collection<Vertex> allVertices = this.vertices.values();
		for (Vertex vtx : allVertices) {
			if (!visited.containsKey(vtx)) {
				visited.put(vtx, null);
				Stack.addFirst(vtx);
			}
			while (!Stack.isEmpty()) {
				Vertex vtx2 = Stack.removeFirst();
				Set<Vertex> nbrs = vtx2.neightbours.keySet();
				for (Vertex nbr : nbrs) {
					if (!visited.containsKey(nbr)) {
						visited.put(nbr, vtx2);

						Stack.addFirst(nbr);
					} else {
						Vertex ReasonForVertex = visited.get(vtx2);
						if (ReasonForVertex == nbr) {
							continue;
						}
						return false;
					}
				}
			}
		}
		return true;
	}

	private class Pair implements Comparable<Pair> {
		int cost;
		Vertex vtx;
		Edge edge; // to be used prims

		Pair(int cost, Vertex vtx) {
			this.cost = cost;
			this.vtx = vtx;
		}

		// to be used by prims
		Pair(int cost, Vertex vtx, Edge edge) {
			this.cost = cost;
			this.vtx = vtx;
			this.edge = edge;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}

	
	public void printHasPathDFSI(String s1, String s2) throws Exception {
		System.out.println(HasPathDFSI(s1, s2));
	}

	public ArrayList<String> HasPathDFSI(String vtx1, String vtx2) throws Exception {
		Vertex v1 = this.getVertex(vtx1);
		Vertex v2 = this.getVertex(vtx2);
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> stack = new LinkedList<>();
		ArrayList<String> arr = new ArrayList<>();
		visited.put(v1, v2);
		stack.addFirst(v1);
//		arr.add(v1.name);
		while (!stack.isEmpty()) {
			Vertex vtx = stack.removeFirst();
			arr.add(vtx.name);
			// work area
			if (vtx.neightbours.containsKey(v2)) {
				arr.add(v2.name);
				return arr;
			}

			Set<Vertex> nbrs = vtx.neightbours.keySet();
			for (Vertex nbr : nbrs) {
				if (!visited.containsKey(nbr)) {
					visited.put(nbr, nbr);
					stack.addFirst(nbr);
//					arr.add(nbr.name);
				}
			}
		}

		return arr;
	}

	public static void main(String[] args) throws Exception {
		Graph g = new Graph();
		Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		int e = s.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < v; i++) {
			map.put(i, i);
			g.addVertex(Integer.toString(i));
		}
		for (int i = 0; i < e; i++) {
			int a = s.nextInt();
			int b = s.nextInt();

			g.addEdge(Integer.toString(a), Integer.toString(b), 0);
		}
		String s1 = s.next();
		String s2 = s.next();
		g.printHasPathDFSI(s1, s2);

	}

}
