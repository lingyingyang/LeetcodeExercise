package leetcode.dp;

public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber t = new HouseRobber();
        int[] num = {2, 7, 9, 3, 1};
        int max = t.rob(num);
        System.out.println(max);
    }

    public int rob(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
