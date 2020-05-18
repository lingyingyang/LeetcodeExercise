package leetcode.recurrsion;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfSteps {
    public static void main(String[] args) {
        int out = new NumberOfSteps().numberOfSteps(14);
        assertThat(out).isEqualTo(6);
    }

    public int numberOfSteps(int num) {
        return helper(num);
    }

    private int helper(int num) {
        if (num == 0) return 0;

        if ((num & 1) == 0) {//偶数
            num = num / 2;
        } else {//奇数
            num -= 1;
        }
        return helper(num) + 1;

    }
}
