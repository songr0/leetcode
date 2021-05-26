package main.domain;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Song Rui
 */
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(Integer val) { this.val = val; }
    TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTree(int[] array){
        if(array.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        int index = 0;
        int len = array.length;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (true){
            index++;
            if(index >= len){
                return root;
            }
            TreeNode parent = deque.poll();
            assert parent != null;
            parent.left = new TreeNode(array[index]);
            index++;
            if(index >= len){
                return root;
            }
            parent.right = new TreeNode(array[index]);
        }
    }
}