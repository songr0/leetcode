package main;

/**
 * 机器人的运动范围，从0，0开始，每次上下左右移动，所在坐标行和列的数位之和不能大于k，只在可能达到的位置内移动
 * 注意审题：该题要区分可达和不可达的答案，虽然有的坐标满足小于等于k，但是不由于能穿越不可达范围，所以不可达的答案不符和本题要求
 * 可以画图举例，尝试探究一下答案的特点
 * dfs，考虑到性能问题，需要剪枝
 * @author Song Rui
 */
public class MovingCount {
    boolean[][] visited;
    int m;
    int n;
    int k;

    /**
     * 数位之和的变化
     * 从19到20： sum(20) = sum(19)-8
     * 从20到21：sum(21) = sum(20)+1
     */
    public int movingCount(int m, int n, int k) {
        if(m == 0 || n == 0 || k< 0){
            return 0;
        }
        if(k == 0){
            return 1;
        }
        visited = new boolean[m][n];
        this.m = m;
        this.n = n;
        this.k = k;
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if(i >= m || j>=n || visited[i][j] || (i%10 + i/10 +j%10 + j/10) > k){
            return 0;
        }
        visited[i][j] = true;
        return dfs(i+1, j) + dfs(i, j+1) + 1;
    }

}
