package main;

import main.domain.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 序列化和反序列化二叉树
 * @author Song Rui
 */
public class EncodesTreeOffer37 {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        dfs(root, stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private void dfs(TreeNode node, StringBuilder stringBuilder) {
        if(node == null){
            stringBuilder.append("null").append(",");
            return;
        }
        stringBuilder.append(node.val).append(",");
        dfs(node.left, stringBuilder);
        dfs(node.right, stringBuilder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()<= 2){
            return null;
        }
        data = data.substring(1);
        data = data.substring(0, data.length()-1);
        List<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return dedfs(list);
    }

    private TreeNode dedfs(List<String> list) {
        if(list.isEmpty()){
            return null;
        }
        if("null".equals(list.get(0))){
            list.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        node.left = dedfs(list);
        node.right = dedfs(list);
        return node;
    }

    public static void main(String[] args) {
        TreeNode node = new EncodesTreeOffer37().deserialize("[1,2,3,null,null,4,5]");
        System.out.println(node.toString());
    }
}
