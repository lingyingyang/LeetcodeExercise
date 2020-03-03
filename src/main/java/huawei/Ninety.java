package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 201301 JAVA题目0-1级
 * 编写一个函数，传入一个int型数组，返回该数组能否分成两组，使得两组中各元素加起来的和相等，
 * 并且，所有5的倍数必须在其中一个组中，所有3的倍数在另一个组中（不包括5的倍数），能满足以上条件，返回true；
 * 不满足时返回false。
 */
public class Ninety {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            int n = Integer.parseInt(str);
            String[] nums = bf.readLine().split(" ");
            int[] left = new int[n + 1];
            int l = 0;
            int lcnt = 0;
            int[] right = new int[n + 1];
            int r = 0;
            int rcnt = 0;
            int[] other = new int[n + 1];
            int o = 0;
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(nums[i]);
                if (num % 5 == 0) {
                    left[l++] = num;
                    lcnt += num;
                } else if (num % 3 == 0) {
                    right[r++] = num;
                    rcnt += num;
                } else {
                    other[o++] = num;
                }
            }
            int sum = Math.abs(lcnt - rcnt);
            System.out.println(canGet(0, o, other, 0, sum));
        }
        bf.close();
    }

    private static boolean canGet(int i, int o, int[] other, int j, int sum) {
        if (i == o) return Math.abs(j) == sum;
        return (canGet(i + 1, o, other, j + other[i], sum)
                || canGet(i + 1, o, other, j - other[i], sum));
    }
}
