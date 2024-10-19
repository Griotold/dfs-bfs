package io.conduktor.demos.dfsbfs.practice241010.advanced;

import java.util.Scanner;

// 8. 수열 추측하기
public class SequencePrediction8 {
    private static final int MAX = 35;
    static int N;
    static int F;
    static boolean flag;
    static int[] binomial;
    static int[] permutations;
    static int[] ch;
    static int[][] dy = new int[MAX][MAX];

    int combi(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r];
        if (n == r || r == 0) return dy[n][r] = 1;
        else return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);

    }

    void dfs(int level, int sum) {
        if (flag) return;
        if (level == N) {
            if (sum == F) {
                flag = true;
                for (int element : permutations) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        } else {
            for (int i = 1; i <= N; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    permutations[level] = i;
                    dfs(level + 1, sum + (permutations[level] * binomial[level]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        SequencePrediction8 T = new SequencePrediction8();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        F = sc.nextInt();
        binomial = new int[N];
        permutations = new int[N];
        ch = new int[N + 1];
        for (int i = 0; i < N; i++) {
            binomial[i] = T.combi(N-1, i);
        }
        flag = false;
        T.dfs(0, 0);
    }
}
