package leetcode;

import leetcode.helpers.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class TestSolution {
    public static void main(String[] args) {
        System.out.println();;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxCount = 0;
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                int p = maxAreaRec(grid, i, j, visited);
                if(p > maxCount) maxCount = p;
            }
        }
        return maxCount;
    }
    private int maxAreaRec(int[][] grid, int r, int c, boolean[][] visited){
        if(r < 0 || r >= grid.length || c<0 || c>=grid[0].length || visited[r][c] || grid[r][c] == 0) return 0;
        visited[r][c] = true;
        int j = maxAreaRec(grid, r-1, c, visited);
        int k = maxAreaRec(grid, r+1, c, visited);
        int l = maxAreaRec(grid, r, c+1, visited);
        int m = maxAreaRec(grid, r, c-1, visited);
        return j+k+l+m+1;
    }


}