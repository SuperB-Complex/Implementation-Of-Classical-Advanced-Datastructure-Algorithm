package solution;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import util.LinkedListFactory;

public class Sort {

	/*
	 * Assuming that the input size can not fit the size of memory.
	 * The input can be upgraded into file handlers if needed.
	 * 
	 * N is the number of inputing lists;
	 * M is the number of all elements;
	 * 
	 * time complexity:
	 * Initiate class MyMiniLoserTree. => O(logN)
	 * Build MyMiniLoserTree. => O(N)
	 * Adjust MyMiniLoserTree. => O(logN)
	 * Sort MyMiniLoserTree. => O(MlogN)
	 *  adjust method => O(logN)
	 * 	calling (M - N) times => M times
	 * 
	 * space complexity:
	 * 3 * N
	 * 
	 * */
	public List<Integer> sortOneByOne(List<List<Integer>> lists) {
		List<Iterator<Integer>> iterators = new LinkedList<Iterator<Integer>>();
		for (int i = 0; i < lists.size(); i++) {
			iterators.add(lists.get(i).iterator());
		}
		MyMiniLoserTree myMiniLoserTree = new MyMiniLoserTree(iterators);
		List<Integer> result = myMiniLoserTree.sort();
		return result;
	}

}
