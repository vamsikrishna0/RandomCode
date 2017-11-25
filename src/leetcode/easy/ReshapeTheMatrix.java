package leetcode.easy;

/**
 * Created by Vamsi on 5/21/2017.
 */
public class ReshapeTheMatrix {
    public static void main(String[] args) {
        ReshapeTheMatrix x = new ReshapeTheMatrix();
        int[][] w = {{1,2}, {3, 4}};
        int[][] res = x.matrixReshape(w, 2, 4);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] +" ");
            }
            System.out.println();
        }
    }
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length;
        int cols = nums[0].length;
        if(rows * cols == r * c){
            int[][] res = new int[r][c];
            int resr = 0, resc = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    res[resr][resc] = nums[i][j];
                    if(resc == c -1){
                        resc = 0;
                        resr++;
                    }else{
                        resc++;
                    }
                }
            }
            return res;
        }else return nums;
    }
}
