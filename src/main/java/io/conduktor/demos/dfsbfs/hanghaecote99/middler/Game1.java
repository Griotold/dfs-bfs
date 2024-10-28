package io.conduktor.demos.dfsbfs.hanghaecote99.middler;

import java.util.Scanner;

// 백준 1072번 게임
public class Game1 {

    static int N;
    static int M;

    static int calculateWinningPercent(int x, int y) {
        return (int) ((long) y * 100 / x);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int currentPercent = calculateWinningPercent(N, M);

        int answer = -1;
        int left = 0;
        int right = (int) 1e9;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (calculateWinningPercent(N + mid, M + mid) != currentPercent) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);

    }
}
