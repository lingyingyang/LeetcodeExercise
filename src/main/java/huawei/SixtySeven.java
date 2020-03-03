package huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * 矩阵乘法计算量估算
 */
public class SixtySeven {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[][] a = new int[n][2];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    a[i][j] = in.nextInt();
                }
            }
            String str = in.next();
            System.out.println(getTimes(a, str));
        }
    }

    public static int getTimes(int[][] a, String str) {
        int sum = 0;
        int n = a.length - 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            char s = str.charAt(i);
            if (s == ')') {
                stack.push(-1);
            } else {
                if (s == '(') {
                    int b = stack.pop();
                    int c = stack.pop();
                    sum += a[b][0] * a[c][0] * a[c][1];
                    a[b][1] = a[c][1];
                    stack.pop();
                    stack.push(b);
                } else {
                    stack.push(n);
                    n--;
                }
            }
        }
        return sum;
    }
}
