package solution;

public class MyBinaryIndexTree {
	// binary indexed tree starts from index 1s
	private int[] storage;
	private int length;
	
	public MyBinaryIndexTree(int[] storage, int length) {
		this.storage = storage;
		this.length = length + 1;
	}
	
	private int lowBit(int input) {
		return input & (-input);
	}
	
	public void buildTree() {
		for (int i = 1; i < this.length; i++) {
			int j = i;
			int temp = 0;
			while (j > 0) {
				temp += this.storage[j];
				j -= this.lowBit(i);
			}
			this.storage[i] = temp;
		}
	}
	
	public void bubbleUp(int input1, int input2) {
		int difference = input2 - this.storage[input1];
		while (input1 < length) {
			this.storage[input1] += difference;
			input1 += this.lowBit(input1);
		}
	}
	
	public int queryRangeSum(int input) {
		// return sum from index 1 to index input
		int result = 0; 
		while (input > 0) {
			result += this.storage[input];
			input -= lowBit(input);
		}
		return result;
	}
	
	public int queryRangeSum(int input1, int input2) {
		// return sum from range[input, input2]
		int result1 = this.queryRangeSum(input1);
		int result2 = this.queryRangeSum(input2);
		return result2 - result1;
	}
}
