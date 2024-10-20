package io.conduktor.demos.dfsbfs.practice241010.advanced;

import java.util.Scanner;

// 10. 미로탐색(DFS)
public class ExploringMaze10 {

    private static final int MAX = 8;
    private static final int[] dy = {-1, 0, 1, 0};
    private static final int[] dx = {0, 1, 0, -1};

    static int answer;
    static int[][] board = new int[MAX][MAX];

    void dfs(int y, int x) {
        if (y == 7 && x == 7) {
            answer++;
        } else {
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny >= 1 && nx >= 1 && ny < MAX && nx < MAX) {
                    if (board[ny][nx] == 0) {
                        board[ny][nx] = 1;
                        dfs(ny, nx);
                        board[ny][nx] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ExploringMaze10 T = new ExploringMaze10();
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < MAX; i++) {
            for (int j = 1; j < MAX; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        answer = 0;
        board[1][1] = 1;
        T.dfs(1, 1);
        System.out.println(answer);
    }
}
