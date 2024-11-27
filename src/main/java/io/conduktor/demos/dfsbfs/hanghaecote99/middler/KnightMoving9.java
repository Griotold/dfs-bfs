package io.conduktor.demos.dfsbfs.hanghaecote99.middler;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * 241105 화 - 나이트의 이동 - 백준 7562
 * https://www.acmicpc.net/problem/7562
 * BFS
 * */
public class KnightMoving9 {
    static final int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static final int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        while (T-- > 0) {

            int boardSize = Integer.parseInt(br.readLine());
            int[][] ch = new int[boardSize][boardSize];
            st = new StringTokenizer(br.readLine());
            Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            // 시작점과 도착점이 같은 경우를 먼저 처리
            if (start.equals(end)) {
                sb.append("0\n");
                continue;
            }

            // bfs
            Deque<Point> queue = new ArrayDeque<>();
            ch[start.getY()][start.getX()] = 0;
            queue.add(start);

            while (!queue.isEmpty()) {
                Point cur = queue.poll();
                if (cur.equals(end)) break;
                for (int i = 0; i < 8; i++) {
                    int ny = cur.getY() + dy[i];
                    int nx = cur.getX() + dx[i];
                    if (ny >= 0 && ny < boardSize && nx >= 0 && nx < boardSize && ch[ny][nx] == 0) {
                        ch[ny][nx] = ch[cur.getY()][cur.getX()]+ 1;
                        queue.add(new Point(ny, nx));
                    }
                }
            }
            sb.append(ch[end.getY()][end.getX()]).append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
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

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return y == point.y && x == point.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}
