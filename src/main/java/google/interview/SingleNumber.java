package google.interview;

public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber test = new SingleNumber();
//        int[] nums = {4, 1, 2, 1, 2};
//        System.out.println(test.singleNumber(nums));
        int[] nums1 = {2, 2, 1};
        System.out.println(test.singleNumber(nums1));
    }

    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == -1) continue;
            boolean isSingle = true;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    nums[j] = -1;
                    isSingle = false;
                }
            }
            if (isSingle) return nums[i];
        }
        return nums[nums.length - 1];
    }
}
