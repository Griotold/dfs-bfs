package io.conduktor.demos.dfsbfs.hanghaecote99.beginner;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 241120 수요일 - 국회의원 선거 - 백준 1147번
 * https://www.acmicpc.net/problem/1417
 * 우선순위 큐
 * */
public class ElectionCongressman1147 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int dasomVotes = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 1; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (!pq.isEmpty() && pq.peek() >= dasomVotes) {
            // 가장 많은 표를 가진 후보의 표를 하나 줄이고 다솜이의 표를 하나 늘린다.
            int maxVotes = pq.poll();
            maxVotes--;
            dasomVotes++;
            answer++;
            pq.offer(maxVotes);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
