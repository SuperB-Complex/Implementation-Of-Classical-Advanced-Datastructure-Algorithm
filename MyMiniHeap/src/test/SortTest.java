package test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;

import solution.Sort;
import util.LinkedListFactory;

public class SortTest {

	@Test
	public void testSortAll() {
		LinkedListFactory linkedListFatcory = new LinkedListFactory();
		Sort sort = new Sort();
		
		List<List<Integer>> lists = new LinkedList<> ();
		lists.add(linkedListFatcory.produce(new int[] {1, 20, 300, 40, 500}));
		lists.add(linkedListFatcory.produce(new int[] {10, 2, 30, 4, 50}));
		lists.add(linkedListFatcory.produce(new int[] {100, 200, 3, 400, 5}));
		
		String expected = "[1, 2, 3, 4, 5, 10, 20, 30, 40, 50, 100, 200, 300, 400, 500]";
		String real = sort.sortAll(lists).toString();
		
		assertEquals(expected, real);
	}
}
