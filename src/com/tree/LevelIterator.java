package com.tree;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @ClassName LevelIterator
 * @Author Gavin
 * @Date 2019/9/21 下午6:25
 **/
public class LevelIterator {



    private static void f(Node root){
        Queue<Node> queue = new LinkedList<>();
        Node last = root;
        Node nextLast = null;
        int count = 1;

        if (root!=null){
            queue.offer(root);
        }

        System.out.println(count);

        while (queue.size()!=0){
            Node temp = queue.poll();
            System.out.println(temp.value);
            if (temp.left!=null){
                queue.offer(temp.left);
                nextLast = temp.left;
            }
            if (temp.right!=null){
                queue.offer(temp.right);
                nextLast = temp.right;
            }
            if (temp == last){
                count++;
                last = nextLast;
                if (queue.size()!=0)
                System.out.println(count);
            }


        }

    }

    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);
        Node node5 = new Node(50);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.right = node5;

        f(node1);

    }

}

