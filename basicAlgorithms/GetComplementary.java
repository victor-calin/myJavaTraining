package myJavaTraining.basicAlgorithms;

public class GetComplementary {
	/* write a method which return complementary of a given number
	 * example: 123 -> 877 (123 + 877 = 1.000)
	 * 			2301 -> 7699 (2301 + 7699 = 10.000)
	 * 
	 */
	
	public static void main(String[] args) {
		
		System.out.println(getComplementary(123));
	}
	
	public static int getComplementary(int n) {
	    int round = 1;
	    for (int i = n; i > 0; i/=10) {
	      round *= 10;
	    }
	    return round - n;
	}
}
