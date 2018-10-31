package myJavaTraining.dataStructures.binarySearchTree;

public class BinarySearchTre {
	//fields
	private Node root;

	//insert---------------------------------------
	public void insert(int key) {
		Node newNode = new Node(key);

		if(this.root == null) {
			this.root = newNode;
		} else {
			Node current = this.root; //traversal variable
			Node parent;

			while(true) {
				parent = current;
				if(key < current.key) { //left scenario
					current = current.leftChild;
					if(current == null) { //it's parent is a leaf node
						parent.leftChild = newNode;
						return;
					}
				} else { //right scenario
					current = current.rightChild;
					if(current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}


	//find min--------------------------------------
	public Node findMin() {
		Node current = root;
		Node last = null;

		while(current != null) {
			last = current;
			current = current.leftChild;
		}
		return last;
	}


	//find max--------------------------------------
	public Node findMax() {
		Node current = root;
		Node last = null;

		while(current != null) {
			last = current;
			current = current.rightChild;
		}
		return last;
	}


	//remove---------------------------------------
	public boolean remove(int key) {

		Node current = root;
		Node parent = root;

		boolean isLeftChild = false;

		//searching for the node to delete
		while(current.key != key) {
			parent = current;
			if(key < current.key) {
				isLeftChild = true;
				current = current.leftChild;
			} else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if(current == null) {
				return false; 
			}
		}

		//found the node to delete
		Node toDelete = current;		

		//if node is a leaf
		if(toDelete.leftChild == null && toDelete.rightChild == null) {
			if(toDelete == root) {
				root = null;
			} else if(isLeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		}

		//if node has one child (left)
		else if(toDelete.rightChild == null) {
			if(toDelete == root) {
				root = toDelete.leftChild;
			} else if(isLeftChild) {
				parent.leftChild = toDelete.leftChild;
			} else {
				parent.rightChild = toDelete.leftChild;
			}
		}

		//if node has one child (right)
		else if(toDelete.leftChild == null) {
			if(toDelete == root) {
				root = toDelete.rightChild;
			} else if(isLeftChild) {
				parent.leftChild = toDelete.rightChild;
			} else {
				parent.rightChild = toDelete.rightChild;
			}
		}

		//if node has 2 children
		else {
			Node successor = getsuccessor(toDelete);

			//connect parent of toDelete to successor instead
			if(toDelete == root) {
				root = successor;
			} else if(isLeftChild) {
				parent.leftChild = successor;
			} else {
				parent.rightChild = successor;
			}

			successor.leftChild = toDelete.leftChild;
		}

		return true;		
	}


	//get successor--------------------------------
	private Node getsuccessor(Node toDelete) {
		Node successorParent = toDelete;
		Node successor = toDelete;

		Node current = toDelete.rightChild; //go to the roght child

		while(current != null) { //start going left down the tree until node has no left child
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}

		//if the successor is not a right child
		if(successor != toDelete.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = toDelete.rightChild;  
		}
		return successor;
	}


	//get level-------------------------------------------------
	public int getLevel(Node root) {
		if(root == null) {
			return 0;
		}
		int left = getLevel(root.leftChild);
		int right = getLevel(root.rightChild);

		return Math.max(left, right) + 1;
	}


	//display tree-------------------------------------------
	public void displayTree() {
		if(getLevel(root) == 0) {
			System.out.println("the tree is empty...");

		} else if (getLevel(root) == 1) {
			System.out.println(value(root));

		} else if (getLevel(root) == 2) {
			System.out.println(tab1 + value(root)); //line 1

			System.out.println(value(root.leftChild) + tab2 + value(root.rightChild)); //line 2

		} else if (getLevel(root) == 3) {
			System.out.println(tab3 + value(root)); //line 1

			System.out.println(tab1 +  value(root.leftChild) + tab4 + value(root.rightChild)); //line 2

			System.out.println(value(root.leftChild.leftChild) + tab2 + value(root.leftChild.rightChild) 
			+ tab2 + value(root.rightChild.leftChild) + tab2 + value(root.rightChild.rightChild)); //line 3

		} else if (getLevel(root) == 4) {
			System.out.println(tab7 + value(root)); //line 1

			System.out.println(tab3 +  value(root.leftChild) + tab8 + value(root.rightChild)); //line 2

			System.out.println(tab1 + value(root.leftChild.leftChild) + tab4 + value(root.leftChild.rightChild) 
			+ tab4 + value(root.rightChild.leftChild) + tab4 + value(root.rightChild.rightChild)); //line 3

			System.out.println(value(root.leftChild.leftChild.leftChild) + tab2 + value(root.leftChild.leftChild.rightChild) 
			+ tab2 + value(root.leftChild.rightChild.leftChild) + tab2 + value(root.leftChild.rightChild.rightChild) 
			+ tab2 + value(root.rightChild.leftChild.leftChild) + tab2 + value(root.rightChild.leftChild.rightChild) 
			+ tab2 + value(root.rightChild.rightChild.leftChild) + tab2 + value(root.rightChild.rightChild.rightChild)); //line 4

		} else if (getLevel(root) == 5) {
			System.out.println(tab15 + value(root)); //line 1

			System.out.println(tab7 +  value(root.leftChild) + tab16 + value(root.rightChild)); //line 2

			System.out.println(tab3 + value(root.leftChild.leftChild) + tab8 + value(root.leftChild.rightChild) 
			+ tab8 + value(root.rightChild.leftChild) + tab8 + value(root.rightChild.rightChild)); //line 3

			System.out.println(tab1 + value(root.leftChild.leftChild.leftChild) + tab4 + value(root.leftChild.leftChild.rightChild) 
			+ tab4 + value(root.leftChild.rightChild.leftChild) + tab4 + value(root.leftChild.rightChild.rightChild) 
			+ tab4 + value(root.rightChild.leftChild.leftChild) + tab4 + value(root.rightChild.leftChild.rightChild) 
			+ tab4 + value(root.rightChild.rightChild.leftChild) + tab4 + value(root.rightChild.rightChild.rightChild)); //line 4


			//for line 5 we have to make sure not to refer null parents
			if(root.leftChild.leftChild.leftChild == null) {
				System.out.print("--" + tab2 + "--");
			} else {
				System.out.print(value(root.leftChild.leftChild.leftChild.leftChild) + tab2 + value(root.leftChild.leftChild.leftChild.rightChild));
			}

			if(root.leftChild.leftChild.rightChild == null) {
				System.out.print(tab2 + "--" + tab2 + "--");
			} else {
				System.out.print(tab2 + value(root.leftChild.leftChild.rightChild.leftChild) + tab2 + value(root.leftChild.leftChild.rightChild.rightChild));
			}

			if(root.leftChild.rightChild.leftChild == null) {
				System.out.print(tab2 + "--" + tab2 + "--");
			} else {
				System.out.print(tab2 + value(root.leftChild.rightChild.leftChild.leftChild) + tab2 + value(root.leftChild.rightChild.leftChild.rightChild));
			}

			if(root.leftChild.rightChild.rightChild == null) {
				System.out.print(tab2 + "--" + tab2 + "--");
			} else {
				System.out.print(tab2 + value(root.leftChild.rightChild.rightChild.leftChild) + tab2 + value(root.leftChild.rightChild.rightChild.rightChild));
			}

			if(root.rightChild.leftChild.leftChild == null) {
				System.out.print(tab2 + "--" + tab2 + "--");
			} else {
				System.out.print(tab2 + value(root.rightChild.leftChild.leftChild.leftChild) + tab2 + value(root.rightChild.leftChild.leftChild.rightChild));
			}

			if(root.rightChild.leftChild.rightChild == null) {
				System.out.print(tab2 + "--" + tab2 + "--");
			} else {
				System.out.print(tab2 + value(root.rightChild.leftChild.rightChild.leftChild) + tab2 + value(root.rightChild.leftChild.rightChild.rightChild));
			}

			if(root.rightChild.rightChild.leftChild == null) {
				System.out.print(tab2 + "--" + tab2 + "--");
			} else {
				System.out.print(tab2 + value(root.rightChild.rightChild.leftChild.leftChild) + tab2 + value(root.rightChild.rightChild.leftChild.rightChild));
			}

			if(root.rightChild.rightChild.rightChild == null) {
				System.out.print(tab2 + "--" + tab2 + "--\n");
			} else {
				System.out.print(tab2 + value(root.rightChild.rightChild.rightChild.leftChild) + tab2 + value(root.rightChild.rightChild.rightChild.rightChild) + "\n");
			}


		} else {
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


	private String value(Node root) {
		if(root == null) {
			return "--";
		} else {
			return String.valueOf(root.key);
		}
	}


}
