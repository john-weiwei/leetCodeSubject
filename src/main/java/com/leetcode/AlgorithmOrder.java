package com.leetcode;

import java.util.Arrays;

/**
 * @author zhang weiwei
 * @date 2022/8/26
 */
public class AlgorithmOrder {

    private static int[] arr = new int[]{3,5,3,0,8,6,1,5,8,6,2,4,9,4,7,0,1,8,9,7,3,1,2,5,9,7,4,0,2,6};

    public static void main(String[] args) {
//        System.out.println(1/2);
//        sort();
        heapSort();
//        fastSort(arr, 0, arr.length - 1);
//        insertSort(arr);
//        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void fastSort(int[] arr, int low, int high) {
        if (high - low <= 0) return;

        int left = low, right = high, axios = left;
        while (left < right) {
            while (left < right && arr[right] <= arr[axios]) {
                right--;
            }

            while (left < right && arr[left] >= arr[axios]) {
                left++;
            }
            swapFast(arr, left, right);
        }
        swapFast(arr, left, axios);
        fastSort(arr, low, left - 1);
        fastSort(arr, left + 1, high);
    }

    private static void swapFast(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 插入排序步骤：
     * 1、第一轮暂时将索引1的值移走，并用两个临时变量分别保存它本身和所在的索引下标（此时索引1对应的位置留下一个空隙，不包含值），之后会一次移动后面索引的值
     * 2、接着是平移阶段，依次拿空隙左侧的每一个值与临时变量比较，如果空隙左侧的值大于临时变量，则该值右移，空隙会左移；如果遇到比临时变量小的值，或者空隙已经到了数组的最左端，则结束平移阶段
     * 3、将临时变量放入空隙所在的下标
     * 4、重复以上步骤
     * @param arr
     */
    private static void insertSort(int[] arr) {
        for (int i = 1 ; i < arr.length; i++) {
            int tempIndex = i;
            int tempValue = arr[i];
            while (tempIndex > 0 && arr[tempIndex - 1] > tempValue) {
                arr[tempIndex] = arr[tempIndex - 1];
                tempIndex -= 1;
            }
            arr[tempIndex] = tempValue;
        }
    }

    /**
     * 双指针
     * 选择排序步骤：
     * 1、从左到右检查数组的每个格子 i，并用一个变量临时保存最小值的索引 lowIndex，从lowIndex + 1位置值开始与lowIndex下标值比较，找出最小值，更新最小值下标索引 lowIndex = j
     * 2、确定本轮最小值后，如果最小值比本轮起点值i的值小，则将该值与本轮检查的起点值i交换
     * 3、重复以上步骤，直至数组有序
     * @param arr
     */
    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int lowIndex = i;
            int j = lowIndex + 1;
            for (;j < arr.length;j++) {
                if (arr[j] < arr[lowIndex]) {
                    lowIndex = j;
                }
            }

            if (arr[lowIndex] < arr[i]) {
                int temp = arr[lowIndex];
                arr[lowIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    // 小顶堆
    private static void minHeap(int index, int len) {
        int left = (2 * index) + 1;
        int right = left + 1;
        int minValIndex = left; // 取左节点下标为最大值
        if (left > len) return;
        if (right <= len && arr[right] < arr[left]) minValIndex = right;
        if (arr[minValIndex] < arr[index]) {
            swap(index, minValIndex); // 父节点跟子节点值交换
            minHeap(minValIndex, len); // 递归，以maxValIndex作为父节点，判断是否符合堆的特性
        }
    }

    // 堆排序
    private static void heapSort() {
        // 1、构建最大堆，计算第一个非叶子节点下标 (len - 1)/2（叶子节点可以当成是符合堆特性的，所以从第一个非叶子节点开始）
        int len = arr.length - 1;
        int beginIndex = (arr.length >> 1) - 1;
        for (int i = beginIndex; i >= 0 ; i--) {
            maxHeap(i, len);
        }

        // 2、每次排序得到新的最大堆arr[0]，将堆顶元素跟最后一个元素交换
        for (int i = len; i > 0; i--) {
            swap(0, i);
            maxHeap(0, i - 1);
        }
    }

    // 大顶推；index 是父节点索引下标
    private static void maxHeap(int index, int len) {
        int left = (2 * index) + 1;
        int right = left + 1;
        int maxValIndex = left; // 取左节点下标为最大值
        if (left > len) return;
        if (right <= len && arr[right] > arr[left]) maxValIndex = right;
        if (arr[maxValIndex] > arr[index]) {
            swap(index, maxValIndex); // 父节点跟子节点值交换
            maxHeap(maxValIndex, len); // 递归，以maxValIndex作为父节点，判断是否符合堆的特性
        }
    }

    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 归并排序
   private static void mergeSort(int[] values, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        // 递归分解左子序列
        mergeSort(values, start, mid);
        // 递归分解右子序列
        mergeSort(values, mid + 1, end);
        // 合并有序子序列，放入临时数组
        int[] temp = new int[values.length];
        merge(values, temp, start, mid, end);
   }

   // 合并序列， 左子序列：[i, mid]；  右子序列：[mid + 1, end]
   private static void merge(int[] value, int[] temp, int start, int mid, int end) {
        int i = start; // 左子序列开始下标
        int j = mid + 1; // 右子序列开始下标
        int tempIndex = start; // 临时数组存放起始下标

       // 把两个序列中的较小值放入临时数组
        while (i <= mid && j <= end) {
            if (value[i] < value[j]) {
                temp[tempIndex] = value[i];
                i++;
            } else {
                temp[tempIndex] = value[j];
                j++;
            }
            tempIndex++;
        }

        // 遍历左子序列剩下的元素放入临时数组
        while (i <= mid) {
            temp[tempIndex] = value[i];
            i++;
            tempIndex++;
        }

       // 遍历右子序列剩下的元素放入临时数组
        while (j <= end) {
            temp[tempIndex] = value[j];
            j++;
            tempIndex++;
        }

       // 有序序列传回原数组
       if (end + 1 - start >= 0) System.arraycopy(temp, start, value, start, end + 1 - start);
   }
}
