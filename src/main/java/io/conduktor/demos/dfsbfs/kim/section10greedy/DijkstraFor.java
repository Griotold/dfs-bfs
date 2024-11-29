package io.conduktor.demos.dfsbfs.kim.section10greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 다익스트라 알고리즘
 * */
public class DijkstraFor {
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

    static void dijkstra(int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));
        dis[v] = 0;
        while (!pq.isEmpty()) {
            Edge temp = pq.poll();
            int now = temp.getVertex();
            int nowCost = temp.getCost();
            if (nowCost > dis[now]) continue;
            for (Edge ob : graph.get(now)) {
                if (dis[ob.getVertex()] > nowCost + ob.getCost()) {
                    dis[ob.getVertex()] = nowCost + ob.getCost();
                    pq.offer(new Edge(ob.getVertex(), nowCost + ob.getCost()));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i < M; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            int c = Integer.parseInt(br.readLine());
            graph.get(a).add(new Edge(b, c));
        }
        dijkstra(1);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            if (dis[i] != Integer.MAX_VALUE) {
                sb.append(i + " : " +dis[i]).append("\n");
            } else {
                sb.append(i + " : impossible").append("\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }

    static class Edge implements Comparable<Edge>{
        private int vertex;
        private int cost;

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
            return this.cost - o.cost;
        }
    }
}
