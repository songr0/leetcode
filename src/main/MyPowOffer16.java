package main;

/**
 * 快速幂
 * @author Song Rui
 */
public class MyPowOffer16 {

    public double myPow(double x, int n){
        if(x == 0){
            return 0;
        }
        double res = 1.0;
        long b = n;
        if(n < 0){
            b = -b;
            x = 1/x;
        }
        while (b>0){
            if((b & 1) == 1){
                res *= x;
            }
            x*= x;
            b = b >> 1;
        }
        return res;
    }
}
