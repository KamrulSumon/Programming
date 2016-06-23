package com.sumon.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Find the connection, if exist, between two node of directed graph using BFS or DFS
 * @author Kamrul Hasan
 * @reference Cracking the coding interview 4.1
 */
class Graph {

	public enum State {
		Unvisited, Visiting, Visited;
	}

	private final static int NIL = -1;
	private static int time;

	private LinkedList<Integer> graph[]; // Store adjacency list of each vertex
	private final boolean directed; // Flag for Graph is directed or undirected
	private final int nVertices; // Number of vertices
	private int nEdges; // Number of edges
	private State[] states; // represent the state of vertex
	private int[] parents; // hold the parents
	private int[] distances; // hold the distance
	private int[] finishedTime;

	public Graph(int numberOfVertices, boolean directed) {
		if (numberOfVertices < 0)
			throw new IllegalArgumentException("Number of vertices must be nonnegative");

		graph = new LinkedList[numberOfVertices + 1];
		states = new State[numberOfVertices + 1];
		parents = new int[numberOfVertices + 1];
		distances = new int[numberOfVertices + 1];
		finishedTime = new int[numberOfVertices + 1];
		nVertices = numberOfVertices;
		nEdges = 0;
		this.directed = directed;

		for (int v = 1; v <= numberOfVertices; v++) {
			graph[v] = new LinkedList();
		}
	}

	/* Add Nodes to the neighbor of the vertex */
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
					if (it.next() == from) {
						it.remove();
					}
				}
			}
		} else {
			System.out.println("There is not edge between (" + from + "->" + to + ")");
		}
	}

	/* Check whether there is an edge between two edges */
	public boolean hasEdge(int from, int to) {
		return graph[from].contains(to);
	}

	/* Returns adjacent neighbor of the vertex */
	public List<Integer> getAdjacentVertices(int from) {
		validateVertex(from);
		return graph[from];
	}

	/* Returns number of vertices in the graph */
	public int getNumberOfVertices() {
		return nVertices;
	}

	/* Returns number of edges in the graph */
	public int getNumberOfEdges() {
		return nEdges;
	}

	/* Validate a vertex */
	private void validateVertex(int vertex) {
		if (vertex <= 0 || vertex > nVertices)
			throw new IndexOutOfBoundsException("The vertex " + vertex + " is not between 1 and " + nVertices);
	}

	/* Returns the number of neighbors(degree) of the given vertex */
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

	/*
	 * Returns boolean if there is a connection between two vertices using BFS
	 */
	boolean search(Graph g, int start, int end) {
		if (start == end)
			return true;
		// operates as queue
		LinkedList<Integer> queue = new LinkedList<>();

		// set all the vertices are unvisited initially
		for (int v = 1; v <= nVertices; v++) {
			states[v] = State.Unvisited;
		}

		states[start] = State.Visiting;
		queue.add(start);

		while (!queue.isEmpty()) {
			int u = queue.removeFirst();

			for (int v : getAdjacentVertices(u)) {
				if (states[v] == State.Unvisited) {
					if (v == end) {
						return true;
					} else {
						states[v] = State.Visiting;
						queue.add(v);
					}
				}
			}
			states[u] = State.Visited;
		}

		return false;
	}

	/* Returns boolean if there is a connection between two nodes */
	boolean searchDFS(Graph g, int start, int end) {

		for (int v = 1; v <= nVertices; v++) {
			states[v] = State.Unvisited;
			parents[v] = NIL;
		}

		time = 0;
		return dfs_visit(g, start, end);
	}

	private boolean dfs_visit(Graph g, int v, int end) {

		if (v == end)
			return true;
		time = time + 1;
		distances[v] = time;
		states[v] = State.Visiting;

		for (int u : getAdjacentVertices(v)) {
			if (states[u] == State.Unvisited) {
				parents[u] = v;
				return dfs_visit(g, u, end);

			}
		}
		states[v] = State.Visited;
		time = time + 1;
		finishedTime[v] = time;
		return false;
	}

}

public class RouteBetweenNodes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int from, to;
		int numberOfEdges, numberOfVertices;
		boolean directed = true;

		// Read the number of vertices and edges in graph
		System.out.println("Enter the number of vertices and edges in graph");
		System.out.print("Vertices:");
		numberOfVertices = sc.nextInt();
		System.out.print("Edges:");
		numberOfEdges = sc.nextInt();
		Graph graph = new Graph(numberOfVertices, directed);

		/* Reads the edges present in the graph */
		System.out.println("Enter the edges in graph format : (from -> to)");
		for (int i = 1; i <= numberOfEdges; i++) {
			System.out.print("Edge:");
			from = sc.nextInt();
			to = sc.nextInt();
			graph.addEdge(from, to);
		}

		System.out.println(graph);
		System.out.println(graph.search(graph, 1, 6));
		System.out.println(graph.search(graph, 4, 5));

		System.out.println(graph.searchDFS(graph, 1, 6));
		System.out.println(graph.searchDFS(graph, 4, 5));
	}

}
