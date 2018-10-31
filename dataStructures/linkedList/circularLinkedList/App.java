package myJavaTraining.dataStructures.linkedList.circularLinkedList;

public class App {

	public static void main(String[] args) {
		CircularLinkedlist myList = new CircularLinkedlist();
		myList.insertFirst(100);
		myList.insertFirst(50);
		myList.insertFirst(10);
		myList.insertLast(9999);
		
		myList.displayList();	
		
	}

}
