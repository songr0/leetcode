package main.sort;

/**
 * 希尔排序
 * 插入排序，是简单插入排序的改进版本，会优先比较距离较远的元素，又叫缩小增量排序
 * 每次选择一个增量t1,t2,...,tk，其中，最后一次增量tk=1
 * 每次根据增量分割子序列，分别对子序列进行直接插入排序
 * 时间复杂度平均n^1.3，最坏n^2，最好n
 * @author Song Rui
 */
public class ShellSort {

    void sort(int[] nums){
        if(nums.length == 0 || nums.length == 1){
            return;
        }
        int n = nums.length;
        int div = 2;
        int minIndex;
        int j;
        for(int gap = Math.floorDiv(n,div);gap>0; gap = Math.floorDiv(gap, div)){
            for(int i = gap;i< n;++i){
                minIndex = i;
                for(j = i-gap; j>=0; j-= gap){
                    if(nums[j] < nums[minIndex]){
                        minIndex = j;
                    }
                }
                swap(nums, minIndex, j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
