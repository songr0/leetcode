package main;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文字符串
 * @author Song Rui
 */
public class Partition131 {
    public List<List<String>> partition(String s) {
        if(s.length() == 0){
            return new ArrayList<>(0);
        }
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(res, list, s, 0);
        return res;
    }

    void dfs(List<List<String>> res, List<String> list, String s, int index){
        if(index == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = index+1;i<= s.length();++i){
            String s1 = s.substring(index, i);
            if(valid(s1)){
                list.add(s1);
                dfs(res, list, s, i);
                list.remove(list.size()-1);
            }
        }
    }

    boolean valid(String s){
        if(s.length() == 1){
            return true;
        }
        int len = s.length();
        for(int i = 0;i<= len/2;++i){
            if(s.charAt(i) != s.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> res = new Partition131().partition("aab");
        System.out.println(res.toString());
    }
}
