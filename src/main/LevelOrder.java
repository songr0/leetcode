package main;

import main.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * fixme 1,2,3,4,null, null, 5 failed
 * @author Song Rui
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>(0);
        }
        List<List<Integer>> res = new ArrayList<>();
        bfs(root, res);
        return res;
    }

    private void bfs(TreeNode root, List<List<Integer>> res) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int j = 1;
        while(! queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
            for(int i = len-1;i>=0;--i){
                list.add(queue.peek().val);
                if(j == 0){
                    if(queue.peek().left != null){
                        queue.add(queue.peek().left);
                    }
                    if(queue.peek().right != null){
                        queue.add(queue.peek().right);
                    }
                } else {
                    if(queue.peek().right != null){
                        queue.add(queue.peek().right);
                    }
                    if(queue.peek().left != null){
                        queue.add(queue.peek().left);
                    }
                }
                queue.poll();
            }
            j ^= 1;
            res.add(list);
        }
    }
}
