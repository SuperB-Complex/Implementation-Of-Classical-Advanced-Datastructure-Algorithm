package solution;

public class PreOrderIterativeTraversal implements Traversal  {
	public String traversal(Node root) {
		StringBuilder result = new StringBuilder();
		this.helper(root, result);
		return result.toString();
	}
	
	private void helper(Node current, StringBuilder stringBuilder) {
		if (current != null) {
			// System.out.println("inside PreOrderIterativeTraversal helper " + current);
			stringBuilder.append(current.getName());
			helper(current.getLeft(), stringBuilder);
			helper(current.getRight(), stringBuilder);
		}
	}
}
