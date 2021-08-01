package main;

import main.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 树的中序遍历非递归
 * @author Song Rui
 */
public class MidOrder {

    void midOrder(TreeNode root){
        if(root == null){
            return;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        TreeNode node = root;
        while(node != null || ! stack.isEmpty()){
            while(node != null){
                stack.addLast(node.val);
                node = node.left;
            }
            if(!stack.isEmpty()){
                System.out.print(stack.pollLast());
                node = node.right;
            }
        }
    }
}
