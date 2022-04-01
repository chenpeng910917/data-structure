package com.data.structure.stack;

/**
 * 括号匹配 使用数组栈检测
 *
 * @author chenpeng
 */
public class BracketsMatching {

    static char[] stack = new char[10001];
    static int top;

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
    public static boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            int number = getNumber(s.charAt(i));
            // 入栈
            if (number <= 2) {
                stack[top++] = (char) number;
            } else if (top == 0 || number - stack[--top] !=3) {
                return false;
            }
        }
        return top == 0;
    }

    static private int getNumber(char c) {
        switch (c) {
            case '{':
                return 0;
            case '[':
                return 1;
            case '(':
                return 2;
            case '}':
                return 3;
            case ']':
                return 4;
            case ')':
                return 5;
            default:
                return 0;
        }
    }
}
