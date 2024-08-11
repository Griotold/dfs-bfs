package io.conduktor.demos.dfsbfs.kim.section8;

import java.util.Scanner;

/**
 * 바둑이 승차 - DFS
 * */
public class BoardingDog {
    // 259 5
    //81
    //58
    //42
    //33
    //61
    static int c;
    static int n;
    static int max;
    static int[] dogs;
    static int[] ch;

    public void DFS(int L) {
        if (L == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (ch[i] != 0) {
                    sum += dogs[i];
                }
            }
            if (sum < c) {
                if (sum > max) {
                    max = sum;
                }
            }
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) {
        BoardingDog T = new BoardingDog();
        Scanner kb = new Scanner(System.in);
        c = kb.nextInt();
        n = kb.nextInt();
        max = Integer.MIN_VALUE;
        dogs = new int[n];
        ch = new int[n];
        for (int i = 0; i < n; i++) {
            dogs[i] = kb.nextInt();
        }
        T.DFS(0);
        System.out.println(max);
    }
}
