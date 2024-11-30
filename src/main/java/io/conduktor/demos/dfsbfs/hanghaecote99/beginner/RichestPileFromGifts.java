package io.conduktor.demos.dfsbfs.hanghaecote99.beginner;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 241118 월 - Take Gifts From the Richest Pile - leetcode 2558
 * https://leetcode.com/problems/take-gifts-from-the-richest-pile/
 * 우선순위 큐
 */
public class RichestPileFromGifts {

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : gifts) {
            pq.add(x);
        }
        while (k-- > 0) {
            int maximum = pq.poll();
            pq.add((int) Math.sqrt(maximum));
        }
        return pq.stream().mapToLong(Integer::longValue).sum();
    }

    public static void main(String[] args) {
        RichestPileFromGifts p = new RichestPileFromGifts();
        System.out.println(p.pickGifts(new int[] {25, 64, 9, 4, 100}, 4));
        System.out.println(p.pickGifts(new int[] {1, 1, 1, 1}, 4));
    }
}
