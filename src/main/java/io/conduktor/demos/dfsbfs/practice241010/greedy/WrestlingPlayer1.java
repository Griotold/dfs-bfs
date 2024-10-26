package io.conduktor.demos.dfsbfs.practice241010.greedy;

import java.util.*;

// 1. 씨름 선수
public class WrestlingPlayer1 {

    static int N;
    static List<Player> players;

    static class Player implements Comparable<Player> {
        private int height;
        private int weight;

        // 키순으로 정렬되도록 구현
        @Override
        public int compareTo(Player other) {
            return Integer.compare(this.height, other.height);
        }

        public Player(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        public int getHeight() {
            return height;
        }

        public int getWeight() {
            return weight;
        }
    }

    private static int calculatePickingCount() {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for (Player player : players) {
            if (player.getWeight() > max) {
                max = player.getWeight();
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        players = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Player player = new Player(sc.nextInt(), sc.nextInt());
            players.add(player);
        }
        // 키순으로 내림차순 정렬
        Collections.sort(players, Comparator.reverseOrder());  // Collections.sort 사용
        System.out.println(calculatePickingCount());
    }
}
