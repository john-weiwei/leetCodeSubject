package com.leetcode;

/**
 * @Auth ZhangWeiWei
 * @Date 2022/5/10
 **/
public class NextQueue13 {
    public static void main(String[] args) {
        NextQueue13 nq = new NextQueue13();
        int[] nums = new int[]{1,2,3};
        nq.nextPermutation(nums);
    }

    private void nextPermutation(int[] nums) {
        int size = nums.length;
        int right = size - 1;
        int left = right - 1;
    }
}
