package com.xu.leetcode.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

/**
 * @author charlie Created on 2018/1/31.
 *
 * 输入1个正整数数组，把数组里所有数字拼接起来排成
 *
 * 1个数，打印能拼接出的所有数字中最小的1个
 *
 * {3，31，321}	最小数字  313213
 */
public class PrintMinNumber {

	@Test
	public void test() {
		int[] num = {3, 31, 321, 156};
		PrintMinNumber(num);
	}

	public void PrintMinNumber(int[] num) {
		int size = num.length;
		List<Integer> list = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			list.add(num[i]);
		}
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = o1 + "" + o2;
				String s2 = o2 + "" + o1;
				return s1.compareTo(s2);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0, length = list.size(); i < length; i++) {
			sb.append(list.get(i));
		}
		System.out.println(sb.toString());
	}
}
