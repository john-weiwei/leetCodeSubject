package com.leetcode;

/**
 * X的平方根
 * 
 * @Auth ZhangWeiWei
 * @Date 2022/8/22
 **/
public class XSqar {
    public static void main(String[] args) {
        System.out.println(calculateSqrt(24));
        System.out.println(niu(24));
    }

    // 二分查找
    private static int calculateSqrt(int x) {
        int index = -1, l = 0, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid * mid <= x) {
                index = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return index;
    }

    private static int niu(int x) {
        return niuDun(x,x);
    }

    // 递归，牛顿迭代 x = n^2, x/n = n, (x/n + n) / 2 ~= 根号x
    private static int niuDun(double n, int x) {
        double res = (n + x/n) / 2;
        if (res == n) {
            return (int) res;
        }
        return niuDun(res, x);
    }
}
