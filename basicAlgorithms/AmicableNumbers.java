package myJavaTraining.basicAlgorithms;

public class AmicableNumbers {
	
	/* Write a method which displays all amicable pair numbers 
	 * within a given range.
	 * 2 amicable numbers have the sum of all divisors + 1 
	 * equal to the other.
	 * ex: 220 & 284
	 * 1 + 2 + 4 + 5 + 10 + 11 + 20 + 44 + 55 + 110 = 284
	 * 1 + 2 + 4 + 71 + 142 = 220 
	 */

	public static void main(String[] args) {
		
		friendPairs(1, 10000);

	}
	
	public static int tryFriend(int a) {
	    int sum = 0;
	    for (int i=1; i <= a/2; i++) {
	      if (a%i == 0) {
	        sum += i;
	      }
	    }
	    return sum;
	  }

	  public static int getFriend(int a) {
	    int possibleAFriend = tryFriend(a);
	    int possibleBFriend = tryFriend(possibleAFriend);
	    if (possibleBFriend == a) {
	      return possibleAFriend;
	    }
	    return a;
	  }

	  public static void friendPairs(int start, int end) {
	    for (int i=start; i<=end; i++) {
	      int rez = getFriend(i);
	      if (rez != i && i < rez) {
	        System.out.println(i + " " + rez);
	      }  
	    }
	  }

}
