package crackingTheCodingInterview;

import java.util.Stack;

/**
 * Created by Vamsi on 1/10/2017.
 */

public class StackAndMin extends Stack<Integer> {
    Stack<Integer> minStack;

    public StackAndMin() {
        minStack = new Stack<>();
    }

    public void push(int data) {
        if (data < min()) {
            minStack.push(data);
        }
        super.push(data);
    }

    public Integer pop() {
        int data = super.pop();
        if (data == min()) {
            minStack.pop();
        }
        return data;
    }

    public int min() {
        return minStack.peek();
    }
}