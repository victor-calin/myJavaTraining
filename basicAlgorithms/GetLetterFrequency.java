package myJavaTraining.basicAlgorithms;

public class GetLetterFrequency {
	
	/* Define a method which receives a string and prints
	 * the letters with max and min frequencies.
	 * If more letters have the min or max frequencies, display all.
	 * Duplicates will not be displayed.
	 * 
	 */

	public static void main(String[] args) {
		getOccurences("acAb,,,, bbc");
	}
	
	public static void getOccurences(String str) {
		int maxOccurences = Integer.MIN_VALUE;
		int minOccurences = Integer.MAX_VALUE;

		//find max
		for (int i=0; i<str.length(); i++) { //find max frequency (letters only)
			int contor = 0;
			
			for(int j=i; j<str.length(); j++) {
				if( Character.isLetter(str.charAt(i)) && Character.isLetter(str.charAt(j)) ) {
					if ( Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(str.charAt(j)) ) {
						contor++;
					}
				}
			}
			
			if (maxOccurences < contor) {
				maxOccurences = contor;
			}		
		}
		
		for (int i=0; i<str.length(); i++) { //find the letter with max frequency
			int contor = 0;
			
			for(int j=i; j<str.length(); j++) {
				if( Character.isLetter(str.charAt(i)) && Character.isLetter(str.charAt(j)) ) {
					if ( Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(str.charAt(j)) ) {
						contor++;
					}
				}
			}
			
			if (maxOccurences == contor) { 
				System.out.println("Character " + str.charAt(i) + " appears " + maxOccurences + " times.");
			}		
		}
		
		System.out.println();
		
		//find min
		for (int i=0; i<str.length(); i++) { //find min frequency
			int contor = 0;
						
			for(int j=0; j<str.length(); j++) {
				if( Character.isLetter(str.charAt(i)) && Character.isLetter(str.charAt(j)) ) {
					if ( Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(str.charAt(j)) ) {
						contor++;
					}
				}
			}
			
			if (Character.isLetter(str.charAt(i)) && contor < minOccurences) {
					minOccurences = contor;
				}
		
		}
		
		for (int i=0; i<str.length(); i++) { //find letters with min frequency
			int contor = 0;
			boolean isDuplicate = false;
			
			for(int j=0; j<str.length(); j++) {
				if( Character.isLetter(str.charAt(i)) && Character.isLetter(str.charAt(j)) ) {
					if ( Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(str.charAt(j)) ) {
						contor++;
					}
				}
			}
			
			if (minOccurences == contor) {
				
				for (int k=0; k<i; k++) { //avoid duplicates 
					if (Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(str.charAt(k))) {
						isDuplicate	= true;
					}
				}
				if (!isDuplicate) {
					System.out.println("Character " + str.charAt(i) + " appears " + minOccurences + " times.");
				}
			}		
		}
		
		
	}
}
