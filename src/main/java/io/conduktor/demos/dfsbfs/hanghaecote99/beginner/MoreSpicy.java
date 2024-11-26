package io.conduktor.demos.dfsbfs.hanghaecote99.beginner;

import java.util.PriorityQueue;

/**
 * 241121 목요일 - 더 맵게 - 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 * 힙
 * */
public class MoreSpicy {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : scoville) pq.offer(x);

        while (pq.peek() < K) {
            if (pq.size() == 1) return -1;

            pq.add(pq.poll() + (pq.poll() * 2));
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        MoreSpicy ms = new MoreSpicy();
        System.out.println(ms.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}
