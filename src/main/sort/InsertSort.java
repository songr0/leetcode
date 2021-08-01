package main.sort;

/**
 * 插入排序
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 * @author Song Rui
 */
public class InsertSort {

    void insertSort(int[] nums){
        if(nums.length == 0 || nums.length == 1){
            return;
        }
        int n = nums.length;
        int min;
        for(int i = 0;i< n-1;++i){
            min = i;
            for(int j = i+1;j< n;++j){
                if(nums[j] < nums[min]){
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
