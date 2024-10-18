package io.conduktor.demos.dfsbfs.practice241010.advanced;

import java.util.Scanner;

// 6. 순열 구하기
public class Permutation6 {

    static int N;
    static int M;
    static int[] ch;
    static int[] arr;

    void dfs(int level) {
        if (level == M) {
            for (int i = 1; i <= N; i++) {
                if (ch[i] == 1) System.out.print(arr[i] + " ");
            }
            System.out.println();
        }  else {
            for (int i = 1; i <= N; i++) {
                if (ch[i] == 0) {
                  ch[i] = 1;
                  dfs(level + 1);
                  ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Permutation6 p = new Permutation6();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        ch = new int[N + 1];
        p.dfs(0);
    }
}
