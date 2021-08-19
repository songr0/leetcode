package main;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值
 * @author Song Rui
 */
public class MedianFinderOffer41 {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    /**
     * 小顶堆存放较大的一半数据，堆顶是最小
     * 大顶堆存放较小的一半数据，堆顶是最大
     */
    public MedianFinderOffer41() {
        max = new PriorityQueue<>();
        min = new PriorityQueue<>((x, y) -> y-x);
    }

    public void addNum(int num) {
        if(max.size() != min.size()){
            max.add(num);
            min.add(max.poll());
        } else {
            min.add(num);
            max.add(min.poll());
        }
    }

    /**
     * 可能会被调用多次，不能使用poll
     * @return 中位数
     */
    public double findMedian() {
        if(max.size() != min.size()){
            return max.peek();
        } else {
            return (max.peek()+min.peek()) /2.0;
        }
    }
}
