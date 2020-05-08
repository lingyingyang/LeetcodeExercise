package leetcode.mapset.set;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class IsHappyNumber {
    public static void main(String[] args) {
        boolean out = new IsHappyNumber().isHappy(19);
        assertThat(out).isTrue();
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            sum += digit * digit;
        }
        return sum;
    }
}
