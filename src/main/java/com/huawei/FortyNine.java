package com.huawei;

import java.util.Scanner;

/**
 * 输出单向链表中倒数第k个结点
 */
public class FortyNine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            int num = sc.nextInt();
            sc.nextLine();
            node root = null;
            node head = null;
            String str = sc.nextLine();
            String[] in = str.split(" ");
            int[] tv = new int[num];
            for (int i = 0; i < num; i++) {
                tv[i] = Integer.parseInt(in[i]);
            }

            for (int i = 0; i < num; i++) {
                node n = new node(tv[i]);
                if (i == 0) {
                    root = n;
                    head = n;
                } else {
                    head.next = n;
                    head = head.next;
                }
            }
            node first = root;
            node second = root;
            int k = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < k - 1; i++) {
                second = second.next;
            }
            while (second.next != null) {
                first = first.next;
                second = second.next;
            }
            System.out.println(first.val);
        }
    }
}

class node {
    int val;
    node next;

    public node(int val) {
        this.val = val;
    }
}
