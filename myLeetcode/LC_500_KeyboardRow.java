package myJavaTraining.myLeetcode;
import java.util.ArrayList;

public class LC_500_KeyboardRow {
	
	/*  Given a List of words, return the words that can be typed using letters
	  		of alphabet on only one row's of American keyboard like the image below.
	 	Example:
			Input: ["Hello", "Alaska", "Dad", "Peace"]
			Output: ["Alaska", "Dad"]
 		Note:
			You may use one character in the keyboard more than once.
			You may assume the input string will only contain letters of alphabet.
	*/
	
	public static void main(String[] args) {
		String[] s = {"Hello", "Alaska", "Dad", "Peace"};
		
		displayArray(findWords(s));
		
	}

	public static String[] findWords(String[] words) {
		if(words.length == 0) {
			return new String[0];
		}
		
		String row1 = "qwertyuiop";
		String row2 = "asdfghjkl";
		String row3 = "zxcvbnm";

		ArrayList<String> result = new ArrayList<>();
		
		for(int i=0; i<words.length; i++) {
			if(allInRow(words[i], row1) || allInRow(words[i], row2) || allInRow(words[i], row3)) {
				result.add(words[i]);
			}
		}
		
		if(result.size() == 0) {
			return new String[0];
		} else {
			String[] resultedArray = new String[result.size()];
			resultedArray = result.toArray(resultedArray);
			return resultedArray;
		}
		

	}

	private static boolean allInRow(String s, String row) {
		String sLc = s.toLowerCase();
		
		for(int i=0; i<s.length(); i++) {
			boolean letterInRow = false;
			
			for(int j=0; j<row.length(); j++) {
				if(sLc.charAt(i) == row.charAt(j)) {
					letterInRow = true;
				}
			}
			
			if(!letterInRow) {
				return false;
			}
		}
		return true;
	}
	
	private static void displayArray(String[] s) {
		for(int i=0; i<s.length; i++) {
			System.out.print(s[i] + " ");
		}
		System.out.println();
	}



}
