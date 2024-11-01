package io.conduktor.demos.dfsbfs.hanghaecote99.middler;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 보너스 문제. 241031 - 예산 - 백준 : 2512
public class BudgetBonus1 {

    static int N;
    static int M;
    static int[] requestBudgets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        requestBudgets = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            requestBudgets[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());

        int maxBudget = Arrays.stream(requestBudgets).max().getAsInt();
        if (Arrays.stream(requestBudgets).sum() <= M) {
            bw.write(String.valueOf(maxBudget));
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        int left = 0;
        int right = maxBudget;

        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            long totalBudget = 0;
            for (int i = 0; i < N; i++) {
                totalBudget += Math.min(mid, requestBudgets[i]);
            }
            if (totalBudget <= M) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }
}
