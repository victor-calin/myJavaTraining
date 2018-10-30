package myJavaTraining.inputOutput.readThanWrite;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class ReadThanWrite {
	
	/* Given the text file "input", write a program which receives 2 words
	 * and creates a second file named "output" which will contain the same text 
	 * with the first word replaced by the second.
	 */
	
	public static void main(String[] args) throws IOException {
		replace("football" , "hokey");
	}

	public static void replace(String crtWord, String newWord) throws IOException {

		try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("C:\\Users\\Vikroom\\Desktop\\JavaCurs26\\input.txt")));	
			 BufferedWriter outputFile = new BufferedWriter(new FileWriter("C:\\Users\\Vikroom\\Desktop\\JavaCurs26\\output.txt"))) {
			
			while(scanner.hasNextLine()) {
				String newLine = scanner.nextLine().replace(crtWord, newWord);
				outputFile.write(newLine);
				outputFile.newLine();
			}
		}

	}

}
