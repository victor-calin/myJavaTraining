package myJavaTraining.myLeetcode;

public class LC_189_RotateArray {
	
	/* Given an array, rotate the array to the right by k steps, where k is non-negative.
		Example 1:
			Input: [1,2,3,4,5,6,7] and k = 3
			Output: [5,6,7,1,2,3,4]
			Explanation:
				rotate 1 steps to the right: [7,1,2,3,4,5,6]
				rotate 2 steps to the right: [6,7,1,2,3,4,5]
				rotate 3 steps to the right: [5,6,7,1,2,3,4]
		Example 2:
			Input: [-1,-100,3,99] and k = 2
			Output: [3,99,-1,-100]
			Explanation: 
				rotate 1 steps to the right: [99,-1,-100,3]
				rotate 2 steps to the right: [3,99,-1,-100]
	*/
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6};
		print(a);
		rotate(a, 2);
		print(a);

	}

	public static void rotate(int[] nums, int k) {
		int count = 0;

		for(int start = 0; count < nums.length; start++) {
			int current = start;
			int prev = nums[start];

			do {
				int next = (current + k) % nums.length;
				int temp = nums[next];
				nums[next] = prev;
				prev = temp;
				current = next;
				count++;
			} while (start != current);
		}
	}

	public static void print(int[] a) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}


}