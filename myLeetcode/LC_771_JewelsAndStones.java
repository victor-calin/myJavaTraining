package myJavaTraining.myLeetcode;

import java.util.HashMap;
import java.util.Map;

public class LC_771_JewelsAndStones {
	
	/* You're given strings J representing the types of stones that are jewels,
	 		and S representing the stones you have.  Each character in S is a type
	 		of stone you have.  You want to know how many of the stones you have are also jewels.
		The letters in J are guaranteed distinct, and all characters in J and S are letters.
		Letters are case sensitive, so "a" is considered a different type of stone from "A".
		Example 1:
			Input: J = "aA", S = "aAAbbbb"
			Output: 3
		Example 2:
			Input: J = "z", S = "ZZ"
			Output: 0
		Note:
			S and J will consist of letters and have length at most 50.
			The characters in J are distinct.
	*/
	
	public static void main(String[] args) {
		String j = "aA";
		String s = "aAAbbbb";
		
		System.out.println(numJewelsInStones(j, s));

	}

	public static int numJewelsInStones(String j, String s) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(map.containsKey(ch)) {
				int val = map.get(ch);
				map.put(ch, val + 1);
			} else 
				map.put(ch, 1);
		}
		int count = 0;
		for(int i=0; i<j.length(); i++) 
			if(map.containsKey(j.charAt(i))) 
				count +=map.get(j.charAt(i));
		return count;
	}

}
