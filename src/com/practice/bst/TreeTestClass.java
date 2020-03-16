package com.practice.bst;

import org.junit.jupiter.api.Test;

public class TreeTestClass {
    @Test
    public void inorder(){
        BinarySearchTree tree = getBinarySearchTree();
        TreeTraversal.inorderTraversal(tree.getRoot());
        System.out.println("");
        //tree.delete(70);
        //TreeTraversal.inorderTraversal(tree.getRoot());
        //System.out.println("");
        System.out.println(tree.getRoot().val);
        System.out.println("Height of tree is:"+TreeTraversal.heightOfTree(tree.getRoot()));
        System.out.println("Is tree balanced :"+TreeTraversal.isTreeBalanced(tree.getRoot()));
        System.out.println("Is tree balanced :"+TreeTraversal.isTreeBalanced(getUnBalancedTree().getRoot()));
    }

    /* create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
    private BinarySearchTree getBinarySearchTree() {
        BinarySearchTree tree=new BinarySearchTree(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        return tree;
    }

    private BinarySearchTree getUnBalancedTree() {
        BinarySearchTree tree=new BinarySearchTree(10);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        return tree;
    }
}
