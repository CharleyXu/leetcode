package com.xu.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

/**
 * @author charlie Created on 2018/2/1.
 *
 * Letter Combinations of a Phone Number 电话号码的字母组合
 *
 * 给定一个数字字符串，返回数字可能表示的所有可能的字母组合
 *
 * 数字到字母的映射(电话按键)
 */
public class No17 {

	/**
	 * 递归实现	Recursive
	 */
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return result;
		}
		String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		for (int i = 0, size = digits.length(); i < size; i++) {
			result = letterCombinations(result, digits, digits.charAt(i), letters);
		}
		return result;
	}

	public List<String> letterCombinations(List<String> currentList, String digits, char c,
			String[] letters) {
		int num = c - '0';
		String letter = letters[num];
		int length = letter.length();
		if (length == 0) {
			return currentList;
		}
		if (currentList.size() == 0) {
			for (int i = 0; i < length; i++) {
				currentList.add(letter.charAt(i) + "");
			}
			return currentList;
		}
		List<String> result = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < currentList.size(); j++) {
				StringBuilder sb = new StringBuilder(letter.charAt(i) + "");
				sb.insert(0, currentList.get(j));
				result.add(sb.toString());
			}
		}
		return result;
	}

	/**
	 * 队列实现 从队列头获得上一种情况的结果，经过处理后添加到队列尾
	 */
	public List<String> letterCombinations2(String digits) {
		LinkedList<String> linkedList = new LinkedList<>();
		if (digits == null || digits.length() == 0) {
			return linkedList;
		}
		linkedList.add("");
		int empty = 0;
		String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		for (int i = 0, size = digits.length(); i < size; i++) {
			int num = digits.charAt(i) - '0';
			String letter = letters[num];
			int length = letter.length();
			if (length == 0) {
				empty++;
				continue;
			}
			while (linkedList.peek().length() + empty == i) {
				String s = linkedList.removeFirst();
				for (int j = 0; j < length; j++) {
					linkedList.add(s + letter.charAt(j));
				}
			}
		}
		return linkedList;
	}

	@Test
	public void test() {
		List<String> list = letterCombinations("161");
		System.out.println(list);
		List<String> list1 = letterCombinations2("161");
		System.out.println(list1);
	}
}
