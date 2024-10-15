package io.conduktor.demos.dfsbfs.practice241010.basic;
// 4. 피보나치 재귀(메모이제이션)
public class Fibonacci4 {

    static int[] fibo;

    int DFS(int n) {
        if (fibo[n] > 0) return fibo[n];
        if (n == 1 || n == 2) {
            return fibo[n] = 1;
        } else {
            return fibo[n] = DFS(n - 2) + DFS(n - 1);
        }
    }

    public static void main(String[] args) {
        Fibonacci4 fib = new Fibonacci4();
        int n = 13;
        fibo = new int[n+1];
        fib.DFS(n);
        for (int i : fibo) {
            if (i == 0) continue;
            System.out.print(i + " ");
        }
    }
}
