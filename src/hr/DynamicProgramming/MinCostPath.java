package hr.DynamicProgramming;

/**
 * Created by Vamsi on 12/27/2016.
 */
public class MinCostPath {
    public static void main(String[] args) {
        MinCostPath x = new MinCostPath();
        int[][] cost = { {1, 2, 3},
            {4, 8, 2},
            {1, 5, 3} };
        System.out.println(x.minCostPath(cost));
    }
    /*
      The bottom-up array
      [0        INT_MAX, INT_MAX, INT_MAX]
      [INT_MAX,     .       .      .     ]
      [INT_MAX,     .       .      .     ]
      [INT_MAX,     .       .      .     ]

    * */
    public int minCostPath(int[][] cost){
        //.length on a 2d array gives no of rows
        int rows = cost.length;
        int cols = cost[0].length;

        int[][] minCost = new int[rows+1][cols+1];
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                if(i==0 && j==0)
                    minCost[i][j] = 0;
                else if(i==0 || j==0)
                    minCost[i][j] = Integer.MAX_VALUE;
                else{
                    int[] subproblems = {minCost[i-1][j], minCost[i][j-1], minCost[i-1][j-1]};
                    minCost[i][j] = cost[i-1][j-1] + min(subproblems);
                }
                System.out.println(i+" "+j+" : "+minCost[i][j]);
            }
        }
        return minCost[rows][cols];
    }

    //Helper for min of an array of ints
    public int min(int[] values){
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < values.length; i++) {
            if(temp > values[i])
                temp = values[i];
        }
        return temp;
    }

}
