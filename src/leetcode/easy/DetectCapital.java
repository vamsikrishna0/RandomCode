package leetcode.easy;

/**
 * Created by Vamsi on 5/24/2017.
 */
public class DetectCapital {
    /*Idea:
    1.Use regex pattern matching
    2.Count the number of capitals in the word and then check for each condition.
    */

    //.matches is a regex comparision method on String
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
//        return word.equals(word.toUpperCase()) ||
//                word.equals(word.toLowerCase()) ||
//                Character.isUpperCase(word.charAt(0)) &&
//                        word.substring(1).equals(word.substring(1).toLowerCase());
    }

}
