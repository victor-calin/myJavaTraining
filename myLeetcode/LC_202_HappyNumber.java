package myJavaTraining.myLeetcode;

public class LC_202_HappyNumber {
	
	/*  Write an algorithm to determine if a number is "happy".
		A happy number is a number defined by the following process:
		Starting with any positive integer, replace the number
			by the sum of the squares of its digits, and repeat the process
			until the number equals 1 (where it will stay), or it loops
			endlessly in a cycle which does not include 1. Those numbers
			for which this process ends in 1 are happy numbers.
		Example: 
			Input: 19
			Output: true
			Explanation: 
				12 + 92 = 82
				82 + 22 = 68
				62 + 82 = 100
				12 + 02 + 02 = 1
	*/
	
	public static void main(String[] args) {
		System.out.println(isHappy(490));
	}

	public static boolean isHappy(int n) {
		while(n > 9) {
			int sum = 0;
			while(n != 0) {
				sum += Math.pow(n%10, 2);
				n /= 10;
			}
			n = sum;
		}

		if(n == 1 || n == 7)
			return true;
		return false;
	}
}