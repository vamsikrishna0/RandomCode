package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Vamsi on 1/3/2017.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        HashMap<Character, Character> matches = new HashMap<>();
        matches.put('(', ')');
        matches.put('{', '}');
        matches.put('[', ']');
        Stack<Character> orderedOpenBraces = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(matches.containsKey(c)){
                orderedOpenBraces.push(c);
            }else{
                if(!orderedOpenBraces.isEmpty() && matches.get(orderedOpenBraces.peek()) == c){
                    orderedOpenBraces.pop();
                }else {
                    return false;
                }
            }
        }
        return orderedOpenBraces.isEmpty();
    }
}
