package myJavaTraining.basicAlgorithms;

public class SortingAlgorithms {
	public static void main(String[] args) {
		int[] myArray = {12, 81, 74, 43, 1098, 0, 8, 92, 17, 754, 912, 0, 6, 4};

		quickSort(myArray);

		displayArray(myArray);

	}

	//selection sort ----------------------------------
	public static int[] selectionSort(int[] a) {

		for (int i=0; i<a.length; i++) {
			int minValueIndex = i;

			for (int j=i+1; j<a.length; j++) {
				if(a[j] < a[minValueIndex]) {
					minValueIndex = j;
				}
			}

			int tempValue = a[i];
			a[i] = a[minValueIndex];
			a[minValueIndex] = tempValue;
		}
		return a;  
	}


	//insertion sort -----------------------------------
	public static int[] insertionSort(int[] a) {
		for (int i=1; i<a.length; i++) {
			int element = a[i]; //data to bring into sorted area
			int j = i-1; //index of last el in sorted area

			while (j >= 0 && a[j] > element) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = element;
		}
		return a;
	}


	//merge sort ---------------------------------------
	public static void mergeSort(int[] a) {
		sort(a, 0, a.length-1);
	}

	public static void sort(int[] a, int start, int end) {
		if(end <= start) {
			return; //we're done traversing the array
		}

		int mid  = (start + end) / 2;
		sort(a, start, mid); //sort left half
		sort(a, mid+1, end); //sort right half
		merge(a, start, mid, end); //merge sorted results into initial array "a"
	}

	private static void merge(int[] a, int start, int mid, int end) {
		int tempArray[] = new int[end-start+1];

		int leftSlot = start; //index counter for left part of the array
		int rightSlot = mid+1; //index counter for right part of the array
		int k = 0;

		while(leftSlot <= mid && rightSlot <= end) {
			if(a[leftSlot] < a[rightSlot]) {
				tempArray[k] = a[leftSlot];
				leftSlot++;
			} else {
				tempArray[k] = a[rightSlot];
				rightSlot++;
			}
			k++;
		} 
		//at this point both sides of the array are sorted

		if(leftSlot <= mid) {
			while(leftSlot <= mid) {
				tempArray[k] = a[leftSlot];
				leftSlot++;
				k++;
			}
		} else if(rightSlot <= end) {
			while(rightSlot <= end) {
				tempArray[k] = a[rightSlot];
				rightSlot++;
				k++;
			}
		} 
		//at this point all elements in tempArray are sorted, we just need to copy into a

		for (int i=0; i<tempArray.length; i++) {
			a[start+i] = tempArray[i];
		}
	}


	//quick sort ----------------------------------
	public static void quickSort(int[] a) {
		recursiveQuickSort(a, 0, a.length-1);
	}

	public static void recursiveQuickSort(int a[], int start, int end) {
		if(start < end) {
			int mid = partition(a, start, end); 
			recursiveQuickSort(a, start, mid-1); //sorts the left half
			recursiveQuickSort(a, mid+1, end); //sorts the right half
		}
	}

	public static int partition(int[] a, int start, int end) {
		int pivot = a[end]; 
		int i = start-1; //if j is smaller or equal than pivot we'll swap i and j
		int tempValue = 0; //used for swap
		for (int j=start; j<end; j++) {
			if(a[j] <= pivot) {
				i++;
				tempValue = a[i];
				a[i] = a[j];
				a[j] = tempValue;
			}
		}
		//next we have to put the pivot in the correct slot
		//swap a[i+1] (up to i everything is sorted, so pivot must come after)
		tempValue = a[i+1];
		a[i+1] = pivot;
		a[end] = tempValue;

		return i+1; //returning the pivot's final index to be used as mid
	}


	//displayArray----------------------------------
	public static void displayArray(int[] a) {
		System.out.print("[ ");
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("]");
	}
}