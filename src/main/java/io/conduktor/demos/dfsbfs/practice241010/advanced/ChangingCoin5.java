package io.conduktor.demos.dfsbfs.practice241010.advanced;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 5. 동전 교환
public class ChangingCoin5 {

    static int N;
    static int M;
    static int answer;
    static Integer[] coins;

    void dfs(int count, int sum) {
        if (sum > M) return;
        if (sum == M) {
            answer = Math.min(answer, count);
        } else {
            for (int i = 0; i < N; i++) {
                dfs(count + 1, sum + coins[i]);
            }
        }
    }

    public static void main(String[] args) {
        ChangingCoin5 T = new ChangingCoin5();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        coins = new Integer[N];
        for(int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins, Collections.reverseOrder());
        M = sc.nextInt();
        answer = Integer.MAX_VALUE;
        T.dfs(0, 0);
        System.out.println(answer);
    }
}
