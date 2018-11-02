package myJavaTraining.myLeetcode;

public class LC_088_MergeSortedArray {
	
	/*  Given two sorted integer arrays nums1 and nums2,
	 		merge nums2 into nums1 as one sorted array.
		Note: the number of elements initialized in nums1
		 	and nums2 are m and n respectively.
		You may assume that nums1 has enough space (size that
		 	is greater or equal to m + n) to hold additional elements from nums2.
		Example:
			Input:
				nums1 = [1,2,3,0,0,0], m = 3
				nums2 = [2,5,6],       n = 3
			Output: [1,2,2,3,5,6]
	*/
	
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 0, 0, 0};
		int[] nums2 = {2, 5, 6};

		merge(nums1, 3, nums2, 3);
		displayArray(nums1);

	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		m--; 
		n--;

		while(n >= 0) {
			if (m < 0 || nums1[m] < nums2[n]) {
				nums1[n+m+1] = nums2[n];
				n--;
			} else {
				nums1[n+m+1] = nums1[m];
				m--;
			}
		}
	}

	public static void displayArray(int[] a) {
		for(int i =0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}