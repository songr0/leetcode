package main.sort;

/**
 * 快速排序
 * 比较类排序，采用分治法，每次对子序进行排序，将排好序的子序合并，得到完全有序的序列 —— 2路归并
 * 平均时间复杂度，最坏，最好
 * @author Song Rui
 */
public class QuickSort {

    void sort(int[] nums){
        if(nums.length == 0 || nums.length == 1){
            return;
        }
        quickSort(nums, 0 , nums.length-1);
    }

    private void quickSort(int[] nums, int i, int j) {

    }


}
