package com.sumon.graph.adjacency;

import static java.lang.System.out;
import java.util.Scanner;

public class AdjacencyGraph {
	Scanner sc = new Scanner(System.in);
	
	private final int MAX_VERTEX = 100;		// number of vertex
	public final int MAX_DEGREE = 50;		// number of edge
	
	int edges[][];							// adjacency info
	int degree[];							// outdegree of each vertex
	int nvertices;							// number of vertex in graph
	int nedges;								// number of edges in graph
	
	boolean processed[];   //Which vertices have been processed
	boolean discovered[];  // which vertices have been found
	int parent[];		   // discovery realtionship
	int distance[];
	
	
	public AdjacencyGraph(){
		edges = new int[MAX_VERTEX][MAX_DEGREE];
		degree = new int[MAX_VERTEX];
		processed = new boolean[MAX_VERTEX];
		discovered = new boolean[MAX_VERTEX];
		parent = new int[MAX_VERTEX];
		distance = new int[MAX_VERTEX];
	}

	// Initialize the graph
	public void initializeGraph(){
		int i;		// counter
		nvertices = 0;
		nedges = 0;
		
		for(i = 0; i < MAX_VERTEX; i++){
			degree[i] = 0;
		}	
	}
	
	public void readGraph(boolean directed){
		int i;		//counter
		int numberOfEdge;		// number of edge
		int x, y;		//vertex in edge (x, y)
		
		initializeGraph();
		out.print("Insert Number of Vertex & Edges:");
		nvertices = sc.nextInt();
		numberOfEdge = sc.nextInt();
		
		for(i = 1; i <= numberOfEdge; i++){
			x = sc.nextInt();
			y = sc.nextInt();
			insertEdge(x, y, directed);
		}
	}
	
	public void insertEdge(int x, int y, boolean directed){
		
		if(degree[x] > MAX_DEGREE){
			out.println("Warining: insertion("+x+","+y+") excedes max degree");
		}
		
		edges[x][degree[x]] = y;
		degree[x]++;
		
		if( directed == false ){
			insertEdge(y, x, true);
		}else
			nedges ++;
	}
	
	public void printGraph(){
		int i, j;
		out.println("Adjacency Graph:");
		for(i = 1; i <= nvertices; i++){
			out.print(i+": ");
			
			for(j = 0; j < degree[i]; j++){
				out.print(edges[i][j]+" ");
			}
			out.println();
		}
	}
	
}
