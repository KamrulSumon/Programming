package com.sumon.java;

/**
 * Demonstration of Inner class(Member, static/Nested, Anonymous)
 * 
 * @author Kamrul Hasan
 *
 */
interface Phone {
	void display();
}

/* Node class */
class TreeNode {
	// member class
	class Node {
	}

	// static/nested class
	static class Node2 {

	}

	public void show() {
	}
}

class InnerClassInJava {
	public static void main(String[] args) {
		TreeNode tn = new TreeNode(); // create TreeNode.clss
		// Node nd = new Node(); // can't create

		// member inner class
		TreeNode.Node inObj = tn.new Node(); // creating object of member class,
												// TreeNode$Node.class

		// static inner class
		TreeNode.Node2 staticObj = new TreeNode.Node2(); // creating static
															// object

		// anonymous inner class
		TreeNode anoObj = new TreeNode() {
			public void show2() {

			}
		};
	}

	Phone p = new Phone() {
		public void display() {
			System.out.println("Phone, me");
		}
	};

}
