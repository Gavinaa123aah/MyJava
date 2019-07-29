package com.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName BinaryTreeTraversal
 * @Author Gavin
 * @Date 2019/7/29 下午1:02
 **/
public class BinaryTreeTraversal {

    public static void preOrderRec(Node root){
        if (root!=null){
            System.out.println(root.value);
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }


    public static void inOrderRec(Node root){
        if(root!=null){
            preOrderRec(root.left);
            System.out.println(root.value);
            preOrderRec(root.right);
        }
    }



    public static void postOrderRec(Node root){
        if(root!=null){
            preOrderRec(root.left);
            preOrderRec(root.right);
            System.out.println(root.value);
        }
    }



    /**
     * 先序遍历非递归
     * @param root
     */
    public static void preOrderStack_1(Node root){
        if(root==null){
            return;
        }

        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.empty()){
            Node temp=s.pop();
            System.out.println(temp.value);
            if(temp.right!=null) s.push(temp.right);
            if(temp.left!=null) s.push(temp.left);
        }
    }

    /**
     * 中序遍历非递归
     * @param root
     */
    public static void inOrderStack(Node root) {
        if (root == null) return;
        Stack<Node> s = new Stack<Node>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);//先访问再入栈
                root = root.left;
            }
            root = s.pop();
            System.out.println(root.value);
            root = root.right;//如果是null，出栈并处理右子树
        }

    }

    /**
     * 层序遍历
     * @param root
     */
    public static void levelTravel(Node root){
        if (root==null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.println(temp.value);
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }

    }

}

