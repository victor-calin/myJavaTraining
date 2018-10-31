package myJavaTraining.dataStructures.heapSearchTree;

public class Node {
	private int key;

	public Node(int key) {
		super();
		this.key = key;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.key);
	}
	
	

}
