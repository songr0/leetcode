package main;

import main.domain.TreeNode;

/**
 * 输入一个二叉树，该函数应输出它的镜像
 * @author Song Rui
 */
public class MirrorTreeOffer27 {

    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }

}
