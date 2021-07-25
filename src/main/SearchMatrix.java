package main;

/**
 * @author Song Rui
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        if(matrix[0][0] == target){
            return true;
        }
        return find(matrix, target, 0, 0, matrix.length-1, matrix[0].length-1);
    }

    boolean find(int[][] matrix, int target, int x1, int y1, int x2, int y2){
        if(x2<x1 || y2<y1 || target>matrix[x2][y2] || target<matrix[x1][y1]){
            return false;
        }
        int mid = (y1+y2)/2;
        return true;
    }

    public static void main(String[] args) {
        boolean res = new SearchMatrix().searchMatrix(new int[][]{{1,4,7,11,15},
                {2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 20);
    }
}
