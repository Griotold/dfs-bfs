package io.conduktor.demos.dfsbfs.practice241010.basic;

import java.util.Scanner;

public class SearchPath12 {

    static int N;
    static int M;
    static int answer;
    static int[][] arr;
    static int[] ch;

    void dfs(int v) {
        if (v == N) answer++;
        else {
            for (int i = 1; i <= N; i++) {
                if (ch[i] == 0 && arr[v][i] == 1) {
                    ch[i] = 1;
                    dfs(i);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        SearchPath12 T = new SearchPath12();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
        }
        ch = new int[N+1];
        ch[1] = 1;
        T.dfs(1);
        System.out.println("answer = " + answer);

    }
}
