package myJavaTraining.basicAlgorithms;
public class ZerosToLeft {
	
	/* write a method which moves zeros from an int array to the left */
	
	public static void main(String[] args) {
		int[] numbers = {1, 0, 2, -5};
		int[] numbers2 = {0, 2, 1, 0, -1, 14, 0, -6};

		zerosToLeft(numbers);
		zerosToLeft(numbers2);
	}

	public static void zerosToLeft(int[] numbers) {
		int nextAvailable = numbers.length-1;
    
		for (int i=nextAvailable; i>=0; i--) {
			if (numbers[i] != 0) {
				numbers[nextAvailable] = numbers[i];
				nextAvailable--;
			} 
		}

		while (nextAvailable >= 0) {
			numbers[nextAvailable] = 0;
			nextAvailable--;
		}

		for (int i=0; i<numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}

		System.out.println();
	}

}