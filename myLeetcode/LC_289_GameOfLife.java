package myJavaTraining.myLeetcode;

public class LC_289_GameOfLife {
	
	/*  According to the Wikipedia's article: "The Game of Life,
	 		also known simply as Life, is a cellular automaton devised
	 		by the British mathematician John Horton Conway in 1970."
		Given a board with m by n cells, each cell has an initial state
			live (1) or dead (0). Each cell interacts with its eight neighbors
			(horizontal, vertical, diagonal) using the following four rules
			(taken from the above Wikipedia article):
Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
		Write a function to compute the next state (after one update)
			of the board given its current state. The next state is created by
			applying the above rules simultaneously to every cell in the
			current state, where births and deaths occur simultaneously.
		Example:
			Input: 
				[
  					[0,1,0],
  					[0,0,1],
  					[1,1,1],
  					[0,0,0]
				]
			Output: 
				[
  					[0,0,0],
  					[1,0,1],
  					[0,1,1],
  					[0,1,0]
				]
	*/
		
	public static void main(String[] args) {
		int[][] input = {{0, 1, 0},
				{0, 0, 1},
				{1, 1, 1},
				{0, 0, 0}};
		System.out.println("Input:");
		displayMatrix(input);
		gameOfLife(input);
		System.out.println("\nOutput:");
		displayMatrix(input);
	}

	public static void gameOfLife(int[][] input) {
		if (input == null || input.length == 0) return;
		int[][] output = new int[input.length][input[0].length];

		for(int i=0; i<input.length; i++) {
			for(int j=0; j<input[0].length; j++) {
				transform(input, output, i, j);
			}
		}

		for(int i=0; i<input.length; i++) {
			for(int j=0; j<input[0].length; j++) {
				input[i][j] = output[i][j];
			}
		}
		
		output = null;
	}

	private static void transform(int[][] input, int[][] output, int elementI, int elementJ) {
		int alives = aliveNeigh(input, elementI, elementJ);
		boolean isCrtAlive = input[elementI][elementJ] == 1;

		if(isCrtAlive) {
			if(alives == 2 || alives == 3)
				output[elementI][elementJ] = 1;
		} else {
			if(alives == 3)
				output[elementI][elementJ] = 1;
		}
	}

	private static int aliveNeigh(int[][] m, int elementI, int elementJ) {
		int[] dirI = {-1, -1, 0, +1, +1, +1, 0, -1};
		int[] dirJ = {0, +1, +1, +1, 0, -1, -1, -1};

		int alive = 0;

		for(int i=0; i<dirI.length; i++) {
			int neighI = elementI + dirI[i];
			int neighJ = elementJ + dirJ[i];

			if(neighI >= 0 && neighI < m.length && neighJ >= 0 && neighJ < m[0].length) {
				if(m[neighI][neighJ] == 1) 
					alive++;
			}
		}
		return alive;
	}


	private static void displayMatrix(int[][] m) {
		for(int i=0; i<m.length; i++) {
			for(int j=0; j<m[0].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}

}