package main.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三角形最小路径和
 * @author Song Rui
 */
public class MinimumTotal120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        if(m == 0){
            return 0;
        }
        int n = triangle.get(m-1).size();
        if(n == 0){
            return 0;
        }
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for(int i = 1;i< m;++i){
            for(int j = i; j>0; --j) {
                if (i == j) {
                    f[j] = f[j-1] + triangle.get(i).get(j);
                } else {
                    f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
                }
            }
            f[0] += triangle.get(i).get(0);
        }
        Arrays.sort(f);
        return f[0];
    }


    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>(){{
            add(new ArrayList<>(){{add(2);}});
            add(new ArrayList<>(){{add(3);add(4);}});
            add(new ArrayList<>(){{add(6);add(5);add(7);}});
            add(new ArrayList<>(){{add(4);add(1);add(8);add(3);}});
        }};
        int res = new MinimumTotal120().minimumTotal(list);
        System.out.println(res);
    }
}
