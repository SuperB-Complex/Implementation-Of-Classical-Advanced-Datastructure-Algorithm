package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import solution.MyHuffmanTreeWithPriorityQueue;

public class TestMyHuffmanTreeWithPriorityQueue {

	@Test
	public void testEncodeList() {
		Map<Character, Integer> input = new HashMap<> ();
		input.put('a', 6);
		input.put('b', 3);
		input.put('c', 1);
		input.put('d', 7);
		input.put('e', 3);
		MyHuffmanTreeWithPriorityQueue myHuffmanTreeWithPriorityQueue = new MyHuffmanTreeWithPriorityQueue(input);
		
		Map<Character, String> result = new HashMap<> ();
		String real = myHuffmanTreeWithPriorityQueue.encodeList().toString();
		String expected = "{a=10, b=110, c=1110, d=0, e=1111}";
	}
}
