package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
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

    }

    private static int longestSubString(String s) {
        Map<Character,Integer> map = new HashMap();
        int maxLen = 0;
        int leftIndex = 0;
        for(int i = 0; i < s.length(); i++ ) {
            if (map.containsKey(s.charAt(i))) {
                // map.get(s.charAt(i)) + 1  这里是为了更新leftIndex值，即往前移动一位
                leftIndex = Math.max(leftIndex, map.get(s.charAt(i)) + 1);
            }

            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - leftIndex + 1);
        }

        return maxLen;
    }
}
