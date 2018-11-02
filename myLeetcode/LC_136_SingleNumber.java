package myJavaTraining.myLeetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC_136_SingleNumber {
	
	/*  Given a non-empty array of integers, every element
	  		appears twice except for one. Find that single one.
		Note: your algorithm should have a linear runtime complexity.
		 	Could you implement it without using extra memory?
		Example 1:
			Input: [2,2,1]
			Output: 1
		Example 2:
			Input: [4,1,2,1,2]
			Output: 4
	*/	
	
	public static void main(String[] args) {
		int[] nums = {4, 1, 2, 1, 2};

		System.out.println(singleNumberMap(nums));
	}

	public static int singleNumber(int[] nums) {
		Arrays.sort(nums);
		for(int i=0; i<nums.length-1; i+=2) {
			if(nums[i] != nums[i+1]) return nums[i];
		}
		return nums[nums.length-1];
	}


	public static int singleNumberMap(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			if(map.containsKey(nums[i])) 
				map.put(nums[i], 2);
			else 
				map.put(nums[i], 1);
		}

		for(int i=0; i<nums.length; i++) 
			if(map.get(nums[i]) == 1)
				return nums[i];
		return -1;
	}

}
