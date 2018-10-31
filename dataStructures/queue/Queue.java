package myJavaTraining.dataStructures.queue;

public class Queue {
	private int maxSize; //initializes the set number of slots
	private long[] queArray; // slots to add data
	private int front; //index position of the front
	private int rear; //index position at the back
	private int nItems; //counter for elements in queue

	public Queue(int size) {
		this.maxSize = size;
		this.queArray = new long[this.maxSize];
		front = 0;
		rear = -1; //when no item in queue
		nItems = 0;
	}

	public void insert(long j) {
		if (rear == maxSize -1) {
			rear = -1;
		}
		rear++;
		queArray[rear] = j;
		nItems++;
	}

	public long remove() { //remove item from the front
		long temp = queArray[front];
		front++;
		if (front == maxSize) {
			System.out.println("array is empty");
			front = 0;
		}
		nItems--;
		return temp;
	}

	public long peekFront() {
		return queArray[this.front];     
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}
	
	public boolean isFull() {
		return (maxSize == nItems);
	}

	public void view() {
		System.out.print("[ ");
		for (int i=0; i<queArray.length; i++) {
			System.out.print(queArray[i] + " ");
		}
		System.out.print("]");
	}

}
