package com.xu.leetcode.Medium;

import org.junit.Test;

/**
 * String to Integer (atoi)
 *
 *
 越界问题？

 正负号问题？

 空格问题？

 精度问题？
 */
public class No8 {
	public int myAtoi(String str) {
		int result = 0 ;
		if(str==null|| str.isEmpty()){
			return 0;
		}

		str = str.trim();

		int i = 0 ;
		char flag = '+';
		if(str.charAt(0)=='-'){
			flag = '-';
			i++;
		}else if (str.charAt(0)=='+'){
			i++;
		}

		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			if(Integer.MAX_VALUE/10 < result || (Integer.MAX_VALUE/10 == result && Integer.MAX_VALUE%10 < (str.charAt(i) - '0')))
				return flag == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;

			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
		return flag=='-'?-result:result;
	}

	@Test
	public void test(){
		System.out.println(Integer.MAX_VALUE);
		String s1 = "     010";
		String s2 = "-2147483648";
		System.out.println(myAtoi(s1)+"\n"+myAtoi(s2));

	}
}
