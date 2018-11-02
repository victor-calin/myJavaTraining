package myJavaTraining.myLeetcode;

import java.util.HashSet;
import java.util.Set;

public class LC_003_LongestSubstringWithoutRepeatingCharacters {
	
	/* Given a string, find the length of the longest substring without repeating characters.
			Example 1:
				Input: "abcabcbb"
				Output: 3 
				Explanation: The answer is "abc", with the length of 3. 
			Example 2:
				Input: "bbbbb"
				Output: 1
			Explanation: The answer is "b", with the length of 1.
	*/
	
	public static void main(String[] args) {
		String s = "abcabcbb";

		System.out.println(lengthOfLongestSubstring(s));

	}

	public static int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
		int maxLength = 0, i = 0, j = 0;
		while(i < s.length() && j < s.length()) {
			if(!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				maxLength = Math.max(maxLength, j-i);
			} 
			else {
				set.remove(s.charAt(i++));
			}  
		}
		return maxLength;
	}

}
