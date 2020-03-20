package solution;

import java.util.Stack;

public class PostOrderSequentialTraversalVersionTwo implements Traversal {

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
		
		StringBuilder result = new StringBuilder();
		Stack<Node> stack = new Stack<> ();
		Node prev = null;
		
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.getLeft();
			} else {
				root = stack.pop();
				
				if (root.getRight() == null || root.getRight() == prev) {
					result.append(root.getName());
					prev = root;
					root = null;
				} else {
					stack.push(root);
					root = root.getRight();
					stack.push(root);
					root = root.getLeft();
				}
			}
		}
		return result.toString();
	}

}
