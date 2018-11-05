package myJavaTraining.myLeetcode;

public class LC_706_DesignHashMap {
	/*  Design a HashMap without using any built-in hash table libraries.
		To be specific, your design should include these functions:
			put(key, value) : Insert a (key, value) pair into the HashMap.
			 	If the value already exists in the HashMap, update the value.
			get(key): Returns the value to which the specified key is mapped,
			 	or -1 if this map contains no mapping for the key.
			remove(key) : Remove the mapping for the value key if this map
			 	contains the mapping for the key.
	 */

	class Node {
		public int value;
		public Node(int value) {
			this.value = value;
		}
	}

	Node[] pairs;    

	public LC_706_DesignHashMap() {
		this.pairs = new Node[1000000];
	}

	public void put(int key, int value) {
		this.pairs[key] = new Node(value);
	}

	public int get(int key) {
		if(this.pairs[key] == null) {
			return -1;
		}
		return this.pairs[key].value;
	}

	public void remove(int key) {
		if(this.pairs[key] == null) {
			return;
		}
		this.pairs[key] = null;
	}
}
