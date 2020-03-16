package com.practice.bst;

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree(int root) {
        this.root = new TreeNode(root);
    }

    public BinarySearchTree() {
    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode insert(int value){
       return insertNode(root,value);
    }
    public TreeNode insertNode(TreeNode currRoot,int value){
        if(currRoot==null){
            currRoot=new TreeNode(value);
            return currRoot;
        }
        if(currRoot.val<value){
            currRoot.right=insertNode(currRoot.right,value);
        }
        else {
            currRoot.left=insertNode(currRoot.left,value);
        }
        return currRoot;
    }

    public void delete(int key){
        deleteNode(root,key);
    }
    public TreeNode deleteNode(TreeNode node,int target){
        if(node==null) return node;

        if(target<node.val){
            node.left=deleteNode(node.left,target);
        }
        else if (target>node.val){
            node.right=deleteNode(node.right,target);
        }
        else {
            //this is the node to be deleted.
            if(node.left==null){
                //if no left child, we can directly point to right child and so deleting this node
                return node.right;
            }
            if(node.right==null){
                return node.left;
            }
            //if both left and right childs exist, we find inorder successor
            TreeNode successor=node.right;
            while (successor.left!=null){
                successor=successor.left;
            }
            node.val=successor.val;
            node.right=deleteNode(node.right,node.val);
        }

        return node;
    }




}
