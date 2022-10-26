package com.leetcode;

/**
 * 统计100以内的素数
 *
 * @author zhang weiwei
 * @date 2022/8/23
 */
public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println(flPrime(100));
        System.out.println(primeNum(100));
    }

    private static int flPrime(int n) {
        int count = 0;
        for (int i = 2 ; i < n; i++) {
            count += isBlPrime(i) ? 1 : 0;
        }
        return count;
    }

    private static boolean isBlPrime(int n) {
        for (int j = 2; j * j <= n; j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }

    // 埃筛法，找出非素数（合数）
    private static int primeNum(int n) {
        boolean[] isPrime = new boolean[n]; // 类似布隆过滤器
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
                for (int j = 2 * i; j < n; j += i) { // 优化：j = i * i，每次自增的基数是i
                    isPrime[j] = true; // 非素数的位置为true
                }
            }
        }
        return count;
    }
}
