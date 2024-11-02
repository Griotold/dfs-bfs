package io.conduktor.demos.dfsbfs.hanghaecote99.middler;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 6. 나무 자르기 - 백준 : 2805 - 이분탐색
public class CuttingTree6 {

    static int N;
    static int M;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int left = 0;
        int right = 1_000_000_000;

        while (left <= right) {
            int mid = (left + right) / 2;
            long cuttingTreesLength = 0;
            for (int currentTree : trees) {
                if (currentTree > mid) {
                cuttingTreesLength += currentTree - mid;
                }
            }
            if (cuttingTreesLength >= M) {
                result = mid;
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
