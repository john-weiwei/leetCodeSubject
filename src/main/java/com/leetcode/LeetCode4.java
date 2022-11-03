package com.leetcode;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * @Auth ZhangWeiWei
 * @Date 2022/11/2
 **/
public class LeetCode4 {

    public static void main(String[] args) {

        int[] nums1 = {1,2};
        int[] nums2 = {3,4};

        LeetCode4 leetCode4 = new LeetCode4();
        double result = leetCode4.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    // 暴力求解
    // 核心思想：合并数组，增加一个数组结束标识；判断数组长度是否能整除2，是：中位数 = (nums3[mid] + nums3[mid-1]) / 2; 否：中位数 = nums3[mid]
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int size3 = size1 + size2;
        int[] nums3 = new int[size3];
        if (size1 == 0 && size2 == 0) return 0.0;
        if (size1 == 0) {
            nums3 = nums2;
        }

        if (size2 == 0) {
            nums3 = nums1;
        }
        int index1 = 0, index2 = 0, index3 = 0;
        int value1 = 0, value2 = 0;
        boolean endFlag1 = false, endFlag2 = false;
        while(index3 < size3) {
            if (index1 < size1) {
                value1 = nums1[index1];
            } else {
                endFlag1 = true;
            }

            if (index2 < size2) {
                value2 = nums2[index2];
            } else {
                endFlag2 = true;
            }

            if (endFlag1) {
                nums3[index3] = value2;
                index2++;
            } else if (endFlag2) {
                nums3[index3] = value1;
                index1++;
            } else {
                if (value1 <= value2) {
                    nums3[index3] = value1;
                    index1++;
                } else {
                    nums3[index3] = value2;
                    index2++;
                }
            }

            index3++;
        }


        double result = 0.0;
        int mid = size3 / 2;
        if (size3 % 2 == 0) {
            double sum = nums3[mid] + nums3[mid-1];
            result = sum / 2;
        } else {
            result = nums3[mid];
        }
        return result;
    }

}
