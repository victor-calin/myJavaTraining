package myJavaTraining.dataStructures.stack;

public class Stack {
	private int maxSize;
	private char[] stackArray;
	private int top;
	
	public Stack(int maxSize) {
		this.maxSize = maxSize;
		this.stackArray = new char[maxSize];
		this.top = -1;
	}
	
	public void push(char j) {
		if (isFull()) {
			System.out.println("stack full");
		} 
		top++;
		stackArray[top] = j;
	}
	
	public char pop() {
		if (isEmpty()) {
			System.out.println("stack empty");
			return '0';
		}
		int old_top = top;
		top--;
		return stackArray[old_top];
	}
	
	public char peak() {
		return stackArray[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (maxSize-1 == top);
	}
}
