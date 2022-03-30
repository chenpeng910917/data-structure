package com.data.structure.linked;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 双向链表
 *
 * @author chenpeng
 */
public class BidirectionalLinkedList<E> {

    /**
     * 大小
     */
    private int size;

    /**
     * 头部节点
     */
    private Node<E> head;

    /**
     * 尾部节点
     */
    private Node<E> tail;

    /**
     * 获取节点
     *
     * @param index 索引
     * @return 值
     */
    public E get(int index) {
        return getNode(index).val;
    }

    /**
     * 获取大小
     *
     * @return 大小
     */
    public int size() {
        return size;
    }

    /**
     * 获取第一个节点的值
     *
     * @return 值
     */
    public E getFirst() {
        if (head == null) {
            return null;
        }
        return head.val;
    }

    /**
     * 获取最后一个节点的值
     *
     * @return 值
     */
    public E getLast() {
        if (tail == null) {
            return null;
        }
        return tail.val;
    }

    /**
     * 获取节点
     *
     * @param index 索引
     * @return 节点
     */
    public Node<E> getNode(int index) {
        if (index < 0 || index > (size - 1)) {
            throw new IndexOutOfBoundsException();
        }
        int cnt = 0;
        Node<E> temp = head;
        while (cnt != index) {
            temp = temp.next;
            cnt++;
        }
        return temp;
    }

    public Node<E> getPreNode(int index) {
        int cnt = 0;
        Node<E> temp = head;
        while (cnt != index) {
            temp = temp.next;
            cnt++;
        }
        return temp;
    }

//    /**
//     * 获取
//     * @param index
//     * @return
//     */
//    public Node<E> getPreNode(int index) {
//
//    }

    /**
     * 添加第一个节点
     *
     * @param e 值
     */
    public void addFirst(E e) {
        // 获得头部节点
        Node<E> h = head;
        // 创建一个新节点 新节点的下一个节点为当前头部节点
        Node<E> newNode = new Node<>(null, e, h);
        // 把新节点设置为首节点
        head = newNode;
        if (h == null) {
            // 如果头部节点为空 则头尾为一个节点
            tail = newNode;
        } else {
            // 如果之前的头部节点不为空 则之前的头部节点的前一个节点为新建节点
            h.prev = newNode;
        }
        // 长度加1
        size++;
    }

    /**
     * 添加尾部一个节点
     *
     * @param e 值
     */
    public void addLast(E e) {
        Node<E> t = tail;
        Node<E> newNode = new Node<>(tail, e, null);
        tail = newNode;
        if (t == null) {
            head = newNode;
        } else {
            t.next = newNode;
        }
        size++;
    }

    /**
     * 尾部追加一个节点
     *
     * @param e 值
     */
    public void add(E e) {
        addLast(e);
    }

    /**
     * 指定索引位置添加一个节点
     *
     * @param index 索引
     * @param e     值
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(e);
            return;
        }

        if (index == size) {
            addLast(e);
            return;
        }

        // 获取前一个节点
        Node<E> node = getNode(index - 1);
        node.next = new Node<>(node, e, node.next);
        size++;
    }

    /**
     * 移除第一个节点
     */
    public E removeFirst() {
        if (head == null) {
            throw new NullPointerException();
        }
        Node<E> h = head;
        Node<E> temp = head.next;
        head = temp;
        if (temp == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
        return h.val;
    }

    /**
     * 移除最后一个节点
     */
    public E removeLast() {
        if (tail == null) {
            throw new NullPointerException();
        }

        if (size == 1) {
            return removeFirst();
        }

        Node<E> prev = tail.prev;
        tail = prev;
        if (prev == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
        return prev.val;
    }

    /**
     * 移除指定节点
     *
     * @param index 索引
     */
    public E remove(int index) {
        if (index < 0 || index > (size - 1)) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == size - 1) {
            return removeLast();
        }

        // 获取前一个节点
        Node<E> node = getPreNode(index - 1);
        Node<E> next = node.next;
        node.next = node.next.next;
        size--;
        return next.val;
    }

    public static class Node<E> {
        /**
         * 值
         */
        E val;
        /**
         * 下一个节点
         */
        Node<E> next;
        /**
         * 上一个节点
         */
        Node<E> prev;

        public Node(Node<E> prev, E val, Node<E> next) {
            this.prev = prev;
            this.val = val;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        Iterator<E> it = new LinkedIterator();
        if (!it.hasNext()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (; ; ) {
            E e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (!it.hasNext()) {
                return sb.append(']').toString();
            }
            sb.append(',').append(' ');
        }
    }

    /**
     * 迭代器
     *
     * @author chenpeng
     */
    private class LinkedIterator implements Iterator<E> {
        /**
         * 光标
         */
        private int cursor;

        public LinkedIterator() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            // 注意这里，cursor(光标)在指向最后一个元素的时候，hasNext()仍旧返回true。
            return cursor != size;
        }

        /**
         * 获取当前下标内容 下标加1
         *
         * @return 内容
         */
        @Override
        public E next() {
            if (cursor > size - 1) {
                throw new NoSuchElementException();
            }
            return get(cursor++);
        }
    }
}
