package leetcode.arrays;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        ProductExceptSelf t = new ProductExceptSelf();
        int[] out = t.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(out));
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];

        // ans[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so the ans[0] would be 1
        ans[0] = 1;
        for (int left = 1; left < len; left++) {

            // ans[left - 1] already contains the product of elements to the left of 'left - 1'
            // Simply multiplying it with nums[left - 1] would give the product of all
            // elements to the left of index 'left'
            ans[left] = nums[left - 1] * ans[left - 1];
        }
        System.out.println(Arrays.toString(ans));

        // rightProduct contains the product of all the elements to the right
        // Note: for the element at index 'len - 1', there are no elements to the right,
        // so the rightProduct would be 1
        int rightProduct = 1;
        for (int right = len - 1; right >= 0; right--) {

            // For the index 'right', rightProduct would contain the
            // product of all elements to the right. We update rightProduct accordingly
            ans[right] = rightProduct * ans[right];
            rightProduct *= nums[right];
            System.out.println(Arrays.toString(ans));
        }

        return ans;
    }
}
