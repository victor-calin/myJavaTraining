package myJavaTraining.dataStructures.arrayList;
import java.util.Arrays;

public class MyIntArrayList {

	private int[] elements;
	private int size;

	public MyIntArrayList() {
		this(10);
	}

	public MyIntArrayList(MyIntArrayList c) {    
		if (c == null) {
			// should throw NullPointerException 
			System.out.println("Throwing NullPointerException when trying" + 
					" to construct collection from a null collection");
			return;
		}

		this.elements = Arrays.copyOf(c.elements, c.elements.length);
		this.size = c.size;
	}

	public MyIntArrayList(int initialCapacity) {
		this.elements = new int[initialCapacity];
	}

	public void add(int index, int element) {
		if (index < 0 || index > this.size) {
			// should throw IndexOutOfBoundsException
			System.out.println("Throwing IndexOutOfBoundsException when trying to"
					+ " add element " + element + " at position " + index);
			return;
		}

		if (this.size == this.elements.length) {
			this.changeCapacity(-1);
		}

		for (int i=this.size; i>index; i--) {
			this.elements[i] = this.elements[i - 1];
		}

		this.elements[index] = element;
		this.size++;
	}

	public boolean add(int e) {
		this.add(this.size, e);
		return true;
	}

	public int size() {
		return this.size;
	}

	public boolean contains(int e) {
		return this.indexOf(e) >= 0;
	}

	public int get(int index) {
		if (index < 0 || index >= this.size) {
			// should throw IndexOutOfBoundsException
			System.out.println("Throwing IndexOutOfBoundsException when trying to"
					+ " get element at position " + index);
			return -1;
		}

		return this.elements[index];
	}

	public int indexOf(int e) {
		for (int i=0; i<this.size; i++) {
			if (this.elements[i] == e) {
				return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(int e) {
		for (int i=this.size-1; i>=0; i--) {
			if (this.elements[i] == e) {
				return i;
			}
		}
		return -1;
	}

	public boolean remove(int e) {
		int index = this.indexOf(e);

		if (index < 0) {
			return false;
		}

		removeElementAtIndex(index);
		return true;
	}

	public int removeElementAtIndex(int index) {
		if (index < 0 || index >= this.size) {
			// should throw IndexOutOfBoundsException
			System.out.println("Throwing IndexOutOfBoundsException when trying to" +
					" remove element at position " + index);
			return -1;
		}

		int removedElement = this.elements[index];
		for (int i=index; i<this.size; i++) {
			this.elements[i] = this.elements[i+1];
		}
		this.size--;

		return removedElement;
	}

	public void clear() {
		this.size = 0;
	}

	public int set(int index, int e) {
		if (index < 0 || index >= this.size) {
			// should throw IndexOutOfBoundsException
			System.out.println("Throwing IndexOutOfBoundsException when trying to set" +
					" the element " + e + " at position " + index);
			return -1;
		}

		int replacedElement = this.elements[index];
		this.elements[index] = e;
		return replacedElement;
	}

	public boolean addAll(MyIntArrayList c) {
		return addAll(this.size, c);
	}

	public boolean addAll(int index, MyIntArrayList c) {
		if (c == null) {
			// should throw NullPointerException 
			System.out.println("Throwing NullPointerException when trying" + 
					" to add all elements from a null collection");
			return false;
		}

		if (index < 0 || index > this.size) {
			// should throw IndexOutOfBoundsException
			System.out.println("Throwing IndexOutOfBoundsException when trying to add" +
					" all elements from a collection at position " + index);
			return false;
		}

		if (c.size == 0) {
			return false;
		}

		if (this.size + c.size > this.elements.length) {
			this.changeCapacity(this.size + c.size);
		}

		for (int i=this.size-1; i>=index; i--) {
			this.elements[i + c.size] = this.elements[i];
		}

		for (int i=0; i<c.size; i++) {
			this.elements[index+i] = c.elements[i];
		}

		this.size += c.size;

		return true;
	}

	public int[] toArray() {
		return Arrays.copyOf(this.elements, this.size);
	}

	public void ensureCapacity(int minCapacity) {
		if (minCapacity > this.elements.length) {
			this.changeCapacity(minCapacity);
		}
	}

	public void trimToSize() {
		this.changeCapacity(this.size);
	}

	@Override
	public String toString() {
		String ret = "[";

		for (int i=0; i<this.size - 1; i++) {
			ret += this.elements[i] + ", ";
		}
		if (this.size > 0) {
			ret += this.elements[this.size - 1];
		}

		ret += "]";

		return ret;
	}

	/* This method is used for both shrinking and increasing the array capacity.
	 * If size is negative, the array will double it's capacity.
	 * Return: true if the operation is successful (i.e. the operation does not
	 *         affect elements integrity. False otherwise.
	 */
	private boolean changeCapacity(int capacity) {
		if (capacity < 0) {
			// increase the capacity with the default algorithm: double capacity
			capacity = this.elements.length * 2;
		} 

		if (capacity < this.size) {
			return false;
		}

		this.elements = Arrays.copyOf(this.elements, capacity);
		return true;
	}
}