package io.conduktor.demos.dfsbfs.hanghaecote99.beginner;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 241117 일요일 - 센티와 마법의 뿅망치 - 백준 19638
 * https://www.acmicpc.net/problem/19638
 * 우선순위 큐
 * */
public class MagicHammer19638 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        while(T-- > 0) {
            if (pq.peek() < H) break;
            Integer maxGiant = pq.poll();
            if (maxGiant > 1) {
                maxGiant /= 2;
            }
            pq.add(maxGiant);
            count++;
        }

        StringBuilder sb = new StringBuilder();
        if (H > pq.peek()) {
            sb.append("YES").append("\n").append(count + "").append("\n");
        } else {
            sb.append("NO").append("\n").append(pq.peek()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
