package io.conduktor.demos.dfsbfs.practice241010.basic;
// 3. 팩토리얼
public class Factorial3 {

    int DFS(int n) {
        if (n == 1) return 1;
        else {
            return n * DFS(n - 1);
        }
    }

    public static void main(String[] args) {
        Factorial3 T = new Factorial3();
        int value = T.DFS(5);
        System.out.println(value);
    }
}
