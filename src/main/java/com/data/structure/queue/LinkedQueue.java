package com.data.structure.queue;

/**
 * 链表实现队列
 *
 * @author chenpeng
 */
public class LinkedQueue {

    private Node head;
    private Node tail;

    /**
     * 入队
     *
     * @param data 入队数据
     */
    public void enqueue(String data) {
        if (tail == null) {
            Node newNode = new Node(data, null);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new Node(data, null);
            tail = tail.next;
        }
    }

    /**
     * 出队
     *
     * @return 出队数据
     */
    public String dequeue() {
        if (head == null) {
            return null;
        }
        String data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }


    private static class Node {
        String data;
        Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
