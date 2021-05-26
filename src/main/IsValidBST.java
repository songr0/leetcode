package main;

import main.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Song Rui
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        List<Integer> list = new ArrayList<>();
        // 中序遍历，若递增，则true，否则false
        inorder(root, list);
        int len = list.size();
        for(int i =1;i< len;i++){
            if(list.get(i) <= list.get(i-1)){
                return false;
            }
        }
        return true;
    }

    void inorder(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 1};
        TreeNode root = TreeNode.buildTree(array);
        IsValidBST isValidBST = new IsValidBST();
        System.out.println(isValidBST.isValidBST(root));
    }

}
