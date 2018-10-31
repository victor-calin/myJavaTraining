package myJavaTraining.basicAlgorithms;

public class SieveOfEratosthenes {
	
	/* Implement the "Sieve Of Eratosthenes" algorithm to display
	 * all prime numbers up to a given limit.	 * 
	 */
	
	public static void main(String[] args) {
		displayPrimes(200);
	}

	public static void displayPrimes(int n) {
		boolean[] isPrime = new boolean[n+1];

		for (int i=2; i<isPrime.length; i++) {
			isPrime[i] = true;
		}

		for (int number=2; number<isPrime.length; number++) {
			if (isPrime[number]) {
				for (int j = number; number * j < isPrime.length; j++) {
					isPrime[number * j] = false;
				}
			}
		}

		int countPrimes = 0;
		for (int i=2; i<isPrime.length; i++) {
			if (isPrime[i] == true) {
				countPrimes++;
				System.out.print(i + " ");
			}
		}
		System.out.println("\n" + countPrimes + " prime numbers!");
	}

}
