package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import solution.BinaryTree;

public class TestTraversal {

	@Test
	public void testTraversal() {
		String preOrder = "12489cd5ab367";
		String inOrder = "84cd92a5b1637";
		String postOrder = "8dc94ab526731";
		String levelOrder = "123456789abcd";
		String morrisInOrder = inOrder;
		String[] expected = new String[] {preOrder, preOrder, inOrder, inOrder, postOrder, postOrder, levelOrder, morrisInOrder};
		
		BinaryTree binaryTree = new BinaryTree();
		Map<Character, List<Character>> root = new HashMap<> ();
		Map<Character, List<Character>> body = new HashMap<> ();
		List<Character> temp1 = new LinkedList<>();
		temp1.add('2');
		temp1.add('3');
		root.put('1', temp1);
		
		List<Character> temp2 = new LinkedList<>();
		temp2.add('4');
		temp2.add('5');
		body.put('2', temp2);
		List<Character> temp3 = new LinkedList<>();
		temp3.add('6');
		temp3.add('7');
		body.put('3', temp3);
		List<Character> temp4 = new LinkedList<>();
		temp4.add('8');
		temp4.add('9');
		body.put('4', temp4);
		List<Character> temp5 = new LinkedList<>();
		temp5.add('a');
		temp5.add('b');
		body.put('5', temp5);
		List<Character> temp9 = new LinkedList<>();
		temp9.add('c');
		temp9.add(null);
		body.put('9', temp9);
		List<Character> temp12 = new LinkedList<>();
		temp12.add(null);
		temp12.add('d');
		body.put('c', temp12);
		
		String[] real = binaryTree.traversal(root, body);
		
		assertArrayEquals(expected, real);
	}

}
