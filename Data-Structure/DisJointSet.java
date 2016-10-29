package com.sumon.disjointset;

import java.util.HashMap;
import java.util.Map;

public class DisJointSet {
	
	
	private Map< Long, Node> map = new HashMap<>();
	
	class Node{
		long value;
		Node parent;
		long rank;
	}
	
	public void make_set(long data){
		Node node = new Node();
		node.value = data;
		node.parent = node;
		node.rank = 0;
		map.put(data, node);
	}
	
	
	public void make_union(long x, long y){
		
		Node xnode = map.get(x);
		Node ynode = map.get(y);
		
		Node xRepresentNode = findTheRepresentingNode(xnode);
		Node yRepresentNode = findTheRepresentingNode(ynode);
		
		if(xRepresentNode == yRepresentNode) return;
		
		if(xRepresentNode.rank < yRepresentNode.rank )
			xRepresentNode.parent = yRepresentNode;
		else if(xRepresentNode.rank > yRepresentNode.rank)
			yRepresentNode.parent = xRepresentNode;
		else
		{
			yRepresentNode.parent = xRepresentNode;
			xRepresentNode.rank = xRepresentNode.rank + 1;
		}
		
	}
	
	Node findTheRepresentingNode(Node xnode){
		if(xnode.parent != xnode){
			xnode.parent = findTheRepresentingNode(xnode.parent);
		}
		
		return xnode.parent;
	}
	
	long findTheRepresentingNode(long value){
	  Node n =	findTheRepresentingNode(map.get(value));
	  return n.value;
	}
	
	

	public static void main(String[] args) {

		DisJointSet dset = new DisJointSet();
		dset.make_set(90);
		dset.make_set(80);
		dset.make_set(70);
		dset.make_set(60);
		dset.make_set(50);
		dset.make_set(40);
		dset.make_set(20);
		dset.make_set(10);
		dset.make_set(5);
		
		dset.make_union(90, 80);
		dset.make_union(70, 60);
		dset.make_union(50, 40);
		dset.make_union(20, 10);
		
		System.out.println(dset.findTheRepresentingNode(80));
		System.out.println(dset.findTheRepresentingNode(60));
		System.out.println(dset.findTheRepresentingNode(70));
		System.out.println(dset.findTheRepresentingNode(10));
		System.out.println(dset.findTheRepresentingNode(5));

	}

}
