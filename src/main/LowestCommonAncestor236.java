package main;

import main.domain.TreeNode;

/**
 * @author Song Rui
 */
public class LowestCommonAncestor236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        // 1.return 的时候按最内层理解
        if(root.val.equals(p.val) || root.val.equals(q.val)){
            // 返回条件，找到p或q
            // 返回到的层数，与递归条件有关，即root.left或root.right的root
            // 若能同时找到node1，node2,那么root就是公共父结点，
            // 当继续向上返回时，作为新的node1或node2存在,则另外一个为null，因此可以将root继续向上返回
            return root;
        }
        // 2.递归层，注意递归条件
        TreeNode node1 = lowestCommonAncestor(root.left, p, q);
        TreeNode node2 = lowestCommonAncestor(root.right, p, q);
        // 3. 以下按最外层理解
        if(node1 != null && node2 != null){
            return root;
        } else if(node1 == null){
            return node2;
        } else {
            return node1;
        }
    }
}
