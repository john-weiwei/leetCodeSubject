package com.leetcode;

import java.util.Arrays;

/**
 * 有序数组的两数之和等于目标值target
 * 返回两数下标
 *
 * @author zhang weiwei
 * @date 2022/8/25
 */
public class OrderSumOfTwo {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,3,4,5,8};
        Arrays.stream(orderSum(arr, 6)).forEach(System.out::println);
    }

    // 双指针；左指针指向数组最左端，右指针指向数组最右端
    private static int[] orderSum(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            if (target - arr[l] > arr[r]) {
                l++;
            } else if (target - arr[l] < arr[r]) {
                r--;
            } else if (target - arr[l] == arr[r]) {
                return new int[]{l,r};
            }
        }
        return new int[0];
    }
}
