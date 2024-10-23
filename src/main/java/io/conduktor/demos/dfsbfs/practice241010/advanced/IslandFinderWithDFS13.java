package io.conduktor.demos.dfsbfs.practice241010.advanced;

import java.util.Scanner;

// 13. 섬나라 아일랜드 DFS
public class IslandFinderWithDFS13 {

    static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    static int N;
    static int answer;
    static int[][] board;

    static void dfs(int y, int x) {
        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && nx >= 0 && ny < N && nx < N && board[ny][nx] == 1) {
                board[ny][nx] = 0;
                dfs(ny, nx);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        // 1인 애들만 탐색을 하고 밟은 곳은 0으로 만든다.
        answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    dfs(i, j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
