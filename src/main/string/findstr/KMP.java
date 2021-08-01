package main.string.findstr;

/**
 * 字符串匹配
 * KMP 与状态机有关
 * 相对于朴素字符串匹配（失配后每次后移一位），KMP认为只要模版串中的失配点确定，那么对应后移的位数也随之确定
 * 移动位数 = 已匹配的字符数 - 对应的部分匹配值
 * http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
 * @author Song Rui
 */
public class KMP {
    private int[][] dp;

    /**
     * 时间复杂度 m*n
     */
    int findstr(String str, String p){
        if(str.length() == 0 || p.length() == 0){
            return -1;
        }
        int m= str.length();
        int n = p.length();
        int i = 0;
        int j = 0;
        while(i< m && j < n){
            if(str.charAt(i) == p.charAt(j)){
                i++;
                j++;
            } else {
                i = i-j+1;
                j = 0;
            }
        }
        if(j == n){
            return i-j;
        }
        return -1;
    }

    /**
     * "部分匹配值"就是"前缀"和"后缀"的最长的共有元素的长度。以"ABCDABD"为例
     * @param str BBC ABCDAB ABCDABCDABDE
     * @param pat ABCDABD
     * －　"A"的前缀和后缀都为空集，共有元素的长度为0；
     * －　"AB"的前缀为[A]，后缀为[B]，共有元素的长度为0；
     * －　"ABC"的前缀为[A, AB]，后缀为[BC, C]，共有元素的长度0；
     * －　"ABCD"的前缀为[A, AB, ABC]，后缀为[BCD, CD, D]，共有元素的长度为0；
     * －　"ABCDA"的前缀为[A, AB, ABC, ABCD]，后缀为[BCDA, CDA, DA, A]，共有元素为"A"，长度为1；
     * －　"ABCDAB"的前缀为[A, AB, ABC, ABCD, ABCDA]，后缀为[BCDAB, CDAB, DAB, AB, B]，共有元素为"AB"，长度为2；
     * －　"ABCDABD"的前缀为[A, AB, ABC, ABCD, ABCDA, ABCDAB]，后缀为[BCDABD, CDABD, DABD, ABD, BD, D]，共有元素的长度为0。
     * @return RES
     */
    int kmp(String str, String pat){
        if(str.length() == 0 || pat.length() == 0){
            return -1;
        }
        constructDp(pat);
        int m= str.length();
        int n = pat.length();
        int i = 0;
        int j = 0;

        return -1;
    }

    /**
     * 构建状态转移图
     * @param pat
     */
    void constructDp(String pat){

    }

}
