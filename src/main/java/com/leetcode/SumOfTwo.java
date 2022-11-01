package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 数组两数之和等于target，返回两数的下标值，以数组形式返回
 *
 * @Auth ZhangWeiWei
 * @Date 2022/8/24
 **/
public class SumOfTwo {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,7,6,5,6};
        Arrays.stream(sumOfTwo(arr, 11)).forEach(System.out::println);
        int[] arr2 = new int[]{1,3,7,8,10,16};
        Arrays.stream(orderSumOfTwo(arr2, 17)).forEach(System.out::println);
        Arrays.stream(twoPoint(arr2, 17)).forEach(System.out::println);
    }

    // 用map来存储标记位
    private static int[] sumOfTwo(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(target - arr[i])) {
                map.put(arr[i], i);
            } else {
                return new int[]{map.get(target-arr[i]), i};
            }
        }
        return new int[0];
    }

    // 有序数组的两数之和；二分查找
    private static int[] orderSumOfTwo(int[] arr, int target) {
        int r = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i], l = i;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (target - val == arr[mid]) {
                    return new int[] {i, mid};
                }else if (target - val > arr[mid]) {
                    l = mid + 1;
                } else {
                  r = mid - 1;
                }
            }
        }
        return new int[0];
    }

    // 有序数组两数之和，双指针
    private static int[] twoPoint(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            if (target - arr[l] == arr[r]) {
                return new int[]{l, r};
            } else if (target - arr[l] < arr[r]) {
                r--;
            } else if (target - arr[l] > arr[r]) {
                l++;
            }
        }
        return new int[0];
    }
}
