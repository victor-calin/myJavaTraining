package myJavaTraining.myLeetcode;

public class LC_061_RotateList {
	
	/* 	Given a linked list, rotate the list to the right
	  		by k places, where k is non-negative.
		Example 1:
			Input: 1->2->3->4->5->NULL, k = 2
			Output: 4->5->1->2->3->NULL
			Explanation:
				rotate 1 steps to the right: 5->1->2->3->4->NULL
				rotate 2 steps to the right: 4->5->1->2->3->NULL
		Example 2:
			Input: 0->1->2->NULL, k = 4
			Output: 2->0->1->NULL
			Explanation:
				rotate 1 steps to the right: 2->0->1->NULL
				rotate 2 steps to the right: 1->2->0->NULL
				rotate 3 steps to the right: 0->1->2->NULL
				rotate 4 steps to the right: 2->0->1->NULL
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
		displayListNode(rotateRight(list1, 2));	

	}

	public static ListNode rotateRight(ListNode head, int k) {
		if(head == null) return null;
		
		int len = 1;
		ListNode newHead = head;
		while(newHead.next != null) {
			newHead = newHead.next;
			len++;
		}
		
		newHead.next = head;
						
		int splitPoint = len - k % len;
		for(int i=1; i<splitPoint; i++) {
			head = head.next;
		}
		
		newHead = head.next;
		head.next = null;
				
		return newHead;
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
