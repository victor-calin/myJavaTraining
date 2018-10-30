package myJavaTraining.inputOutput.readAnalyseWrite;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadAnalyseWrite {
	
	/* Write a program which receives a list of words and writes a result file
	 * which contains: 1. the shortest word
	 * 				   2. the longest word
	 * 				   3. first word in alphabetic order
	 * 				   4. last word in alphabetic order
	 * 				   5. the total number of words
	 * word list example: "Uniunea scriitorilor din Roamania" 
	 */

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		String nextWord = "";
		
		System.out.println("Type the words list. After finishing, press <q> than <enter>");
		while(true) {
			nextWord = sc.next();
			if(nextWord.toLowerCase().equals("q")) break;
			list.add(nextWord);
		}
		sc.close();
		
		solution(list);
	}
	
	public static void solution(List<String> list) throws IOException {
		try (BufferedWriter outputFile = new BufferedWriter(new FileWriter("C:\\Users\\Vikroom\\Desktop\\JavaCurs26\\result.txt"))) {
						
			String shortest = "", longest = "";
			int minLenght = Integer.MAX_VALUE, maxLenght = Integer.MIN_VALUE;
			
			for(String word : list) {								
				if(word.length() < minLenght) {
					shortest = word;
					minLenght = word.length();
				}
				if(word.length() > maxLenght) {
					longest = word;
					maxLenght = word.length();
				}
			}
			
			outputFile.write("1. The shortest word is: " + shortest);
			outputFile.newLine();
			outputFile.write("2. The longest word is: " + longest);
			outputFile.newLine();
			Collections.sort(list);
			outputFile.write("3. The first word is: " + list.get(0));
			outputFile.newLine();
			outputFile.write("4. The last word is: " + list.get(list.size()-1));
			outputFile.newLine();
			outputFile.write("5. The total number of words is: " + list.size());
		}
	}

}
