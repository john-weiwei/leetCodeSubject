package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode3
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 注：子串是连续的，子序列可以是非连续的
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *    请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 * @author zhang weiwei
 * @date 2022/10/26
 */
public class LeetCode3 {
    public static void main(String[] args) {
        String str = "abcabb";
        int num = str.indexOf(str.charAt(2), 0);
        System.out.println(num);
    }

    private static int longestSubString(String s) {
        Map<Character,Integer> map = new HashMap();
        int maxLen = 0;
        int tempLen = 0;
        int leftIndex = 0;
        for(int i = 0; i < s.length(); i++ ) {
            if (map.containsKey(s.charAt(i))) {
                // map.get(s.charAt(i)) + 1  这里是为了更新leftIndex值，即往前移动一位
                leftIndex = leftIndex > map.get(s.charAt(i)) + 1 ? leftIndex : map.get(s.charAt(i)) + 1;
            }

            map.put(s.charAt(i), i);
            tempLen = i - leftIndex + 1;
            maxLen = maxLen > tempLen ? maxLen : tempLen;
        }

        return maxLen;
    }

    // 称为滑动窗口
    // 核心思想：找到重复元素位置index，更新子串起始位置index+1，新子串长度 = 当前元素位置i - index + 1
    private static int secondSubStr(String s) {
        int maxLen = 0;
        int tempLen = 0;
        int fromIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.indexOf(s.charAt(i), fromIndex);
            if (index < i) { // 表示从fromIndex起始位置开始时，有重复元素
                if (maxLen < tempLen) maxLen = tempLen;
                // 更新子串起始位置，计算新子串长度
                fromIndex = index + 1; // 新子串的起始位置
                tempLen = i - fromIndex + 1; // 新子串从起始位置到下标i的长度
            } else {
                tempLen++;
            }
        }
        return tempLen > maxLen ? tempLen : maxLen;
    }
}
