package myJavaTraining.dataStructures.linkedList.circularLinkedList;

public class CircularLinkedlist {
	private Node first;
	private Node last;
	
	public boolean isEmpty() {
		return (this.first == null);
	}
	
	//used to insert at the beginning of the list
	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if (isEmpty()) {
			last = newNode;
		}
		newNode.next = this.first; //newNode --> old first
		this.first = newNode; //first place
	}
	
	public void insertLast(int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if (isEmpty()) {
			this.first = newNode;
		} else {
			last.next = newNode; //the last value of the last node will point to the new node
		}
		last = newNode; //make the new created node be the last node in the list		
	}
	
	public int deleteFirst() {
		 int temp = first.data;
		 if (first.next == null) {
			 last = null;
		 }
		 first = first.next; //first will point to old's next value;
		 return temp;		 
	}
	
	public void displayList() {
		System.out.println("list (first --> last)");
		Node current = first;
		while(current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.println();
	}
}
