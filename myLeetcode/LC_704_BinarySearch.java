package myJavaTraining.myLeetcode;

public class LC_704_BinarySearch {
	
	/*  Given a sorted (in ascending order) integer array nums of n elements
	 		and a target value, write a function to search target in nums.
	 	If target exists, then return its index, otherwise return -1.
		Example 1:
			Input: nums = [-1,0,3,5,9,12], target = 9
			Output: 4
			Explanation: 9 exists in nums and its index is 4
		Example 2:
			Input: nums = [-1,0,3,5,9,12], target = 2
			Output: -1
			Explanation: 2 does not exist in nums so return -1
	*/
	
	public static void main(String[] args) {
		int[] nums = {-1,0,3,5,9,12};
		
		System.out.println(search(nums, 9));
	}

	public static int search(int[] nums, int target) {
		int start = 0, end = nums.length-1, mid = 0;
		while(start <= end) {
			mid = (start + end) / 2;
			if (target < nums[mid]) {
				end = mid-1;
			} else if (target > nums[mid]) {
				start = mid+1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
