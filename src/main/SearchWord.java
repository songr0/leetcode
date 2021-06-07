package main;

import java.util.HashSet;

public class SearchWord extends Solution{

    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int x, y;
    int xLen;
    int yLen;
    boolean[][] used;

    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0){
            return false;
        }
        if(word.length() == 0){
            return true;
        }
        xLen = board.length;
        yLen = board[0].length;
        used = new boolean[xLen][yLen];
        for(int i = 0;i<xLen;++i){
            x=i;
            for(int j = 0;j< yLen;++j){
                y=j;
                if(board[x][y] == word.charAt(0)){
                    used[i][j] = true;
                    if(dfs(board, word, 1)){
                        return true;
                    }
                    used[i][j] = false;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, int l){
        if(l == word.length()){
            return true;
        }
        for(int i=0;i<4;++i){
            x = x+directions[i][0];
            y = y+directions[i][1];
            if(inArea(x, y) && !used[x][y] && board[x][y] == word.charAt(l)){
                used[x][y] = true;
                if(dfs(board, word, l+1)){
                    return true;
                }
                used[x][y] = false;
            }
            x -= directions[i][0];
            y -= directions[i][1];
        }
        return false;
    }

    boolean inArea(int x ,int y){
        if(x < 0 || y < 0 || x>=xLen || y>=yLen){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SearchWord searchWord = new SearchWord();
        char[][] board = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAB";
        System.out.println("Expected result is " + true);
        System.out.println("The actual result is " + searchWord.exist(board, word));
    }

}
