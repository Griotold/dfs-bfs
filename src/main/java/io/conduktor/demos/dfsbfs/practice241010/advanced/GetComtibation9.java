package io.conduktor.demos.dfsbfs.practice241010.advanced;

import java.util.Scanner;

// 9. 조합 구하기
public class GetComtibation9 {

    static int N;
    static int M;
    static int[] combi;
    static int[] ch;

    void dfs(int level, int start) {
        if (level == M) {
            for (int x : combi) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i <= N; i++) {
                combi[level] = i;
                dfs(level + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        GetComtibation9 T = new GetComtibation9();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        combi = new int[M];
        ch = new int[N + 1];
        T.dfs(0, 1);
    }
}
