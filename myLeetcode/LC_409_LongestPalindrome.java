package myJavaTraining.myLeetcode;

import java.util.HashSet;
import java.util.Set;

public class LC_409_LongestPalindrome {
	
	/*  Given a string which consists of lowercase or uppercase letters,
	 		find the length of the longest palindromes that can be built with those letters.
		This is case sensitive, for example "Aa" is not considered a palindrome here.
		Example:
			Input: "abccccdd"
			Output: 7
			Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
	*/
	
	public static void main(String[] args) {
		String s = "bananas";

		System.out.println(longestPalindrome(s));
	}

	public static int longestPalindrome(String s) {
		Set<Character> set = new HashSet<>();

		for(int i=0; i<s.length(); i++) {
			if(set.contains(s.charAt(i))) 
				set.remove(s.charAt(i));
			else 
				set.add(s.charAt(i));
		}

		if(set.size() < 2) return s.length();
		else return s.length() - set.size() + 1;
	}

}
