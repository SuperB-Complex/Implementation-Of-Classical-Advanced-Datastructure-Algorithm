package solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BinaryTree {
	private Node root;
	
	public BinaryTree() {
		
	}
	
	private void buildBinaryTree(Map<Character, List<Character>> root, Map<Character, List<Character>> input) {
		/* 
		 * if there is a link between two points, there will be an entry in this map type input
		 * the input is regardless in its order except the first one must be the root, but each 
		 * element should put its left child on 0th position, including null, and right child on 
		 * 1th position.
		 * 
		 */
		Map<Character, Node> points = new HashMap<> ();
		for (Map.Entry<Character, List<Character>> entry : root.entrySet()) {
			this.root = new Node(entry.getKey());
			points.put(entry.getKey(), this.root);
			List<Character> temp = entry.getValue();
			
			if (temp == null) {
				throw new IllegalArgumentException("there is only node in this binary tree not enough for traversal");
			}
			
			for (int i = 0; i < temp.size(); i++) {
				if (temp.get(i) != null) {
					Node child = new Node(temp.get(i));
					
					if (i == 0)
						this.root.setLeft(child);
					else if (i == 1) 
						this.root.setRight(child);
					
					points.put(temp.get(i), child);
				}
			}
		}
		for (Map.Entry<Character, List<Character>> entry : input.entrySet()) {
			Character key = entry.getKey();
			List<Character> value = entry.getValue();
			Node parent = new Node(entry.getKey());
			
			if (points.containsKey(key)) 
				parent = points.get(key);
			else
				points.put(entry.getKey(), parent);
			
			for (int i = 0; i < value.size(); i++) {
				if (value.get(i) != null) {
					Node child = new Node(value.get(i));
					
					if (points.containsKey(value.get(i))) {
						child = points.get(value.get(i));
					} else 
						points.put(value.get(i), child);
					
					if (i == 0)
						parent.setLeft(child);
					else if (i == 1) 
						parent.setRight(child);
				}
			}
		}
	}
	
	private Node getRoot() {
		return this.root;
	}
	
	public String[] traversal(Map<Character, List<Character>> root, Map<Character, List<Character>> input) {
		this.buildBinaryTree(root, input);
		
		Traversal[] instances = new Traversal[9];
		instances[0] = new PreOrderIterativeTraversal();
		instances[1] = new PreOrderSequentialTraversal();
		instances[2] = new InOrderIterativeTraversal();
		instances[3] = new InOrderSequentialTraversal();
		instances[4] = new PostOrderIterativeTraversal();
		instances[5] = new PostOrderSequentialTraversalVersionOne();
		instances[6] = new LevelOrderTraversal();
		instances[7] = new MorrisInOrderTraversal();
		instances[8] = new PostOrderSequentialTraversalVersionTwo();
		String[] result = new String[instances.length];
		
		for (int i = 0; i < instances.length; i++) {
			result[i] = instances[i].traversal(this.getRoot());
		}
		
		return result;
	}
}
