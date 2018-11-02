package myJavaTraining.myLeetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_118_PascalsTriangle {
	
	/*  Given a non-negative integer numRows, generate
	  		the first numRows of Pascal's triangle.
	 	Example:
			Input: 5
			Output:
				[
     				   [1],
    			      [1,1],
   				     [1,2,1],
  				    [1,3,3,1],
 				   [1,4,6,4,1]
				]
	*/
	
	
	public static void main(String[] args) {
		displayPascalsTriangle(generate(5));
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> m = new ArrayList<List<Integer>>(numRows);
		int numCol = 1;

		for(int i=0; i<numRows; i++, numCol++) {
			List<Integer> newRow = new ArrayList<Integer>(numCol);

			for(int j=0; j<numCol; j++) {
				newRow.add(1);
			}
			m.add(newRow);
		}

		if(m.size() < 3) return m;

		for(int i=2; i<m.size(); i++) {
			for(int j=1; j<m.get(i).size()-1; j++) {
				int newVal = m.get(i-1).get(j-1) + m.get(i-1).get(j);
				m.get(i).set(j, newVal);
			}
		}

		return m;
	}


	private static void displayPascalsTriangle(List<List<Integer>> m) {
		for(int i=0; i<m.size(); i++) {
			for (int t=0; t<m.size()-i; t++) {
				System.out.print("\t");
			}

			for(int j=0; j<m.get(i).size(); j++) {
				System.out.print(m.get(i).get(j) + "\t\t");
			}
			System.out.println();
		}
	}


}

