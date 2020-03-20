package solution;

import java.util.Stack;

public class PostOrderSequentialTraversal implements Traversal {
	public String traversal(Node root) {
		StringBuilder result = new StringBuilder();
		Stack<Node> stack = new Stack<> ();
		Node prev = null;
		while (root != null) {
			stack.push(root);
			root = root.getLeft();
			
		}
		while (!stack.isEmpty()) {
			root = stack.pop();
			if (root.getRight() == null || root.getRight() == prev) {
				result.append(root.getName());
				prev = root;
			} else {
				stack.push(root);
				root = root.getRight();
				while (root != null) {
					stack.push(root);
					root = root.getLeft();
					
				}
			}
		}
		return result.toString();
	}
}
