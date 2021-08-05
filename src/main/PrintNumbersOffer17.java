package main;

/**
 * @author Song Rui
 */
public class PrintNumbersOffer17 {

    int[] res;
    char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    int n;
    char[] num;
    int index;
    int start;
    int nine;
    public int[] printNumbers(int n) {
        if(n == 0){
            return new int[0];
        }
        this.n = n;
        this.index = 0;
        num = new char[n];
        start = n - 1;
        nine = 0;
        int end = (int) (Math.pow(10,n) -1);
        res = new int[end];
        dfs(0);
        return res;
    }

    private void dfs(int x) {
        if(x == n){
            String s = String.valueOf(num).substring(start);
            if(!"0".equals(s)){
                res[index++] = Integer.parseInt(s);
            }
            if(n- start == nine){
                start--;
            }
            return;
        }
        for(int i = 0;i< 10;++i){
            if(chars[i] == '9'){
                nine++;
            }
            num[x] = chars[i];
            dfs(x+1);
        }
        nine--;
    }

    public static void main(String[] args) {
        int[] res = new PrintNumbersOffer17().printNumbers(3);
        System.out.println(res.toString());
    }
}
