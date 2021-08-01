package main.sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 快速排序，每次选中一个基准值进行分治排序
 * 比较类排序，分区操作：每次排序选出一个关键字，将数组分成独立的两个部分，其中一部分都比关键字小，另一部分都比关键字大
 * 平均时间复杂度nlog2n，最坏n^2，最好nlog2n
 * 空间复杂度nlog2n
 * 不稳定
 * @author Song Rui
 */
public class QuickSort {

    void sort(int[] nums){
        if(nums.length == 0 || nums.length == 1){
            return;
        }
        quickSort(nums, 0 , nums.length-1);
    }

    private void quickSort(int[] nums, int begin, int end) {
        if(end<= begin){
            return;
        }
        int i = begin;
        int j = end;
        int key = nums[i];
        while(i< j){
            while(nums[j]>= key && j>i){
                j--;
            }
            if(i< j){
                nums[i] = nums[j];
                i++;
            }
            while(nums[i] <= key && i< j){
                i++;
            }
            if(i< j){
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = key;
        quickSort(nums, begin, i-1);
        quickSort(nums, i+1, end);
    }


}
