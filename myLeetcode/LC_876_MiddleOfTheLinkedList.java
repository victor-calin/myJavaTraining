package myJavaTraining.myLeetcode;

public class LC_876_MiddleOfTheLinkedList {
	
	/*  Given a non-empty, singly linked list with head node head,
	 		return a middle node of linked list.
		If there are two middle nodes, return the second middle node. 
		Example 1:
			Input: [1,2,3,4,5]
			Output: Node 3 from this list (Serialization: [3,4,5])
		The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
		Note that we returned a ListNode object ans, such that:
			ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
		Example 2:
			Input: [1,2,3,4,5,6]
			Output: Node 4 from this list (Serialization: [4,5,6])
		Since the list has two middle nodes with values 3 and 4, we return the second one.
	*/

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		ListNode list2 = new ListNode(2);
		ListNode list3 = new ListNode(3);
		ListNode list4 = new ListNode(4);
		ListNode list5 = new ListNode(5);
		ListNode list6 = new ListNode(6);

		list1.next = list2;
		list2.next = list3;
		list3.next = list4;
		list4.next = list5;
		list5.next = list6;

		displayListNode(middleNode(list1));	
	}

	public static ListNode middleNode(ListNode head) {
		if(head == null || head.next == null) return head;

		ListNode it = head;
		int count = 1;

		while(it.next != null) {
			it = it.next;
			count++;
		}

		it = head;
		int middle = 0;

		while(middle != count/2) {
			it = it.next;
			middle++;
		}
		return it;
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
