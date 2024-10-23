package io.conduktor.demos.dfsbfs.practice241010.advanced;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// 14. 섬나라 아일랜드 BFS
public class IslandFinderWithBFS14 {

    static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    static int N;
    static int answer;
    static int[][] board;
    static Deque<Point> queue;

    static void bfs(Deque<Point> queue) {
        while (!queue.isEmpty()) {
            Point landPoint = queue.poll();
            for (int i = 0; i < 8; i++) {
                int ny = landPoint.getY() + dy[i];
                int nx = landPoint.getX() + dx[i];
                if (ny >= 0 && nx >= 0 && ny < N && nx < N && board[ny][nx] == 1) {
                    board[ny][nx] = 0;
                    queue.add(new Point(ny, nx));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        answer = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 1) {
                    board[i][j] = 0;
                    queue = new ArrayDeque<>();
                    queue.add(new Point(i, j));
                    bfs(queue);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    static class Point{
        private int y;
        private int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }

}
