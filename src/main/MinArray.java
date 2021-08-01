package main;

/**
 * 旋转数组的最小数字
 * @author Song Rui
 */
public class MinArray {
    public int minArray(int[] numbers){
        if(numbers.length == 0){
            return -1;
        }
        int n = numbers.length;
        int i = 1;
        while(i < n){
            if(numbers[i] < numbers[i-1]){
                return numbers[i];
            }
            i++;
        }
        return numbers[0];
    }
}
