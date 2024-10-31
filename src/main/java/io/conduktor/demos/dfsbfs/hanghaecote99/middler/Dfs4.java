package io.conduktor.demos.dfsbfs.hanghaecote99.middler;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 4. 알고리즘 수업 - 깊이 우선 탐색 1 - 백준 : 24479
public class Dfs4 {

    static int N;
    static int M;
    static int start;
    static List<List<Integer>> adjList;
    static int[] ch;
    static int order = 1;

    static void dfs(int node) {
        for (int x : adjList.get(node)) {
            if (ch[x] == 0) {
                ch[x] = ++order;
                dfs(x);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 수
        M = Integer.parseInt(st.nextToken()); // 간선의 수
        start = Integer.parseInt(st.nextToken()); // 시작 정점

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList.get(i));
        }

        ch = new int[N + 1];
        ch[start] = order;
        dfs(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(ch[i]).append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
