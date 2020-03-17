package solution;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import util.IndexNode;

public class MyMiniLoserTree {
	private List<Iterator<Integer>> channel;
	private IndexNode[] container;
	private Integer[] buffer;
	private int totalLength;
	private int depth;
	private LinkedList<Integer> result;
	
	public MyMiniLoserTree(List<Iterator<Integer>> iterators) {
		this.depth = this.makeUp(iterators);
		this.channel = iterators;
		this.container = new IndexNode[this.totalLength];
		this.buffer = new Integer[this.channel.size()];
		this.result = new LinkedList<> ();
	}

	private int makeUp(List<Iterator<Integer>> input) {
		int length = input.size();
		int depth = 0;
		int number = 0;
		
		while (Math.pow(2, depth) < length) {
			number += (int) Math.pow(2, depth);
			++depth;
		}
		
		number += (int) Math.pow(2, depth);
		this.setTotalLength(number);
		
		int generatingLength = (int) Math.pow(2, depth) - length;
		for (int i = 0 ; i < generatingLength; i++) 
			input.add(input.get(0));
		return depth;
	}
	
	private int getStartIndex() {
		return (int) Math.pow(2, this.depth) - 1;
	}
	
	private void initiate() {
		int start = this.getStartIndex();
		for (int i =0; i < this.buffer.length; i++) {
			try{
				this.initiatePer(this.channel.get(i), i);
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException();
			} 
			if (this.buffer[i] == Integer.MAX_VALUE) 
				this.container[start + i] = new IndexNode(-1, start + i, -1);
			else
				this.container[start + i] = new IndexNode(i, start + i, -1);
		}
	}
	
	private void initiatePer(Iterator<Integer> iterator, int input) throws IllegalArgumentException {
		if (iterator.hasNext()) 
			this.buffer[input] = (Integer)iterator.next();
		else 
			throw new IllegalArgumentException();
	}
	
	private void initiatePer(Iterator<Integer> iterator, int input1, int input2) {
		try {
			this.initiatePer(iterator, input1);
		} catch (IllegalArgumentException e) {
			this.buffer[input1] = Integer.MAX_VALUE;
			this.container[input2].setOriginalIndex(-1);
		}
	}
	
	private void bubbleUp() {
		for (int i = this.depth; i > 0; i--) {
			int base = (int) Math.pow(2, i) - 1;
			int size = base + 1;
			for (int j = 0; j < size; ) {
				int parent = this.parentIndex(base + j);
				if (parent < 0) 
					return;
				
				IndexNode newIndexNode = new IndexNode(Integer.MIN_VALUE, parent, Integer.MIN_VALUE);
				
				IndexNode leftPair = this.container[base + j];
				++j;
				IndexNode rightPair = this.container[base + j];
				++j;

				int leftPeer = leftPair.getPeerIndex();
				int rightPeer = rightPair.getPeerIndex();
				int leftOriginal = leftPair.getOriginalIndex();
				int rightOriginal = rightPair.getOriginalIndex();
				
				int origin = rightPeer;
				int peer = leftPeer;
				if (leftPeer > -1 && rightPeer > -1) {
					if (this.buffer[leftPeer] > this.buffer[rightPeer]) {
						origin = leftPeer;
						peer = rightPeer;
					}
					
				} else {
					origin = rightOriginal;
					peer = leftOriginal;
					if (this.buffer[leftOriginal] > this.buffer[rightOriginal]) {
						origin = leftOriginal;
						peer = rightOriginal;
					}
				}
				newIndexNode.setOriginalIndex(origin);
				newIndexNode.setPeerIndex(peer);
				this.container[parent] = newIndexNode;
			}
		}
	}
	
	private int parentIndex(int input) {
		if (input % 2 == 0) 
			return ((input - 1) >> 1);
		else 
			return (input >> 1);
	}

	private void setTotalLength(int input) {
		this.totalLength = input;
	}
	
	private void buildMyLoserTree() {
		try {
			this.initiate();
		} catch (Exception e) {
			System.out.println("by initiate " + e);
		}
		try {
			this.bubbleUp();
		} catch (Exception e) {
			System.out.println("by bubbleUp " + e);
		}

	}
	
	private IndexNode pop() {
		return this.container[0];
	}
	
	private void push(int input, int base) {
		this.initiatePer(this.channel.get(input), input, base + input);
	}
	
	private void adjustPer(IndexNode node, int input) {
		int oldOriginalIndex = node.getOriginalIndex();
		if (this.buffer[oldOriginalIndex] < this.buffer[input]) {
			node.setOriginalIndex(input);
			node.setPeerIndex(oldOriginalIndex);
		} else {
			node.setPeerIndex(input);
		}
	}
	
	private void adjust(int input, int base) {
		IndexNode parent = this.container[this.parentIndex(input + base)];
		while(parent.getCurrentIndex() != 0) {
			this.adjustPer(parent, input);
			input = parent.getPeerIndex();
			parent = this.container[this.parentIndex(parent.getCurrentIndex())];
		}
		this.adjustPer(parent, input);
	}
	
	private void update() {
		int start = this.getStartIndex();
		while (!this.checkEnd(start)) {
			IndexNode miniNode = this.pop();
			int miniIndex = miniNode.getPeerIndex();
			this.result.add(this.buffer[miniIndex]);
			this.push(miniIndex, start);
			this.adjust(miniIndex, start);
		}
	}
	
	private boolean checkEnd(int input) {
		for (int i = input; i < this.totalLength; i++) 
			if (!this.container[i].isEnd()) 
				return false;
		return true;
	}
	
	public LinkedList<Integer> sort() {
		this.buildMyLoserTree();
		this.update();
	    return this.result;
	}
}
