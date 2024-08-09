package io.conduktor.demos.dfsbfs.basic;
/**
 * 팩토리얼
 * */
public class Factorial {

    private int DFS(int n) {
        if (n==0) return 1;
        else {
            return n * DFS(n-1);
        }
    }

    public static void main(String[] args) {
        Factorial T = new Factorial();
        int result = T.DFS(5);
        System.out.println(result);
    }
}
