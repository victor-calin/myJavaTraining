package myJavaTraining.myLeetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_412_FizzBuzz {
	
	/* 	Write a program that outputs the string representation of numbers from 1 to n.
		But for multiples of three it should output “Fizz” instead of the number and
			for the multiples of five output “Buzz”. For numbers which are multiples
		 	of both three and five output “FizzBuzz”.
		Example:
n = 15,
Return: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14", "FizzBuzz"]
	*/
	
	public static void main(String[] args) {
		displayList(fizzBuzz(15));

	}

	public static List<String> fizzBuzz(int n) {
		if(n<1) return null;
		
		List<String> result = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			if(i % 3 == 0) {
				if(i % 5 == 0) 
					result.add("FizzBuzz");
				else 
					result.add("Fizz");
				
			} else if(i % 5 == 0) 
				result.add("Buzz");
			
			else 
				result.add(String.valueOf(i));			
		}
		return result;	
	}
	
	private static void displayList(List<String> list) {
		System.out.println("[");
		for(int i=0; i<list.size(); i++) {
			System.out.println("\t" +  list.get(i));
		}
		System.out.println("]");
	}

}
