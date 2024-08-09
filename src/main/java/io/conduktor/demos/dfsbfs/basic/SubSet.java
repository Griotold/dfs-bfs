package io.conduktor.demos.dfsbfs.basic;

public class SubSet {
    static int[] ch;
    static int n;

    public void DFS(int L) {
        if (L == n + 1) {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) System.out.print(i + " ");
            }
            System.out.println();
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) {
        SubSet T = new SubSet();
        n = 3;
        ch = new int[n+1];
        T.DFS( 1 );
    }
}
