package solution;

public class MorrisInOrderTraversal implements Traversal {
	
	@Override
	public String traversal(Node root) {
		/*
		 * using right node of leaf node in a binary tree to reduce extra space
		 * 
		 * N is the number of nodes in a binary tree
		 * 
		 * time complexity: O(N)
		 * 
		 * space complexity: O(1)
		 * */
		
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
