package Lecture32;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import Lecture32.Heap;

public class Graphsir {
	// comparable to implement kruskals
	private class Edge implements Comparable<Edge> {
		Vertex one;
		Vertex two;
		int weight;

		Edge(Vertex one, Vertex two, int weight) {
			this.one = one;
			this.two = two;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}

	private class Vertex {
		String name;
		HashMap<Vertex, Edge> neighbors;

		Vertex(String name) {
			this.name = name;
			this.neighbors = new HashMap<>();
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

	public Graphsir() {
		this.vertices = new HashMap<>();
	}

	public int numVertices() {
		return this.vertices.size();
	}

	public void addVertex(String v) {
		if (this.containsVertex(v)) {
			return;
		}

		Vertex vtx = new Vertex(v);
		this.vertices.put(v, vtx);
	}

	public void removeVertex(String v) {
		if (!this.containsVertex(v)) {
			return;
		}

		Vertex vtx = this.getVertex(v);
		Set<Vertex> nbrVertices = vtx.neighbors.keySet();
		for (Vertex nbrVtx : nbrVertices) {
			nbrVtx.neighbors.remove(vtx);
		}

		this.vertices.remove(v);
	}

	public boolean containsVertex(String v) {
		Vertex vtx = this.getVertex(v);

		if (vtx != null) {
			return true;
		} else {
			return false;
		}
	}

	private Vertex getVertex(String v) {
		return this.vertices.get(v);
	}

	public int numEdges() {
		int rv = 0;

		Collection<Vertex> allVertices = this.vertices.values();
		for (Vertex vtx : allVertices) {
			rv += vtx.neighbors.size();
		}

		rv = rv / 2;

		return rv;
	}

	public void addEdge(String v1, String v2, int weight) {
		Vertex vtx1 = this.getVertex(v1), vtx2 = this.getVertex(v2);

		if (vtx1 == null || vtx2 == null || this.containsEdge(v1, v2)) {
			return;
		}

		Edge commonEdge = new Edge(vtx1, vtx2, weight);
		vtx1.neighbors.put(vtx2, commonEdge);
		vtx2.neighbors.put(vtx1, commonEdge);
	}

	public void removeEdge(String v1, String v2) {
		Vertex vtx1 = this.getVertex(v1), vtx2 = this.getVertex(v2);

		if (vtx1 == null || vtx2 == null || !this.containsEdge(v1, v2)) {
			return;
		}

		vtx1.neighbors.remove(vtx2);
		vtx2.neighbors.remove(vtx1);
	}

	public boolean containsEdge(String v1, String v2) {
		Vertex vtx1 = this.getVertex(v1), vtx2 = this.getVertex(v2);

		if (vtx1 == null || vtx2 == null) {
			return false;
		}

		return vtx1.neighbors.containsKey(vtx2);
	}

	public void display() {
		Set<Map.Entry<String, Vertex>> allEntries = this.vertices.entrySet();
		for (Map.Entry<String, Vertex> entry : allEntries) {
			Vertex vtx = entry.getValue();

			String toPrint = vtx.name + " => ";
			Set<Vertex> nbrs = vtx.neighbors.keySet();

			for (Vertex nbr : nbrs) {
				toPrint += nbr.name + ", ";
			}

			toPrint += "END";
			System.out.println(toPrint);
		}

		System.out.println("**************************************");
	}

	/* Questions */
	public boolean hasPath(String v1, String v2) {
		Vertex vtx1 = this.getVertex(v1), vtx2 = this.getVertex(v2);

		if (vtx1 == null || vtx2 == null) {
			return false;
		}

		// HashMap<Vertex, Vertex> visited = new HashMap<>();
		// visited.put(vtx1, null);
		//
		// return this.hasPathDFS(vtx1, vtx2, visited);
		// return this.hasPathBFS(vtx1, vtx2);
		return this.hasPathDFSI(vtx1, vtx2);
	}

	private boolean hasPathDFS(Vertex vtx1, Vertex vtx2, HashMap<Vertex, Vertex> visited) {
		if (vtx1.neighbors.containsKey(vtx2)) {
			return true;
		}

		Set<Vertex> nbrs = vtx1.neighbors.keySet();
		for (Vertex nbr : nbrs) {
			if (!visited.containsKey(nbr)) {
				visited.put(nbr, null);

				if (this.hasPathDFS(nbr, vtx2, visited)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean hasPathBFS(Vertex vtx1, Vertex vtx2) {
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();

		visited.put(vtx1, vtx1);
		queue.addLast(vtx1);

		while (!queue.isEmpty()) {
			Vertex vtx = queue.removeFirst();

			// work area
			if (vtx.neighbors.containsKey(vtx2)) {
				return true;
			}

			Set<Vertex> nbrs = vtx.neighbors.keySet();
			for (Vertex nbr : nbrs) {
				if (!visited.containsKey(nbr)) {
					visited.put(nbr, nbr);
					queue.addLast(nbr);
				}
			}
		}

		return false;
	}

	private boolean hasPathDFSI(Vertex vtx1, Vertex vtx2) {
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> stack = new LinkedList<>();

		visited.put(vtx1, vtx1);
		stack.addFirst(vtx1);

		while (!stack.isEmpty()) {
			Vertex vtx = stack.removeFirst();

			// work area
			if (vtx.neighbors.containsKey(vtx2)) {
				return true;
			}

			Set<Vertex> nbrs = vtx.neighbors.keySet();
			for (Vertex nbr : nbrs) {
				if (!visited.containsKey(nbr)) {
					visited.put(nbr, nbr);
					stack.addFirst(nbr);
				}
			}
		}

		return false;
	}

	public void bft() {
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();

		Collection<Vertex> allVertices = this.vertices.values();
		for (Vertex vtx : allVertices) {
			if (!visited.containsKey(vtx)) {
				visited.put(vtx, vtx);
				queue.addLast(vtx);

				while (!queue.isEmpty()) {
					Vertex ovtx = queue.removeFirst();

					System.out.println(ovtx.name);

					Set<Vertex> nbrs = ovtx.neighbors.keySet();
					for (Vertex nbr : nbrs) {
						if (!visited.containsKey(nbr)) {
							visited.put(nbr, nbr);
							queue.addLast(nbr);
						}
					}
				}
			}
		}
	}

	public void dft() {
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> stack = new LinkedList<>();

		Collection<Vertex> allVertices = this.vertices.values();

		for (Vertex vtx : allVertices) {
			if (!visited.containsKey(vtx)) {
				visited.put(vtx, vtx);
				stack.addFirst(vtx);

				while (!stack.isEmpty()) {
					vtx = stack.removeFirst();

					// work area
					System.out.println(vtx.name);

					Set<Vertex> nbrs = vtx.neighbors.keySet();
					for (Vertex nbr : nbrs) {
						if (!visited.containsKey(nbr)) {
							visited.put(nbr, nbr);
							stack.addFirst(nbr);
						}
					}
				}
			}
		}
	}

	public boolean isConnected() {
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();

		Vertex[] allVertices = new Vertex[this.vertices.size()];
		this.vertices.values().toArray(allVertices);

		visited.put(allVertices[0], allVertices[0]);
		queue.addLast(allVertices[0]);

		while (!queue.isEmpty()) {
			Vertex vtx = queue.removeFirst();

			// work area
			System.out.println(vtx.name);

			Set<Vertex> nbrs = vtx.neighbors.keySet();
			for (Vertex nbr : nbrs) {
				if (!visited.containsKey(nbr)) {
					visited.put(nbr, nbr);
					queue.addLast(nbr);
				}
			}
		}

		return this.vertices.size() == visited.size();
	}

	public ArrayList<ArrayList<String>> getConnectedComponents() {
		ArrayList<ArrayList<String>> rv = new ArrayList<>();

		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> stack = new LinkedList<>();

		Collection<Vertex> allVertices = this.vertices.values();

		for (Vertex vtx : allVertices) {
			if (!visited.containsKey(vtx)) {
				ArrayList<String> cc = new ArrayList<>();

				visited.put(vtx, vtx);
				stack.addFirst(vtx);

				while (!stack.isEmpty()) {
					vtx = stack.removeFirst();

					// work area
					cc.add(vtx.name);

					Set<Vertex> nbrs = vtx.neighbors.keySet();
					for (Vertex nbr : nbrs) {
						if (!visited.containsKey(nbr)) {
							visited.put(nbr, nbr);
							stack.addFirst(nbr);
						}
					}
				}

				rv.add(cc);
			}
		}

		return rv;
	}

	public boolean isBipartite() {
		HashMap<Vertex, String> visited = new HashMap<>();
		LinkedList<Vertex> stack = new LinkedList<>();

		Collection<Vertex> allVertices = this.vertices.values();

		for (Vertex vtx : allVertices) {
			if (!visited.containsKey(vtx)) {
				visited.put(vtx, "Red");
				stack.addFirst(vtx);

				while (!stack.isEmpty()) {
					vtx = stack.removeFirst();

					Set<Vertex> nbrs = vtx.neighbors.keySet();
					for (Vertex nbr : nbrs) {
						String covtx = visited.get(vtx);
						String cToApplyOnNbr = covtx.equals("Red") ? "Green" : "Red";

						if (!visited.containsKey(nbr)) {
							visited.put(nbr, cToApplyOnNbr);
							stack.addFirst(nbr);
						} else {
							String actualCOnNbr = visited.get(nbr);

							if (actualCOnNbr.equals(cToApplyOnNbr)) {
								continue;
							}

							return false;
						}
					}
				}
			}
		}

		return true;
	}

	public boolean isAcyclic() {
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> stack = new LinkedList<>();

		Collection<Vertex> allVertices = this.vertices.values();

		for (Vertex vtx : allVertices) {
			if (!visited.containsKey(vtx)) {
				visited.put(vtx, null);
				stack.addFirst(vtx);

				while (!stack.isEmpty()) {
					vtx = stack.removeFirst();

					Set<Vertex> nbrs = vtx.neighbors.keySet();
					for (Vertex nbr : nbrs) {
						if (!visited.containsKey(nbr)) {
							visited.put(nbr, vtx);
							stack.addFirst(nbr);
						} else {
							Vertex reasonForVtx = visited.get(vtx);

							if (reasonForVtx == nbr) {
								continue;
							}

							return false;
						}
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

	public HashMap<String, Integer> djikstra(String src) {
		HashMap<String, Integer> rv = new HashMap<>();

		Heap<Pair> vtxHeap = new Heap<>(true);
		HashMap<Vertex, Pair> vtxMap = new HashMap<>();

		Set<Map.Entry<String, Vertex>> allEntries = this.vertices.entrySet();
		for (Map.Entry<String, Vertex> entry : allEntries) {
			Vertex vtx = entry.getValue();

			Pair p = null;
			if (vtx.name.equals(src)) {
				p = new Pair(0, vtx);
			} else {
				p = new Pair(Integer.MAX_VALUE, vtx);
			}

			vtxHeap.add(p);
			vtxMap.put(vtx, p);
		}

		while (!vtxHeap.isEmpty()) {
			Pair tpair = vtxHeap.remove();
			Vertex tvtx = tpair.vtx;

			Set<Map.Entry<Vertex, Edge>> nbrEntries = tvtx.neighbors.entrySet();
			for (Map.Entry<Vertex, Edge> nbrEntry : nbrEntries) {
				Vertex ovtx = nbrEntry.getKey();
				Edge oedge = nbrEntry.getValue();
				Pair opair = vtxMap.get(ovtx);

				int oldScore = opair.cost;
				int newScore = tpair.cost + oedge.weight;

				if (newScore < oldScore) {
					opair.cost = newScore;
					vtxHeap.updatePriority(opair);
				}
			}
		}

		Set<Map.Entry<Vertex, Pair>> pairEntries = vtxMap.entrySet();
		for (Map.Entry<Vertex, Pair> pairEntry : pairEntries) {
			rv.put(pairEntry.getKey().name, pairEntry.getValue().cost);
		}

		return rv;
	}

	public Graphsir prims() {
		Graphsir rv = new Graphsir();

		Heap<Pair> vtxHeap = new Heap<>(true);
		HashMap<Vertex, Pair> vtxMap = new HashMap<>();

		boolean first = true;
		Set<Map.Entry<String, Vertex>> allEntries = this.vertices.entrySet();
		for (Map.Entry<String, Vertex> entry : allEntries) {
			Vertex vtx = entry.getValue();

			Pair p = null;
			if (first) {
				first = false;
				p = new Pair(0, vtx);
			} else {
				p = new Pair(Integer.MAX_VALUE, vtx);
			}

			vtxHeap.add(p);
			vtxMap.put(vtx, p);
		}

		while (!vtxHeap.isEmpty()) {
			Pair tpair = vtxHeap.remove();
			Vertex tvtx = tpair.vtx;

			// processing
			if (rv.numVertices() == 0) {
				rv.addVertex(tvtx.name);
			} else {
				rv.addVertex(tvtx.name);
				rv.addEdge(tpair.edge.one.name, tpair.edge.two.name, tpair.edge.weight);
			}

			Set<Map.Entry<Vertex, Edge>> nbrEntries = tvtx.neighbors.entrySet();
			for (Map.Entry<Vertex, Edge> nbrEntry : nbrEntries) {
				if (rv.containsVertex(nbrEntry.getKey().name)) {
					continue;
				}

				Vertex ovtx = nbrEntry.getKey();
				Edge oedge = nbrEntry.getValue();
				Pair opair = vtxMap.get(ovtx);

				int oldScore = opair.cost;
				int newScore = oedge.weight;

				if (newScore < oldScore) {
					opair.cost = newScore;
					opair.edge = oedge;
					vtxHeap.updatePriority(opair);
				}
			}
		}

		return rv;
	}

	public Graphsir kruskals() {
		Graphsir rv = new Graphsir();

		Heap<Edge> edgeHeap = new Heap<>(true);
		HashMap<Edge, Boolean> edgeDuplicacyMap = new HashMap<>();
		HashMap<Vertex, Cluster<Vertex>> partition = new HashMap<>();

		Set<Map.Entry<String, Vertex>> allEntries = this.vertices.entrySet();
		for (Map.Entry<String, Vertex> entry : allEntries) {
			Vertex vtx = entry.getValue();

			Cluster<Vertex> cluster = new Cluster<>(vtx);
			partition.put(vtx, cluster);

			Set<Map.Entry<Vertex, Edge>> nbrs = vtx.neighbors.entrySet();
			for (Map.Entry<Vertex, Edge> nbr : nbrs) {
				Edge edge = nbr.getValue();

				if (!edgeDuplicacyMap.containsKey(edge)) {
					edgeHeap.add(edge);
					edgeDuplicacyMap.put(edge, true);
				}
			}
		}

		while (rv.numEdges() != this.numVertices() - 1) {
			Edge edge = edgeHeap.remove();

			Cluster<Vertex> cone = partition.get(edge.one).find();
			Cluster<Vertex> ctwo = partition.get(edge.two).find();

			if (cone != ctwo) {
				cone.union(ctwo);
				
				rv.addVertex(edge.one.name);
				rv.addVertex(edge.two.name);
				rv.addEdge(edge.one.name, edge.two.name, edge.weight);
			}
		}

		return rv;
	}

	private class Cluster<V> {
		V data;
		int size;
		Cluster<V> parent;

		Cluster(V data) {
			this.data = data;
			this.size = 1;
			this.parent = this;
		}

		public Cluster<V> find() {
			if (this.parent == this) {
				return this;
			}

			return this.parent.find();
		}

		public void union(Cluster<V> o) {
			o.parent = this;
			this.size += o.size;
		}
	}

	/*
	 * public HashMap<String, Integer> djikstra(String src) { Heap<Pair> vtxHeap
	 * = new Heap<>(true); HashMap<Vertex, Pair> vtxPairMap = new HashMap<>();
	 * 
	 * Set<Map.Entry<String, Vertex>> allEntries = this.vertices.entrySet(); for
	 * (Map.Entry<String, Vertex> entry : allEntries) { Vertex vtx =
	 * entry.getValue();
	 * 
	 * Pair p = null; if (vtx.name.equals(src)) { p = new Pair(0, vtx); } else {
	 * p = new Pair(Integer.MAX_VALUE, vtx); }
	 * 
	 * vtxHeap.add(p); vtxPairMap.put(vtx, p); }
	 * 
	 * while (!vtxHeap.isEmpty()) { Pair tpair = vtxHeap.remove(); Vertex tvtx =
	 * tpair.vtx;
	 * 
	 * Set<Map.Entry<Vertex, Edge>> nbrs = tvtx.neighbors.entrySet(); for
	 * (Map.Entry<Vertex, Edge> nbr : nbrs) { Vertex ovtx = nbr.getKey(); Edge
	 * oedge = nbr.getValue(); Pair opair = vtxPairMap.get(ovtx);
	 * 
	 * int ns = oedge.weight + tpair.cost; int os = opair.cost;
	 * 
	 * if (ns < os) { opair.cost = ns; vtxHeap.updatePriority(opair); } } }
	 * 
	 * HashMap<String, Integer> rv = new HashMap<>();
	 * 
	 * Set<Map.Entry<Vertex, Pair>> entries = vtxPairMap.entrySet(); for
	 * (Map.Entry<Vertex, Pair> entry : entries) { rv.put(entry.getKey().name,
	 * entry.getValue().cost); }
	 * 
	 * return rv; }
	 * 
	 * public Graph prims() { Graph rv = new Graph();
	 * 
	 * Heap<Pair> vtxHeap = new Heap<>(true); HashMap<Vertex, Pair> vtxPairMap =
	 * new HashMap<>();
	 * 
	 * boolean first = true; Set<Map.Entry<String, Vertex>> allEntries =
	 * this.vertices.entrySet(); for (Map.Entry<String, Vertex> entry :
	 * allEntries) { Vertex vtx = entry.getValue();
	 * 
	 * Pair p = null; if (first) { first = false; p = new Pair(0, vtx, null); }
	 * else { p = new Pair(Integer.MAX_VALUE, vtx, null); }
	 * 
	 * vtxHeap.add(p); vtxPairMap.put(vtx, p); }
	 * 
	 * while (!vtxHeap.isEmpty()) { Pair tpair = vtxHeap.remove(); Vertex tvtx =
	 * tpair.vtx;
	 * 
	 * if (rv.numVertices() == 0) { rv.addVertex(tvtx.name); } else {
	 * rv.addVertex(tvtx.name); rv.addEdge(tpair.edge.one.name,
	 * tpair.edge.two.name, tpair.edge.weight); }
	 * 
	 * Set<Map.Entry<Vertex, Edge>> nbrs = tvtx.neighbors.entrySet(); for
	 * (Map.Entry<Vertex, Edge> nbr : nbrs) { if
	 * (rv.containsVertex(nbr.getKey().name)) { continue; }
	 * 
	 * Vertex ovtx = nbr.getKey(); Edge oedge = nbr.getValue(); Pair opair =
	 * vtxPairMap.get(ovtx);
	 * 
	 * int ns = oedge.weight; int os = opair.cost;
	 * 
	 * if (ns < os) { opair.cost = ns; opair.edge = oedge;
	 * vtxHeap.updatePriority(opair); } } }
	 * 
	 * return rv; }
	 * 
	 * public Graph kruskals() { Graph rv = new Graph();
	 * 
	 * Heap<Edge> edgeHeap = new Heap<>(true); HashMap<Edge, Boolean>
	 * edgeDuplicacyMap = new HashMap<>();
	 * 
	 * HashMap<Vertex, Cluster<Vertex>> partition = new HashMap<>();
	 * 
	 * Set<Map.Entry<String, Vertex>> allEntries = this.vertices.entrySet(); for
	 * (Map.Entry<String, Vertex> entry : allEntries) { Vertex vtx =
	 * entry.getValue();
	 * 
	 * partition.put(vtx, new Cluster<Graph.Vertex>(vtx));
	 * 
	 * Set<Map.Entry<Vertex, Edge>> nbrs = vtx.neighbors.entrySet(); for
	 * (Map.Entry<Vertex, Edge> nbr : nbrs) { Edge edge = nbr.getValue();
	 * 
	 * if (!edgeDuplicacyMap.containsKey(edge)) { edgeDuplicacyMap.put(edge,
	 * true); edgeHeap.add(edge); } } }
	 * 
	 * while (rv.numEdges() != this.numVertices() - 1) { Edge edge =
	 * edgeHeap.remove();
	 * 
	 * Cluster<Vertex> cone = partition.get(edge.one).find(); Cluster<Vertex>
	 * ctwo = partition.get(edge.two).find();
	 * 
	 * if (cone != ctwo) { cone.union(ctwo);
	 * 
	 * rv.addVertex(edge.one.name); rv.addVertex(edge.two.name);
	 * rv.addEdge(edge.one.name, edge.two.name, edge.weight); } }
	 * 
	 * return rv; }
	 * 
	 * private class Pair implements Comparable<Pair> { int cost; Vertex vtx;
	 * Edge edge; // to be used in prims
	 * 
	 * // for djikstra's Pair(int cost, Vertex vtx) { this.cost = cost; this.vtx
	 * = vtx; }
	 * 
	 * // for prims Pair(int cost, Vertex vtx, Edge edge) { this.cost = cost;
	 * this.vtx = vtx; this.edge = edge; }
	 * 
	 * @Override public int compareTo(Pair o) { // TODO Auto-generated method
	 * stub return this.cost - o.cost; }
	 * 
	 * public boolean equals(Object other) { Pair op = (Pair) other; return
	 * this.vtx.equals(op.vtx); }
	 * 
	 * public int hashCode() { return this.vtx.hashCode(); } }
	 * 
	 * private class Cluster<V> {
	 */
	// V data;
	// int size;
	// Cluster<V> parent;
	//
	// Cluster(V data) {
	// this.data = data;
	// this.size = 1;
	// this.parent = this;
	// }
	//
	// public Cluster<V> find() {
	// if (this.parent == this) {
	// return this;
	// }
	//
	// Cluster<V> rv = this.parent.find();
	//// this.parent = rv;
	//
	// return rv;
	// }
	//
	// public void union(Cluster<V> c) {
	// if (this == c) {
	// return;
	// }
	//
	// if (this.size < c.size) {
	// this.parent = c;
	// c.size += this.size;
	// } else {
	// c.parent = this;
	// this.size += c.size;
	// }
	// }
	// }
}
