package io.conduktor.demos.dfsbfs.hanghaecote99.beginner;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Heap 자료구조 사용해보기
 * */
public class HeapExercise {

    public static void main(String[] args) {
        // 최소 힙 생성
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 최대 힙 생성
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // 요소 추가
        minHeap.offer(5);
        minHeap.offer(2);
        minHeap.offer(8);
        minHeap.offer(1);

        maxHeap.offer(5);
        maxHeap.offer(2);
        maxHeap.offer(8);
        maxHeap.offer(1);

        // 요소 출력
        System.out.println("최소 힙:");
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }

        System.out.println("\n최대 힙:");
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
    }

}
