package io.conduktor.demos.dfsbfs.kim.section8;

import java.util.Scanner;

/**
 * 중복 순열 구하기
 * */
public class DuplicatePermutationPrinter {

    static int n, m;
    static int[] pm;

    private void DFS(int L) {
        if (L == m) {
            for (int el : pm) {
                System.out.print(el + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                pm[L] = i;
                DFS(L + 1);
            }
        }
    }

    public static void main(String[] args) {
        DuplicatePermutationPrinter T = new DuplicatePermutationPrinter();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        pm = new int[m];
        T.DFS(0);
    }
}
