package com.sumon.tree;

/**
 * Create a minimal height binary tree from a sorted array
 * @author Kamrul Hasan
 * @Ref- Cracking the coding interview 4.2
 */

/* Tree node */
class TreeNode {
	public int data;
	public TreeNode left, right, parent;

	public TreeNode(int data) {
		this.data = data;
	}
}

/* create minimal height binary tree */
class MinimalHeightBinarySearchTreeImpl {

	/* create minimal height binary tree */
	public TreeNode createMinimalBST(int[] values) {
		return createMinimalBST(values, 0, values.length - 1);
	}
	/* recursivly create minimal height binary tree */
	private TreeNode createMinimalBST(int[] values, int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(values[mid]);
		node.left = createMinimalBST(values, start, mid - 1);
		node.right = createMinimalBST(values, mid + 1, end);
		return node;
	}

	// In-Order Traversal of Tree
	public void inOrderTraversalOfTree(TreeNode node) {

		if (node != null) {
			// Traverse the left node
			inOrderTraversalOfTree(node.left);
			// Print the value of currently focus node
			System.out.print(node.data + " ");
			// Traverse the right node
			inOrderTraversalOfTree(node.right);
		}
	} // end of inOrderTraversalOfTree

	// Find height of a Tree
	public int findHeight(TreeNode root) {
		if (root == null) {
			return -1;
		}

		int leftHeight = findHeight(root.left);
		int rightHeight = findHeight(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}

}

/* Driver class */
public class MinimalHeightBinarySearchTree {

	public static void main(String[] args) {
		int[] values = { 3, 5, 7, 8, 9, 12, 15 };
		MinimalHeightBinarySearchTreeImpl mhbt = new MinimalHeightBinarySearchTreeImpl();
		TreeNode root = mhbt.createMinimalBST(values);
		mhbt.inOrderTraversalOfTree(root);
		System.out.println();
		System.out.println(mhbt.findHeight(root));
	}

}
