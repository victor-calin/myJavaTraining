package myJavaTraining.projects.ReversePolishNotation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ReversePolishNotation {
	
	/*/ Output:     In-Fixed expression: 3+(2+1)*2^3^2-8/(5-1*2/2)
	 *	      Post-Fixed expression: 321+232^^*+8512*2/-/-
	 *	      Post-Fixed evaluation: 1537
	 */
	
	public static void main(String[] args) {
		String inFix = "3+(2+1)*2^3^2-8/(5-1*2/2)";

		System.out.println("  In-Fixed expression: " + inFix);

		printPostFixed(convertToPostFix(inFix));

		System.out.println("Post-Fixed evaluation: " + evaluatePostFix(convertToPostFix(inFix)));
	}

	public static String[] convertToPostFix(String inFix) {
		List<String> postFix = new ArrayList<>();
		ArrayDeque<String> stack = new ArrayDeque<>(); 

		for(int i=0; i<inFix.length(); i++) {
			char ch = inFix.charAt(i);

			if(Character.isDigit(ch)) {
				postFix.add(Character.toString(ch));
			} else if(ch != '(' && ch != ')') {
				while(stack.peekFirst() != null && stack.peekFirst() != "(" &&
						(getPrecedence(ch) < getPrecedence(stack.peekFirst()) ||  
						(getPrecedence(ch) == getPrecedence(stack.peekFirst()) && getPrecedence(ch) != 13))) {
					postFix.add(stack.removeFirst());
				}

				stack.addFirst(Character.toString(ch));
			} else if(ch == '(') {
				stack.addFirst(Character.toString(ch));
			} else if(ch == ')') {
				while(!stack.peekFirst().equals("(")) {
					postFix.add(stack.removeFirst());
				}
				if(stack.isEmpty()) {
					System.out.println("Invalid infix expression!");
					return null;
				}
				stack.removeFirst();
			}
		}

		while(!stack.isEmpty()) {
			if(stack.peekFirst().equals("(")) {
				System.out.println("Invalid infix expression!");
				return null;
			} else {
				postFix.add(stack.removeFirst());
			}
		}
		String[] postFixArray = new String[postFix.size()];
		return postFix.toArray(postFixArray);
	}


	public static int evaluatePostFix(String[] tokens) {
		Deque<Integer> stack = new ArrayDeque<>();
		for(int i=0; i<tokens.length; i++) {
			if(tokens[i].matches("-?\\d+")) 
				stack.addFirst(Integer.valueOf(tokens[i]));
			else {
				Integer op1 = stack.removeFirst();
				Integer op2 = stack.removeFirst();
				switch(tokens[i]) {
					case "+":
						stack.addFirst(op1 + op2);
						break;
					case "-":
						stack.addFirst(op2 - op1);
						break;
					case "*":
						stack.addFirst(op1 * op2);
						break;
					case "/":
						stack.addFirst(op2 / op1);
						break;
					case "^":
						stack.addFirst(myPow(op2, op1));
						break;
				}
			}
		}
		return stack.removeFirst();
	}


	private static int getPrecedence(char op) {
		switch(op) {
			case '+':
			case '-':
				return 11;
			case '*':
			case '/':
				return 12;
			case '^':
				return 13;
			default:
				return -1;
		}
	}


	private static int getPrecedence(String op) {
		switch(op) {
			case "+":
			case "-":
				return 11;
			case "*":
			case "/":
				return 12;
			case "^":
				return 13;
			default:
				return -1;
		}
	}


	private static int myPow(int base, int exp) {
		if(exp == 0) return 1;

		int result = base;
		for(int i=2; i<=exp; i++) {
			result *= base;
		}
		return result;
	}


	private static void printPostFixed(String[] s) {
		System.out.print("Post-Fixed expression: ");
		for(int i=0; i<s.length; i++) {
			System.out.print(s[i]);
		}
		System.out.println();
	}
}
