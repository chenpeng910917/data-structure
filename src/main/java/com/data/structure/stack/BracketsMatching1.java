package com.data.structure.stack;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 括号匹配 使用JDK栈检测
 *
 * @author chenpeng
 */
public class BracketsMatching1 {

    static List<String> pushList = Lists.newArrayList();
    static Map<String, String> popMap = Maps.newHashMap();

    static {
        pushList.add("{");
        pushList.add("[");
        pushList.add("(");

        popMap.put("}", "{");
        popMap.put("]", "[");
        popMap.put(")", "(");

    }

    public static void main(String[] args) {
        // 不合法
//        String str = "{[(]})";
        String str = "{[()]}";
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            String brackets = String.valueOf(str.charAt(i));
            if (pushList.contains(brackets)) {
                // 入栈
                stack.push(brackets);
            } else if (popMap.get(brackets) != null) {
                if (!stack.isEmpty()) {
                    // 出栈
                    String pop = stack.pop();
                    if (!popMap.get(brackets).equals(pop)) {
                        System.out.println("括号不合法");
                        return;
                    }
                } else {
                    System.out.println("括号不一致");
                    return;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("括号一致");
            return;
        }
        System.out.println("括号不一致");
    }
}
