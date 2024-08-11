package io.conduktor.demos.dfsbfs.kim.section8;

import java.util.Scanner;

/**
 * 동전 교환
 * */
public class ExchangeCoin {
    static int n, m;
    static int answer = Integer.MAX_VALUE;
    static int[] coins;

    private void DFS(int sum, int count) {
        if (sum > m) return;
        if (sum == m) {
            answer = Math.min(answer, count);
        } else {
            for (int i = 0; i < n; i++) {
                DFS(sum + coins[i], count + 1);
            }
        }
    }

    public static void main(String[] args) {
        ExchangeCoin T = new ExchangeCoin();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = kb.nextInt();
        }
        m = kb.nextInt();
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
