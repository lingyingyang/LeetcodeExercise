package google.interview;

public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement t = new MajorityElement();
        int[] nums = {3, 2, 3};
        System.out.println(t.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int half = nums.length / 2;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == Integer.MIN_VALUE) continue;
            int cnt = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    cnt++;
                    nums[j] = Integer.MIN_VALUE;
                }
            }
            if (cnt > half) return nums[i];
        }
        return nums[nums.length - 1];
    }
}
