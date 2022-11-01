package com.leetcode;

import java.util.Arrays;

/**
 * @Auth ZhangWeiWei
 * @Date 2022/8/28
 **/
public class SortAlgorithm {

    private static int[] arr = new int[]{1,3,7,6,5,6};

    public static void main(String[] args) {
        heapSort();
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort() {
        // 1、构造大顶堆（小顶堆）,从第一个非叶子节点（叶子节点可以看成是符合堆特性的）开始 beginIndex = arr.length / 2 - 1
        int len = arr.length - 1;
        int beginIndex = arr.length / 2 - 1;
        for (int i = beginIndex; i >= 0; i--) {
            maxHeap(i, len);
        }

        // 2、将堆数据进行排序
        // 每次排序将堆顶元素跟最后一个元素交换，即把堆顶元素放到数组后面
        for (int i = len; i > 0; i--) {
            swap(0, i);
            maxHeap(0, i - 1);
        }
    }

    // 元素下标index，数组长度
    private static void maxHeap(int index, int len) {
        int l = 2 * index + 1;
        int r = l + 1;
        int tempMax = l;
        if (l > len) return;
        if (r <= len && arr[l] < arr[r]) tempMax = r;
        if (arr[tempMax] > arr[index]) {
            swap(tempMax, index);
            maxHeap(tempMax, len);
        }
    }

    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
