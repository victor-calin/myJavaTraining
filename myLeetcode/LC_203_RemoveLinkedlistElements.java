package myJavaTraining.myLeetcode;

public class LC_203_RemoveLinkedlistElements {
	
	/* Remove all elements from a linked list of integers that have value val.
	   Example:
			Input:  1->2->6->3->4->5->6, val = 6
			Output: 1->2->3->4->5
	*/

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		ListNode list2 = new ListNode(2);
		ListNode list3 = new ListNode(6);
		ListNode list4 = new ListNode(3);
		ListNode list5 = new ListNode(4);
		ListNode list6 = new ListNode(5);
		ListNode list7 = new ListNode(6);

		list1.next = list2;
		list2.next = list3;
		list3.next = list4;
		list4.next = list5;
		list5.next = list6;
		list6.next = list7;

		displayListNode(list1);
		displayListNode(removeElements(list1, 6));

	}

	public static ListNode removeElements(ListNode head, int toRemove) {
		if(head == null) return null;

		ListNode it = head;
		while(it.val == toRemove && it != null && it.next != null) 
			it = it.next;

		if(it.val == toRemove) return null;
		else head = it;

		ListNode prev = head;
		while(it != null) {
			if(it.val == toRemove) 
				prev.next = it.next;
			else 
				prev = it;
			it = it.next;
		} 
		return head;
	}

	private static void displayListNode(ListNode head) {
		if(head == null) return;

		System.out.print(head.val);
		ListNode it = head.next;
		while(it != null) {
			System.out.print(" -> " + it.val);
			it = it.next;
		}
		System.out.println();
	}

}


