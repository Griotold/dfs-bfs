package io.conduktor.demos.dfsbfs.practice241010.basic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// 8. 송아지 찾기 1(BFS)
public class FindingCalf8 {
    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] ch;
    Deque<Integer> queue = new ArrayDeque<Integer>();

    int bfs(int s, int e) {
        ch = new int[10001]; // 체크 배열
        ch[s] = 1; // 체크 배열의 스타트 체크
        queue.offer(s); // 큐에 집어 넣기
        int level = 0; // 거리(레벨) 선언
        while (!queue.isEmpty()) {
            int length = queue.size(); // 큐에 사이즈 가져오기
            for (int i = 0; i < length; i++) { // 큐에 사이즈만큼 반복문
                int x = queue.poll(); // 큐에 있는 거 꺼내기
                if (x == e) return level; // 큐에 있는게 타겟이면 거리(레벨) 리턴
                for (int j = 0; j < 3; j++) { // 갈 수 있는 상황이 3개
                    int nx = x + dis[j];
                    if (nx >= 1 && nx <= 10_000 && ch[nx] == 0) { // 조건이 충족되면
                        ch[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        FindingCalf8 T = new FindingCalf8();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();
        System.out.println(T.bfs(s, e));
    }
}
