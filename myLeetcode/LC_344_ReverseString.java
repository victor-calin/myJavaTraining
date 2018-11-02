package myJavaTraining.myLeetcode;

public class LC_344_ReverseString {
	
	/* Write a function that takes a string as input and returns the string reversed.
		Example 1:
			Input: "hello"
			Output: "olleh"
		Example 2:
			Input: "A man, a plan, a canal: Panama"
			Output: "amanaP :lanac a ,nalp a ,nam A"
	*/	
	
	public static void main(String[] args) {
		String s = "hello";
		System.out.println(reverseString(s));

	}

	public static String reverseString(String s) {
		char[] sArray = new char[s.length()];
		for(int i=0; i<sArray.length; i++) {
			sArray[i] = s.charAt(s.length()-1-i);
		}
		return new String(String.valueOf(sArray));
	}
}