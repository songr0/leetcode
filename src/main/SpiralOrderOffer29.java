package main;

/**
 * @author Song Rui
 */
public class SpiralOrderOffer29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m*n];
        int left = 0;
        int right = n-1;
        int top = 0;
        int down = m-1;
        int i = 0;
        while(left <= right && top <= down){
            for(int col = left;col<= right; ++col){
                res[i++] = matrix[top][col];
            }
            for(int row = top+1;row <= down;++row){
                res[i++] = matrix[row][right];
            }
            if(left <right && top < down){
                for(int col = right-1;col>= left;--col){
                    res[i++] = matrix[down][col];
                }
                for(int row = down-1;row> top;--row){
                    res[i++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            down--;
        }
        return res;
    }
}
