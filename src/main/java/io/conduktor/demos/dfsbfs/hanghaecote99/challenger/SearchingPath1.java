package io.conduktor.demos.dfsbfs.hanghaecote99.challenger;

import java.io.*;
import java.util.StringTokenizer;

// 백준 : 11403 경로 찾기
public class SearchingPath1 {

    static int N;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // i에서 j까지 갈 수 있는가?
        // i에서 k로 가고, k에서 j로 갈 수 있는가?
        // 위에 2개의 질문은 동일함.
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 단순히 갈 수 있는 경로가 있는지만 체크함.
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}

/**
 * 다른 풀이
 * */
//        public static void main(String[] args) throws IOException {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//            final int N = Integer.parseInt(br.readLine());
//            int[][] visited = new int[N][N];
//
//            List<List<Integer>> graph = new ArrayList<>();
//
//            for(int i = 0; i < N; i++) {
//                graph.add(new ArrayList<>());
//            }
//
//            for(int i = 0; i < N; i++) {
//                int[] cols = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//                for(int j = 0; j < cols.length; j++) {
//                    if(cols[j] == 1) {
//                        graph.get(i).add(j);
//                    }
//                }
//            }
//
//            for(int i = 0; i < N; i++) {
//                List<Integer> startVertexes = graph.get(i);
//                Queue<Integer> queue = new LinkedList<>(startVertexes);
//
//                while(!queue.isEmpty()) {
//                    int curVertex = queue.poll();
//                    if(visited[i][curVertex] == 1) continue;
//                    visited[i][curVertex] = 1;
//
//                    List<Integer> neighbors = graph.get(curVertex);
//                    queue.addAll(neighbors);
//                }
//            }
//
//            for (int[] rows : visited) {
//                for (int row : rows) {
//                    System.out.print(row);
//                    System.out.print(" ");
//                }
//                System.out.println();
//            }
//
//        }

