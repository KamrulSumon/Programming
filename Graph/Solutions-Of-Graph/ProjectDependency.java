package com.sumon.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
/**
 * Find the build order of projects where one project depends on other project. 
 * This algorithm use a DFS technique that is called Topological sort
 * @author Kamrul Hasan
 * @ref Cracking the coding interview Graphh 4.7
 */

/* class project */
class Project {
	public enum State{UnVisisted, Visiting, Visisted};   // sate of node
	private ArrayList<Project> childerns = new ArrayList<>();  // childerens of node
	private HashMap<String, Project> map = new HashMap<>();  // hold name -> node maping
	private String name;  // node name
	private int dependencies = 0;  // number of dependencies
	private State state = State.UnVisisted;  // initially state is unvisited

	public Project(String name) {
		this.name = name;
	}
	/* add neighbor */
	public void addNeighbor(Project pro){
		if(!map.containsKey(pro.getName())){
			childerns.add(pro);
			pro.incrementDependencies(); 
			map.put(pro.getName(), pro);
		}
	}
	
	/* increment neighbor */
	public void incrementDependencies(){
		dependencies++;
	}
	
	/* decrement neighbor */
	public void decrementDependencies(){
		dependencies--;
	}
	/* get name of the node */
	public String getName(){
		return name;
	}
	/* returns list of childrens of node */
	public ArrayList<Project> getChilders(){
		return childerns;
	}
	/* returns number of dependencies */
	public int getNumberOfDependencies(){
		return dependencies;
	}
	/* retunrs state */
	public State getState(){
		return state;
	}
	/* set the state of node */
	public void setState(State st){
		state = st;
	}
}

/* class graph that create a graph */
class Graph {
	private ArrayList<Project> nodes = new ArrayList<>();
	private HashMap<String, Project> map = new HashMap<>();

	/* create a new node if not exist otherwise return existing node */
	public Project getOrCreateNode(String name) {
		if (!map.containsKey(name)) {
			Project pro = new Project(name);
			nodes.add(pro);
			map.put(name, pro);
		}
		return map.get(name);
	}
	/* add edge between two nodes */
	public void addEdge(String startName, String endName){
		Project start = getOrCreateNode(startName);
		Project end = getOrCreateNode(endName);
		start.addNeighbor(end);
	}
	/* returns number of nodes in graph */
	public ArrayList<Project> getNodes(){
		return nodes;
	}
	
	/* Returns adjacency list representation of the graph */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getNodes().size() + " vertices, edges \n");
		for (Project pro : getNodes()) {
			sb.append(pro.getName() + ": "); 
			for (Project child : pro.getChilders()) {
				sb.append(child.getName() + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}

class ProjectDependencyImpl{
	
	public Stack<Project> findBuildOrder(String[] projects, String[][] dependencies){
		Graph graph = buildGraph(projects, dependencies);
		return orderProjects(graph.getNodes());
	}
	
	public Graph buildGraph(String[] projects, String[][] dependencies){
		Graph graph = new Graph();
		
		for(String project : projects){
			graph.getOrCreateNode(project);
		}
		
		for(String[] dependency : dependencies){
			String frist = dependency[0];
			String second = dependency[1];
			graph.addEdge(frist, second);
		}
		return graph;
	}
	
	public Stack<Project> orderProjects(ArrayList<Project> projects){
		Stack<Project> stack = new Stack<>();
		
		for(Project project : projects){
			if(project.getState() == Project.State.UnVisisted){
				if(!doDFSVisit(project, stack)){
					return null;
				}
			}
		}
		return stack;
	}
	
	public boolean doDFSVisit(Project project, Stack<Project> stack){
		
		// cycle checking
		if(project.getState() == Project.State.Visiting){
			return false;
		}
		
		if(project.getState() == Project.State.UnVisisted){
			project.setState(Project.State.Visiting);
			ArrayList<Project> childrens = project.getChilders();
			for(Project child : childrens){
				if(!doDFSVisit(child, stack)){
					return false;
				}
			}
			
			project.setState(Project.State.Visisted);
			stack.push(project);
		}
		
		return true;
	}
}


public class ProjectDependency {

	public static void main(String[] args) {
	
		ProjectDependencyImpl pd = new ProjectDependencyImpl();
		
		Project a = new Project("a");
		Project b = new Project("b");
		Project c = new Project("c");
		Project d = new Project("d");
		Project e = new Project("e");
		Project f = new Project("f");
		
		String[] projects = {"a","b","c","d","e","f"};
		String[][] dependencies = {{"d", "a"}, {"d", "a"}, {"b", "f"}, {"d", "b"}, {"a", "f"}, {"c", "d"}};
		
		Stack<Project> order = pd.findBuildOrder(projects, dependencies);
		while(!order.isEmpty()) System.out.println(order.pop().getName());
		
	}

}
