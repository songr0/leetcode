package main;

/**
 * 正则表达式匹配
 * 示例：
 * s = "mississippi"
 * p = "mis*is*p*."
 * @author Song Rui
 */
public class IsMatchOffer19 {

    /**
     * fixme 未通过：aa, a*
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if(p.length() == 0 && s.length() == 0){
            return true;
        }
        if(p.length() == 0){
            return false;
        }
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i = 1;i<= m;++i){
            for(int j = 1;j<= n;++j){
                if(p.charAt(j-1) == '*'){
                    if(j>1){
                        dp[i][j] |= dp[i][j-2];
                    }
                    if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.');
                }
            }
        }
        return dp[m][n];
    }
}
