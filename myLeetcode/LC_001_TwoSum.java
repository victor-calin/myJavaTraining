package myJavaTraining.myLeetcode;

import java.util.HashMap;
import java.util.Map;

public class LC_001_TwoSum {
	
	/* Given an array of integers, return indices of the two numbers such that they add up to a specific target.
       You may assume that each input would have exactly one solution, and you may not use the same element twice.
       Example:
			Given nums = [2, 7, 11, 15], target = 9,
			Because nums[0] + nums[1] = 2 + 7 = 9,
			return [0, 1].
	*/

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		print(twoSumHashOnePass(nums, target));
	}
	
	public static int[] twoSumHashOnePass(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			int complement = target - nums[i];
			if(map.containsKey(complement)) {
				return new int[] {map.get(complement), i};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	
	public static int[] twoSumHash(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++) 
			map.put(nums[i], i);
		
		for(int i=0; i<nums.length; i++) {
			int complement = target - nums[i];
			if(map.containsKey(complement) && map.get(complement) != i) 
				return new int[] {i, map.get(complement)};
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	
	public static int[] twoSumIteration(int[] nums, int target) {
		for(int i=0; i<nums.length-1; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					return new int[] {i, j};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
		
	
	private static void print(int[] a) {
		System.out.println("[" + a[0] + ", " + a[1] + "]");
	}

}
