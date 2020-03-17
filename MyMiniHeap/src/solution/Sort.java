package solution;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import util.LinkedListFactory;

public class Sort {
	
	/*
	 * Assuming that the input size can fit the size of memory.
	 * 
	 * N is the number of all elements;
	 *
	 * time complexity:
	 * Put all element into an array. => O(N)
	 * Build MiniHeap. => O(N)
	 * Sort MiniHeap. => O(NlogN)
	 *  popMini method => O(logN)
	 * 	calling N times
	 * 
	 * space complexity:
	 * N
	 *
	 * */
	public List<Integer> sortAll(List<List<Integer>> lists) {
		// assuming inputs are k sorted linked lists in a list array
		int length = 0;
		for (int i = 0; i < lists.size(); i++) {
			length += lists.get(i).size();
		}
		int[] arr = new int[length];
		int mark = 0;
		for (int i = 0; i < lists.size(); i++) {
			for (int j = 0; j < lists.get(i).size(); j++) {
				arr[mark++] = lists.get(i).get(j);
			}
		}
		MyMiniHeap myMiniHeap = new MyMiniHeap(arr);
		List<Integer> result = myMiniHeap.sort();
		return result;
	}
}
