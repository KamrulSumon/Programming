package com.sumon.leetcode;
/**
 * Inorder Traversal of Tree using stack and recursion
 * @author Kamrul Hasan
 * @source LeetCode #94
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* Tree Node */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class InorderTraversal {
	List<Integer> list = new ArrayList<>();

	/* inorder traversal of tree using recursion */
	public List<Integer> inorderTraversal(TreeNode root) {
		if (root != null) {
			inorderTraversal(root.left);
			list.add(root.val);
			inorderTraversal(root.right);
		}
		return list;
	}

	/* inorder traversal of tree using stack */
	public List<Integer> inorderTraversal2(TreeNode root) {
		Stack<TreeNode> stk = new Stack<>();
		if (root == null)
			return list;

		TreeNode currNode = root;

		while (!stk.isEmpty() || currNode != null) {
			if (currNode != null) {
				stk.push(currNode);
				currNode = currNode.left;
			} else {
				TreeNode t = stk.pop();
				list.add(t.val);
				currNode = t.right;
			}
		}
		return list;
	}
}
