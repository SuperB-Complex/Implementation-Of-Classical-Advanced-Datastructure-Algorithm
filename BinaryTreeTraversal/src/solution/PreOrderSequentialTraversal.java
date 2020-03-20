package solution;

import java.util.Stack;

public class PreOrderSequentialTraversal implements Traversal  {
	
	@Override
	public String traversal(Node root) {
		/*
		 * using a stack to store state of nodes along the way
		 * 
		 * N is the number of nodes in a binary tree
		 * 
		 * time complexity: O(N)
		 * 
		 * space complexity: O(N)
		 * */
		
		Stack<Node> stack = new Stack<> ();
		StringBuilder stringBuilder = new StringBuilder();
		
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stringBuilder.append(root.getName());
				stack.push(root);
				root = root.getLeft();
			} else {
				root = stack.pop();
				root = root.getRight();
			}
		}
		return stringBuilder.toString();
	}
}
