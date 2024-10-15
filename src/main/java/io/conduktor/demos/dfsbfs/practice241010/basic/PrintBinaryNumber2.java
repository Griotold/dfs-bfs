package io.conduktor.demos.dfsbfs.practice241010.basic;

import java.util.Scanner;

// 2. 이진수 출력(재귀)
public class PrintBinaryNumber2 {

    public void DFS(int n) {
        if (n == 1) {
            System.out.print(1 + " ");
        } else {
            DFS(n / 2);
            int binaryNumber = n % 2;
            System.out.print(binaryNumber + " ");
        }
    }

    public static void main(String[] args) {
        PrintBinaryNumber2 T = new PrintBinaryNumber2();
        Scanner scanner = new Scanner(System.in);
        T.DFS(Integer.parseInt(scanner.nextLine()));
    }
}
