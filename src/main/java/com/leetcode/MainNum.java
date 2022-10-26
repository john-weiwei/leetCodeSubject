package com.leetcode;

/**
 * 主要元素
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1
 * @author zhang weiwei
 * @date 2022/10/25
 */
public class MainNum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,4,4,4,5};
        System.out.println(majorityElement(nums));
    }

    // 摩尔计数法：核心思想是两两抵消
    public static int majorityElement(int[] nums) {
        int len = nums.length;
        int tempCount = 0;
        int temp = 0;
        for (int j : nums) { // 找众数
            if (tempCount == 0) {
                temp = j;
                tempCount++;
            } else {
                if (temp == j) {
                    tempCount++;
                } else {
                    tempCount--;
                }
            }
        }

        int half = len / 2;
        int count = 0;
        if (tempCount > 0) { // 判断众数是否为主要元素
            for (int num : nums) {
                if (temp == num) {
                    count++;
                    if (count > half) return temp;
                }
            }
        }
        return -1;
    }
}
