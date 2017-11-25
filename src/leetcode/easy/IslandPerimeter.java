package leetcode.easy;

/**
 * Created by Vamsi on 5/1/2017.
 */
public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] arr = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        int[][] arr2 = {{1,0}};
        IslandPerimeter x = new IslandPerimeter();
        System.out.println(Math.sqrt(Integer.MAX_VALUE));

    }
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int width = grid[0].length, height = grid.length;
        System.out.println(width +" "+ height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(grid[i][j] == 1){
                    //left
                    if((j == 0) || grid[i][j-1] == 0)
                        perimeter++;

                    //right
                    if(j == width - 1 || grid[i][j+1] == 0)
                        perimeter++;

                    //top
                    if(i == 0 || grid[i-1][j] == 0)
                        perimeter++;

                    //bottom
                    if(i == height - 1 || grid[i+1][j] == 0)
                        perimeter++;
                }
            }
        }
        return perimeter;
    }

    //Each neighbour island(1) removes 2 from the perimeter, one from each island.(picked from solutions)
    public int islandPerimeter2(int[][] grid) {
        int perimeter = 0, islands = 0, neighbour = 0;
        int width = grid[0].length, height = grid.length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(grid[i][j] == 1){
                    islands ++;

                    //right
                    if(j < width - 1 && grid[i][j+1] == 1)
                        neighbour++;

                    //bottom
                    if(i < height - 1 && grid[i+1][j] == 1)
                        neighbour++;
                }
            }
        }
        return islands * 4 - neighbour * 2;
    }
}
