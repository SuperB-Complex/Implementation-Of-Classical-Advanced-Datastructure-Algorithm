package solution;

public class Node {
	private Integer name;
	private Character charName;
	private Node left;
	private Node right;
	
	public Node(Integer name, Character charName, Node left, Node right) {
		this.name = name;
		this.charName = charName;
		this.left = left;
		this.right = right;
	}

	public Node(Integer name, Character charName) {
		this(name, charName, null, null);
	}
	
	public String toString() {
		return "node " + this.charName;
	}
	
	public Integer getName() {
		return this.name;
	}
	
	public Node getLeft() {
		return this.left;
	}
	
	public Node getRight() {
		return this.right;
	}
	
	public Character getCharName() {
		return this.charName;
	}
}
