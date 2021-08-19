package main;

import java.util.Stack;

/**
 * @author Song Rui
 */
public class ValidateStackSequencesOffer31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length == 0 && popped.length == 0){
            return true;
        }
        if(pushed.length == 0 || popped.length == 0){
            return false;
        }
        int m = pushed.length;
        int n = popped.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int j = 0;j< m;++j) {
            stack.push(pushed[j]);
            while (!stack.isEmpty() && stack.peek().equals(popped[i])) {
                stack.pop();
                if(++i == n){
                    return true;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean res = new ValidateStackSequencesOffer31().validateStackSequences(new int[]{1,2,3,4,5},
                new int[]{4,5,3,2,1});
        System.out.println(res);
    }
}
