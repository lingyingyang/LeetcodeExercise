package leetcode.recurrsion;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 */
public class YangTriangle {
    public static void main(String[] args) {
        List<List<Integer>> out = new YangTriangle().generate(5);
        System.out.println(out.toString());
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ans.add(new ArrayList<>());
        }
        helper(ans, 0, numRows);
        return ans;
    }

    public void helper(List<List<Integer>> ans, int row, int rows) {
        if (row >= rows) return;

        ans.get(row).add(1); // 每行赋值第一位为1
        for (int col = 1; col < row; col++) {
            int value = ans.get(row - 1).get(col - 1) + ans.get(row - 1).get(col);
            ans.get(row).add(value);
        }
        // 除了第一行外，其他行都需要赋值最后一位为1
        if (row > 0) {
            ans.get(row).add(1);
        }
        helper(ans, ++row, rows);
    }
}
