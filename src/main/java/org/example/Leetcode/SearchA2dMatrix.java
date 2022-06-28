package org.example.Leetcode;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/submissions/
 */
public class SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;

        int m = matrix.length;
        int n = matrix[0].length;

        if(m == 0 || n == 0) return false;

        if(target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;

        //find row
        int row;
        if(target >= matrix[m - 1][0])
            row = m - 1;
        else {
            row = findRow(matrix, 0, m - 1, target);
        }
        System.out.println("row: " + row);

        return findElement(matrix[row], 0, n - 1, target);
    }

    private boolean findElement(int[] row, int l, int r, int target){
        if(l > r) return false;

        int mid = (l + r)/2;

        if(row[mid] == target) return true;

        if(target < row[mid])
            return findElement(row, l, mid - 1, target);
        else
            return findElement(row, mid + 1, r, target);
    }

    private int findRow(int[][] matrix, int t, int b, int target){
        if(t == b) return t;
        else if(t == b - 1){
            if(target >= matrix[b][0]) return b;
            else return t;
        }

        int mid = (t + b) / 2;

        if(target == matrix[mid][0]) return mid;
        if(target < matrix[mid][0]){
            return findRow(matrix, t, mid - 1, target);
        } else {
            return findRow(matrix, mid, b, target);
        }
    }
}
