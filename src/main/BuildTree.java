package main;

import main.domain.TreeNode;

import java.util.Arrays;
import java.util.List;

public class BuildTree extends Solution{
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        // 根据前序中提供的根节点将中序数组划分为左右子树两个部分
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    TreeNode build(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR){
        if(inL > inR || preL > preR || inR < 0 || preR < 0 || preL >= preorder.length || preR >= preorder.length || inL >= inorder.length || inR >= inorder.length){
            return null;
        }
        int subscript = findSubscript(inorder, preorder[preL], inL, inR);
        if(subscript == -1){
            return null;
        }
        TreeNode node = new TreeNode(inorder[subscript]);
        node.left = build(preorder, inorder, preL+1, preL+subscript-inL, inL, subscript-1);
        node.right = build(preorder, inorder, preL+subscript-inL+1, preR, subscript+1, inR);
        return node;
    }

    int findSubscript(int[] order, int target, int begin, int end){
        for(int i = begin;i<= end;++i){
            if(order[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // expected: 3,9,20,6,null,15,7
        int[] preorder = new int[]{3,9,6,20,15,7};
        int[] inorder = new int[]{6,9,3,15,20,7};
        BuildTree buildTree = new BuildTree();
        TreeNode root = buildTree.buildTree(preorder, inorder);
        TreeNode.printTree(root);
    }
}
