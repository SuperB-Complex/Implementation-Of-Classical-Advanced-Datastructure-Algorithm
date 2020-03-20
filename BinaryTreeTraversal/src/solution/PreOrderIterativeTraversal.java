package solution;

public class PreOrderIterativeTraversal implements Traversal  {
	
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
		this.helper(root, result);
		return result.toString();
	}
	
	private void helper(Node current, StringBuilder stringBuilder) {
		if (current != null) {
			stringBuilder.append(current.getName());
			helper(current.getLeft(), stringBuilder);
			helper(current.getRight(), stringBuilder);
		}
	}
}
