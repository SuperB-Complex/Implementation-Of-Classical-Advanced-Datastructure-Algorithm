package solution;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal implements Traversal  {
	
	@Override
	public String traversal(Node root) {
		/*
		 * using a queue to store order of nodes along the way
		 * 
		 * N is the number of nodes in a binary tree
		 * 
		 * time complexity: O(N)
		 * 
		 * space complexity: O(N)
		 * */
		
		StringBuilder result = new StringBuilder();
		Queue<Node> queue = new LinkedList<> ();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			result.append(current.getName());
			
			if (current.getLeft() != null) 
				queue.add(current.getLeft());
			
			if (current.getRight() != null)
				queue.add(current.getRight());
		}
		
		return result.toString();
	}
}
