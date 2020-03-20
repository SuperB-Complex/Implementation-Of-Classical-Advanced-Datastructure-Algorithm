package solution;

public class InOrderIterativeTraversal implements Traversal  {
	public String traversal(Node root) {
		StringBuilder result = new StringBuilder();
		this.helper(root, result);
		return result.toString();
	}
	
	private void helper(Node current, StringBuilder stringBuilder) {
		if (current != null) {
			helper(current.getLeft(), stringBuilder);
			stringBuilder.append(current.getName());
			helper(current.getRight(), stringBuilder);
		}
	}
}
