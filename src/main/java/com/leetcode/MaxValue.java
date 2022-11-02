package com.leetcode;

/**
 * 整型数组三个数乘积的最大值
 * 三种情况
 * 1、全是正整数；3个最大的数
 * 2、全是负整数；3个最大的数
 * 3、有正，有负；2个最小负数 + 1个最大的正数
 *
 * @Auth ZhangWeiWei
 * @Date 2022/8/22
 **/
public class MaxValue {
    public static void main(String[] args) {
        int[] arr = new int[]{-1,2,-3,4,5,6};
        System.out.println(getMaxMin(arr));
    }

    // 线性扫描，一次遍历
    private static int getMaxMin(int[] arr) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;  // 如果最小值取MIN_VALUE，就没有值比min1、min2小，所以只能取MAX_VALUE
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
             int x = arr[i];
             if (x < min1) {
                 min2 = min1;
                 min1 = x;
             } else if (x < min2) {
                 min2 = x;
             }

             if (x > max1) {
                 max3 = max2;
                 max2 = max1;
                 max1 = x;
             } else if (x > max2) {
                 max3 = max2;
                 max2 = x;
             } else if (x > max3) {
                 max3 = x;
             }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
