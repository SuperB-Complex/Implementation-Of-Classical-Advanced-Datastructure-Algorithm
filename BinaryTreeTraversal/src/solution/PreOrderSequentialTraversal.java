package solution;

import java.util.Stack;

public class PreOrderSequentialTraversal implements Traversal  {
	public String traversal(Node root) {
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
