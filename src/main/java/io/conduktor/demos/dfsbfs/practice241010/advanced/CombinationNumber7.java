package io.conduktor.demos.dfsbfs.practice241010.advanced;

import java.util.Scanner;

// 7. 조합수 (메모이제이션)
public class CombinationNumber7 {
    private static final int MAX = 35;
    int[][] dy = new int[MAX][MAX];
    static int N;
    static int R;

    int dfs(int n, int r) {
        if (dy[n][r] != 0) return dy[n][r];
        if (n == r || r == 0) return 1;
        else {
            return dy[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
        }
    }

    public static void main(String[] args) {
        CombinationNumber7 T = new CombinationNumber7();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        System.out.println(T.dfs(N, R));
    }
}
