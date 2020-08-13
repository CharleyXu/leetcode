package com.xu.algorithm.medium;

import org.junit.Test;

/**
 * ZigZag Conversion
 *
 *
 *
 * PAYPALISHIRING
 *
 * P   A   H   N A P L S I I G Y   I   R
 *
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 * 2n-2       中间行额外  2n-2-2i
 */
public class No6 {

	public String convert(String s, int numRows) {
		StringBuilder stringBuilder = new StringBuilder();

		if (s == null || numRows<=0) {
			return null;
		}
		int length = s.length();
		if (numRows == 1 || length == 0|| numRows>=length) {
			return s;
		}
		int step = 2 * numRows - 2;

		for (int i = 0; i < numRows; i++) {
			for (int j = i; j < length; j += step) {
				stringBuilder.append(s.charAt(j));
				if (0 != i && i != numRows - 1) {
					int temp = j + step - 2 * i ;
					if (temp<length){
						stringBuilder.append(s.charAt(temp));
					}
				}
			}
		}
		return stringBuilder.toString();
	}

	@Test
	public void test() {
		String s = "";
		int numRows = 1;
		System.out.println(convert(s, numRows));
	}


}
