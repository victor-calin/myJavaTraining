package myJavaTraining.basicAlgorithms;

public class AnagramSolver {
	
	/* Given 2 String, find out if they are anagrams (only letters counts) */

	public static void main(String[] args) {
		System.out.println(anagramSolver("fairy tales!", "rail, safety"));
	}
	
	public static boolean anagramSolver(String anag1, String anag2) {
		
			for (int i=0; i<anag1.length(); i++) {
				int contorAnagr1 = 0;
				int contorAnagr2 = 0;
				
				for(int j=0; j<anag1.length(); j++) {
					if( Character.isLetter(anag1.charAt(i)) && Character.isLetter(anag1.charAt(j)) ) {
						if ( Character.toLowerCase(anag1.charAt(i)) == Character.toLowerCase(anag1.charAt(j)) ) {
							contorAnagr1++;
						}
					}
				}
				
				for(int k=0; k<anag2.length(); k++) {
					if( Character.isLetter(anag1.charAt(i)) && Character.isLetter(anag2.charAt(k)) ) {
						if ( Character.toLowerCase(anag1.charAt(i)) == Character.toLowerCase(anag2.charAt(k)) ) {
							contorAnagr2++;
						}
					}
				}
				
				if (contorAnagr1 != contorAnagr2) {
					return false;
				}		
			}
			
			return true;
	}
}
