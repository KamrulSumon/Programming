package com.sumon.graph.adjacency;

import static java.lang.System.out;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

	public void bfs(AdjacencyGraph graph, int start){
		Queue queue = new LinkedList();
		int currentVertex;
		int i;

		initializeSearch(graph);
		
		queue.add(start);
		graph.discovered[start] = true;
		graph.distance[start] = 0;
		graph.parent[start] = -1;
		
		while(!queue.isEmpty()){
			currentVertex = (int) queue.remove(); 
			graph.processed[currentVertex] = true;
			
			for(i = 0; i < graph.degree[currentVertex]; i++){
				if(valid_edge(graph.edges[currentVertex][i]) == true){
					if( graph.discovered[graph.edges[currentVertex][i]] == false ){
						queue.add(graph.edges[currentVertex][i]);
						graph.discovered[graph.edges[currentVertex][i]] = true;
						graph.parent[graph.edges[currentVertex][i]] = currentVertex;
						graph.distance[graph.edges[currentVertex][i]] = graph.distance[currentVertex] + 1;
					}
					
					if(graph.processed[graph.edges[currentVertex][i]] == false ){
						process_edge(currentVertex, graph.edges[currentVertex][i]);
					}
				}
			}
		}
		
	}
	
	public void initializeSearch(AdjacencyGraph graph){
		int i;
		
		for(i = 1; i <= graph.nvertices; i++){
			graph.processed[i] = false;
			graph.discovered[i] = false;
			graph.parent[i] = -1;
			graph.distance[i] = -2; 
		}
	}
	
	public boolean valid_edge(int v){
		return v == 0 ? false : true;
	}
	
	public void process_edge(int x, int y){
		out.println("Process edge ("+x+","+y+")");
	}
}
