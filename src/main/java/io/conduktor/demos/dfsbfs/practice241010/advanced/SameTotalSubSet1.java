package io.conduktor.demos.dfsbfs.practice241010.advanced;

import java.util.Scanner;

// 1. 합이 같은 부분집합(DFS, 아마존 인터뷰)
public class SameTotalSubSet1 {

    static int N;
    static int total;
    static int[] arr;
    static boolean flag;

    void dfs(int level, int sum) {
        if (flag) return;
        if (sum>total/2) return;
        if (level == N) {
            if(total == sum * 2) flag = true;
        } else {
            dfs(level + 1, sum+arr[level]);
            dfs(level + 1, sum);
        }
    }

    public static void main(String[] args) {
        SameTotalSubSet1 T = new SameTotalSubSet1();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int a = sc.nextInt();
            arr[i] = a;
            total += a;
        }
        flag = false;
        T.dfs(0, 0);
        if (flag) System.out.println("YES");
        else System.out.println("NO");
    }
}
