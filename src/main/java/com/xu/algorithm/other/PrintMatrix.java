package com.xu.algorithm.other;

import org.junit.Test;

/**
 * @author charlie Created on 2018/1/31. 回环矩阵
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 *
 *
 * 1		2		3		4
 *
 * 5		6 	7		8
 *
 * 9		10	11	12
 *
 * 13		14	15	16
 *
 * 依次打印出数字1、2、3、4、8、12、16、15、14、13、9、5、6、7、11、10
 */
public class PrintMatrix {

	@Test
	public void test01() {
		int[][] num = new int[20][20];
		int length = 4;
		int count = 1;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				num[i][j] = count++;
			}
		}
		output(num, 0, length - 1);
	}

	public void output(int[][] num, int start, int end) {
		if (start > end || end < 1) {
			return;
		}
		for (int i = start; i <= end; i++) {
			System.out.print(num[start][i] + ",");
		}
		for (int i = start + 1; i <= end; i++) {
			System.out.print(num[i][end] + ",");
		}
		for (int i = end - 1; i >= start; i--) {
			System.out.print(num[end][i] + ",");
		}
		for (int i = end - 1; i > start; i--) {
			System.out.print(num[i][start] + ",");
		}

		output(num, start + 1, end - 1);

	}

}
