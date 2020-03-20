package solution;

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
