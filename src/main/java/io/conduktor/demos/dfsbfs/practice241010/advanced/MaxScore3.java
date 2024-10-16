package io.conduktor.demos.dfsbfs.practice241010.advanced;

import java.util.Scanner;

// 3. 최대점수 구하기(DFS)
public class MaxScore3 {

    static int N;
    static int M;
    static int answer;
    static Problem[] problems;

    void dfs(int level, int sum, int time) {
        if (time > M) return;
        if (level == N) {
            answer = Math.max(answer, sum);
        } else {
            dfs(level + 1, sum + problems[level].getPoint(), time + problems[level].getTime());
            dfs(level + 1, sum, time);
        }
    }

    public static void main(String[] args) {
        MaxScore3 T = new MaxScore3();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        problems = new Problem[N];
        for (int i = 0; i < N; i++) {
            int point = sc.nextInt();
            int time = sc.nextInt();
            problems[i] = new Problem(point, time);
        }
        answer = Integer.MIN_VALUE;
        T.dfs(0, 0, 0);
        System.out.println(answer);
    }

    static class Problem {
        private int point;
        private int time;

        public Problem(int point, int time) {
            this.point = point;
            this.time = time;
        }

        public int getPoint() {
            return point;
        }

        public int getTime() {
            return time;
        }

    }
}
