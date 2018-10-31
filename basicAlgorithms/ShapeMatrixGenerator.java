package myJavaTraining.basicAlgorithms;
import java.util.Random;

public class ShapeMatrixGenerator {
	
	/* Write a program which generates 2 matrix with random size.
	 * First matrix will have a "descending - horizontal shape.
	 * Second matrix will have a "ascending vertical shape.	 * 
	 */
	
	private static final int limit = 11;
	private static Random r = new Random();
	private int row;
	private int col;
	private int[][] m;

	public ShapeMatrixGenerator() {
		this.row = r.nextInt(limit - 3) + 3;
		this.col = r.nextInt(limit - 3) + 3;
		m = new int[this.row][this.col];
	}

	public static void main(String[] args) {
		ShapeMatrixGenerator snake = new ShapeMatrixGenerator();
		snake.descendingHorizontal();
		snake.ascendingVertical();
	}

	public void descendingHorizontal() {
		boolean rightToLeft = false;
		int crtVal = row * col;

		for(int i=0; i<row; i++) {
			rightToLeft = !rightToLeft;
			for(int j=0; j<col; j++) {
				if(rightToLeft) {
					m[i][col-j-1] = crtVal;
				} else {
					m[i][j] = crtVal;
				}
				crtVal--;
			}
		}

		System.out.println("Descending horizontal matrix:");
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void ascendingVertical() {
		boolean upToDown = false;
		int crtVal = 1;

		for(int j=0; j<col; j++) {
			upToDown = !upToDown;

			for(int i=0; i<row; i++) {
				if(upToDown) {
					m[i][j] = crtVal;
				} else {
					m[row-i-1][j] = crtVal;
				}
				crtVal++;
			}
		}

		System.out.println("Ascending vertical matrix:");
		for(int i=0; i<row; i++) {
			for(int j =0; j<col; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

}
