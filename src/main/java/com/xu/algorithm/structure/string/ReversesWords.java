package com.xu.algorithm.structure.string;

/**
 * Created by CharleyXu on 2020-06-11
 * <p>
 * 给定一个字符串，
 * <p>
 * 需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class ReversesWords {

    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(new StringBuilder(str).reverse().toString()).append(" ");
        }
        return sb.toString().trim();
    }
}
