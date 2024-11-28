package io.conduktor.demos.dfsbfs.hanghaecote99.beginner;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 241116 토요일 - N번째 큰수 - 백준 2075
 * https://www.acmicpc.net/problem/2075
 * 우선순위 큐
 */
public class NthBigNumber2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < N - 1; i++) pq.poll();
        bw.write(String.valueOf(pq.poll()));

        bw.flush();
        bw.close();
        br.close();
    }
}
