package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Song Rui
 */
public class MergeRanges extends Solution{

    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] int1, int[] int2){
                return int1[0] - int2[0];
            }
        });
        int len = intervals.length;
        List<int[]> merged = new ArrayList<>(len);
        merged.add(intervals[0]);
        for(int i =1;i< len;++i){
            if(intervals[i][0]> merged.get(merged.size()-1)[1]){
                merged.add(intervals[i]);
            } else {
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], intervals[i][1]);
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }

}
