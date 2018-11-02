package myJavaTraining.myLeetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_020_ValidParentheses {
	
	/* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
	   An input string is valid if:
			Open brackets must be closed by the same type of brackets.
			Open brackets must be closed in the correct order.
	   Note that an empty string is also considered valid.
			Example 1:
				Input: "()"
				Output: true
			Example 2:
				Input: "()[]{}"
				Output: true
			Example 3:
				Input: "(]"
				Output: false
			Example 4:
				Input: "([)]"
				Output: false
			Example 5:
				Input: "{[]}"
				Output: true
	*/
	
	public static void main(String[] args) {
		
		System.out.println(isValid("()[]({})"));
		System.out.println(isValid("(((([{}]))))[]"));
		System.out.println(isValid("()[([{}])]"));
		System.out.println(isValid("()(([])){[[()]]}"));
		System.out.println(isValid("[[])"));
		System.out.println(isValid("[[]])"));
		System.out.println(isValid("[[(]])"));
		System.out.println(isValid("[(])"));
	}

	public static boolean isValid(String s) {
		if(s.length() == 0) return true;
		if(s.length() % 2 != 0) return false;

		Deque<Character> stack = new ArrayDeque<>();

		for(int i=0; i<s.length(); i++) {
			//adding opened brackets only
			if(s.charAt(i) == '(')
				stack.addFirst('(');
			if(s.charAt(i) == '[')
				stack.addFirst('[');
			if(s.charAt(i) == '{')
				stack.addFirst('{');

			//compare closed brackets with peek
			if(s.charAt(i) == ')') {
				if(stack.isEmpty()) return false;
				else if(stack.peekFirst() != '(') return false;
				else stack.removeFirst();
			}

			if(s.charAt(i) == ']') {
				if(stack.isEmpty()) return false;
				else if(stack.peekFirst() != '[') return false;
				else stack.removeFirst();
			}

			if(s.charAt(i) == '}') {
				if(stack.isEmpty()) return false;
				else if(stack.peekFirst() != '{') return false;
				else stack.removeFirst();
			}
		}
		return stack.isEmpty();    
	}
}

