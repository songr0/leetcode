package main;

import java.util.ArrayDeque;
import java.util.Deque;

public class Trap {
    public int trap(int[] height) {
        if(height.length==0){
            return 0;
        }
        // 若出现更高（相同）的柱子，则分段（更高的柱子下标-前一个更低（相同）的柱子）
        Deque<Integer> stack = new ArrayDeque<>();
        int len = height.length;
        int curIndex;
        int maxSum = 0;
        int newStart=0;
        int left;
        while(height[newStart]==0){
            newStart++;
        }
        stack.addLast(newStart);
        for(int i = newStart+1;i< len;++i){
            while(! stack.isEmpty() && height[stack.peekLast()]< height[i]){
                curIndex = stack.pollLast();
                if(stack.isEmpty()){
                    break;
                }
                left = stack.peekLast();
                maxSum+= (i-left-1)*(Math.min(height[left], height[i])-height[curIndex]);
            }
            stack.addLast(i);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int maxSum = new Trap().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println("The result is : " + maxSum);
    }

}
