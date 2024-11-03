package io.conduktor.demos.dfsbfs.hanghaecote99.middler;

import java.util.ArrayList;
import java.util.List;

// 7. 프로그래머스 - 모음 사전 - 그래프 이론
public class VowelsDictionary7 {
    static List<String> list;
    static String[] vowels = {"A", "E", "I", "O", "U"};

    void dfs(String str, int len) {
        list.add(str);
        if (len == 5) return;
        for (int i = 0; i < 5; i++) {
            dfs(str + vowels[i], len + 1);
        }
    }

    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        dfs("", 0);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        VowelsDictionary7 dictionary = new VowelsDictionary7();
        System.out.println(dictionary.solution("A")); // 1
        System.out.println(dictionary.solution("AAAAE")); // 6
        System.out.println(dictionary.solution("AAAE")); // 10
        System.out.println(dictionary.solution("I")); // 1563
        System.out.println(dictionary.solution("EIO")); // 1189
    }
}
