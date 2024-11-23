package io.conduktor.demos.dfsbfs.hanghaecote99.beginner;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 241121 목 - 보너스 문제
 * 이중 우선순위 큐 - 힙
 * https://school.programmers.co.kr/learn/courses/30/lessons/42628
 * */
public class DualPriorityQueue {

    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (String operation : operations) {
            String[] split = operation.split(" ");
            int num;

            switch (split[0]) {
                case "I" -> {
                    num = Integer.parseInt(split[1]);
                    minHeap.add(num);
                    maxHeap.add(num);
                }
                case "D" -> {
                    if (minHeap.isEmpty()) continue;

                    if (split[1].equals("1")) {
                        num = maxHeap.poll();
                        minHeap.remove(num);
                    } else {
                        num = minHeap.poll();
                        maxHeap.remove(num);
                    }
                }
            }
        }

        if (minHeap.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{maxHeap.peek(), minHeap.peek()};
    }

    public static void main(String[] args) {
        DualPriorityQueue dq = new DualPriorityQueue();
        // 테스트 케이스 1
        String[] operations1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int[] result1 = dq.solution(operations1);
        System.out.println("Test Case 1: [" + result1[0] + ", " + result1[1] + "]");

        // 테스트 케이스 2
        String[] operations2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] result2 = dq.solution(operations2);
        System.out.println("Test Case 2: [" + result2[0] + ", " + result2[1] + "]");
    }
}
