package myJavaTraining.myLeetcode;

public class LC_744_FindSmallestLetterGreaterThanTarghet {
	
	/*  Given a list of sorted characters letters containing only
	 		lowercase letters, and given a target letter target, find the
	 		smallest element in the list that is larger than the given target.
		Letters also wrap around. For example, if the target is
		 	target = 'z' and letters = ['a', 'b'], the answer is 'a'.
		Examples:
			Input:
				letters = ["c", "f", "j"]
				target = "a"
			Output: "c"

			Input:
				letters = ["c", "f", "j"]
				target = "c"
			Output: "f"

			Input:
				letters = ["c", "f", "j"]
				target = "d"
			Output: "f"

			Input:
				letters = ["c", "f", "j"]
				target = "g"
			Output: "j"

			Input:
				letters = ["c", "f", "j"]
				target = "j"
			Output: "c"

			Input:
				letters = ["c", "f", "j"]
				target = "k"
			Output: "c"
	*/

	public static void main(String[] args) {
		char[] letters = {'c', 'f', 'j'};
		char[] letters2 = {'a', 'b', 'c'};
		
		System.out.println(nextGreatestLetter(letters, 'a'));
		System.out.println(nextGreatestLetter(letters2, 'z'));

	}

	public static char nextGreatestLetter(char[] letters, char target) {
		int l = 0, r = letters.length;
		while (l < r) {
			int m = l + (r - l) / 2;
			
			if (letters[m] <= target) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		return letters[l % letters.length];
	}

}
