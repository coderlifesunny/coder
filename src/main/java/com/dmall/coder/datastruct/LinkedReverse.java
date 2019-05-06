package com.dmall.coder.datastruct;

/**
 * Description: 链表逆序操作
 *
 * @Author Guangcai.xu
 * @Date 2019/5/6 15:30
 */
public class LinkedReverse {

    private static Node head;

    private static class Node {
        Object data;

        Node next;

        public Node(Object data) {
            this.data = data;
        }
    }


    public static void reverse() {
        if (null == head || null == head.next) {
            return;
        }
        Node p1 = head;
        Node p2 = head.next;
        Node p3;
        while (null != p2) {//直到p2为null，否则一直向后移动
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        head.next = null;
        head = p1;
    }

    public static void main(String[] args) {
        //初始化链表
        head = new Node(3);
        head.next = new Node(5);
        Node temp = head.next;
        temp.next = new Node(1);
        temp = temp.next;
        temp.next = new Node(4);
        temp = temp.next;
        temp.next = new Node(9);
        //逆序前输出链表
        temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        //逆序链表
        reverse();
        //逆序后输出链表
        temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}