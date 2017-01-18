package crackingTheCodingInterview;

public class MatrixRotation {
    public void rotate(int[][] matrix, int n) {

        //there are n/2 layers from inside to outside.
        for (int layerStart = 0; layerStart < n / 2; layerStart++) {
            int layerEnd = n - 1 - layerStart;

            for (int j = layerStart; j < layerEnd; j++) {
                int offset = j - layerStart;

                int top = matrix[layerStart][j];

                //keeping either row or column constant
                //left row -> top row
                matrix[layerStart][j] = matrix[layerEnd - offset][layerStart];

                //bottom row -> left
                matrix[layerEnd - offset][layerStart] = matrix[layerEnd][layerEnd - offset];

                //right -> bottom row
                matrix[layerEnd][layerEnd - offset] = matrix[j][layerEnd];

                //top -> right row
                matrix[j][layerEnd] = top;
            }
        }
    }
}
