package test;

public class ObjectsForTest {
	private int a;
	private int b;
	
	public ObjectsForTest(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public String toString() {
		return "Object" + Integer.toString(this.a);
	}
}
