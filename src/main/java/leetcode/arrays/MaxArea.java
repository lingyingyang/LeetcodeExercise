package leetcode.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxArea {
    public static void main(String[] args) {
        MaxArea t = new MaxArea();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int out = t.maxArea(height);
        assertEquals(49, out);
    }

    /**
     * 使用双指针
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(area, ans);
            if (height[left] < height[right]) // 移动矮的一边
                left++;
            else right--;
        }
        return ans;
    }
}
