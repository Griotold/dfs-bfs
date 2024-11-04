package io.conduktor.demos.dfsbfs.hanghaecote99.middler;

import java.io.*;
import java.util.StringTokenizer;

// 8. 촌수 계산 - 백준 : 2644 - DFS, BFS
public class ChonNumber8 {
    static int N;
    static int targetA;
    static int targetB;
    static int M;
    static int answer = 0;
    static int[][] adjMatrix;
    static int[] ch;

    static void dfs(int idx, int count) {
        ch[idx] = 1;

        if (idx == targetB) answer = count;

        for (int i = 1; i <= N; i++) {
            if (adjMatrix[idx][i] == 1 && ch[i] == 0) {
                dfs(i, count + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        targetA = Integer.parseInt(st.nextToken());
        targetB = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        adjMatrix = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjMatrix[a][b] = 1;
            adjMatrix[b][a] = 1;
        }
        ch = new int[N+1];
        answer = -1;
        dfs(targetA, 0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
