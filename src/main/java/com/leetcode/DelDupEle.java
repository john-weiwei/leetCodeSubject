package com.leetcode;

/**
 * 删除重复元素
 *
 * @author zhang weiwei
 * @date 2022/8/22
 */
public class DelDupEle {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,3,4,5};
        System.out.println(retLen(arr));
    }

    private static int retLen(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int i = 0; // 慢指针 i
        for (int j = 1; j < arr.length; j++) { //  快指针 j
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }
}
