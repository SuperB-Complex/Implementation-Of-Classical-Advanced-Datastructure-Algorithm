package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import solution.InorderPostorderTraversal;
import solution.PreorderInorderTraversal;
import solution.PreorderPostorderTraversal;

public class TestRecovery {

	@Test
	public void testPreOrderInOrder() {
		String expected = new String(" 1 2 3 4 5 6 7 8 9 a b null null null null null null c null null null null null null d null null");
		PreorderInorderTraversal preorderInorderTraversal = new PreorderInorderTraversal();
		String real = preorderInorderTraversal.recover("12489cd5ab367", "84cd92a5b1637");
		assertEquals(expected, real);
	}
	
	@Test
	public void testPostOrderInOrder() {
		String expected = new String(" 1 2 3 4 5 6 7 8 9 a b null null null null null null c null null null null null null d null null");		
		InorderPostorderTraversal preorderInorderTraversal = new InorderPostorderTraversal();
		String real = preorderInorderTraversal.recover("8dc94ab526731", "84cd92a5b1637");
		assertEquals(expected, real);
	}
	
	@Test
	public void testPreOrderPostOrder() {
		String expected = new String(" 1 2 3 4 5 6 7 8 9 a b null null null null null null c null null null null null d null null null");		
		PreorderPostorderTraversal preorderInorderTraversal = new PreorderPostorderTraversal();
		String real = preorderInorderTraversal.recover("12489cd5ab367", "8dc94ab526731");
		assertEquals(expected, real);
	}

}
