package myJavaTraining.myLeetcode;

public class LC_021_MergeTwoSortedLists {
	
	/* Merge two sorted linked lists and return it as a new list. 
	   The new list should be made by splicing together the nodes of the first two lists.
			Example:
				Input: 1->2->4, 1->3->4
				Output: 1->1->2->3->4->4
	*/

	public static void main(String[] args) {
		ListNode l1n1 = new ListNode(1);
		ListNode l1n2 = new ListNode(2);
		ListNode l1n3 = new ListNode(4);
		
		ListNode l2n1 = new ListNode(1);
		ListNode l2n2 = new ListNode(3);
		ListNode l2n3 = new ListNode(3);

		l1n1.next = l1n2;
		l1n2.next = l1n3;
		
		l2n1.next = l2n2;
		l2n2.next = l2n3;

		displayListNode(mergeTwoLists(l1n1, l2n1));
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {			
		ListNode prevMerged = new ListNode(0);
		ListNode merged = prevMerged;
		
		while(l1 != null && l2 != null) {
			if(l1.val <= l2.val) {
				merged.next = l1;
				l1 = l1.next;
			} else {
				merged.next = l2;
				l2 = l2.next;
			}
			merged = merged.next;
		}
		
		if(l1 != null) merged.next = l1;
		if(l2 != null) merged.next = l2;
		
		return prevMerged.next;
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
