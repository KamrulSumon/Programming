package com.sumon.prog.binarytree;

class Node {

	int key;
	String name;
	int data;
	int height;
	int size;

	Node leftChild;
	Node rightChild;

	// create new node and set the value to this new node
	public static Node createNode(int data) {
		Node node = new Node(); // new node
		// set all the values
		node.leftChild = null;
		node.rightChild = null;
		node.data = data;
		node.height = 1;
		node.size = 1;

		return node;
	}

	public String toString() {
		return "";
	}

}

class BinaryTree {

	// Add a new node to an binary tree
	public Node addNode(int data, Node head) {
		// assign the head reference to a new variable
		Node root = head;
		// Create New node
		Node newNode = Node.createNode(data);
		// If tree is empty, this is the first node and head point to this node
		if (head == null) {
			head = newNode;
			return head;
		}

		Node focusNode = null;
		// Check where to add new node, if a tree already exist
		while (head != null) {

			focusNode = head;

			if (head.data < newNode.data) {
				head = head.rightChild;
			} else {
				head = head.leftChild;
			}
		}

		// Assign new node in proper place
		if (focusNode.data < newNode.data) {
			focusNode.rightChild = newNode;
		} else {
			focusNode.leftChild = newNode;
		}

		return root;
	} // end of addNode()

	// In-Order Traversal of Tree
	public void inOrderTraversalOfTree(Node focusNode) {

		if (focusNode != null) {
			// Traverse the left node
			inOrderTraversalOfTree(focusNode.leftChild);
			// Print the value of currently focus node
			System.out.print(focusNode.data + " ");
			// Traverse the right node
			inOrderTraversalOfTree(focusNode.rightChild);
		}
	} // end of inOrderTraversalOfTree

	// Pre-Order Traversal of Tree
	public void preOrderTraversalOfTree(Node focusNode) {

		if (focusNode != null) {
			// Print the value of currently focus node
			System.out.print(focusNode.data + " ");
			// Traverse the left node
			preOrderTraversalOfTree(focusNode.leftChild);
			// Traverse the right node
			preOrderTraversalOfTree(focusNode.rightChild);
		}
	} // end of preOrderTraversalOfTree

	// Pre-Order Traversal of Tree
	public void postOrderTraversalOfTree(Node focusNode) {

		if (focusNode != null) {
			// Traverse the left node
			postOrderTraversalOfTree(focusNode.leftChild);
			// Traverse the right node
			postOrderTraversalOfTree(focusNode.rightChild);
			// Print the value of currently focus node
			System.out.print(focusNode.data + " ");

		}
	} // end of preOrderTraversalOfTree
	
	//Find height of a Tree
	public int findHeight(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight  = findHeight(root.leftChild);
        int rightHeight = findHeight(root.rightChild);
        return Math.max(leftHeight, rightHeight) + 1;
    }
	
	
	public Node findNode(int data, Node head){
		
		Node focusNode = head;
		
		while(focusNode.data != data){
			
			if( data < focusNode.data ){
			   focusNode = focusNode.leftChild;
			}else{
				focusNode = focusNode.rightChild;
			}
			
			if( focusNode == null) return null;
		}
		
		return focusNode;
	}
	

}

public class BinaryTreeImp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		Node head = null;

		// head = bt.addNode(5, head);
		head = bt.addNode(10, head);
		head = bt.addNode(15, head);
		head = bt.addNode(15, head);
		head = bt.addNode(27, head);
		head = bt.addNode(29, head);
		head = bt.addNode(20, head);
		head = bt.addNode(-10, head);
		head = bt.addNode(21, head);
	    head = bt.addNode(35, head);
		head = bt.addNode(45, head);
		System.out.println("In-Order:");
		bt.inOrderTraversalOfTree(head);
		System.out.println("\nPre-Order:");
		bt.preOrderTraversalOfTree(head);
		System.out.println("\nPost-Order:");
		bt.postOrderTraversalOfTree(head);
	}

}
