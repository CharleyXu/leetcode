package com.xu.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.junit.Test;

/**
 * @author charlie Created on 2018/2/9.
 *
 * Valid Parentheses	有效的括号
 *
 * "()" and "()[]{}" are all valid but "(]" and "([)]" are not
 */
public class No20 {

	/**
	 * 使用 HashMap + Stack
	 */
	public boolean isValid(String s) {
		if (s == null) {
			return false;
		}
		int length = s.length();
		if (length < 2) {
			return false;
		}
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			switch (c) {
				case '(':
				case '[':
				case '{':
					stack.push(c);
					break;
				case ')':
				case ']':
				case '}':
					if (stack.isEmpty() || map.get(stack.pop()) != c) {
						return false;
					}
					break;
			}
		}
		return stack.isEmpty();
	}

	@Test
	public void isValidTest() {
		String s = "(){}[]{}{}[]()[][]()";
		System.out.println(isValid(s));
	}
}
