package com.sumon.carrercup;

import java.util.HashMap;
import java.util.Map;

/**
 * Find a connection between two city using disjoint set
 * 
 * @author Kamrul Hasan
 * @ref Carrer cup Amazon interview section
 */
class CityPlannerImpl {

	private Map<Long, Node> map = new HashMap<>();

	class Node {
		long value;
		Node parent;
		long rank;
	}

	public void make_set(long data) {
		Node node = new Node();
		node.value = data;
		node.parent = node;
		node.rank = 0;
		map.put(data, node);
	}

	/* merge two set */
	public void make_union(long x, long y) {

		Node xnode = map.get(x);
		Node ynode = map.get(y);

		Node xRepresentNode = findTheRepresentingNode(xnode);
		Node yRepresentNode = findTheRepresentingNode(ynode);
		// if both represent the same then do nothing
		if (xRepresentNode == yRepresentNode)
			return;

		if (xRepresentNode.rank < yRepresentNode.rank)
			xRepresentNode.parent = yRepresentNode;
		else if (xRepresentNode.rank > yRepresentNode.rank)
			yRepresentNode.parent = xRepresentNode;
		else {
			yRepresentNode.parent = xRepresentNode;
			xRepresentNode.rank = xRepresentNode.rank + 1;
		}

	}

	/*
	 * Find the representing node of the given node also do the path compression
	 */
	Node findTheRepresentingNode(Node xnode) {
		if (xnode.parent != xnode) {
			xnode.parent = findTheRepresentingNode(xnode.parent);
		}

		return xnode.parent;
	}

	/* Find the representing node of the given value */
	long findTheRepresentingNode(long value) {
		Node n = findTheRepresentingNode(map.get(value));
		return n.value;
	}

	/* build the road */
	public void buildRoad(long a, long b) {
		Node node1 = map.get(a);
		Node node2 = map.get(b);
		if (node1 == null) {
			make_set(a);
		}

		if (node2 == null) {
			make_set(b);
		}
		make_union(a, b);
	}

	/* checking if there is a connection between two nodes */
	public boolean isRoadExist(long a, long b) {

		long parent1 = findTheRepresentingNode(a);
		long parent2 = findTheRepresentingNode(b);
		return parent1 == parent2;
	}

}

public class CityPlanner {

	public static void main(String[] args) {

		CityPlannerImpl dset = new CityPlannerImpl();

		dset.buildRoad(90, 80);
		dset.buildRoad(70, 60);
		dset.buildRoad(50, 40);
		dset.buildRoad(20, 10);
		dset.buildRoad(80, 10);

		System.out.println(dset.isRoadExist(80, 10));
		System.out.println(dset.isRoadExist(60, 50));
		System.out.println(dset.isRoadExist(90, 20));
		System.out.println(dset.isRoadExist(10, 40));

	}

}