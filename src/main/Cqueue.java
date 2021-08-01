package main;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 基本思想：负负得正
 * @author Song Rui
 */
public class Cqueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public Cqueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(! stack2.isEmpty()){
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty()? -1 : stack2.pop();
        }
    }
}
