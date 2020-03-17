package util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListFactory extends InputParameterFactory {
	
	@Override
	public List<Integer> produce(int[] arr) {
		List<Integer> result = new LinkedList<> ();
		for (int i = 0; i < arr.length; i++) {
			result.add(arr[i]);
		}
		return result;
	}
}
