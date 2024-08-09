package io.conduktor.demos.dfsbfs.basic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 송아지 찾기 - BFS
 * */
public class Calf {
    static int n, m;
    static int[] dis = {-1, 1, 5};
    static int[] ch;
    Queue<Integer> queue = new LinkedList<>();

    public int BFS(int s, int e) {
        ch = new int[10_001];
        ch[s] = 1;
        queue.offer(s);
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int x = queue.poll();
                if (x == e) return L;
                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    if (nx >= 1 && nx <= 10_000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Calf T = new Calf();
        n = 5;
        m = 14;
        System.out.println(T.BFS(n, m));;
    }
}
