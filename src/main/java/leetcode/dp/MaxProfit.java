package leetcode.dp;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class MaxProfit {
    public static void main(String[] args) {
        MaxProfit t = new MaxProfit();
        int[] in = {7, 1, 5, 3, 6, 4};
        int profit = t.maxProfit(in);
        System.out.println(profit);
    }

    public int maxProfit(int prices[]) {
        int last = 0, profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            last = Math.max(0, last + prices[i + 1] - prices[i]);
            profit = Math.max(profit, last);
        }
        return profit;
    }
}
