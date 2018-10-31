package myJavaTraining.basicAlgorithms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BigNumberAddingMachine {
	
	/* Given 2 linkedlists of integers, each representing a big number
	 * formed by digits (nodes), write a method which returns a linkedlist,
	 * representing the sum of the 2 big numbers.
	 *                   example:
	 * 1 -> 9 -> 7 -> 8 -> 6 -> 4 -> 3 -> 4 -> 7 -> 9 -> 5
	 *                      +
	 * 2 -> 1 -> 3 -> 5 -> 6 -> 5 -> 2 -> 0 -> 5
	 * 			=
	 * 2 -> 0 -> 0 -> 0 -> 0 -> 0 -> 0 -> 0 -> 0 -> 0 -> 0
	 */

	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();

		list1.add(1); list1.add(9);	list1.add(7); list1.add(8); list1.add(6);
		list1.add(4); list1.add(3); list1.add(4); list1.add(7); list1.add(9); list1.add(5);
		
		list2.add(2); list2.add(1);	list2.add(3); list2.add(5); list2.add(6);
		list2.add(5); list2.add(2);	list2.add(0); list2.add(5);
		
		System.out.println("Parameters:");
		print(list1);
		print(list2);
		System.out.println("Return:");
		print(sum(list1, list2));
	}

	public static LinkedList<Integer> sum(LinkedList<Integer> op1, LinkedList<Integer> op2) {
		if(op1.size() == 0) return op2;
		if(op2.size() == 0) return op1;
		
		LinkedList<Integer> result = new LinkedList<>();
		
		if(op1.size() < op2.size()) {
			LinkedList<Integer> temp = op1;
			op1 = op2;
			op2 = temp;
		}
		
		ListIterator<Integer> i = op1.listIterator(op1.size());
		ListIterator<Integer> j = op2.listIterator(op2.size());
		
		Integer sum = 0;
		Integer rem = 0;
		
		while(j.hasPrevious()) {
			Integer upOp = i.previous();
			Integer downOp = j.previous();
			
			sum = (rem + upOp + downOp) % 10;
			rem = (rem + upOp + downOp) / 10;
			result.addFirst(sum);
		}
		
		while(i.hasPrevious()) {
			Integer upOp = i.previous();
			
			sum = (rem + upOp) % 10;
			rem = (rem + upOp) / 10;
			result.addFirst(sum);
		}
		
		if(rem != 0) result.addFirst(rem);
		
		return result;
	}

	private static void print(List<Integer> list) {
		System.out.print(list.get(0));
		Iterator<Integer> it = list.iterator();
		it.next();

		while(it.hasNext()) {
			System.out.print(" -> " + it.next());
		}
		System.out.println();
	}

}
