package myJavaTraining.dataStructures.linkedList.singlyLinkedList;

public class App {

	public static void main(String[] args) {
		SinglyLinkedlist myList = new SinglyLinkedlist();
		myList.insertFirst(100);
		myList.insertFirst(50);
		myList.insertFirst(10);
		myList.insertLast(9999);
		
		myList.displayList();		
		
	}
	
}
