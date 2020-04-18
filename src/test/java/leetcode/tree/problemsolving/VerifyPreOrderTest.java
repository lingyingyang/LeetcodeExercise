package leetcode.tree.problemsolving;

import leetcode.tree.prolemsolving.VerifyPreOrder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class VerifyPreOrderTest {
    @Test
    void test() {
        VerifyPreOrder test = new VerifyPreOrder();
        int[] in = {5, 2, 1, 3, 6};
        assertTrue(test.verifyPreorder(in));
    }
}