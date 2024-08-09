package io.conduktor.demos.dfsbfs.basic;

/**
 * 피보나치 수열(메모이제이션)
 * */
public class Fibonacci {
    static int[] fibo;
    private int DFS(int n) {
        // 이미 계산된 값이 있으면 그 값을 반환
        if (fibo[n] != 0) return fibo[n];

        if (n == 1 || n == 2) return fibo[n] = 1;
        else {
            return fibo[n] = DFS(n - 1) + DFS(n - 2);
        }
    }

    public static void main(String[] args) {
        Fibonacci T = new Fibonacci();
        int n = 45;
        fibo = new int[n+1];
        T.DFS(n);
        for (int i = 1; i <= n; i++) {
            System.out.println(fibo[i]+ " ");
        }
    }
}
