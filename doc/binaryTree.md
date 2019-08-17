```java
package com.tree;

import java.util.*;

/**
 * @ClassName BinaryTreeTraversal
 * @Author Gavin
 * @Date 2019/7/29 下午1:02
 **
 *
 *     4
 *    / \
 *   3  5
 *  /   \
 * 2    9
 * */

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
            inOrderRec(root.left);
            System.out.println(root.value);
            inOrderRec(root.right);
        }
    }



    public static void postOrderRec(Node root){
        if(root!=null){
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.println(root.value);
        }
    }
    

    /**
     * 先序遍历非递归
     * @param root
     */
    public static void preOrderStack(Node root){
        if(root==null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        while (root!=null||!stack.empty()){
            if (root!=null){
                stack.push(root);
                System.out.println(root.value);
                root = root.left;
            }else {
                Node temp = stack.pop();
                root=temp.right;
            }
        }
    }

    /**
     * 中序遍历非递归
     * @param root
     */
    public static void inOrderStack(Node root) {
        if (root == null) return;
        Stack<Node> s = new Stack<>();
        while (root!=null||!s.empty()){
            if (root!=null){
                s.push(root);
                root = root.left;
            }else {
                Node temp = s.pop();
                System.out.println(temp.value);
                root=temp.right;
            }
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


    public static void main(String[] args){
        Node root = new Node(4);
        Node node0 = new Node(5);
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(9);

        root.left=node1;
        node1.left=node2;
        root.right=node0;
        node0.right=node3;

        System.out.println("前序遍历");
        preOrderStack(root);

        System.out.println("中序遍历");
        inOrderStack(root);

        System.out.println("后续遍历");
        postOrderRec(root);

        System.out.println("层次遍历");
        levelTravel(root);

    }

}
```
# 参考
>https://blog.csdn.net/My_Jobs/article/details/43451187