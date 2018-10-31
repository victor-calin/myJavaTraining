package myJavaTraining.dataStructures.hashTable;


public class HashTable {
	String[] hashArray;
	int arraySize;
	int size = 0; //counter for number of elements in the hash table

	public HashTable(int noOfSlots) {
		if(isPrime(noOfSlots)) {
			this.hashArray = new String[noOfSlots];
			arraySize = noOfSlots;
		} else {
			int primeCount = getNextPrime(noOfSlots);
			this.hashArray = new String[primeCount];
			arraySize = primeCount;

			System.out.println("Hash table size given " + noOfSlots + " is not a prime");
			System.out.println("Hash table size changed to  " + primeCount);
		}
	}

	private boolean isPrime(int num) {
		for(int i=2; i*i <= num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}

	private int getNextPrime(int num) {
		int nextInt = num + 1;
		while(!isPrime(nextInt)) {
			nextInt++;
		}
		return nextInt;
	}


	//first hash function (returns preferred idx pos)---------------
	private int hashFunc1(String word) {
		int hashVal = word.hashCode();
		hashVal %= arraySize;
		if(hashVal < 0) {
			hashVal += arraySize;
		}
		return hashVal; //ideal index position we'd like to insert or search in
	}


	//second hash function (retuns step size greater than 0)-----
	private int hashFunc2(String word) {
		int hashVal = word.hashCode();
		hashVal %= arraySize;

		if(hashVal < 0) {
			hashVal += arraySize;
		}
		return  3 - hashVal % 3; //3 can be any prime smaller than arraySize
	}


	//inserting into HashTable
	public void insert(String word) {
		int hashVal = hashFunc1(word);
		int stepSize = hashFunc2(word);

		while(hashArray[hashVal] != null) {
			hashVal += stepSize;
			hashVal %= arraySize;
		}

		hashArray[hashVal] = word;
		System.out.println("inserted word: " + word);
		size++;
	}


	//finding element in the HashTable----------------------------
	public String find(String word) {
		int hashVal = hashFunc1(word);
		int stepSize = hashFunc2(word);

		while(hashArray[hashVal] != null) {
			if(hashArray[hashVal].equals(word)) {
				return hashArray[hashVal];
			}
			hashVal += stepSize;
			hashVal %= arraySize;
		}
		return hashArray[hashVal];
	}


	//display table-----------------------
	public void displayTable() {
		System.out.println("\n\tTable: ");
		for(int i=0; i<arraySize; i++) {
			if(hashArray[i] != null) {
				System.out.print(hashArray[i] + " ");
			} else {
				System.out.print("** ");
			}
		}
		System.out.println();
	}


}
