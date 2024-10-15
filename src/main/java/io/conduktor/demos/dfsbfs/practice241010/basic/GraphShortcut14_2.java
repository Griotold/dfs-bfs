package io.conduktor.demos.dfsbfs.practice241010.basic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

// 14. 그래프 최단거리(BFS) - 인접리스트
public class GraphShortcut14_2 {

    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    static int[] dis;

    void bfs(int s) {
        Deque<Integer> queue = new ArrayDeque<>();
        ch[s] = 1;
        dis[s] = 0;
        queue.offer(s);
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int nextNode : graph.get(currentNode)) {
                if (ch[nextNode] == 0) {
                    ch[nextNode] = 1;
                    queue.offer(nextNode);
                    dis[nextNode] = dis[currentNode] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphShortcut14_2 T = new GraphShortcut14_2();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        ch = new int[N + 1];
        dis = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        T.bfs(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}
