package myJavaTraining.dataStructures.linkedList.singlyLinkedList;

public class SinglyLinkedlist {
	private Node first;
	
	public boolean isEmpty() {
		return (this.first == null);
	}
	
	//used to insert at the beginning of the list
	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = this.first;
		this.first = newNode;
	}
	
	public void insertLast(int data) {
		Node current = first;
		while(current.next != null) {
			current = current.next;
		}
		Node newNode = new Node();
		newNode.data = data;
		current.next = newNode;
	}
	
	public Node deleteFirst() {
		 Node temp = first;
		 first = first.next;
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
