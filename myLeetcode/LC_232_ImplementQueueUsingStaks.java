package myJavaTraining.myLeetcode;
import java.util.Stack;

public class LC_232_ImplementQueueUsingStaks {

	class MyQueue {

		/** Initialize your data structure here. */
		private Stack<Integer> q1;
		private Stack<Integer> q2;
		private int front;

		public MyQueue() {
			this.q1 = new Stack<Integer>();
			this.q2 = new Stack<Integer>();  
		}

		/** Push element x to the back of queue. */
		public void push(int x) {
			if(q1.isEmpty()) {
				front = x;
			}
			q1.push(x);
		}

		/** Removes the element from in front of queue and returns that element. */
		public int pop() {
			if(q2.isEmpty()) {
				while(!q1.isEmpty()) {
					q2.push(q1.pop());
				}
			}
			return q2.pop();        
		}

		/** Get the front element. */
		public int peek() {
			if(!q2.isEmpty()) {
				return q2.peek();
			}
			return this.front;        
		}

		/** Returns whether the queue is empty. */
		public boolean empty() {
			return q1.isEmpty() && q2.isEmpty();        
		}
	}
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
