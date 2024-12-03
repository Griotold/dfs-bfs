package io.conduktor.demos.dfsbfs.hanghaecote99.beginner;
/**
 * 241030 수 - 숫자 문자열과 영단어 - 2021 카카오 인턴쉽
 * String 조작
 * */
public class NumberAndString {

    public int solution(String s) {
        String[] arr = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for(int i=0;i<arr.length;i++) {
            if(s.contains(arr[i])) {
                s = s.replace(arr[i], Integer.toString(i));
            }
        }
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        NumberAndString n = new NumberAndString();
        System.out.println(n.solution("one4seveneight")); // 1478
    }
}
