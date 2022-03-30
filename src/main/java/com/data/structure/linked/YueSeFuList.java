package com.data.structure.linked;

/**
 * 循环单链表简单实现约瑟夫问题
 *
 * @author chenpeng
 */
public class YueSeFuList {

    public static void main(String[] args) {
        //申请一个指定长度的链表
        int count = 41;
        Node n = createNodes(count);

        for (int i = 0; i < count; i++) {
            //第2个
            Node second = n.next;
            //第3个
            n = n.next.next;
            //返回第3个
            System.out.println(n.item);
            //让第2个的next指向第4个
            second.next = n.next;
            //让第4个作为第1个
            n = n.next;
        }
    }

    public static Node createNodes(int count) {

        Node next = null;
        Node head = new Node<String>("head", null);
        //刚开始头和尾都是同一个元素
        Node last = head;
        //新元素插入尾部，新元素作为尾
        for (int i = 1; i <= count; i++) {
            next = new Node<String>("num " + i, null);
            last.next = next;
            last = next;
        }
        //最后把尾部元素和插入的第一个元素连起来
        last.next = head.next;
        //把刚开始的那个head去掉，让插入的第一个元素作为head，返回出去
        head = head.next;
        return head;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        //Node<E> prev;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
            // this.prev = prev;
        }
    }
}
