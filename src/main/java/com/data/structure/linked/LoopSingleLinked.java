package com.data.structure.linked;

/**
 * 循环单链表
 *
 * @author chenpeng
 */
public class LoopSingleLinked {

    /**
     * 数组：items，数组大小：n
     */
    private String[] items;
    private int n;
    /**
     * head 表示队头下标，tail 表示队尾下标
     */
    private int head = 0;
    private int tail = 0;

    /**
     * 申请一个大小为 capacity 的数组
     *
     * @param capacity 容量
     */
    public LoopSingleLinked(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队
     *
     * @param item 入队数据
     * @return ture/false 队列满时返回false
     */
    public boolean enqueue(String item) {
        // 队列满了
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    /**
     * 出队
     *
     * @return 数据
     */
    public String dequeue() {
        // 如果 head == tail 表示队列为空
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }
}
