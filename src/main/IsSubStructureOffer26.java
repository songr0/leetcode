package main;

import main.domain.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * @author Song Rui
 */
public class IsSubStructureOffer26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null || A == null){
            return false;
        }
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean recur(TreeNode a, TreeNode b) {
        if(b == null){
            return true;
        }
        if(a == null || a.val != b.val){
            return false;
        }
        return recur(a.left, b.left) && recur(a.right, b.right);
    }

}
