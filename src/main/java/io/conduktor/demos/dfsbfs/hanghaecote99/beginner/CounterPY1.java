package io.conduktor.demos.dfsbfs.hanghaecote99.beginner;

// 프로그래머스 : 문자열 내 p와 y의 개수
public class CounterPY1 {

    boolean solution(String s) {
        boolean answer = true;

        String str = s.toLowerCase();
        System.out.println(str);

        int pCount = 0;
        int yCount = 0;
        for(char ch : str.toCharArray()) {
            if(ch == 'p') pCount++;
            if(ch == 'y') yCount++;
        }
        if(pCount != yCount) answer = false;

        return answer;
    }
}
