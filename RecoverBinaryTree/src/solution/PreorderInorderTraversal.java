package solution;

public class PreorderInorderTraversal implements Recovery {

	@Override
	public String recover(String input1, String input2) {
		// the first parameter should be preorder traversal
		Node root = this.helper(0, input1.length() - 1, 0, input2.length() - 1, input1, input2);
		String result = Node.serialize(root);
		return result;
	}
	
	private Node helper(int rootStart, int rootEnd, int normalStart, int normalEnd, String input1, String input2) {
		if (rootStart > rootEnd || normalStart > normalEnd) {
			return null;
		}
		
		Node root = new Node(input1.charAt(rootStart));
		if (normalStart == normalEnd || rootStart == rootEnd) {
			return root;
		}
		for (int i = normalStart; i <= normalEnd; i++) {
			if (input1.charAt(rootStart) == input2.charAt(i)) {
				root.setLeft(helper(rootStart + 1, rootStart + i - normalStart, normalStart, i - 1, input1, input2));
				root.setRight(helper(rootStart + i -normalStart + 1, rootEnd, i + 1, normalEnd, input1, input2));
			}
		}
		return root;
	}
}
