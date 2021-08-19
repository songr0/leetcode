package main;

import main.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 树的后序遍历非递归
 * @author Song Rui
 */
public class PostOrder {

    List<Integer> postOrder(TreeNode root){
        if(root == null){
            return new ArrayList<>(0);
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;
        stack.push(root);
        List<Integer> res = new ArrayList<>();
        while(! stack.isEmpty()){
            if(cur != null && cur.left != null){
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.peek();
                if(cur.right != null && cur.right != last){
                    cur = cur.right;
                    stack.push(cur);
                } else {
                    res.add(stack.pop().val);
                    last = cur;
                    cur = null;
                }
            }
        }

        return res;
    }
}
