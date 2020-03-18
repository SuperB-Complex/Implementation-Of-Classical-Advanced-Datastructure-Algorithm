package solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MyHuffmanTreeWithPriorityQueue {
	private Node root;
	private Map<String, Character> codeBook;
	
	public MyHuffmanTreeWithPriorityQueue(Map<Character, Integer> input) {
		this.buildMyHuffmanTree(input);
	}
	
	private void buildMyHuffmanTree(Map<Character, Integer> input) {
		// input should be a map contaning {charcter:frequency}
		if (input == null || input.size() == 0) {
			throw new IllegalArgumentException();
		}
		PriorityQueue<Node> queue = new PriorityQueue<Node> (
			new Comparator<Node> () {
				@Override
				public int compare(Node node1, Node node2) {
					return node1.getName() - node2.getName();
				}
		});
		for (Map.Entry<Character, Integer> entry : input.entrySet()) {
			queue.offer(new Node(entry.getValue(), entry.getKey(), null, null));
		}
		while(!queue.isEmpty()) {
			Node leftNode = queue.poll();
			if (queue.isEmpty()) {
				this.root = leftNode;
				break;
			}
			Node rightNode = queue.poll();
			System.out.println(leftNode + "  " + rightNode);
			Integer parent = leftNode.getName() + rightNode.getName();
			queue.offer(new Node(parent, null, leftNode, rightNode));
		}
	}
	
	public Map<Character, String> encodeList() {
		Map<Character, String> result = new HashMap<> ();
		helper(new StringBuilder(), this.root, result);
		this.codeBook = this.reverse(result);
		return result;
	}

	private Map<String, Character> reverse(Map<Character, String> input) {
		Map<String, Character> result = new HashMap<String, Character> ();
		for(Map.Entry<Character, String> entry : input.entrySet()) {
			result.put(entry.getValue(), entry.getKey());
		}
		return result;
	}
	
	private void helper(StringBuilder code, Node current, Map<Character, String> result) {
		if (current.getLeft() == null && current.getRight() == null) {
			result.put(current.getCharName(), code.toString());
			return;
		}
		code.append("0");
		helper(code, current.getLeft(), result);
		code.deleteCharAt(code.length() - 1);
		
		code.append("1");
		helper(code, current.getRight(), result);
		code.deleteCharAt(code.length() - 1);
	}
	
	public Character decode(String input) {
		if (!this.codeBook.containsKey(input)) {
			throw new IllegalArgumentException();
		}
		return this.codeBook.get(input);
	}
}
