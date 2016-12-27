package hr.DynamicProgramming;

public class EditDistance {
    public static void main(String[] args) {
        EditDistance x = new EditDistance();
        System.out.println(x.editDistance("sunday", "saturday"));
    }

    /*
      The bottom-up array
      [0     1,      2,     3     ]
      [1,    .       .      .     ]
      [2,    .       .      .     ]
      [3,    .       .      .     ]

    * */
    public int editDistance(String str1, String str2){
        //Convert str1 to str2
        int len1 = str1.length();
        int len2 = str2.length();

        //Create a 2-d array of len1+1 by len2+1 for storing the editDistances of subproblems
        int[][] editDistances = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                //Set the 0th row to defaults for empty target string
                if(i==0)
                    editDistances[i][j] = j;

                //Set the 0th column for empty source string
                else if(j==0)
                    editDistances[i][j] = i;

                //For all others
                else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    editDistances[i][j] = editDistances[i-1][j-1];
                }else {
                    int[] subproblems = {editDistances[i][j-1], editDistances[i-1][j], editDistances[i-1][j-1]};
                    editDistances[i][j] = 1 + min(subproblems);
                }
            }
        }

        return editDistances[len1][len2];
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
