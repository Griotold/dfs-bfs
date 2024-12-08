package io.conduktor.demos.dfsbfs.hanghaecote99.beginner;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 241031 목 보너스문제 - 의상입기 - 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 * 해쉬
 * */
public class FittingClothes {
    public int solution(String[][] clothes) {
        // 1. 옷을 종류 별로 구분한다.
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        // 2. 입지 않는 경우를 추가해서 모든 조합을 계산한다.
        int answer = 1;
        Iterator<Integer> it = map.values().iterator();
        while(it.hasNext())
            answer *= it.next().intValue() + 1;

        // 3. 아무 종류의 옷도 입지 않는 경우 제외한다.
        return answer - 1;
    }

    public static void main(String[] args) {
        FittingClothes sol = new FittingClothes();

        // 테스트 케이스 1
        String[][] clothes1 = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };

        // 테스트 케이스 2
        String[][] clothes2 = {
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
        };

        System.out.println("테스트 케이스 1 결과: " + sol.solution(clothes1)); // 5 출력
        System.out.println("테스트 케이스 2 결과: " + sol.solution(clothes2)); // 3 출력
    }
}
