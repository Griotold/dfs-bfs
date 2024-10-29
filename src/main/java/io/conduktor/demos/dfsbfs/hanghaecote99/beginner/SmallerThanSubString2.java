package io.conduktor.demos.dfsbfs.hanghaecote99.beginner;

// 2. 프로그래머스 : 크기가 작은 부분문자열
public class SmallerThanSubString2 {

    public int solution(String t, String p) {
        int length = t.length() - p.length() + 1;
        long pNum = Long.parseLong(p);
        int answer = 0;

        for (int i = 0; i < length; i++) {
            String temp = t.substring(i, i + p.length());

            if (Long.parseLong(temp) <= pNum) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        SmallerThanSubString2 s = new SmallerThanSubString2();
        System.out.println(s.solution("3141592", "271"));
        System.out.println(s.solution("500220839878", "7"));
        System.out.println(s.solution("10203", "15"));
    }
}
