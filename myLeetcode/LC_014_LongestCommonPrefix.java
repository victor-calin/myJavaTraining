package myJavaTraining.myLeetcode;

public class LC_014_LongestCommonPrefix {
	
	/* Write a function to find the longest common prefix string amongst an array of strings.
       If there is no common prefix, return an empty string "".
			Example 1:
				Input: ["flower","flow","flight"]
				Output: "fl"
			Example 2:
				Input: ["dog","racecar","car"]
				Output: ""
			Explanation: There is no common prefix among the input strings.
	*/
	
	public static void main(String[] args) {
		String[] strs = {"flower", "flow", "flight"};

		System.out.println(longestCommonPrefix(strs));
	}

	public static String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) {
			return new String("");
		}
		
		int minLenth = minLengt(strs);
		StringBuilder sb = new StringBuilder("");

		for(int i=0; i<minLenth; i++) {
			char letter = strs[0].charAt(i);

			for(int j=1; j<strs.length; j++) {
				if(strs[j].charAt(i) != letter) {
					return sb.toString();
				} 
			}	
			sb.append(letter);
		}
		return sb.toString();
	}

	private static int minLengt(String[] s) {
		int minLength = s[0].length();
		for(int i=1; i<s.length; i++) {
			if(s[i].length() < minLength) {
				minLength = s[i].length();
			}
		}
		return minLength;
	}


}
