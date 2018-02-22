package leetcode.graphsAndTrees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Vamsi on 1/16/2017.
 */
public class PacificAtlanticWaterFlow417 {
    public static void main(String[] args) {
        PacificAtlanticWaterFlow417 x = new PacificAtlanticWaterFlow417();
        int[][] arr = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
//        for (int[] a: x.pacificAtlantic(arr)) {
//            System.out.println(a[0] +" "+ a[1]);
//        }
        int value=0;
        for (char c : "123".toCharArray() ) {
            value += c-'0';
            System.out.println(value);
        }
    }

    boolean[][] resPac;
    boolean[][] resAtl;
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        if(matrix == null || matrix.length==0|| matrix[0].length==0)
            return result;
        int m = matrix.length, n = matrix[0].length;

        resPac = new boolean[m][n];
        resAtl = new boolean[m][n];
        //For both oceans run through start columns ocean
        for(int col = 0; col < n ; col++){
            findReachable(0, col, matrix, resPac, Integer.MIN_VALUE);

            findReachable(m-1, col, matrix, resAtl, Integer.MIN_VALUE);
        }
        for(int row = 0; row < m ; row++){
            findReachable(row, 0, matrix, resPac, Integer.MIN_VALUE);

            findReachable(row, n-1, matrix, resAtl, Integer.MIN_VALUE);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(resPac[i][j] && resAtl[i][j]){
                    int[] arr = new int[2];
                    arr[0] = i;
                    arr[1] = j;
                    result.add(arr);
                }
            }
        }
        return result;
    }
    //check if the node is part of path? yes then adds it and recurse,
    private void findReachable(int x, int y, int[][] matrix, boolean[][] res, int height){
        int m = matrix.length, n = matrix[0].length;
        if(x < 0 || y >= n || x >= m || y < 0 || res[x][y] || matrix[x][y] < height)
            return;

        res[x][y] = true;
        for(int[] arr: neighbours){
            findReachable(x+arr[0], y+arr[1], matrix, res, matrix[x][y]);
        }
    }

    private int[][] neighbours = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
}
