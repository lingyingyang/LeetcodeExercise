package leetcode.arrays;

public class IncreasingTriplet {
    public static void main(String[] args) {
        IncreasingTriplet t = new IncreasingTriplet();
        boolean out = t.increasingTriplet(new int[]{1, 2, 1, 3, 4, 5});
        System.out.println(out);//true
    }

    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) return false;
        int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= mid) {
                mid = num;
            } else if (num > mid) {
                return true;
            }
        }
        return false;
    }
}
