package myJavaTraining.dataStructures.heapSearchTree;

public class Heap {
	private Node[] heapArray;
	private int maxSize; //size of the array
	private int currentSize; //number of nodes in the array

	public Heap(int size) {
		this.maxSize = size;
		currentSize = 0;
		heapArray = new Node[size]; //actually creates the array

	}

	public int getSize() {
		return currentSize;
	}

	public boolean isEmpty() {
		return (currentSize == 0);
	}


	//inserting ------------------------------------------------
	public boolean insert(int key) {
		if(currentSize == maxSize) {
			return false; //array is full
		}

		Node newNode = new Node(key);
		heapArray[currentSize] = newNode;

		trickleUp(currentSize);		
		currentSize++;

		return true;
	}


	//trickle up ------------------------------------------------
	private void trickleUp(int idx) {
		int parentIdx = (idx-1)/2;
		Node nodeToInsert = heapArray[idx];

		//loop as long as we haven't reached the root and the key of nodeToInsert's parent is less than nodeToInsert's key
		while(idx > 0 && heapArray[parentIdx].getKey() < nodeToInsert.getKey()) {
			heapArray[idx] = heapArray[parentIdx]; //move parent down
			idx = parentIdx;
			parentIdx = (parentIdx-1) / 2; //move up
		}
		heapArray[idx] = nodeToInsert;
	}


	//remove------------------------------------------------------
	public Node remove() {
		Node root = heapArray[0];
		currentSize--;
		heapArray[0] = heapArray[currentSize];

		trickleDown(0);

		return root;

	}


	//trickle down------------------------------------------------
	private void trickleDown(int idx) {
		int largerChildIdx;
		Node top = heapArray[idx]; //save last into top variable

		//will run as long as idx is not one the bottom row(at least 1 child)
		while(idx < currentSize/2) {
			int leftChildIdx = 2 * idx + 1; //left child idx position
			int rightChildIdx = 2 * idx + 2; //right child idx position

			//figure out which child is larger
			if(rightChildIdx < currentSize && 
					heapArray[leftChildIdx].getKey() < heapArray[rightChildIdx].getKey()) {
				largerChildIdx = rightChildIdx;
			} else {
				largerChildIdx = leftChildIdx;
			}

			if(top.getKey() >= heapArray[largerChildIdx].getKey()) {
				//successfully made root the larger key
				break;
			}

			heapArray[idx] = heapArray[largerChildIdx];
			idx = largerChildIdx; //go down 

		}
		heapArray[idx] = top;
	}


	//get level---------------------------------------------------
	private int getLevel() {
		if(currentSize == 0) {
			return 0;
		}

		else if(currentSize == 1) {
			return 1;
		}

		else if(currentSize > 1 && currentSize < 4) {
			return 2;
		}

		else if(currentSize > 3 & currentSize < 8) {
			return 3;
		}

		else if(currentSize > 7 && currentSize < 16) {
			return 4;
		} 

		else if(currentSize > 15 & currentSize < 32) {
			return 5;
		}

		else {
			return -1;
		}

	}

	
	//display heap-------------------------------------------------
	public void displayHeap() {
		if(getLevel() == 0) {
			System.out.println("the heap is empty...");
		}

		else if(getLevel() == 1) {
			System.out.println(heapArray[0]);
		}

		else if(getLevel() == 2) {
			System.out.println(tab1 + heapArray[0]); //line 1

			for(int i=1; i<currentSize; i++) {
				System.out.print(heapArray[i] + tab2); //line 2
			}
			System.out.println();
		}

		else if(getLevel() == 3) {
			System.out.println(tab3 + heapArray[0]); //line 1

			System.out.println(tab1 +  heapArray[1] + tab4 + heapArray[3]); //line 2

			for(int i=3; i<currentSize; i++) {
				System.out.print(heapArray[i] + tab2); //line 3
			}
			System.out.println();
		}

		else if(getLevel() == 4) {
			System.out.println(tab7 + heapArray[0]); //line 1

			System.out.println(tab3 +  heapArray[1] + tab8 + heapArray[2]); //line 2

			System.out.println(tab1 + heapArray[3] + tab4 + heapArray[4] 
					+ tab4 + heapArray[5] + tab4 + heapArray[6]); //line 3

			for(int i=7; i<currentSize; i++) {
				System.out.print(heapArray[i] + tab2); //line 4
			}
			System.out.println();
		}

		else if(getLevel() == 5) {
			System.out.println(tab15 + heapArray[0]); //line 1

			System.out.println(tab7 +  heapArray[1] + tab16 + heapArray[2]); //line 2

			System.out.println(tab3 + heapArray[3] + tab8 + heapArray[4] 
					+ tab8 + heapArray[5] + tab8 + heapArray[6]); //line 3

			System.out.println(tab1 + heapArray[7] + tab4 + heapArray[8] 
					+ tab4 + heapArray[9] + tab4 + heapArray[10] 
							+ tab4 + heapArray[11] + tab4 + heapArray[12] 
									+ tab4 + heapArray[13] + tab4 + heapArray[14]); //line 4

			for(int i=14; i<currentSize; i++) {
				System.out.print(heapArray[i] + tab2); //line 5
			}
			System.out.println();
		}

		else {
			System.out.println("too many levels to fit on regular display :(");
		}

	}
	
	//fields for displaying the tree
	private String tab1 = "\t";
	private String tab2 = "\t\t";
	private String tab3 = "\t\t\t";
	private String tab4 = tab2+tab2;
	private String tab7 = tab3+tab4;
	private String tab8 = tab4+tab4;
	private String tab15 = tab7+tab8;
	private String tab16 = tab8+tab8;


}
