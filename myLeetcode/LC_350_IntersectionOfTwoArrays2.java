package myJavaTraining.myLeetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_350_IntersectionOfTwoArrays2 {
	
	/* Given two arrays, write a function to compute their intersection.
		Example 1:
			Input: nums1 = [1,2,2,1], nums2 = [2,2]
			Output: [2,2]
		Example 2:
			Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
			Output: [4,9]
		Note: Each element in the result should appear as many times as it shows in both arrays.
			  The result can be in any order.
	*/	
	
	public static void main(String[] args) {
		int[] nums1 = {4, 9, 5};
		int[] nums2 = {9, 4, 9, 8, 4};

		print(intersect(nums1, nums2));

	}

	public static int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();

		for(int n : nums1) 
			if(map.containsKey(n)) 
				map.put(n, map.get(n) + 1);
			else 
				map.put(n, 1);

		for(int n : nums2) 
			if(map.containsKey(n) && map.get(n) > 0) {
				list.add(n);
				map.put(n, map.get(n) - 1);
			}

		int[] res = new int[list.size()];
		int i = 0;
		for(int n : list) res[i++] = n;

		return res;   
	}

	public static void print(int[] a) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}


}