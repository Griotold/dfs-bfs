package io.conduktor.demos.dfsbfs.basic;
/**
 * 재귀함수를 이용한 이진수 출력
 * */
public class BinaryPrinter {

    public void DFS(int n) {
        if(n == 0) return;
        else {
            DFS(n/2);
            System.out.print(n%2);
        }
    }

    public static void main(String[] args) {
        BinaryPrinter T = new BinaryPrinter();
        T.DFS(11);
        System.out.println("===");
        T.DFS(38);
    }
}
