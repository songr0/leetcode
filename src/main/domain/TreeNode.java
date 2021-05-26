package main.domain;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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

    /**
     * 根据传入的数组构建完全二叉树
     * @param array 数组中的元素对应树节点的值，例如：[5,1,4,null,null,3,6]
     * @return 二叉树的根节点
     */
    public static TreeNode buildTree(List<Integer> array){
        if(array.isEmpty()){
            return null;
        }
        TreeNode root = new TreeNode(array.get(0));
        int index = 0;
        int len = array.size();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (true){
            index++;
            if(index >= len){
                return root;
            }
            TreeNode parent = deque.poll();
            assert parent != null;
            parent.left = new TreeNode(array.get(index));
            deque.addLast(parent.left);
            index++;
            if(index >= len){
                return root;
            }
            parent.right = new TreeNode(array.get(index));
            deque.addLast(parent.right);
        }
    }
}