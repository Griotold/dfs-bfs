package io.conduktor.demos.dfsbfs.kim.section8;

import javax.lang.model.SourceVersion;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * 합이 같은 부분집합
 * */
public class SameSumSubSet {
    static String answer = "NO";
    static int n;
    static int total = 0;
    static boolean flag = false;

    public void DFS(int L, int sum, int[] arr) {
        if (flag) return;
        if (L == n) {
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        }
        else {
            DFS(L + 1, sum+arr[L], arr);
            DFS(L + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        SameSumSubSet T = new SameSumSubSet();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }

}
