package io.conduktor.demos.dfsbfs.kim.section8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 최대점수 구하기 - DFS
 * */
public class MaxPoint {
    // 5 20
    //10 5
    //25 12
    //15 8
    //6 3
    //7 4
    static int n, m;
    static int max;
    static int[] ch;
    static List<Problem> problems;

    public void DFS(int L) {
        if (L == n) {
            int sum = 0;
            int maxTime = m;
            for (int i = 0; i < n; i++) {
                if (ch[i] == 1) {
                    maxTime -= problems.get(i).getTime();
                    if (maxTime < 0) return;
                    sum += problems.get(i).getPoint();
                }
            }
            max = Math.max(max, sum);
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) {
        MaxPoint T = new MaxPoint();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        max = Integer.MIN_VALUE;
        ch = new int[n];
        problems = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int point = kb.nextInt();
            int time = kb.nextInt();
            Problem problem = new Problem(point, time);
            problems.add(problem);
        }
        T.DFS(0);
        System.out.println(max);
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
