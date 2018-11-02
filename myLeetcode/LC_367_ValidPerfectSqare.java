package myJavaTraining.myLeetcode;

public class LC_367_ValidPerfectSqare {
	
	/*  Given a positive integer num, write a function
	 		which returns True if num is a perfect square else False.
		Note: Do not use any built-in library function such as sqrt.
		Example 1:
			Input: 16
			Output: true
		Example 2:
			Input: 14
			Output: false
	*/

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(16));
	}

	public static boolean isPerfectSquare(int num) {
		long l=0, r=num;
        while(l<=r) {
            long m = (l+r)/2;
            if(num == m*m) return true;
            else if(num > m*m) l=m+1;
            else if(num < m*m) r=m-1;
        }
        return false;
	}

}
