package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 四则运算
 */
public class FortyEight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            Stack<Character> stack = new Stack<Character>();
            List<Object> list = new ArrayList<Object>();

            for (int i = 0; i < line.length(); i++) {
                StringBuilder T = new StringBuilder();
                boolean isN = false; // 负号
                if (i == 0 && line.charAt(i) == '-') {
                    isN = true;
                    ++i;
                } else if (line.charAt(i) == '-' && (line.charAt(i - 1) == '-' || line.charAt(i - 1) == '+'
                        || line.charAt(i - 1) == '*' || line.charAt(i - 1) == '/' || line.charAt(i - 1) == '('
                        || line.charAt(i - 1) == '[' || line.charAt(i - 1) == '{')) {
                    isN = true;
                    ++i;
                }
                while (i < line.length() && line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                    T.append(line.charAt(i++));
                }
                if (!T.toString().equals("")) {
                    --i;
                    if (isN) {
                        list.add(-(new Integer(T.toString())));
                    } else {
                        list.add(new Integer(T.toString()));
                    }
                } else {
                    char op = line.charAt(i);
                    if (op == '+' || op == '-' || op == '*' || op == '/') {
                        if (stack.isEmpty()) {
                            stack.push(op);
                        } else if (isUpperPro(op, (char) stack.peek())) {
                            stack.push(op);
                        } else {
                            while (!stack.isEmpty()
                                    && (stack.peek() != '(' || stack.peek() != '[' || stack.peek() != '{')
                                    && !isUpperPro(op, (char) stack.peek())) {
                                list.add(stack.pop());
                            }
                            stack.push(line.charAt(i));
                        }
                    } else if (op == '(' || op == '[' || op == '{') {
                        stack.push(op);
                    } else if (line.charAt(i) == ')') {
                        while (stack.peek() != '(') {
                            list.add(stack.pop());
                        }
                        stack.pop();
                    } else if (line.charAt(i) == ']') {
                        while (stack.peek() != '[') {
                            list.add(stack.pop());
                        }
                        stack.pop();
                    } else if (line.charAt(i) == '}') {
                        while (stack.peek() != '{') {
                            list.add(stack.pop());
                        }
                        stack.pop();
                    }
                }
            }
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
            Stack<Integer> Pstack = new Stack<Integer>();
            for (Object temp : list) {
                if (temp instanceof Integer) {
                    Pstack.push((Integer) temp);
                } else if (temp instanceof Character) {
                    int N2 = Pstack.pop();
                    int N1 = Pstack.pop();
                    int res = getRes(N1, N2, (char) temp);
                    Pstack.push(res);
                }
            }
            System.out.println(Pstack.pop());
        }
    }

    public static int getRes(int n1, int n2, char temp) {
        if (temp == '-') {
            return n1 - n2;
        }
        if (temp == '+') {
            return n1 + n2;
        }
        if (temp == '*') {
            return n1 * n2;
        }
        if (temp == '/') {
            return n1 / n2;
        }
        return 0;
    }

    public static boolean isUpperPro(char op, char peek) {
        if (peek == '(' || peek == '[' || peek == '{') {
            return true;
        }
        if ((op == '+' || op == '-') && (peek == '*' || peek == '/')) {
            return false;
        }
        if ((op == '*' || op == '/') && (peek == '+' || peek == '-')) {
            return true;
        }
        if ((op == '+' || op == '-') && (peek == '+' || peek == '-')) {
            return false;
        }
        if ((op == '*' || op == '/') && (peek == '*' || peek == '/')) {
            return false;
        }
        return false;
    }
}
