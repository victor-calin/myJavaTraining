package myJavaTraining.projects.radixSort;
import java.util.*;

public abstract class RadixSort {
	private static List<ArrayDeque<Integer>> queues = generateQueues();

	public static int[] radixSort(int[] nums) {
		for(int crtIt=1; crtIt<=getMaxLength(nums); crtIt++) {
			for(int i=0; i<nums.length; i++) {
				putInQueues(crtIt, nums[i]);
			}
			putBackInArray(nums);
		}
		return nums;
	}


	private static void putInQueues(int crtIt, int n) {
		int crtDigit = currentDigit(crtIt, n);
		queues.get(crtDigit).offerLast(n);
	}


	private static int currentDigit(int crtIt, int n) {
		if(getLength(n) < crtIt)
			return 0;
		while(crtIt-- > 1) {
			n /= 10;
		}
		return n % 10;       
	}


	private static void putBackInArray(int[] nums) {
		int count = 0;
		for(int i=0; i<queues.size(); i++) {
			while(!queues.get(i).isEmpty()) {
				nums[count++] = queues.get(i).removeFirst();
			}
		}
	}


	private static List<ArrayDeque<Integer>> generateQueues() {
		List<ArrayDeque<Integer>> queues = new ArrayList<>();
		for(int i=0; i<10; i++) {
			queues.add(new ArrayDeque<>());
		}
		return queues;
	}


	private static int getMaxLength(int[] nums) {
		int maxLength = Integer.MIN_VALUE;
		for(int i=0; i<nums.length; i++) {
			int crtLength = getLength(nums[i]);
			if(crtLength > maxLength)
				maxLength = crtLength;
		}
		return maxLength;
	}


	private static int getLength(int n) {
		return String.valueOf(n).length();
	}


	public static int[] radixSortReverse(int[] nums) {
		for(int crtIt=1; crtIt<=getMaxLength(nums); crtIt++) {
			for(int i=0; i<nums.length; i++) {
				putInQueues(crtIt, nums[i]);
			}
			putBackInArrayReversed(nums);
		}
		return nums;
	}


	private static void putBackInArrayReversed(int[] nums) {
		int count = 0;
		for(int i=9; i>=0; i--) {
			while(!queues.get(i).isEmpty()) {
				nums[count++] = queues.get(i).removeFirst();
			}
		}
	}


	public static void displayArr(int[] nums) {
		System.out.print("\t[" + nums[0]);
		for(int i=1; i<nums.length; i++)
			System.out.print(", " + nums[i]);
		System.out.println("]");
	}
}