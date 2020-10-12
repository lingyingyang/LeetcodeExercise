package leetcode.binarysearch;

import static org.assertj.core.api.Assertions.assertThat;

public class MySqrt {
    public static void main(String[] args) {
        int out = new MySqrt().mySqrt(2147395599);
        assertThat(out).isEqualTo(46339);
    }

    public int mySqrt(int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) { // 可能在右区间，转换成long防止int类型溢出
                left = mid + 1;
                ans = mid;
            } else { // 可能在左区间
                right = mid - 1;
            }
        }
        return ans;
    }
}
