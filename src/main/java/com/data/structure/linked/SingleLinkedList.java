package com.data.structure.linked;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 单链表
 *
 * @author chenpeng
 */
public class SingleLinkedList<E> {

    /**
     * 大小
     */
    private int size;

    /**
     * 头部指针
     */
    private Node<E> head;

    /**
     * 尾部指针
     */
    private Node<E> tail;

    /**
     * 获取链表数据
     *
     * @param index 索引
     * @return 数据
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).val;
    }

    /**
     * 获取链表长度
     *
     * @return 长度
     */
    public int size() {
        return size;
    }

    /**
     * 获取第一个节点值
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
     * 获取最后一个节点值
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
     * 获取链表节点
     *
     * @param index 索引
     * @return 数据
     */
    public Node<E> getNode(int index) {
        if (index < 0 || index > (size - 1)) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> temp = head;
        int cnt = 0;
        while (cnt != index) {
            temp = temp.next;
            cnt++;
        }
        return temp;
    }

    /**
     * 获取前一个节点
     *
     * @param index 索引
     * @return 节点
     */
    private Node<E> getPreNode(int index) {
        Node<E> temp = head;
        int cnt = 1;
        while (cnt != index) {
            temp = temp.next;
            cnt++;
        }
        return temp;
    }

    /**
     * 添加第一个
     *
     * @param e 数据
     */
    public void addFirst(E e) {
        Node<E> h = head;
        Node<E> newNode = new Node<>(e, h);
        head = newNode;
        if (h == null) {
            tail = newNode;
        }
        size++;
    }

    /**
     * 添加最后一个
     *
     * @param e 数据
     */
    public void addLast(E e) {
        Node<E> t = tail;
        Node<E> newNode = new Node<>(e, null);
        tail = newNode;
        if (t == null) {
            head = newNode;
        } else {
            t.next = newNode;
        }
        size++;
    }

    /**
     * 追加添加(相当于调用addLast)
     *
     * @param e 数据
     */
    public void add(E e) {
        addLast(e);
    }

    /**
     * 添加
     *
     * @param index 索引
     * @param e     数据
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
        Node<E> temp = getPreNode(index);
        Node<E> newNode = new Node<>(e, temp.next);
        temp.next = newNode;
        size++;
    }

    /**
     * 链表翻转
     *
     * @return 节点
     */
    public Node<E> reverseList() {
        Node<E> reversedHead = null;
        Node<E> current = head;
        while (current != null) {
            // 取下一个
            Node<E> next = current.next;
            // 旧链表中的下一个 指向新头节点
            current.next = reversedHead;
            // 组装后的数据 重新指向新头节点
            reversedHead = current;
            // 循环节点为下一个
            current = next;
        }
        return reversedHead;
    }

    public Node<E> reverseListRecursion() {
        return reverseListRecursion(head);
    }

    /**
     * 递归实现链表反转
     *
     * @param head 头部
     * @return 反转或数据
     */
    public Node<E> reverseListRecursion(Node<E> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<E> newHead = reverseListRecursion(head.next);
        Node<E> tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        head.next = null;
        return newHead;
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
        }
        size--;
        return h.val;
    }

    /**
     * 移除最后一个节点
     */
    public E removeLast() {
        if (head == null) {
            throw new NullPointerException();
        }

        if (size == 1) {
            return removeFirst();
        }
        // 获取节点
        Node<E> t = tail;
        Node<E> node = getNode(size - 2);
        node.next = null;
        tail = node;
        size--;
        return t.val;
    }

    /**
     * 移除节点
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

        // 获取节点
        Node<E> node = getNode(index - 1);
        Node<E> next = node.next;
        node.next = node.next.next;
        size--;
        return next.val;
    }

    /**
     * 判断是否是回文
     * <p>
     * 快指针每次走两步，慢指针每次走一步，一直到快指针走到单链表的最后一个结点位置。此时慢指针恰巧会走到字符串的中间位置
     *
     * @return true/false
     */
    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        Node<E> prev = null;
        // 慢指针
        Node<E> slow = head;
        // 快指针
        Node<E> fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            Node<E> next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // 奇偶判断 奇数则向后移动一个节点
        if (fast != null) {
            slow = slow.next;
        }

        // 依次比较中间位置两边每个字符是否相等即可判断是否是回文串
        while (slow != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }


    static class Node<E> {
        /**
         * 值
         */
        E val;
        /**
         * 下一个
         */
        Node<E> next;

        Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "" + val;
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
