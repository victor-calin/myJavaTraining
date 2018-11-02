package myJavaTraining.myLeetcode;
import java.util.ArrayList;

public class LC_038_CountAndSay {
	
	/* The count-and-say sequence is the sequence of integers
	  		with the first five terms as following:
		1.     1
		2.     11
		3.     21
		4.     1211
		5.     111221
			1 is read off as "one 1" or 11.
			11 is read off as "two 1s" or 21.
			21 is read off as "one 2, then one 1" or 1211.
		Given an integer n where 1 <= n <= 30, generate the nth term
		 	of the count-and-say sequence.
		Note: Each term of the sequence of integers will
		 	be represented as a string.
		Example 1:
			Input: 1
			Output: "1"
		Example 2:
			Input: 4
			Output: "1211"
	*/
	
	public static void main(String[] args) {
		System.out.println(countAndSay(6));

	}

	public static String countAndSay(int n) {
		ArrayList<Integer> seq = new ArrayList<>();
		seq.add(1);

		for(int step=1; step<n; step++) {
			ArrayList<Integer> nextSeq = new ArrayList<>();

			int counter = 1;
			for(int i=0; i<seq.size()-1; i++) {
				if(seq.get(i) == seq.get(i+1)) {
					counter++;
				} else {
					nextSeq.add(counter);
					nextSeq.add(seq.get(i));
					counter = 1;
				}
			}
			nextSeq.add(counter);
			nextSeq.add(seq.get(seq.size()-1));
			seq = nextSeq;
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<seq.size(); i++) {
			sb.append(seq.get(i));
		}

		return sb.toString();    
	}
}
