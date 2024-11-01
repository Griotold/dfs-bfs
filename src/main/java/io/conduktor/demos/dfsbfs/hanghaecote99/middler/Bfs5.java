package io.conduktor.demos.dfsbfs.hanghaecote99.middler;

import java.io.*;
import java.util.*;

// 5. 알고리즘 수업 - 너비 우선 탐색 1 - 백준 : 24444
public class Bfs5 {

    static int N;
    static int M;
    static int start;
    static List<List<Integer>> adjList;
    static int[] ch;
    static int orderCount = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <=N; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        for (int i = 1; i < N; i++) {
            Collections.sort(adjList.get(i));
        }
        ch = new int[N + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        ch[start] = orderCount++;
        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int x : adjList.get(cur)) {
                if (ch[x] == 0) {
                    ch[x] = orderCount++;
                    queue.add(x);
                }
            }
        }

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
