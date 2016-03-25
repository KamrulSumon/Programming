package com.sumon.graph.adjacency;

import static java.lang.System.out;

public class DFS {

	int time;  //vertex finished time 
	
	public void dfs(AdjacencyGraph g){
		
		int i;
		
		initializeSearch(g);
		time = 0;
		
		for(i = 1; i <= g.nvertices; i++){
			if(g.processed[i] == false){
				dfs_visit(g, i);
			}
		}
	}
	
	
	public void dfs(AdjacencyGraph g, int v){
		
		int i;
		
		initializeSearch(g);
		time = 0;
		
		dfs_visit(g, v);
	
	}
	
	
	public void dfs_visit(AdjacencyGraph g, int v){
		int y;								//successor vertex
		time = time + 1;
		g.distance[v] = time;
		g.discovered[v] = true;
		
		process_vertex(v);
		
		for(int i = 0; i < g.degree[v] ; i++){
			
			y = g.edges[v][i];
			
			if(valid_edge(g.edges[v][i]) == true){
				
				if(g.discovered[y] == false){
					g.parent[y] = v;
					dfs_visit(g, y);
				}else
					if(g.processed[y] == false ){
						process_edge(v, y);
					}
			}
		}
		
		g.processed[v] = true;
		time = time + 1;
		g.finishTime[v] = time;
	}
	
	
	public void initializeSearch(AdjacencyGraph g){
		int i;
		
		for(i = 1; i <= g.nvertices; i++){
			g.processed[i] = false;
			g.discovered[i] = false;
			g.parent[i] = AdjacencyGraph.NIL;
			g.distance[i] = -2;
			g.finishTime[i] = -3;
		}
	}
	
	public boolean valid_edge(int v){
		return v == 0 ? false : true;
	}
	
	public void process_edge(int x, int y){
		out.println("Process edge ("+x+","+y+")");
	}
	
	public void process_vertex(int v){
		out.println("Process vertex: "+ v);
	}
}
