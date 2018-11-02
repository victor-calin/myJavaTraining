package myJavaTraining.myLeetcode;
import java.util.Arrays;

public class LC_242_ValidAnagrams {
	
	/*  Given two strings s and t , write a function
	 		to determine if t is an anagram of s.
		Example 1:
			Input: s = "anagram", t = "nagaram"
			Output: true
		Example 2:
			Input: s = "rat", t = "car"
			Output: false
		Note: you may assume the string contains only lowercase alphabets.
	*/

	public static void main(String[] args) {
		String s = "creta";
		String t = "carte";

		char[] a = new char[26];
		printArr(a);
		a['a' - 'a']++;
		a['n' - 'a']++;
		a['g' - 'a']++;
		printArr(a);
		a['a' - 'a']--;
		a['n' - 'a']--;
		printArr(a);


		System.out.println(isAnagramHash(s, t));
	}

	public static boolean isAnagramSort(String s, String t) {		
		if(s.length() != t.length()) return false;
		char[] s1 = s.toCharArray();
		char[] s2 = t.toCharArray();
		Arrays.sort(s1);
		Arrays.sort(s2);
		return(Arrays.equals(s1, s2));
	}

	public static boolean isAnagramHash(String s, String t) {
		int[] alphabet = new int[26];
		for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
		for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
		for (int i : alphabet) if (i != 0) return false;
		return true;
	}

	public static void printArr(char[] a) {
		for(int i=0; i<a.length; i++)
			System.out.print(a[i] + "| ");
		System.out.println();
	}

}
