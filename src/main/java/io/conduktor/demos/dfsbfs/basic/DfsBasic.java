package io.conduktor.demos.dfsbfs.basic;

public class DfsBasic {

    public void DFS(int n) {
        if (n==0) return;
        else {
            DFS(n-1);
            System.out.println(n + " ");
        }
    }

    public static void main(String[] args) {
        DfsBasic T = new DfsBasic();
        T.DFS(3);
    }
}
