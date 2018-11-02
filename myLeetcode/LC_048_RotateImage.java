package myJavaTraining.myLeetcode;

public class LC_048_RotateImage {
	
	/*  You are given an n x n 2D matrix representing an image.
		Rotate the image by 90 degrees (clockwise).
		Note: you have to rotate the image in-place, which means
		 	you have to modify the input 2D matrix directly. 
		 	DO NOT allocate another 2D matrix and do the rotation.

		Example 1:
			Given input matrix = 
				[
  					[1,2,3],
  					[4,5,6],
  					[7,8,9]
				],
			rotate the input matrix in-place such that it becomes:
				[
  					[7,4,1],
  					[8,5,2],
  					[9,6,3]
				]
		Example 2:
			Given input matrix =
				[
  					[ 5, 1, 9,11],
  					[ 2, 4, 8,10],
  					[13, 3, 6, 7],
  					[15,14,12,16]
				], 
			rotate the input matrix in-place such that it becomes:
				[
  					[15,13, 2, 5],
  					[14, 3, 4, 1],
  					[12, 6, 8, 9],
  					[16, 7,10,11]
				]
	*/
	 
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

		rotate(matrix);
		displayMatrix(matrix);

	}

	public static void rotate(int[][] matrix) {
		//defining 4 walls -> they'll be inner pushed at each iteration
		int upWall = 0;
		int baseWall = matrix.length - 1;
		int leftWall = 0;
		int rightWall = matrix[0].length - 1;

		while(leftWall < rightWall) {		
			int elm1Row = upWall;
			int elm1Col = rightWall;
			int elm2Row = baseWall;
			int elm2Col = rightWall;
			int elm3Row = baseWall;
			int elm3Col = leftWall;
			int elm4Row = upWall;
			int elm4Col = leftWall;

			//filling current layer of walls
			for(int i=leftWall; i<rightWall; i++) {
				int next = matrix[elm4Row][elm4Col];
				int temp = matrix[elm1Row][elm1Col];

				//shifting elements from one wall to the next (4 steps)
				//1:
				matrix[elm1Row][elm1Col] = next;
				next = temp;
				temp = matrix[elm2Row][elm2Col];
				//2:
				matrix[elm2Row][elm2Col--] = next;
				next = temp;
				temp = matrix[elm3Row][elm3Col];
				//3:
				matrix[elm3Row--][elm3Col] = next;
				next = temp;
				temp = matrix[elm4Row][elm4Col];
				//4:
				matrix[elm4Row][elm4Col++] = next;
				next = temp;
				temp = matrix[elm1Row++][elm1Col];
			}

			//move to the next layer of walls
			upWall++;
			baseWall--;
			leftWall++;
			rightWall--;
		}
	}

	public static void displayMatrix(int[][] a) {
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}	
	}

}
