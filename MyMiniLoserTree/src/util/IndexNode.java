package util;

public class IndexNode {
	private int originalIndex;
	private int currentIndex;
	private int peerIndex;
	
	public IndexNode(int originalIndex, int currentIndex, int peerIndex) {
		this.originalIndex = originalIndex;
		this.currentIndex = currentIndex;
		this.peerIndex = peerIndex;
	}
	
	public IndexNode(int originalIndex, int currentIndex) {
		this(originalIndex, currentIndex, -1);
	}
	
	public void setOriginalIndex(int input) {
		this.originalIndex = input;
	}
	
	public int getOriginalIndex() {
		return this.originalIndex;
	}
	
	public int getCurrentIndex() {
		return this.currentIndex;
	}
	
	public void setPeerIndex(int input) {
		this.peerIndex = input;
	}
	
	public int getPeerIndex() {
		return this.peerIndex;
	}

	public boolean isEnd() {
		return this.originalIndex == -1 ? true : false;
	}
	
	public String toString() {
		return ("originalIndex=" + this.originalIndex + " currentIndex=" + this.currentIndex + " peerIndex=" + this.peerIndex);
	}
	
}
