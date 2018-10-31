package myJavaTraining.dataStructures.stack;

public class App {

	public static void main(String[] args) {
		String stringTest = "hello";
		System.out.println(reverseString(stringTest));
		
		
	}
	
	private static String reverseString(String str) {
		Stack theStack = new Stack(str.length());
		
		for (int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			theStack.push(ch);
		
		}
		String result = "";
		while(!theStack.isEmpty()) {
			char ch = theStack.pop();
			result = result + ch;
		}
		return result;
	}

}
