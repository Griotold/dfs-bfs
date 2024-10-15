package io.conduktor.demos.dfsbfs.practice241010.basic;
// 부분집합 구하기(DFS)
public class SubSet6 {
    static int[] ch;
    static int N;
    void dfs(int L) {
        if (L == N + 1) {
            for (int i = 1; i <= N; i++) {
                if (ch[i] != 0) System.out.print(i + " ");
            }
            System.out.println();
        }
        else {
            ch[L] = 1;
            dfs(L + 1);
            ch[L] = 0;
            dfs(L + 1);
        }
    }

    public static void main(String[] args) {
        SubSet6 T = new SubSet6();
        N = 3;
        ch = new int[N + 1];
        T.dfs(1);
    }
}
