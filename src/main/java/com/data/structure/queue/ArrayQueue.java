package com.data.structure.queue;

/**
 * 数组实现队列
 *
 * @author chenpeng
 */
public class ArrayQueue {

    /**
     * 数组
     */
    private String[] items;

    /**
     * 数组大小
     */
    private int n;

    /**
     * 队头下标
     */
    private int head;

    /**
     * 队尾下标
     */
    private int tail;

    public ArrayQueue(int capacity) {
        // 创建一个容量为capacity大小的数组
        this.items = new String[capacity];
        this.n = capacity;
    }

    /**
     * 入队 队尾添加
     *
     * @param item 入队数据
     * @return true/false 队列满了时返回false
     */
    public boolean enqueue(String item) {
        // 队列满了
        if (tail == n) {
            return false;
        }
        items[tail++] = item;
        return true;
    }

    /**
     * 入队 支持动态搬移
     *
     * @param item 入队数据
     * @return true/false 队列满了时返回false
     */
    public boolean enqueueDynamicMove(String item) {
        // 队尾没有空间了
        if (head == n) {
            // 整个队列都满了
            if (head == 0) {
                return false;
            }
            // 数据搬移
            for (int i = head; i < tail; i++) {
                items[i-head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail++] = item;
        return true;
    }

    /**
     * 出队 队头出
     *
     * @return 队头数据
     */
    public String dequeue() {
        // 队列为空
        if (head == tail) {
            return null;
        }
        String item = items[head++];
        return item;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.enqueue("a");
        System.out.println(arrayQueue.dequeue());
        arrayQueue.enqueue("b");
        System.out.println(arrayQueue.dequeue());

        ArrayQueue arrayQueue1 = new ArrayQueue(1);
        arrayQueue1.enqueueDynamicMove("a");
        System.out.println(arrayQueue1.dequeue());
        arrayQueue1.enqueueDynamicMove("b");
        System.out.println(arrayQueue1.dequeue());
    }
}
