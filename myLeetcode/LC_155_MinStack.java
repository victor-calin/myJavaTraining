package myJavaTraining.myLeetcode;

class LC_155_MinStack {
	
	/* 	Design a stack that supports push, pop, top,
	  		and retrieving the minimum element in constant time.
		push(x) -- Push element x onto stack.
		pop() -- Removes the element on top of the stack.
		top() -- Get the top element.
		getMin() -- Retrieve the minimum element in the stack.
		Example:
			MinStack minStack = new MinStack();
			minStack.push(-2);
			minStack.push(0);
			minStack.push(-3);
			minStack.getMin();   --> Returns -3.
			minStack.pop();
			minStack.top();      --> Returns 0.
			minStack.getMin();   --> Returns -2.
	*/	
	
	class Value {
		int crtVal;
		int minVal;
		Value next;

		Value (int val, int min) {
			this.crtVal = val;
			this.minVal = min;
			this.next = null;
		}
	}

	private Value head;

	public void push(int val) {
		if(head == null) {
			head = new Value(val, val);
		} else {
			Value value = new Value(val, Math.min(val, head.minVal));
			value.next = head; 
			head = value; 
		}
	}

	public void pop() {
		head = head.next;
	}

	public int top() {
		return head.crtVal;
	}

	public int getMin() {
		return head.minVal;
	}
}

