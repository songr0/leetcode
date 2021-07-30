package main.sort;


/**
 * 冒泡排序
 * 比较类排序，每次正确地将一位大数放到数组最后
 * 平均复杂度n^2，最好n,最坏n^2
 * 空间复杂度1
 * 稳定排序
 * 优化：利用flag判断是否已经有序，是的话直接退出，不再进行后面的排序
 * @author Song Rui
 */
public class BubbleSort {
    void sort(int[] nums){
        if(nums.length == 0 || nums.length == 1){
            return;
        }
        int n = nums.length;
        boolean flag;
        // i是排序的轮数
        // j是每轮排序需要比较的次数
        for(int i = 0;i< n-1;++i){
            flag = false;
            for(int j = 0;j< n-i-1;++j){
                if(nums[j+1]> nums[j]){
                    swap(nums, j+1, j);
                    flag = true;
                }
            }
            if(!flag){
                return;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
