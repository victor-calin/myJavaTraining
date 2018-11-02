package myJavaTraining.myLeetcode;
import java.util.Arrays;

public class LC_066_PlusOne {
	
	/* 	Given a non-empty array of digits representing a
 			non-negative integer, plus one to the integer.
		The digits are stored such that the most significant
			digit is at the head of the list, and each element
			in the array contain a single digit.
		You may assume the integer does not contain any
		 	leading zero, except the number 0 itself.
		Example 1:
			Input: [1,2,3]
			Output: [1,2,4]
			Explanation: The array represents the integer 123.
		Example 2:
			Input: [4,3,2,1]
			Output: [4,3,2,2]
			Explanation: The array represents the integer 4321.
	*/
	
	
	public static void main(String[] args) {
		int[] a = {9, 9, 9};

		displayArray(plusOne(a));
	}

	public static int[] plusOne(int[] digits) {
		int[] result = new int[digits.length+1];
		int rem = 1;
		
		for(int i=result.length-1; i>0; i--) {
			result[i] = (digits[i-1] + rem) % 10;
			rem = (digits[i-1] + rem) / 10;
		}
		
		if(rem == 0) {
			return Arrays.copyOfRange(result, 1, result.length);
		} else {
			result[0] = rem;
			return result;
		}
	}
	
	private static void displayArray(int[] a) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

}
