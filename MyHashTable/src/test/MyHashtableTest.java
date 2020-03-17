package test;

import static org.junit.Assert.*;
import org.junit.Test;

import solution.MyHashtable;

public class MyHashtableTest {
	/*
	 * If anything in Test class, it is because hash collision happened
	 * , which changes the order of the original input.
	 * */

    @Test
	public void testPutIntegerOneByOne() {
		String expected = "{1 = 1, 0 = 0}";
		MyHashtable<Integer, Integer> table = new MyHashtable<>();
		table.put(0, 0);
		table.put(1, 1);
		String actual = table.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPutStringOneByOne() {
		String expected = "{qcjj1 = qcjj1, qcjj0 = qcjj0}";
		MyHashtable<String, String> table = new MyHashtable<>();
		table.put("qcjj0", "qcjj0");
		table.put("qcjj1", "qcjj1");
		String actual = table.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPutCharacterOneByOne() {
		String expected = "{b = b, a = a}";
		MyHashtable<Character, Character> table = new MyHashtable<>();
		table.put('a', 'a');
		table.put('b', 'b');
		String actual = table.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testPutObjectOneByOne() {
		ObjectsForTest o1 = new ObjectsForTest(0, 1);
		ObjectsForTest o2 = new ObjectsForTest(1, 2);
 		String expected = "{" + o2 + " = " + o2 + ", " + o1 + " = " + o1 + "}";
		MyHashtable<ObjectsForTest, ObjectsForTest> table = new MyHashtable<>();
		table.put(o1, o1);
		table.put(o2, o2);
		String actual = table.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPutStrings() {
		StringBuilder stringBuilder = new StringBuilder("{");
		MyHashtable<String, String> table = new MyHashtable<>();
		for (int i = 100; i > -1; i--) {
			String key = Integer.toString(i);
			table.put(key, Integer.toString(0));
			stringBuilder.append(key + " = 0, ");
		}
		String expected = stringBuilder.substring(0, stringBuilder.length() - 2) + "}";
		String actual = table.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPutIntegers() {
		StringBuilder stringBuilder = new StringBuilder("{");
		MyHashtable<Integer, Integer> table = new MyHashtable<>();
		for (int i = 100; i > -1; i--) {
			table.put(i, 0);
			stringBuilder.append(Integer.toString(i) + " = 0, ");
		}
		String expected = stringBuilder.substring(0, stringBuilder.length() - 2) + "}";
		String actual = table.toString();
		assertEquals(expected, actual);
	}

}
