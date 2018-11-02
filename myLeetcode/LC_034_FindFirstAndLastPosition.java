package myJavaTraining.myLeetcode;

public class LC_034_FindFirstAndLastPosition {
	
	/*  Given an array of integers nums sorted in ascending order, 
	  		find the starting and ending position of a given target value.
	    Your algorithm's runtime complexity must be in the order of O(log n).
		If the target is not found in the array, return [-1, -1].
			Example 1:
				Input: nums = [5,7,7,8,8,10], target = 8
				Output: [3,4]
			Example 2:
				Input: nums = [5,7,7,8,8,10], target = 6
				Output: [-1,-1]
	*/
	
	public static void main(String[] args) {
		int[] nums = {5, 7, 7, 8, 8, 10};
		int[] res = searchRange(nums, 8);
		System.out.println(res[0] + ", " + res[1]);
	}


	public static int[] searchRange(int[] nums, int target) {
		if(nums.length == 0) return new int[] {-1, -1};

		int firstPosition = getFirstPosition(nums, target);
		if(nums[firstPosition] != target) return new int[] {-1, -1};

		int lastPosition = getFirstPosition(nums, target + 1);
		if(nums[lastPosition] != target) lastPosition--;

		return new int[] {firstPosition, lastPosition};
	}

	private static int getFirstPosition(int[] nums, int target) {
		int l=0, r=nums.length-1;

		while(l < r) {
			int m = l + (r - l) / 2;
			if(nums[m] < target) l = m + 1;
			else r = m;
		}

		return r;
	}



}
