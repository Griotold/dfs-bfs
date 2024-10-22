package io.conduktor.demos.dfsbfs.practice241010.advanced;

// import io.conduktor.demos.dfsbfs.BoardPrinter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// 12. 토마토(BFS 활용)
// 익지 않은 토마트를 구할 때 flag 를 사용하여 board[i][j] == 0 인 걸 체크하는 방법도 있다.
public class Tomato12 {

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    static int M;
    static int N;
    static int[][] board;
    static int[][] dis;

    static class Point {
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

    public static void main(String[] args) {
        Tomato12 T = new Tomato12();
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        board = new int[N][M];
        Deque<Point> queue = new ArrayDeque<>();

        // dis 이중 배열 -1로 초기화
        T.initializeDistanceArray();

        T.initializeBoard(sc, queue);

        //BoardPrinter.printBoard(board);

        // bfs
        T.bfs(queue);

        T.printAnswer();
    }

    private void printAnswer() {
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dis[i][j] == -1 && board[i][j] != -1) {
                    System.out.println(-1);
                    return;
                }

                answer = Math.max(answer, dis[i][j]);
            }
        }
        System.out.println(answer);
    }

    private void initializeBoard(Scanner sc, Deque<Point> queue) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int anInt = sc.nextInt();
                if (anInt == 1) {
                    queue.add(new Point(i, j));
                    dis[i][j] = 0;
                }
                board[i][j] = anInt;
            }
        }
    }

    private void initializeDistanceArray() {
        dis = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dis[i][j] = -1;
            }
        }
    }

    private void bfs(Deque<Point> queue) {
        while (!queue.isEmpty()) {
            Point ripenedTomato = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = ripenedTomato.getY() + dy[i];
                int nx = ripenedTomato.getX() + dx[i];
                if (nx >= 0 && ny >= 0 && nx < M && ny < N && board[ny][nx] == 0) {
                    board[ny][nx] = 1;
                    queue.add(new Point(ny, nx));
                    dis[ny][nx] = dis[ripenedTomato.getY()][ripenedTomato.getX()] + 1;
                }
            }
        }
    }
}
