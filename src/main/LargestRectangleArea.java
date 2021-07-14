package main;

import java.util.*;

/**
 * @author Song Rui
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0){
            return 0;
        }
        int len = heights.length;
        int[] newHeights = new int[len+2];
        newHeights[0] = 0;
        System.arraycopy(heights,0, newHeights, 1, len);
        newHeights[len+1] = 0;
        int maxSum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0;i< len+2;++i){
            while(! stack.isEmpty() && newHeights[stack.peekFirst()] > newHeights[i]){
                int height = newHeights[stack.removeFirst()];
                maxSum= Math.max(maxSum, height*(i-stack.peekFirst()-1));
            }
            stack.addFirst(i);
        }
        return maxSum;
    }


    public static void main(String[] args) {
        int max = new LargestRectangleArea().largestRectangleArea(new int[]{2,1,5,6,2,3,9,8,9,2});
        System.out.println(max);
    }
}
