package myJavaTraining.myLeetcode;

public class LC_033_SearchInRotatedSortedArray {
	
	/* Suppose an array sorted in ascending order is rotated
	  		at some pivot unknown to you beforehand.
				(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
	   You are given a target value to search. If found in the array
	    	return its index, otherwise return -1.
	   You may assume no duplicate exists in the array.
	   Your algorithm's runtime complexity must be in the order of O(log n).
			Example 1:
				Input: nums = [4,5,6,7,0,1,2], target = 0
				Output: 4
			Example 2:
				Input: nums = [4,5,6,7,0,1,2], target = 3
				Output: -1
	*/
	
	public static void main(String[] args) {
		int[] nums = {5, 1, 3};

		System.out.println(search(nums, 3));
	}


	public static int search(int[] nums, int target) {
		if(nums == null || nums.length == 0) return -1;
		int l = 0, r = nums.length-1;

		while(l < r) {
			int m = (l + r) / 2;

			if(nums[m] >= nums[l]) {
				if(target <= nums[m] && target >= nums[l]) {
					r = m;
				} else {
					l = m + 1;
				}

			} else {
				if(target > nums[m] && target <= nums[r]) {
					l = m + 1;
				} else {
					r = m;
				}
			}
		}

		if(nums[l] == target) {
			return l;
		} else {
			return -1;
		}
	}


}
