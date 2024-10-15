package io.conduktor.demos.dfsbfs.practice241010.basic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// 14. 그래프 최단거리(BFS)
public class GraphShortcut14 {

    static int N;
    static int M;
    static int[][] graph;
    static int[] ch;
    static int[] answer;
    static Deque<Integer> queue;

    int bfs(int s, int e) {
        ch[s] = 1;
        queue.offer(s);
        int level = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                int x = queue.poll();
                if (x == e) return level;
                for (int j = 1; j <= N; j++) {
                    if (ch[j] == 0 && graph[x][j] == 1) {
                        ch[j] = 1;
                        queue.offer(j);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        GraphShortcut14 gs = new GraphShortcut14();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        ch = new int[N + 1];
        answer = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            queue = new ArrayDeque<>();
            ch = new int[N + 1];
            answer[i] = gs.bfs(1, i);
        }
        for (int i = 2; i <= N; i++) {
            System.out.println(i + " : " + answer[i]);
        }
    }
}
