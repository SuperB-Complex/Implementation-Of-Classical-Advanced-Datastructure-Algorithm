package solution;

public class MorrisInOrderTraversal implements Traversal {
	public String traversal(Node root) {
		StringBuilder result = new StringBuilder();
		Node prev = null;
		while (root != null) {
			if (root.getLeft() == null) {
				result.append(root.getName());
				root = root.getRight();
			} else {
				prev = root.getLeft();
				while (prev.getRight() != null && prev.getRight() != root) {
					prev = prev.getRight();
				}
				if (prev.getRight() == null) {
					prev.setRight(root);
					root = root.getLeft();
				} else {
					prev.setRight(null);
					result.append(root.getName());
					root = root.getRight();
				}
			}
		}
		return result.toString();
	}
}
