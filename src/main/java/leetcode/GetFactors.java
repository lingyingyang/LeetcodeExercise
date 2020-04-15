package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/factor-combinations/solution/java-hui-su-li-yong-zhan-100-by-fei-ying-12/
 */
public class GetFactors {
    public List<List<Integer>> getFactors(int n) {
        ans.clear();
        helper(new Stack<>(), n);
        return ans;
    }

    List<List<Integer>> ans = new ArrayList<>();

    public void helper(Stack<Integer> stack, int val) {
        if (val == 1)
            return;
        if (stack.size() != 0) {
            List<Integer> list = new ArrayList<>(stack);
            list.add(val);
            ans.add(list);
        }

        for (int i = 2; i <= Math.sqrt(val); i++) {
            if (val % i == 0 && (stack.isEmpty() || i >= stack.peek())) {
                stack.add(i);
                System.out.println(String.format("stack: %s", stack.toString()));
                helper(stack, val / i);
                stack.pop();
            }
        }
    }
}
