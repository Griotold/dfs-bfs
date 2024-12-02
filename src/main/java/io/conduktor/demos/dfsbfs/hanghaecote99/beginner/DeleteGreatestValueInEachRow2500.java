package io.conduktor.demos.dfsbfs.hanghaecote99.beginner;

import java.util.Arrays;

/**
 * 241119 화 - 각 줄에 가장 큰 수 삭제하기 - leetcode 2500
 * https://leetcode.com/problems/delete-greatest-value-in-each-row/description/
 * */
public class DeleteGreatestValueInEachRow2500 {

    public int deleteGreatestValue(int[][] grid) {
        // 각 행을 내림차순으로 정렬
        for (int[] row : grid) {
            Arrays.sort(row);
            reverse(row);
        }

        int result = 0;
        int m = grid.length;
        int n = grid[0].length;

        // 각 열에서 최대값을 찾아 결과에 더함
        for (int j = 0; j < n; j++) {
            int maxInColumn = 0;
            for (int i = 0; i < m; i++) {
                maxInColumn = Math.max(maxInColumn, grid[i][j]);
            }
            result += maxInColumn;
        }

        return result;
    }

    // 배열을 뒤집는 헬퍼 메소드
    private void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        DeleteGreatestValueInEachRow2500 d = new DeleteGreatestValueInEachRow2500();
        System.out.println(d.deleteGreatestValue(new int[][]{{1, 2, 4}, {3, 3, 1}}));
    }
}
