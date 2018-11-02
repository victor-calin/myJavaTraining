package myJavaTraining.myLeetcode;

public class LC_073_SetMatrixZeroes {
	
	/*  Given a m x n matrix, if an element is 0, set its
	  		entire row and column to 0. Do it in-place.
		Example 1:
			Input: 
				[
  					[1,1,1],
  					[1,0,1],
  					[1,1,1]
				]
			Output: 
				[
  					[1,0,1],
  					[0,0,0],
  					[1,0,1]
				]
		Example 2:
			Input: 
				[
  					[0,1,2,0],
  					[3,4,5,2],
  					[1,3,1,5]
				]
			Output: 
				[
  					[0,0,0,0],
  					[0,4,5,0],
  					[0,3,1,0]
				]
	*/
		
	public static void main(String[] args) {
		int[][] m = new int[][] {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

		printMatrix(m);

		setZeroes(m);

		printMatrix(m); 
	}


	public static void setZeroes(int[][] m) {
		boolean firstRow = false, firstCol = false;

		for(int i=0; i<m.length; i++) 
			for(int j=0; j<m[0].length; j++) 
				if(m[i][j] == 0) {
					if(i == 0) firstRow = true;
					if(j == 0) firstCol = true;
					m[0][j] = 0;
					m[i][0] = 0;
				}

		for(int i=1; i<m.length; i++) 
			for(int j=1; j<m[0].length; j++) 
				if(m[0][j] == 0 || m[i][0] == 0) 
					m[i][j] = 0;

		if(firstRow)
			for(int j=0; j<m[0].length; j++)
				m[0][j] = 0;

		if(firstCol)
			for(int i=0; i<m.length; i++)
				m[i][0] = 0; 
	}


	private static void printMatrix(int[][] m) {
		for(int i=0; i<m.length; i++) {
			for(int j=0; j<m[0].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}



}
