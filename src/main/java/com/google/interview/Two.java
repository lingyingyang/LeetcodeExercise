package com.google.interview;

import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        int high = Integer.parseInt(sc.nextLine());
        TreeNode node = new TreeNode(Integer.parseInt(sc.nextLine()));
        TreeNode start = node;
        for (int i = 1; i < high; i++) {
            String[] level = sc.nextLine().split(" ");
            int l = Integer.parseInt(level[0]);
            int r = Integer.parseInt(level[1]);
            node.left = new TreeNode(l);
            node.right = new TreeNode(r);
        }
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            val = value;
        }
    }
}
