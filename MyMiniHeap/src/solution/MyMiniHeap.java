package solution;

import java.util.LinkedList;
import java.util.List;

public class MyMiniHeap {
	private int[] arr;
	private int length;
	
	public MyMiniHeap(int[] arr) {
		this.arr = arr;
		this.length = arr.length;
		this.buildMyMiniHeap();
	}
	
	public List<Integer> sort() {
		List<Integer> result = new LinkedList<> ();
		while (!this.isEmpty()) {
			result.add(this.popMini());
		}
		return result;
	}
	
	private boolean isEmpty() {
		// should be called before popMini()
		if (this.length == 0) {
			return true;
		}
		return false;
	}
	
	public int popMini() {
		int lastIndex = this.length - 1;
		int result = this.arr[0];
		this.swap(0, lastIndex);
		--this.length;
		this.sink(0);
		return result;
	}
	
	private void buildMyMiniHeap() {
		for (int i = this.arr.length / 2; i > -1; i--) {
			this.sink(i);
		}
	}
	
	private void sink(int index) {
		int sinkIndex = this.findMini(index);
		if (index != sinkIndex) {
			this.swap(index, sinkIndex);
			this.sink(sinkIndex);
		}
	}

	private int findMini(int index) {
		int result = index;
		int parent = this.arr[index];
		int leftIndex = this.leftChild(index);
		if (leftIndex < this.length && this.arr[leftIndex] < parent) {
			result = leftIndex;
			parent = this.arr[leftIndex];
		}
		int rightIndex = this.rightChild(index);
		if (rightIndex < this.length && this.arr[rightIndex] < parent) {
			result = rightIndex;
		}
		return result;
	}
	
	private void swap(int operator1, int operator2) {
		int temp = this.arr[operator1];
		this.arr[operator1] = this.arr[operator2];
		this.arr[operator2] = temp;
	}
	
	private int leftChild(int index) {
		return (index + 1) * 2 - 1;
	}
	
	private int rightChild(int index) {
		return (index + 1) * 2;
	}

}
