package io.conduktor.demos.dfsbfs.kim.section8;

import java.util.Scanner;

/**
 * 순열 구하기
 * */
public class Permutation {
    // 3 2
    // 3 6 9
    static int n, m;
    static int[] numbers;
    static int[] ch;
    static int[] pm;

    private void DFS(int L) {
        if (L == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    pm[L] = numbers[i];
                    ch[i] = 1;
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Permutation T = new Permutation();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        numbers = new int[n];
        ch = new int[n];
        pm = new int[m];
        for (int i = 0 ; i < n; i++) {
            numbers[i] = kb.nextInt();
        }
        T.DFS(0);
    }
}
