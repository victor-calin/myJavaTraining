package myJavaTraining.projects.radixSort;

public class App {
	
	/* Output: 
	 * 			Before sorting:
	 *			[1000, 4, 25, 319, 88, 51, 3430, 8471, 701, 1, 2989, 657, 713]
	 *			Ascending sorting:
	 *			[1, 4, 25, 51, 88, 319, 657, 701, 713, 1000, 2989, 3430, 8471]
	 *		    Descending sorting:
	 *			[8471, 3430, 2989, 1000, 713, 701, 657, 319, 88, 51, 25, 4, 1]
	 */

	
	public static void main(String[] args) {
		int[] nums1 = {1000, 4, 25, 319, 88, 51, 3430, 8471, 701, 1, 2989, 657, 713};

		System.out.println("Bofore sorting:");
		RadixSort.displayArr(nums1);
		
		System.out.println("Ascending sorting:");
		RadixSort.radixSort(nums1);
		RadixSort.displayArr(nums1);
		
		System.out.println("Descending sorting:");
		RadixSort.radixSortReverse(nums1);
		RadixSort.displayArr(nums1);
	}
}