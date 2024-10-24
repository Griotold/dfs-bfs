package io.conduktor.demos.dfsbfs.practice241010.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 15. 피자 배달 거리(삼성 SW역량평가 기출문제 : DFS활용)
public class DeliveringPizza15 {

    static int N;
    static int M;
    static int pizzaStoreCount;
    static int answer;
    static int[] combi;
    static int[][] map;
    static List<Point> houses;
    static List<Point> pizzaStore;

    // 집의 피자 배달 거리
    static int calculateHomeDistance(Point house) {
        int homeDeliveryDistance = Integer.MAX_VALUE;
        for (int i : combi) {
            homeDeliveryDistance = Math.min(homeDeliveryDistance,
                    Math.abs(house.getX() - pizzaStore.get(i).getX())
                    + Math.abs(house.getY() - pizzaStore.get(i).getY()));
        }
        return homeDeliveryDistance;
    }

    // 도시의 피자 배달거리 = 각 집의 피자 배달 거리
    static int calculateCityDistance() {
        int cityDeliveryDistance = 0;
        for (Point house : houses) {
            cityDeliveryDistance += calculateHomeDistance(house);
        }
        return cityDeliveryDistance;
    }

    // 조합
    static void populateCombi(int level, int start) {
        if (level == M) {
            // 도시의 피자 배달거리를 구해야 함
            answer = Math.min(calculateCityDistance(), answer);
        } else {
            for (int i = start; i < pizzaStoreCount; i++) {
                combi[level] = i;
                populateCombi(level + 1, i + 1);
            }
        }
    }

    static class Point {
        private int y;
        private int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        // 지도 초기화 - 원베이스
        map = new int[N + 1][N + 1];
        houses = new ArrayList<>();
        pizzaStore = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int temp = sc.nextInt();
                if (temp == 1) houses.add(new Point(i, j));
                else if (temp == 2) pizzaStore.add(new Point(i, j));
            }
        }
        answer = Integer.MAX_VALUE;
        combi = new int[M];
        pizzaStoreCount = pizzaStore.size();
        populateCombi(0, 0);
        System.out.println(answer);
    }
}
