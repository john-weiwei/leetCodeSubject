package com.leetcode;

/**
 * @Auth ZhangWeiWei
 * @Date 2022/11/2
 **/
public class LeetCode4 {

    public static void main(String[] args) {

        int[] nums1 = {100001};
        int[] nums2 = {100000};

        LeetCode4 leetCode4 = new LeetCode4();
        double result = leetCode4.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);

        double a = 5.0/2;
        int b = 1/2;
//        System.out.println(a);
//        System.out.println(b);
    }

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
        while((index1 < size1 || index2 < size2) && index3 < size3) {
            if (index1 < size1) {
                value1 = nums1[index1];
            }

            if (index2 < size2) {
                value2 = nums2[index2];
            }

            if (value1 <= value2 && index1 < size1) {
                nums3[index3] = value1;
                index1++;
            } else if (index2 < size2) {
                nums3[index3] = value2;
                index2++;
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
