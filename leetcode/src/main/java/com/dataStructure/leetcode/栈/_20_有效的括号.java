package com.dataStructure.leetcode.栈;

import java.util.Stack;

public class _20_有效的括号 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i ++) {
            if (!stack.empty() && leftAndRight(stack.peek(), s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.empty())
            return true;
        return false;
    }

    public boolean leftAndRight(char a, char b) {
        if ((a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}'))
            return true;
        return false;
    }

}
