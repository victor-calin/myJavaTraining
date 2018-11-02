package myJavaTraining.myLeetcode;

public class LC_328_OddEvenLinkedList {
	
	/*  Given a singly linked list, group all odd nodes together
	 		followed by the even nodes. Please note here we are talking
	 		about the node number and not the value in the nodes.
		You should try to do it in place. The program should run 
			in O(1) space complexity and O(nodes) time complexity.
		Example 1:
			Input: 1->2->3->4->5->NULL
			Output: 1->3->5->2->4->NULL
		Example 2:
			Input: 2->1->3->5->6->4->7->NULL
			Output: 2->3->6->7->1->5->4->NULL
		Note: The relative order inside both the even and odd
				groups should remain as it was in the input.
			  The first node is considered odd, the second node even and so on ...
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
		displayListNode(oddEvenList(list1));

	}

	public static ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null) return head;

		ListNode oddIt = head, evenHead = head.next, evenIt = evenHead;

		while(evenIt != null && evenIt.next != null) {
			oddIt.next = evenIt.next;
			oddIt = oddIt.next;
			evenIt.next = oddIt.next;
			evenIt = evenIt.next;
		}
		oddIt.next = evenHead;    
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



