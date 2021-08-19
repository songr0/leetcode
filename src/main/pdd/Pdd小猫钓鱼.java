package main.pdd;
import java.util.*;

/**
 * @author Song Rui
 */
public class Pdd小猫钓鱼 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[2][n];
        HashMap<Integer, Integer> hashMap = new HashMap<>(16);
        for(int i = 0; i < 2; ++i){
            for(int j = 0;j< n;++j){
                a[i][j] = sc.nextInt();
            }
        }
        int len = 0;
        int[] res = new int[2];
        int one = 0;
        int two = 0;
        int k;
        int j= 1;
        while(one < n || two < n){
            j= j ^ 1;
            if(one >= n){
                k = two++;
                j = 1;
            } else if(two >= n){
                k = one++;
                j=0;
            } else {
                k = j == 0? one++ : two++;
            }
            if(hashMap.get(a[j][k]) == null){
                hashMap.put(a[j][k], len++);
            } else {
                res[j]+= (len-hashMap.get(a[j][k])+1);
                len = hashMap.get(a[j][k]);
                for(Integer key : hashMap.keySet()){
                    if(hashMap.get(key) != null && hashMap.get(key) >= len){
                        hashMap.put(key, null);
                    }
                }
                j = j ^ 1;
            }
        }
        for(Integer v : hashMap.keySet()){
            if(hashMap.get(v) == null){
                continue;
            }
            if(v%2 == 0){
                res[1]++;
            } else {
                res[0]++;
            }
        }
        System.out.println(res[0]+" "+res[1]);
    }

}

