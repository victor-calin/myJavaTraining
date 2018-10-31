package myJavaTraining.basicAlgorithms;
import java.util.Random;

public class SpiralGenerator {
	
	/* Write a method which generates a spiral matrix */

	public static void main(String[] args) {
		displayMatrix(generateSpiral());
	}

	public static int[][] generateSpiral() {
		Random r = new Random();
		int row = r.nextInt(11 - 3) + 3;
		int col = r.nextInt(11 - 3) + 3;
		int[][] m = new int[row][col];

		int total = row * col;
		int crt = 1;
		boolean upToDown = false;
		int topWall = -1;
		int baseWall = m.length;
		int leftWall = -1;
		int rightWall = m[0].length;


		while (crt < total) {

			upToDown = !upToDown;
			//snake is heading from topWall to bottom
			if(upToDown) {
				for(int i=topWall+1; i<baseWall; i++) {
					//left to right (iterating j)
					if(i==topWall+1) {
						for(int j=leftWall+1; j<rightWall; j++) {
							m[i][j] = crt;
							crt++;
						}
						//up to down (constant j)
					} else {
						m[i][rightWall-1] = crt;
						crt++;
					}
				}

				topWall++;
				rightWall--;

				//snake is heading from bottom to topWall
			} else {
				for(int i=baseWall-1; i>=topWall+1; i--) {
					//right to left (iterating j)
					if(i==baseWall-1) {
						for(int j=rightWall-1; j>leftWall; j--) {
							m[i][j] = crt;
							crt++;
						}
						//down to up (constant j)
					} else {
						m[i][leftWall+1] = crt;
						crt++;
					}
				}

				baseWall--;
				leftWall++;

			}
		}

		return m;
	}


	public static void displayMatrix(int[][] m) {
		for(int i=0; i<m.length; i++) {
			for(int j =0; j<m[0].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

}