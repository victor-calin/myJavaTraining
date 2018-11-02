package myJavaTraining.myLeetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_150_EvaluateReversePolishNotation {
	
	/* 	Evaluate the value of an arithmetic expression in Reverse Polish Notation.
			Valid operators are +, -, *, /. Each operand may be an integer or another expression.
		Note:
		Division between two integers should truncate toward zero.
		The given RPN expression is always valid. That means the expression would always evaluate
		 	to a result and there won't be any divide by zero operation.
		Example 1:
			Input: ["2", "1", "+", "3", "*"]
			Output: 9
			Explanation: ((2 + 1) * 3) = 9
		Example 2:
			Input: ["4", "13", "5", "/", "+"]
			Output: 6
			Explanation: (4 + (13 / 5)) = 6
		Example 3:
			Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
			Output: 22
			Explanation: 
  				((10 * (6 / ((9 + 3) * -11))) + 17) + 5
				= ((10 * (6 / (12 * -11))) + 17) + 5
				= ((10 * (6 / -132)) + 17) + 5
				= ((10 * 0) + 17) + 5
				= (0 + 17) + 5
				= 17 + 5
				= 22
	*/
	
	
	public static void main(String[] args) {
		String[] tokens1 = {"2", "1", "+", "3", "*"};
		String[] tokens2 = {"4", "13", "5", "/", "+"};
		String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		String[] tokens4 = {"3", "2", "1", "+", "2", "3", "2", "^", "^", "*", "+", "8", 
							"5", "1", "2", "*", "2", "/", "-", "/", "-" };

		System.out.println(evalRPN(tokens1));
		System.out.println(evalRPN(tokens2));
		System.out.println(evalRPN(tokens3));
		System.out.println(evalRPN(tokens4));
	}

	public static int evalRPN(String[] tokens) {
		Deque<Integer> stack = new ArrayDeque<>();
		for(int i=0; i<tokens.length; i++) {
			if(tokens[i].matches("-?\\d+")) 
				stack.addFirst(Integer.valueOf(tokens[i]));
			else {
				switch(tokens[i]) {
				case "+":
					stack.addFirst(stack.removeFirst() + stack.removeFirst());
					break;
				case "-":
					Integer minusOp2 = stack.removeFirst();
					Integer minusOp1 = stack.removeFirst();
					stack.addFirst(minusOp1 - minusOp2);
					break;
				case "*":
					stack.addFirst(stack.removeFirst() * stack.removeFirst());
					break;
				case "/":
					Integer divideOp2 = stack.removeFirst();
					Integer divideOp1 = stack.removeFirst();
					stack.addFirst(divideOp1 / divideOp2);
					break;
				case "^":
					Integer exp = stack.removeFirst();
					Integer base = stack.removeFirst();
					stack.addFirst(myPow(base, exp));
					break;
				}
			}
		}
		return stack.removeFirst();
	}


	private static int myPow(int base, int exp) {
		if(exp == 0) return 1;

		int result = base;
		for(int i=2; i<=exp; i++) {
			result *= base;
		}
		return result;
	}
}