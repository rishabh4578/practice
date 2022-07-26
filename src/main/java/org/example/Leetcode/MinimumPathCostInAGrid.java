package org.example.Leetcode;

/**
 * https://leetcode.com/problems/minimum-path-cost-in-a-grid/submissions/
 */
public class MinimumPathCostInAGrid {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = Integer.MAX_VALUE;
        //reusing the grid array as dp array
        for(int r = m - 2; r >= 0; r--){
            for(int c = 0; c < n; c++){
                int min = Integer.MAX_VALUE;
                for(int col = 0; col < n; col++)
                    min = Math.min(grid[r + 1][col] + grid[r][c] + moveCost[grid[r][c]][col], min);
                grid[r][c] = min;

                if(r == 0)
                    ans = Math.min(min, ans);
            }
        }

        return ans;
    }
}
