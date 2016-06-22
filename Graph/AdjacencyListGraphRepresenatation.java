package com.sumon.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

interface IGraph {
	void addEdge(int from, int to);

	List<Integer> getAdjacentEdges(int from);

	void removeEdge(int from, int to);

	boolean hasEdge(int from, int to);

	int getNumberOfVertices();

	int getNumberOfEdges();

	int getDegree(int v);
}

/* Adjacency Graph representation using HashMap */
class Graph implements IGraph {

	private Map<Integer, List<Integer>> graph; // Store adjacency list of each
												// // vertex
	private final boolean directed; // Flag for Graph is directed or undirected
	private final int nVertices; // Number of vertices
	private int nEdges; // Number of edges

	public Graph(int numberOfVertices, boolean directed) {
		if (numberOfVertices < 0)
			throw new IllegalArgumentException("Number of vertices must be nonnegative");
		graph = new HashMap<>();
		nVertices = numberOfVertices;
		nEdges = 0;
		this.directed = directed;
		for (int i = 1; i <= numberOfVertices; i++) {
			graph.put(i, new LinkedList<Integer>());
		}
	}

	/* Add Nodes to the neighbor of the vertex */
	@Override
	public void addEdge(int from, int to) {
		validateVertex(from);
		validateVertex(to);

		List<Integer> fromList = graph.get(from);
		fromList.add(to);

		// if graph is undirected, add nodes to the neighbor of the other vertex
		if (!directed) {
			List<Integer> toList = graph.get(to);
			toList.add(from);
		}
		nEdges++;
	}

	/* Remove edge between two vertices */
	@Override
	public void removeEdge(int from, int to) {
		validateVertex(from);
		validateVertex(to);

		if (hasEdge(from, to)) {
			Iterator<Integer> it = graph.get(from).iterator();
			while (it.hasNext()) {
				if (it.next() == to) {
					it.remove();
				}
			}
			if (!directed) {
				it = graph.get(to).iterator();
				while (it.hasNext()) {
					if (it.next() == from) {
						it.remove();
					}
				}
			}
		} else {
			System.out.println("There is not edge between (" + from + "->" + to + ")");
		}
	}

	/* Check whether there is an edge between two vertex */
	@Override
	public boolean hasEdge(int from, int to) {
		return graph.get(from).contains(to);
	}

	/* Returns adjacent neighbor of the vertex */
	@Override
	public List<Integer> getAdjacentEdges(int from) {
		validateVertex(from);
		return graph.get(from);
	}

	/* Returns number of vertices in the graph */
	@Override
	public int getNumberOfVertices() {
		return nVertices;
	}

	/* Returns number of edges in the graph */
	@Override
	public int getNumberOfEdges() {
		return nEdges;
	}

	/* Validate a vertex */
	private void validateVertex(int vertex) {
		if (vertex <= 0 || vertex > nVertices)
			throw new IndexOutOfBoundsException("The vertex " + vertex + " is not between 1 and " + nVertices);
	}

	/* Returns the number of neighbors(degree) of the given vertex */
	@Override
	public int getDegree(int v) {
		validateVertex(v);
		return graph.get(v).size();
	}

	/* Returns adjacency list representation of the graph */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nVertices + " vertices, edges " + nEdges + "\n");
		for (int v = 1; v <= nVertices; v++) {
			sb.append(v + ": ");
			for (int e : graph.get(v)) {
				sb.append(e + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}

/* Adjacency List Representation of Graph using LinkList */
class AdjacencyGraph implements IGraph {

	private LinkedList<Integer> graph[]; // Store adjacency list of each vertex
	private final boolean directed; // Flag for Graph is directed or undirected
	private final int nVertices; // Number of vertices
	private int nEdges; // Number of edges

	public AdjacencyGraph(int numberOfVertices, boolean directed) {
		if (numberOfVertices < 0)
			throw new IllegalArgumentException("Number of vertices must be nonnegative");
		graph = new LinkedList[numberOfVertices + 1];
		nVertices = numberOfVertices;
		nEdges = 0;
		this.directed = directed;
		for (int v = 1; v <= numberOfVertices; v++) {
			graph[v] = new LinkedList();
		}
	}

	/* Add Nodes to the neighbor of the vertex */
	@Override
	public void addEdge(int from, int to) {
		validateVertex(from);
		validateVertex(to);

		List<Integer> fromList = graph[from];
		fromList.add(to);

		// if graph is undirected, add nodes to the neighbor of the other vertex
		if (!directed) {
			List<Integer> toList = graph[to];
			toList.add(from);
		}
		nEdges++;
	}

	/* Remove edge between two vertices */
	@Override
	public void removeEdge(int from, int to) {
		validateVertex(from);
		validateVertex(to);

		if (hasEdge(from, to)) {
			Iterator<Integer> it = graph[from].iterator();
			while (it.hasNext()) {
				if (it.next() == to) {
					it.remove();
				}
			}
			if (!directed) {
				it = graph[to].iterator();
				while (it.hasNext()) {
					if (it.next() == from){
						it.remove();
					}
				}
			}
		} else {
			System.out.println("There is not edge between (" + from + "->" + to + ")");
		}
	}


	/* Check whether there is an edge between two edges */
	@Override
	public boolean hasEdge(int from, int to) {
		return graph[from].contains(to);
	}

	/* Returns adjacent neighbor of the vertex */
	@Override
	public List<Integer> getAdjacentEdges(int from) {
		validateVertex(from);
		return graph[from];
	}

	/* Returns number of vertices in the graph */
	@Override
	public int getNumberOfVertices() {
		return nVertices;
	}

	/* Returns number of edges in the graph */
	@Override
	public int getNumberOfEdges() {
		return nEdges;
	}

	/* Validate a vertex */
	private void validateVertex(int vertex) {
		if (vertex <= 0 || vertex > nVertices)
			throw new IndexOutOfBoundsException("The vertex " + vertex + " is not between 1 and " + nVertices);
	}

	/* Returns the number of neighbors(degree) of the given vertex */
	@Override
	public int getDegree(int v) {
		validateVertex(v);
		return graph[v].size();
	}

	/* Returns adjacency list representation of the graph */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nVertices + " vertices, edges " + nEdges + "\n");
		for (int v = 1; v <= nVertices; v++) {
			sb.append(v + ": ");
			for (int e : graph[v]) {
				sb.append(e + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}

class AdjacencyListGraphRepresenatation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int from, to;
		int numberOfEdges, numberOfVertices;
		boolean directed = false;

		// Read the number of vertices and edges in graph
		System.out.println("Enter the number of vertices and edges in graph");
		System.out.print("Vertices:");
		numberOfVertices = sc.nextInt();
		System.out.print("Edges:");
		numberOfEdges = sc.nextInt();
		Graph graph = new Graph(numberOfVertices, directed);
		AdjacencyGraph g = new AdjacencyGraph(numberOfVertices, directed);

		/* Reads the edges present in the graph */
		System.out.println("Enter the edges in graph format : (from -> to)");
		for (int i = 1; i <= numberOfEdges; i++) {
			System.out.print("Edge:");
			from = sc.nextInt();
			to = sc.nextInt();
			graph.addEdge(from, to);
			g.addEdge(from, to);
		}
		System.out.println("HashMap Representation:");
		System.out.println(graph);
		System.out.println("LinkedList Representation:");
		System.out.println(g);
		System.out.println(graph.hasEdge(2, 3));
		System.out.println(graph.hasEdge(2, 5));
		System.out.println(g.hasEdge(2, 3));
		System.out.println(graph.hasEdge(2, 5));
		graph.removeEdge(4, 8);
		System.out.println(graph);
		g.removeEdge(4, 8);
		System.out.println(g);
		sc.close();
	}

}
