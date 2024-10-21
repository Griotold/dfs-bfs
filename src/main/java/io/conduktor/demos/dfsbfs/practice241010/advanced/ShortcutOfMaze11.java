package io.conduktor.demos.dfsbfs.practice241010.advanced;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// 11. 미로의 최단거리 통로(BFS)
public class ShortcutOfMaze11 {

    static final int MAZE_SIZE = 7;

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    static int[][] maze;
    static int[][] dis;

    void bfs() {
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(1, 1));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int j = 0; j < 4; j++) {
                int ny = point.getY() + dy[j];
                int nx = point.getX() + dx[j];
                if (ny > 0 && nx > 0 && ny <= MAZE_SIZE && nx <= MAZE_SIZE && maze[ny][nx] == 0) {
                    maze[ny][nx] = 1;
                    dis[ny][nx] = dis[point.getY()][point.getX()] + 1;
                    queue.add(new Point(ny, nx));
                }
            }
        }
    }

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

        public boolean isTargetPoint() {
            return y == MAZE_SIZE && x == MAZE_SIZE;
        }
    }

    public static void main(String[] args) {
        ShortcutOfMaze11 T = new ShortcutOfMaze11();
        Scanner sc = new Scanner(System.in);
        maze = new int[MAZE_SIZE + 1][MAZE_SIZE + 1];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        dis = new int[MAZE_SIZE + 1][MAZE_SIZE + 1];
        T.bfs();
        if (dis[MAZE_SIZE][MAZE_SIZE] == 0) System.out.println(-1);
        else System.out.println(dis[MAZE_SIZE][MAZE_SIZE]);
    }
}
