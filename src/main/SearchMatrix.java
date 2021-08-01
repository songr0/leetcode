package main;

/**
 * @author Song Rui
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols-1;
        int temp;
        while(row < rows && col >= 0){
            temp = matrix[row][col];
            if(temp == target){
                return true;
            } else if(temp > target){
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean res = new SearchMatrix().searchMatrix(new int[][]{{1,4,7,11,15},
                {2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 20);
    }
}
