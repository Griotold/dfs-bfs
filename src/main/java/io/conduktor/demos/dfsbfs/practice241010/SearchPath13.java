package io.conduktor.demos.dfsbfs.practice241010;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchPath13 {

    static int N;
    static int M;
    static int answer;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    void dfs(int v) {
        if (v == N) answer++;
        else {
            for (int nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    dfs(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        SearchPath13 T = new SearchPath13();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch = new int[N+1];
        ch[1] = 1;
        T.dfs(1);
        System.out.println(answer);
    }
}
