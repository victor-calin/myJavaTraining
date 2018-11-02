package myJavaTraining.myLeetcode;

public class LC_082_RemoveDuplicatesFromSortedList2 {
	
	/* 	Given a sorted linked list, delete all nodes that have duplicate
			numbers, leaving only distinct numbers from the original list.
		Example 1:
			Input: 1->2->3->3->4->4->5
			Output: 1->2->5
		Example 2:
			Input: 1->1->1->2->3
			Output: 2->3
	*/

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		ListNode list2 = new ListNode(1);
		ListNode list3 = new ListNode(2);
		ListNode list4 = new ListNode(3);
		ListNode list5 = new ListNode(3);
		ListNode list6 = new ListNode(4);
		ListNode list7 = new ListNode(4);
		ListNode list8 = new ListNode(5);

		list1.next = list2;
		list2.next = list3;
		list3.next = list4;
		list4.next = list5;
		list5.next = list6;
		list6.next = list7;
		list7.next = list8;
		
		displayListNode(list1);	
		displayListNode(deleteDuplicates(list1));		
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null) return null;
		
		//defining 2 pointers: slow - 1 node before the dup series; fast - last node in dup series
		ListNode dummy = new ListNode(0), fast = head, slow = dummy;
		slow.next = fast;
		
		while(fast != null) {
			while(fast.next != null && fast.val == fast.next.val) {
				fast = fast.next; //find last dup
			}
			if(slow.next != fast) { //duplicate detected
				fast = fast.next;
				slow.next = fast;
			} else {
				fast = fast.next;
				slow = slow.next;
			}
		}
		return dummy.next;			
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


