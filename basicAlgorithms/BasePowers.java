package myJavaTraining.basicAlgorithms;

public class BasePowers {
	
	/* Write a method which receives a base and an exponent and displays
	 * all powers of the base from 0 to exponent 
	 * 
	 */

	public static void main(String[] args) {
		
		basePowers(2, 10);

	}
	
	public static void basePowers(int base, int exp) {
	    System.out.print("1 ");
	    int result = 1;
	    for (int i=1; i<=exp; i++) {
	      result *= base;
	      System.out.print(result + " "); 
	    }
	    System.out.println();
	}

}
