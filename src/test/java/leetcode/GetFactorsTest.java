package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

class GetFactorsTest {
    @Test
    void test() {
        GetFactors test = new GetFactors();
        List<List<Integer>> out = test.getFactors(32);
        for (List<Integer> list : out) {
            System.out.println(list.toString());
        }
    }

    @Test
    void name() {
        System.out.println(Math.sqrt(32));
    }
}