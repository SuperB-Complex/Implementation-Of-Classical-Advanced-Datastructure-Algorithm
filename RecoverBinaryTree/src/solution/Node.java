package solution;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
	private char name;
	private Node left;
	private Node right;
	
	public Node(char name) {
		this.name = name;
		this.left = null;
		this.right = null;
	}
	
	public char getName() {
		return this.name;
	}
	
	public Node getLeft() {
		return this.left;
	}
	
	public Node getRight() {
		return this.right;
	}
	
	public void setLeft(Node input) {
		this.left = input;
	}
	
	public void setRight(Node input) {
		this.right = input;
	}
	
	public static String serialize(Node input) {
		Queue<Node> queue = new LinkedList<> ();
		StringBuilder result = new StringBuilder();
		queue.add(input);
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			result.append(current == null ? " null" : (" " + current.getName()));
			if (current != null) {
				Node left = current.getLeft();
				queue.add(left == null ? null : left);
				Node right = current.getRight();
				queue.add(right == null ? null : right);
			}
		}
		return result.toString();
	}
		
	public String toString() {
		String base = "node_" + this.name;
		String append = "";
		if (this.left != null)
			append += (", its left is node_" + this.left.getName());
		if (this.right != null)
			append += (", its left is node_" + this.right.getName());
		return base + append;
	}
}
