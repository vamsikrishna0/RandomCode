package leetcode.easy;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oc = image[sr][sc];
        if (oc == newColor) return image;
        floodFillRec(image, sr, sc, oc, newColor);
        return image;
    }

    private void floodFillRec(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor) return;
        image[sr][sc] = newColor;
        floodFillRec(image,sr-1, sc, oldColor, newColor);
        floodFillRec(image, sr, sc-1, oldColor, newColor);
        floodFillRec(image,sr+1, sc, oldColor, newColor);
        floodFillRec(image, sr, sc+1, oldColor, newColor);
    }

/*
//Old Solution. Extra space used(the boolean[][]). Can be done with few extra recursive calls. Still same runtime.
public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oc = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        floodFillRec(image, visited, sr, sc, oc, newColor);
        return image;
    }

    private void floodFillRec(int[][] image, boolean[][] visited,int sr, int sc, int oldColor, int newColor) {
        visited[sr][sc] = true;
        image[sr][sc] = newColor;
        if(sr > 0 && !visited[sr-1][sc] && image[sr-1][sc] == oldColor) {
            floodFillRec(image, visited, sr-1, sc, oldColor, newColor);
        }
        if(sc > 0 && !visited[sr][sc-1] && image[sr][sc-1] == oldColor) {
            floodFillRec(image, visited, sr, sc-1, oldColor, newColor);
        }
        if(sr < image.length - 1 && !visited[sr+1][sc] && image[sr+1][sc] == oldColor) {
            floodFillRec(image, visited, sr+1, sc, oldColor, newColor);
        }
        if(sc < image[0].length - 1 && !visited[sr][sc+1] && image[sr][sc+1] == oldColor) {
            floodFillRec(image, visited, sr, sc+1, oldColor, newColor);
        }
    }
* */
}
