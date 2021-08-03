package main.dp;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Song Rui
 */
public class CuttingRopeOffer14 {

    /**
     * 动态规划：对于有意义的长度length(!= 0, 1, i)，有剪或者不剪两种情况
     */
    public int cuttingRope(int n) {
        if(n == 0){
            return 0;
        }
        // m <= n and m > 1
        int[] dp = new int[n+1];
        // n = 1
        dp[0] = 0;
        // n = 2
        dp[2] = 1;
        for(int i = 3;i<= n;++i){
            // 剪去的长度length 为0，1以及i时没有意义
            for(int length = 2; length <i;++length){
                dp[i] = Math.max(dp[i], Math.max(length * dp[i-length], length *(i-length)));
            }
        }
        return dp[n];
    }

    public int cuttingRope2(int n) {
        if(n == 1 || n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        long res = 1;
        while(n > 4){
            n-=3;
            res*= 3;
            res%= 1000000007;
        }
        return (int) (n&res%1000000007);
    }
}
