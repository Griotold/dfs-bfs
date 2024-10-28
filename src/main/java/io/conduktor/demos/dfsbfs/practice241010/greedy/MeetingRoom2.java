package io.conduktor.demos.dfsbfs.practice241010.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 2. 회의실 배정
public class MeetingRoom2 {

    static int N;
    static List<Meeting> meetings;

    static class Meeting implements Comparable<Meeting> {
        private int start;
        private int end;

        // 끝나는 시간으로 우선 정렬하고
        // 시작시간으로 후순위 정렬
        @Override
        public int compareTo(Meeting other) {
            return (this.end == other.end) ? this.start - other.start : this.end - other.end;
        }

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        meetings = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            meetings.add(new Meeting(start, end));
        }
        Collections.sort(meetings);
        int answer = 0;
        int currentEnd = 0;
        for (Meeting meeting : meetings) {
            if (currentEnd <= meeting.getStart()) {
                currentEnd = meeting.getEnd();
                answer++;
            }
        }
        System.out.println(answer);
    }
}
