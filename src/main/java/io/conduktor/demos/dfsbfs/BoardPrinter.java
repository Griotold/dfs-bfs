package io.conduktor.demos.dfsbfs;

import java.util.Arrays;
import java.util.stream.Collectors;

// 입력 받은 2차원 배열을 확인하고 싶을 때
public class BoardPrinter {

    private BoardPrinter() {
    }

    public static void printBoard(int[][] board) {
        // Stream을 사용하여 이중 배열 출력
        Arrays.stream(board)
                .map(row -> Arrays.stream(row)
                        .mapToObj(String::valueOf) // int 값을 String으로 변환
                        .collect(Collectors.joining(" "))) // 각 행을 공백으로 연결
                .forEach(System.out::println); // 각 행을 출력
    }
}
