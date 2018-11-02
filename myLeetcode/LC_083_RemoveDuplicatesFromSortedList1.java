package myJavaTraining.myLeetcode;

public class LC_083_RemoveDuplicatesFromSortedList1 {
	
	/*  Given a sorted linked list, delete all duplicates
	 		such that each element appear only once.
		Example 1:
			Input: 1->1->2
			Output: 1->2
		Example 2:
			Input: 1->1->2->3->3
			Output: 1->2->3
	*/
	
	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		ListNode list2 = new ListNode(1);
		ListNode list3 = new ListNode(2);
		ListNode list4 = new ListNode(2);
		ListNode list5 = new ListNode(4);

		list1.next = list2;
		list2.next = list3;
		list3.next = list4;
		list4.next = list5;

		displayListNode(deleteDuplicates(list1));		
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null) {
			return null;
		}

		if(head.next == null) {
			return head;
		}

		ListNode it = head;

		while(it != null && it.next != null) {
			if(it.val == it.next.val) {
				it.next = it.next.next;
			} else {
				it = it.next;
			}
		}
		return head;
	}

	private static void displayListNode(ListNode head) {
		System.out.print(head.val);
		ListNode it = head.next;
		while(it != null) {
			System.out.print(" -> " + it.val);
			it = it.next;
		}
		System.out.println();
	}

}
