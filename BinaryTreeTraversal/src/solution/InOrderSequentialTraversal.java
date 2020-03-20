package solution;

import java.util.Stack;

public class InOrderSequentialTraversal implements Traversal  {
	public String traversal(Node root) {
		StringBuilder result = new StringBuilder();
		Stack<Node> stack = new Stack<> ();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.getLeft();
			} else {
				root = stack.pop();
				result.append(root.getName());
				root = root.getRight();
			}
		}
		return result.toString();
	}
}
