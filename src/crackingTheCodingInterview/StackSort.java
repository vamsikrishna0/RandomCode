package crackingTheCodingInterview;

import java.util.Stack;

/**
 * Created by Vamsi on 1/11/2017.
 */
public class StackSort{
    Stack<Integer> s1;
    Stack<Integer> s2;

    public StackSort(){
        s2 = new Stack<>();
    }

    Stack<Integer> sort(Stack<Integer> stack){
        s1 = stack;
        //First element
        s2.push(s1.pop());

        while(!s1.isEmpty()){
            int element = s1.pop();
            int count =0;
            while(s2.peek() > element && !s2.isEmpty()){
                count++;
                s1.push(s2.pop());
            }

            s2.push(element);
            while(count > 0){
                count--;
                s2.push(s1.pop());
            }
        }
        return s2;
    }
}
