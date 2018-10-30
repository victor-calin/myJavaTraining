package myJavaTraining.inputOutput.readAndWrite;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class ReadAndMergeWrite {

	/* Given 2 files, each containing a sorted array of numbers, separated by one space, 
	 * write a method which creates a third file with the sorted merged array. 
	 * You should't use any type of collection.
	 */

	public static void main(String[] args) throws IOException {
		Scanner numbersOne = new Scanner(new BufferedReader(new FileReader("C:\\Users\\Vikroom\\Desktop\\JavaCurs26\\input1.txt")));
		Scanner numbersTwo = new Scanner(new BufferedReader(new FileReader("C:\\Users\\Vikroom\\Desktop\\JavaCurs26\\input2.txt")));
		BufferedWriter outputFile = new BufferedWriter(new FileWriter("C:\\Users\\Vikroom\\Desktop\\JavaCurs26\\sortedOutput.txt"));

		readAndWrite(numbersOne, numbersTwo, outputFile);

	}

	public static void readAndWrite(Scanner numbersOne, Scanner numbersTwo, BufferedWriter outputFile) throws IOException {

		try (numbersOne; numbersTwo; outputFile) {
			int crtReadOne = 0, crtReadTwo = 0;
			boolean isFirstFinished = false, isSecondFinished = false;

			crtReadOne = Integer.parseInt(numbersOne.next());
			crtReadTwo = Integer.parseInt(numbersTwo.next());


			while(numbersOne.hasNext() && numbersTwo.hasNext()) {

				if(crtReadOne < crtReadTwo) {

					outputFile.write(crtReadOne + " ");
					crtReadOne = Integer.parseInt(numbersOne.next());

				} else {

					outputFile.write(crtReadTwo + " ");
					crtReadTwo = Integer.parseInt(numbersTwo.next());

				}

				if(!numbersOne.hasNext()) {
					isFirstFinished = true;
				}

			}


			if(crtReadOne < crtReadTwo) {
				outputFile.write(String.valueOf(crtReadOne) + " ");
				outputFile.write(String.valueOf(crtReadTwo) + " ");
			} else {
				outputFile.write(String.valueOf(crtReadTwo) + " ");
				outputFile.write(String.valueOf(crtReadOne) + " ");
			}
			
			
			if(isFirstFinished) {
				while(numbersTwo.hasNext()) {
					crtReadTwo = numbersTwo.nextInt();
					outputFile.write(String.valueOf(crtReadTwo) + " ");
				}
			}
			
			if(isSecondFinished) {
				while(numbersOne.hasNext()) {
					crtReadOne = numbersOne.nextInt();
					outputFile.write(String.valueOf(crtReadOne) + " ");
				}
			}
		
		}
	}
}
