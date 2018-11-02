package myJavaTraining.myLeetcode;

public class LC_206_ReverseLinkedList {
	
	/* Reverse a singly linked list.
		Example:
			Input: 1->2->3->4->5->NULL
			Output: 5->4->3->2->1->NULL
	*/

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		ListNode list2 = new ListNode(2);
		ListNode list3 = new ListNode(3);
		ListNode list4 = new ListNode(4);
		ListNode list5 = new ListNode(5);

		list1.next = list2;
		list2.next = list3;
		list3.next = list4;
		list4.next = list5;

		displayListNode(list1);
		displayListNode(reverseList(list1));	
	}

	public static ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) return head;

		ListNode prev = null;
		ListNode crt = head;
		while(crt != null) {
			ListNode nextCrt = crt.next;
			crt.next = prev;
			prev = crt;
			crt = nextCrt;
		}
		return prev;
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



