package myJavaTraining.dataStructures.linkedList.doublyLinkedList;
import java.util.LinkedList;

public class App {
	public static void testDoubleLinkedList() {
		MyIntLinkedList<Integer> test = new MyIntLinkedList<Integer>();
		LinkedList<Integer> testR = new LinkedList<>();

		test.toArray();

		System.out.println(testR);
		System.out.println(test);
		System.out.println(test.size());

		test.addFirst(-100); 
		System.out.println(test);
		System.out.println(test.size());
		test.addLast(-500);
		System.out.println(test);
		System.out.println(test.size());

		test.removeLast(); test.removeLast(); 
		System.out.println(test);
		System.out.println(test.size());

		System.out.println(test);
		System.out.println(test.size());

		test.addFirst(-100); test.addLast(-500);
		System.out.println(test);
		System.out.println(test.size());
		for (int i = 0; i < 10; i++) {
			int val = i;
			test.add(val);
			testR.add(val);
		} 
		System.out.println(testR);
		System.out.println(test);
		System.out.println(test.size());

		MyIntLinkedList<Integer> test2 = new MyIntLinkedList<Integer>(test);
		for (int i = 25; i < 35; i++) {
			int val = i;
			test2.add(val);
		}
		System.out.println(test2);
		System.out.println(test2.size());

		test.removeLast(); test.removeLast(); test.removeLast(); 
		test.add(-15); test.removeFirst();
		test.addFirst(-100); test.addLast(-500);
		test.add(3, 300);
		test.add(0, 800);
		test.add(test.size(), 8000);
		System.out.println(test);
		System.out.println(test.size());
		System.out.println(test2);
		System.out.println(test2.size());

		test.removeLast(); test.removeLast(); test.removeLast(); 
		test.add(-15); test.removeFirst();
		System.out.println(test);
		System.out.println(test2);
		System.out.println(test.size());
		System.out.println(test2.size());

		test2.removeLast(); test2.removeLast(); test2.removeLast(); 
		test2.removeFirst(); test2.removeFirst(); test2.removeFirst(); 
		test2.removeFirst(); test2.removeFirst();
		System.out.println(test);
		System.out.println(test2);
		System.out.println(test.size());
		System.out.println(test2.size());
	}

	public static void main(String[] args) {
		testDoubleLinkedList();
	}
}
