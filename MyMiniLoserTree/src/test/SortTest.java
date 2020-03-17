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
	public void testSortOneByOne2PowerLenth() {
		LinkedListFactory linkedListFatcory = new LinkedListFactory();
		Sort sort = new Sort();
	
		List<List<Integer>> lists = new LinkedList<> ();
		lists.add(linkedListFatcory.produce(new int[] {1, 20, 30, 40, 50}));
		lists.add(linkedListFatcory.produce(new int[] {20, 22, 33, 44, 55}));
		lists.add(linkedListFatcory.produce(new int[] {5, 11, 15, 20, 25}));
		lists.add(linkedListFatcory.produce(new int[] {6, 20, 25, 36, 45}));
		lists.add(linkedListFatcory.produce(new int[] {20, 22, 23, 24, 52}));
		lists.add(linkedListFatcory.produce(new int[] {20, 201, 213, 401, 415}));
		lists.add(linkedListFatcory.produce(new int[] {20, 144, 155, 166, 177}));
		lists.add(linkedListFatcory.produce(new int[] {20, 34, 43, 45, 47}));
		
		String expected = "[1, 5, 6, 11, 15, 20, 20, 20, 20, 20, 20, 20, 20, 22, 22, 23, 24, 25, 25, 30, 33, 34, 36, 40, 43, 44, 45, 45, 47, 50, 52, 55, 144, 155, 166, 177, 201, 213, 401, 415]";
		String real = sort.sortOneByOne(lists).toString();
		
		assertEquals(expected, real);
	}
	
	@Test
	public void testSortOneByOneNot2PowerLenth() {
		LinkedListFactory linkedListFatcory = new LinkedListFactory();
		Sort sort = new Sort();
	
		List<List<Integer>> lists = new LinkedList<> ();
		lists.add(linkedListFatcory.produce(new int[] {1, 20, 30, 40, 50}));
		lists.add(linkedListFatcory.produce(new int[] {20, 22, 33, 44, 55}));
		lists.add(linkedListFatcory.produce(new int[] {5, 11, 15, 20, 25}));
		lists.add(linkedListFatcory.produce(new int[] {6, 20, 25, 36, 45}));
		lists.add(linkedListFatcory.produce(new int[] {20, 22, 23, 24, 52}));
		lists.add(linkedListFatcory.produce(new int[] {20, 201, 213, 401, 415}));
		
		String expected = "[1, 5, 6, 11, 15, 20, 20, 20, 20, 20, 20, 22, 22, 23, 24, 25, 25, 30, 33, 36, 40, 44, 45, 50, 52, 55, 201, 213, 401, 415]";
		String real = sort.sortOneByOne(lists).toString();
		
		assertEquals(expected, real);
	}
	
	@Test
	public void testSortOneByOneOddLenth() {
		LinkedListFactory linkedListFatcory = new LinkedListFactory();
		Sort sort = new Sort();
	
		List<List<Integer>> lists = new LinkedList<> ();
		lists.add(linkedListFatcory.produce(new int[] {1, 20, 30, 40, 50}));
		lists.add(linkedListFatcory.produce(new int[] {20, 22, 33, 44, 55}));
		lists.add(linkedListFatcory.produce(new int[] {5, 11, 15, 20, 25}));
		lists.add(linkedListFatcory.produce(new int[] {6, 20, 25, 36, 45}));
		lists.add(linkedListFatcory.produce(new int[] {20, 22, 23, 24, 52}));
		
		String expected = "[1, 5, 6, 11, 15, 20, 20, 20, 20, 20, 22, 22, 23, 24, 25, 25, 30, 33, 36, 40, 44, 45, 50, 52, 55]";
		String real = sort.sortOneByOne(lists).toString();
		
		assertEquals(expected, real);
	}
	
}
