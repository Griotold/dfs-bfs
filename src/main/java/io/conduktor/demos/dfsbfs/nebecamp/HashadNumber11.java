package io.conduktor.demos.dfsbfs.nebecamp;
/**
 * 자바 심화 2기
 * 11. 하샤드 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/12947
 * */
public class HashadNumber11 {

    public boolean solution(int x) {
        int sum = 0;
        int temp = x;
        while(temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return x % sum == 0 ? true : false;
    }

    public static void main(String[] args) {
        HashadNumber11 h = new HashadNumber11();
        System.out.println(h.solution(10));
        System.out.println(h.solution(12));
        System.out.println(h.solution(11));
        System.out.println(h.solution(13));
    }
}
