package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Song Rui
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0){
            return 0;
        }
        int len = heights.length;
        int maxV = 0;
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>(len);
        stack.push(heights[0]);
        list.add(1);
        int width;
        for(int i = 1;i< len;++i){
            width=1;
            while(!stack.isEmpty() && heights[i]<stack.peek()){
                width++;
                maxV = Math.max(maxV, stack.peek()*list.get(list.size()-1));
                stack.pop();
                list.remove(list.size()-1);
            }
            stack.push(heights[i]);
            for(int j = 0;j< list.size();++j){
                list.set(j, list.get(j)+1);
            }
            list.add(width);
        }
        while(!stack.isEmpty()){
            maxV = Math.max(maxV, stack.peek()*list.get(list.size()-1));
            stack.pop();
            list.remove(list.size()-1);
        }
        return maxV;
    }


    public static void main(String[] args) {
        int max = new LargestRectangleArea().largestRectangleArea(new int[]{2,1,5,6,2,3,9,8,9,2});
        System.out.println(max);
    }
}
