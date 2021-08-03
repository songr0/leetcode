package main;

import java.util.*;

/**
 * 单调栈
 * @author Song Rui
 */
public class MaxNumber321 {

    /**
     * nums1 = [3, 4, 6, 5]
     * nums2 = [9, 1, 2, 5, 8, 3]
     * k = 5
     * 输出: [9, 8, 6, 5, 3]
    */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if((nums1.length == 0 && nums2.length==0) || k==0){
            return new int[0];
        }
        int m = nums1.length;
        int n = nums2.length;
        int[] ns;
        int[] res = new int[k];
        // k-i<=n, i<m ,i<k, i>0
        for(int i = Math.max(0, k-n);i< Math.min(k,m); ++i){
            ns = merge(getMaxNums(nums1, i), getMaxNums(nums2, k-i));
            if(compare(ns, res) > 0){
                System.arraycopy(ns, 0, res, 0, k);
            }
        }
        return res;
    }

    private int compare(int[] ns, int[] res) {
        int l = ns.length;
        if(l != res.length){
            return l > res.length ? 1 : 0;
        }
        int i = 0;
        while(i<l && ns[i] == res[i]){
            i++;
        }
        if(i == l){
            return 0;
        }
        return ns[i] - res[i];
    }

    private int[] merge(int[] maxNums, int[] maxNums1) {
        int i = 0;
        int j = 0;
        int m = maxNums.length;
        int n = maxNums1.length;
        int[] res = new int[m+n];
        int k = 0;
        while(i< m && j< n){
            res[k++] = maxNums[i] >= maxNums1[j] ? maxNums[i++] : maxNums1[j++];
        }
        while(i<m){
            res[k++] = maxNums[i++];
        }
        while (j<n){
            res[k++] = maxNums1[j++];
        }
        return res;
    }

    /**
     * 获得长度为k的最大子序列
     */
    private int[] getMaxNums(int[] nums, int k) {
        if(k==0){
            return new int[0];
        }
        if(k == nums.length){
            return nums;
        }
        int len = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int count=0;
        for(int i = 0;i< len;++i){
            while(! stack.isEmpty() && stack.peekLast()< nums[i] && len-i>=k-count && count<=k){
                stack.pollLast();
                count--;
            }
            stack.addLast(nums[i]);
            count++;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while(! stack.isEmpty() && i< count){
            res[i++] = stack.pollFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new MaxNumber321().maxNumber(new int[]{3, 4, 6, 5},
                new int[]{9, 1, 2, 5, 8, 3}, 5);
        System.out.println(res.toString());
    }

}
