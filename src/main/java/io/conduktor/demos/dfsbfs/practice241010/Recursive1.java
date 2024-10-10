package io.conduktor.demos.dfsbfs.practice241010;

// 1. 재귀함수(스택프레임)
public class Recursive1 {

    public void DFS(int n) {
        // 종단 조건
        if (n == 0) {
            return;
        } else {
            // 로직
            DFS(n - 1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Recursive1 T = new Recursive1();
        T.DFS(3);
    }
}
