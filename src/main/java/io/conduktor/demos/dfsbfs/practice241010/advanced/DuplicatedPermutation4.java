package io.conduktor.demos.dfsbfs.practice241010.advanced;

import java.util.Scanner;

// 4. 중복 순열
public class DuplicatedPermutation4 {
    static int N;
    static int M;
    static int[] answer;

    void dfs(int level) {
        if (level == M) {
            for(int i = 0; i < M; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
        } else {
            for(int i = 1; i <= N; i++) {
                answer[level] = i;
                dfs(level + 1);
                answer[level] = 0;
            }
        }
    }

    public static void main(String[] args) {
        DuplicatedPermutation4 T = new DuplicatedPermutation4();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        answer = new int[M];
        T.dfs(0);
    }
}
