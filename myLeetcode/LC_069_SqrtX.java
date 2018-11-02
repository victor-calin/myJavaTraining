package myJavaTraining.myLeetcode;

public class LC_069_SqrtX {
	
	/* 	Implement int sqrt(int x).
		Compute and return the square root of x, where x is
		 	guaranteed to be a non-negative integer.
		Since the return type is an integer, the decimal digits
		 	are truncated and only the integer part of the result is returned.
		Example 1:
			Input: 4
			Output: 2
		Example 2:
			Input: 8
			Output: 2
		Explanation: The square root of 8 is 2.82842..., and since 
            the decimal part is truncated, 2 is returned.
	*/
	
	
	public static void main(String[] args) {
		System.out.println(mySqrt(8));
	}


	public static int mySqrt(int x) {
		int l=1, r=x, result = 0;

		while(l<=r) {
			int m=l+(r-l)/2;

			if(m == x / m) 
				return m;

			else if(m > x / m) 
				r = m - 1;

			else {
				l = m + 1;
				result = m;
			}
		}

		return result;
	}

}
