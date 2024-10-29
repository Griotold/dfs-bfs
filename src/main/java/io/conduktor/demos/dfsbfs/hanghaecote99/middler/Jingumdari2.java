package io.conduktor.demos.dfsbfs.hanghaecote99.middler;

import java.io.*;

// 2. 징검다리 - 백준 : 11561 징검다리
public class Jingumdari2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            long n = Long.parseLong(br.readLine());
            long left = 0;
            long right = (long) 1e9; // 10억

            long result = 0;

            while (left <= right) {
                long mid = (left + right) / 2;
                long sum = (mid * (mid + 1)) / 2; // 등차수열의 합

                if (sum <= n) {
                    result = Math.max(mid, result);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
