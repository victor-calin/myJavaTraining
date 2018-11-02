package myJavaTraining.myLeetcode;

public class LC_053_MaximumSubarray {
	
	/*  Given an integer array nums, find the contiguous subarray
	  		(containing at least one number) which has the largest sum and return its sum.
		Example:
			Input: [-2,1,-3,4,-1,2,1,-5,4],
			Output: 6
			Explanation: [4,-1,2,1] has the largest sum = 6.
	*/

	public static void main(String[] args) {
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

		System.out.println(maxSubArray(nums));
	}

	public static int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];

		int maxSum = nums[0];
		int sum = nums[0];

		for(int i=1; i<nums.length; i++) {
			if(i !=0) sum += nums[i];
			if(sum > maxSum) maxSum = sum;
			if(sum < 0) sum = 0;
		}
		return maxSum;
	}

}



