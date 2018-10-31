package myJavaTraining.dataStructures.linkedList.doublyLinkedList;

import java.util.ArrayList;

public class MyIntLinkedList<E> {

	private DoubleLinkedListNode<E> headAndTail; // head -> .next()
	// tail -> 
	private int size;

	public MyIntLinkedList() {
		headAndTail = new DoubleLinkedListNode<E>(); // sentinel node
		headAndTail.next(headAndTail);
		headAndTail.prev(headAndTail);
	}

	public MyIntLinkedList(MyIntLinkedList<E> c) {
		this();
		this.addAll(c);
	}

	public void add(int index, E element) {
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException();
		}

		DoubleLinkedListNode<E> it = headAndTail;
		for (int i=0; i<index; i++) {
			it = it.next();
		}
		this.addElementAfterPosition(element, it);
	}

	public boolean add(E e) {
		this.addElementAfterPosition(e, headAndTail.prev());
		return true;
	}

	public int size() {
		return this.size;
	}

	public boolean contains(DoubleLinkedListNode<E> e) {
		return this.indexOf(e) >= 0;
	}

	public E get(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		DoubleLinkedListNode<E> nodeAtIndex = this.getNode(index);
		if (nodeAtIndex == null) {
			return null;
		}
		return nodeAtIndex.value();
	}

	public int indexOf(DoubleLinkedListNode<E> e) {
		int poz = 0;
		for (DoubleLinkedListNode<E> it=headAndTail.next(); it!=headAndTail; it=it.next()) {
			if (it.value().equals(e)) {
				return poz;
			}
			poz++;
		}
		return Integer.MIN_VALUE;
	}

	public int lastIndexOf(E e) {
		int poz = this.size - 1;
		for (DoubleLinkedListNode<E> it=headAndTail.prev(); it!=headAndTail; it=it.prev()) {
			if (it.value().equals(e)) {
				return poz;
			}
			poz--;
		}
		return Integer.MIN_VALUE;
	}

	public boolean remove(E e) {
		DoubleLinkedListNode<E> pos = this.getElementPosition(e);
		if (pos == null) {
			return false;
		}
		this.removeElementAtPosition(pos);
		return true;
	}

	public E removeElementAtIndex(int index) {
		DoubleLinkedListNode<E> nodeAtIndex = this.getNode(index);
		return this.removeElementAtPosition(nodeAtIndex);
	}

	public void clear() {
		this.headAndTail.next(this.headAndTail);
		this.headAndTail.prev(this.headAndTail);
		this.size = 0;
	}

	public E set(int index, E e) {
		DoubleLinkedListNode<E> nodeAtIndex = this.getNode(index);
		if (nodeAtIndex == null) {
			return null;
		}
		E oldValue = nodeAtIndex.value();
		nodeAtIndex.value(e);
		return oldValue;
	}

	public boolean addAll(MyIntLinkedList<E> c) {
		return addAll(this.size, c);
	}

	public boolean addAll(int index, MyIntLinkedList<E> c) {
		if (c == null) {
			throw new IndexOutOfBoundsException();
		}

		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException();
		}

		DoubleLinkedListNode<E> nodeAtIndex = index==0 ? headAndTail:this.getNode(index-1);
		for (DoubleLinkedListNode<E> it=c.headAndTail.next(); it!=c.headAndTail; 
				it=it.next()) {
			this.addElementAfterPosition(it.value(), nodeAtIndex);
			nodeAtIndex = nodeAtIndex.next();
		}
		return true;
	}

	public E[] toArray() {
		ArrayList<E> elements = new ArrayList<>();
		for (DoubleLinkedListNode<E> it=headAndTail.next(); it!=headAndTail; it=it.next()) {
			elements.add(it.value());
		}
		
		return (E[])elements.toArray();
	}

	public boolean addFirst(E e) {
		this.addElementAfterPosition(e, headAndTail);
		return true;
	}

	public boolean addLast(E e) {
		this.addElementAfterPosition(e, headAndTail.prev());
		return true;
	}

	public E removeLast() {
		return this.removeElementAtPosition(headAndTail.prev());
	}

	public E removeFirst() {
		return this.removeElementAtPosition(headAndTail.next());
	}

	public E getLast() {
		if (this.size == 0) {
			return null;
		}
		return this.headAndTail.prev().value();
	}

	public E getFirst() {
		return this.get(0);  
	}

	@Override
	public String toString() {
		if (this.size == 0) {
			return "[empty]";
		}

		String ret = "";
		for (DoubleLinkedListNode<E> it=headAndTail.next(); it!=headAndTail; it=it.next()) {
			ret += it.value() + " <=> ";
		}
		return ret.substring(0, ret.length() - 3);
	}

	private void addElementAfterPosition(E e, DoubleLinkedListNode<E> pos) {
		DoubleLinkedListNode<E> newNode = new DoubleLinkedListNode<E>(e, pos.next(), pos);
		pos.next().prev(newNode); 
		pos.next(newNode);
		size++;
	}

	private E removeElementAtPosition(DoubleLinkedListNode<E> pos) {
		if (size == 0 || pos == null) {
			throw new IndexOutOfBoundsException();
		}

		E removed = pos.value();
		pos.prev().next(pos.next());
		pos.next().prev(pos.prev());
		size--;
		return removed;
	}

	private DoubleLinkedListNode<E> getElementPosition(E e) {
		for (DoubleLinkedListNode<E> it=headAndTail.next(); it!=headAndTail; it=it.next()) {
			if (it.value().equals(e)) {
				return it;
			}
		}
		return null;
	}

	private DoubleLinkedListNode<E> getNode(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}

		int poz = 0;
		DoubleLinkedListNode<E> nodeAtIndex = null;
		for (DoubleLinkedListNode<E> it=headAndTail.next(); it!=headAndTail; it=it.next()) {
			if (poz == index) {
				nodeAtIndex = it;
				break;
			}
			poz++;
		}
		return nodeAtIndex;
	}
}
