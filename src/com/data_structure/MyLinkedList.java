package com.data_structure;

public class MyLinkedList {

}

class Node<E>{
    E item;
    Node<E> next;

    //构造函数
    Node(E element) {
        this.item = element;
        this.next = null;
    }

    static void printListRev(Node<String> head) {
            //倒序遍历链表主要用了递归的思想
        if (head != null) {
            printListRev(head.next);
            System.out.println(head.item);
        }
    }

    /**
     *
     * 单链表反转
     * @param head
     * @return
     */
    static Node<String> revList(Node<String> head){
        if(head==null){ return null;}
        Node<String> nodePre = null;
        Node<String> nodeNext = null;
        Node<String> current = head;
        while (current!=null){
            nodeNext=current.next;
            current.next=nodePre;
            nodePre=current;
            current=nodeNext;

        }
        return nodePre;
    }

    public static void main(String[] args){
        //头节点和尾节点都为空 链表为空
        Node<String> head = null;
        Node<String> tail = null;
        head = new Node("nodedata1");
        tail=head;
        tail.next=new Node("nodedata2");
        tail=tail.next;
        tail.next=new Node("nodedata3");
        tail=tail.next;

        //遍历
        Node<String> current = head;
        while (current!=null){
            System.out.println(current.item);
            current = current.next;
        }

        //反转
        Node<String> current_rev = revList(head);
        while (current_rev!=null){
            System.out.println(current_rev.item);
            current_rev = current_rev.next;
        }





    }
}