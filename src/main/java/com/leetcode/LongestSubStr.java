package com.leetcode;

/**
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
 * @author zhang weiwei
 * @date 2022/10/25
 */
public class LongestSubStr {

    public static void main(String[] args) {

    }

    public static int lengthOfLongestSubstring(String s) {
        String initStr = "";
        String sb = "";
        if (s.length() == 1 || s.length() == 0) return s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String charToStr = String.valueOf(chars[i]);
            if (sb.contains(charToStr) && initStr.length() <= sb.length()) {
                initStr = sb;
                String subStr = sb.substring(initStr.length() - 1);
                if (subStr.equals(charToStr)) {
                    sb = charToStr;
                } else {
                    sb = subStr + charToStr;
                }
            } else {
                sb = sb + charToStr;
            }
        }

        if (initStr.length() <= sb.length()) initStr = sb;

        return initStr.length();
    }
}
