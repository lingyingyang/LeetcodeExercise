package com.tencent;

import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int houses = Integer.parseInt(in.nextLine());
        int[] red = new int[houses];
        int[] green = new int[houses];
        int[] blue = new int[houses];
        for (int i = 0; i < houses; i++) {
            String line = in.nextLine();
            String[] items = line.split(" ");
            red[i] = Integer.parseInt(items[0]);
            green[i] = Integer.parseInt(items[1]);
            blue[i] = Integer.parseInt(items[2]);
        }
        TreeNode redRoot = new TreeNode(red[0]);
        for (int i = 1; i < houses; i++) {
            redRoot.left = new TreeNode(green[i]);
            redRoot.right = new TreeNode(blue[i]);
        }
        TreeNode greenRoot = new TreeNode(green[0]);
        for (int i = 1; i < houses; i++) {
            greenRoot.left = new TreeNode(red[i]);
            greenRoot.right = new TreeNode(blue[i]);
        }
        TreeNode blueRoot = new TreeNode(blue[0]);
        for (int i = 1; i < houses; i++) {
            blueRoot.left = new TreeNode(red[i]);
            blueRoot.right = new TreeNode(green[i]);
        }

        Two test = new Two();
        int i1 = test.maxGain(redRoot);
        int i2 = test.maxGain(greenRoot);
        int i3 = test.maxGain(blueRoot);

    }

    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) return 0;

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int priceNewPath = node.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, priceNewPath);

        // 如果回溯到上一层，返回最大的路径
        return node.val + Math.max(leftGain, rightGain);
    }

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            val = value;
        }
    }
}
