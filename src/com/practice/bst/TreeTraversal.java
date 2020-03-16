package com.practice.bst;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class TreeTraversal {
    public static TreeNode seachNode(TreeNode root,int target){
        TreeNode temp=root;
        while (temp!=null&&temp.val!=target){
            if(target>temp.val){
                temp=temp.right;
            }
            else {
                temp=temp.left;
            }
        }
        return temp;
    }
    public static void inorderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val+"\t");
        inorderTraversal(root.right);
    }
    public static int heightOfTree(TreeNode root){
        if(root==null)
            return 0;
        int height = 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
        return height;
    }
    public static boolean isTreeBalanced(TreeNode root){
        if(root==null)
            return true;

        int left = heightOfTree(root.left);
        int right= heightOfTree(root.right);
        if(Math.abs(left-right)<=1 && isTreeBalanced(root.right) && isTreeBalanced(root.left))
            return true;
        return false;
    }
}
