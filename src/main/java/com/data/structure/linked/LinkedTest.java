package com.data.structure.linked;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 链表
 *
 * @author chenpeng
 */
public class LinkedTest {

    /**
     * 单链表 约瑟夫问题(使用Linked双向链表(单链表就能解决、最好使用循环链表))
     * 41个人，围成圈，从第一个人开始从1报数，当碰到3时，那个人出局。然后后面的人再从1开始报数，直到全部出局
     * <p>
     * 据说著名犹太历史学家 Josephus有过以下的故事:在罗马人占领乔塔帕特后，39 个犹太人与Josephus及他的朋友躲到一个洞中，
     * 39个犹太人决定宁愿死也不要被敌人抓到，于是决定了一个自杀方式，41个人排成一个圆圈，由第1个人开始报数，每报数到第3人该人就必须自杀，
     * 然后再由下一个重新报数，直到所有人都自杀身亡为止。然而Josephus 和他的朋友并不想遵从。首先从一个人开始，越过k-2个人(因为第一个人已经被越过)，
     * 并杀掉第k个人。接着，再越过k-1个人，并杀掉第k个人。这个过程沿着圆圈一直进行，直到最终只剩下一个人留下，这个人就可以继续活着。问题是，给定了和，
     * 一开始要站在什么地方才能避免被处决?Josephus要他的朋友先假装遵从，他将朋友与自己安排在第16个与第31个位置，于是逃过了这场死亡游戏。
     */
    @Test
    public void linkedYueSeFu() {
        // JDK 双向链表
//        List<String> list = new LinkedList<>();
        // 手写单链表
//        SingleLinkedList<String> list = new SingleLinkedList<>();
        // 手写双向链表
        BidirectionalLinkedList<String> list = new BidirectionalLinkedList<>();

        // 初始化链表
        for (int i = 0; i < 41; i++) {
            int num = i + 1;
            list.add("P" + num);
        }

        int i = 0;
        while (list.size() > 2) {
            // 每次移动2位
            i = i + 2;
            // 如果位置超出链表长度，就从头再来  如果是循环链表则不需要从头再来
            if (i > list.size() - 1) {
                i = i - list.size();
            }
            // 杀掉此人 移除
            System.out.println(list.remove(i));
        }

        // 最后的两个幸存者
        System.out.println("幸存者1：" + list.get(0));
        System.out.println("幸存者2：" + list.get(1));
    }

    /**
     * 单链表
     */
    @Test
    public void singleLinkedList() {
        SingleLinkedList<String> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addFirst("aa");
        singleLinkedList.addFirst("bb");
        String node = singleLinkedList.get(1);
        System.out.println(node);

        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3, 4);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        System.out.println(list.toString());
        System.out.println(list.size());
        list.removeFirst();
        list.removeLast();
        list.remove(1);
        System.out.println(list.toString());
        System.out.println(list.size());
    }

    /**
     * 单链表判断是否是回文
     */
    @Test
    public void isPalindrome() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("b");
        list.add("a");
        boolean palindrome = list.isPalindrome();
        System.out.println(palindrome);
    }

    /**
     * 双向链表
     */
    @Test
    public void bidirectionalLinkedList() {
        BidirectionalLinkedList<Integer> list = new BidirectionalLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3, 4);
        list.remove(1);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.toString());
    }

    /**
     * JDK双向链表
     */
    @Test
    public void linkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2, 4);
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        SingleLinkedList.Node<Integer> integerNode = list.reverseListRecursion();
        System.out.println();
    }
}
