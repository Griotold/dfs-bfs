package io.conduktor.demos.dfsbfs.hanghaecote99.middler;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 241106 수요일 - 특정 거리의 도시 찾기 - 백준 18352
 * https://www.acmicpc.net/problem/18352
 * BFS, 다익스트라
 * 다익스트라로 풀었음
 * */
public class FindingCity10 {

    private static int N; // 도시의 개수
    private static int M; // 도로의 개수
    private static int K; // 거리 정보
    private static int X; // 출발 도시 번호
    private static int[] distances; // 출발도시인 x와의 최단경로
    private static ArrayList<Edge>[] edgeList; // 도시 인접리스트

    private static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(X, 0));
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int vertex = edge.getVertex();
            int cost = edge.getCost();
            // 최적화 로직 - 이미 처리된 정점에 대한 불필요한 탐색 방지
            if (distances[vertex] < cost) {
                continue;
            }
            // 해당 도시와 연결되어 있는 도시들 탐색
            for(int i = 0; i < edgeList[vertex].size(); i++) {
                int vertex2 = edgeList[vertex].get(i).getVertex();
                int cost2 = edgeList[vertex].get(i).getCost() + cost;
                // 최단 경로 갱신
                if (distances[vertex2] > cost2) {
                   distances[vertex2] = cost2;
                   pq.add(new Edge(vertex2, cost2));
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        // 생성 초기화
        distances = new int[N + 1];
        edgeList = new ArrayList[N + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        for (int i = 1; i <= N; i++) {
            edgeList[i] = new ArrayList<>();
        }
        // 경로 초기화
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            // A번 도시에서 B번 도시로 이동하는 단방향 도로가 존재
            edgeList[start].add(new Edge(end, 1));
        }
        // 출발 도시
        distances[X] = 0;
        // 다익스트라
        dijkstra();
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        for (int i = 1; i < distances.length; i++) {
            int distance = distances[i];
            if (distance == K) {
                sb.append(i).append("\n");
                answer++;
            }
        }
        if (answer == 0) {
            bw.write("-1");
        } else {
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static class Edge implements Comparable<Edge> {
        int vertex;
        int cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        public int getVertex() {
            return vertex;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public int compareTo(Edge o) { // 오름차순
            return cost - o.cost;
        }
    }
}
