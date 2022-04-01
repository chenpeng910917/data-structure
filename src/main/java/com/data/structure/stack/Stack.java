package com.data.structure.stack;

/**
 * 栈 数组实现
 *
 * @author chenpeng
 */
public class Stack {
    /**
     * 数组
     */
    private String[] item;

    /**
     * 栈元素个数
     */
    private int count;

    /**
     * 栈的大小
     */
    private int n;

    /**
     * 初始化栈大小 构造方法
     *
     * @param n 栈的大小
     */
    public Stack(int n) {
        this.item = new String[n];
        this.count = 0;
        this.n = n;
    }

    /**
     * 入栈
     *
     * @param item 入栈数据
     * @return true/false
     */
    public boolean push(String item) {
        // 栈空间不够用了
        if (count == n) {
            return false;
        }
        this.item[count] = item;
        count++;
        return true;
    }

    /**
     * 出栈
     *
     * @return 栈数据
     */
    public String pop() {
        if (count == 0) {
            return null;
        }
        String temp = this.item[count - 1];
        count--;
        return temp;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
