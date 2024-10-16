package io.conduktor.demos.dfsbfs.practice241010.advanced;

import java.util.Scanner;

// 2. 바둑이 승차(DFS)
public class BadugiBoarding2 {
    static int C;
    static int N;
    static int answer;
    static int[] dogs;

    void dfs(int level, int sum) {
        if (sum > C) return;
        if (level == N) {
            answer = Math.max(answer, sum);
        } else {
            dfs(level + 1, sum + dogs[level]);
            dfs(level + 1, sum);
        }
    }

    public static void main(String[] args) {
        BadugiBoarding2 T = new BadugiBoarding2();
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        N = sc.nextInt();
        dogs = new int[N];
        for (int i = 0; i < N; i++) {
            dogs[i] = sc.nextInt();
        }
        answer = Integer.MIN_VALUE;
        T.dfs(0, 0);
        System.out.println(answer);
    }
}
