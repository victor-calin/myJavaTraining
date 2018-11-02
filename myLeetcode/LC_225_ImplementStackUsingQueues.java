package myJavaTraining.myLeetcode;
import java.util.ArrayDeque;
import java.util.Queue;

public class LC_225_ImplementStackUsingQueues {

	class MyStack {

		/** Initialize your data structure here. */
		private Queue<Integer> stack;

		public MyStack() {
			this.stack = new ArrayDeque<Integer>();                       
		}

		/** Push element x onto stack. */
		public void push(int x) {
			stack.add(x);
			for(int i=1; i<stack.size(); i++) 
				stack.add(stack.poll());
		}

		/** Removes the element on top of the stack and returns that element. */
		public int pop() {
			return stack.poll();        
		}

		/** Get the top element. */
		public int top() {
			return stack.peek();        
		}

		/** Returns whether the stack is empty. */
		public boolean empty() {
			return stack.isEmpty();
		}
	}

	/**
	 * Your MyStack object will be instantiated and called as such:
	 * MyStack obj = new MyStack();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.top();
	 * boolean param_4 = obj.empty();
	 */

}
