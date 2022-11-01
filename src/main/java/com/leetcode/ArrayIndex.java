package com.leetcode;

import java.util.Arrays;

/**
 * 获取数组的中心下标，即左边元素和等于右边元素和
 *
 * @Auth ZhangWeiWei
 * @Date 2022/8/22
 **/
public class ArrayIndex {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,7,6,5,6};
        System.out.println(centerIndex(arr));
    }

    // 双指针
    private static int centerIndex(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
            if (total == sum) {
                return i;
            }
            sum = sum - arr[i];
        }
        return -1;
    }
}
