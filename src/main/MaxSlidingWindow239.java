package main;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Song Rui
 * 单调队列
 */
public class MaxSlidingWindow239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 1 || k==1){
            return nums;
        }
        int len = nums.length;
        Deque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[len-k+1];
        for(int i =0;i< k;++i){
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            queue.addLast(i);
        }
        res[0] = nums[queue.peekFirst()];
        for(int i =k;i< len;++i){
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            while(!queue.isEmpty() && queue.peekFirst() < i-k+1){
                queue.pollFirst();
            }
            res[i-k+1] = nums[queue.peekFirst()];
        }
        return res;
    }
}
