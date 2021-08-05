package main;

import main.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断是否是对称树
 * 若一棵树的镜像与本身完全一致，称为对称树
 * @author Song Rui
 */
public class IsSymmetricOffer28 {

    boolean isSymmetric(TreeNode root){
        if(root == null){
            return true;
        }
        return recur(root.left, root.right);
    }

    private boolean recur(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null || left.val != right.val){
            return false;
        }
        return recur(left.left, right.right) && recur(left.right, right.left);
    }


}
