package io.conduktor.demos.dfsbfs.hanghaecote99.middler;

import java.util.Arrays;

// 3. 프로그래머스 : 입국심사 - 이분탐색
public class Immigration3 {

    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        long right = times[times.length-1] * (long)n;
        int interviewer = times.length;

        while(left <= right) {
            long mid = (left + right) / 2;
            long complete = 0;
            for (int i = 0; i < times.length; i++) {
                complete += mid / times[i];
            }
            if (complete < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Immigration3 T = new Immigration3();
        System.out.println(T.solution(6, new int[] {7, 10}));
    }
}
