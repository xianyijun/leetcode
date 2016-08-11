package cn.xianyijun.leetcode;

/**
 * @author xianyijun
 *	Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimetoBuyandSellStockIII {
	public static int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int[] left = new int[prices.length];
		int[] right = new int[prices.length];
		int min = prices[0];//买入的最小价格

		for (int i = 1; i < left.length; i++) {
			left[i] = Math.max(left[i - 1], prices[i] - min);
			min = Math.min(min, prices[i]);
		}
		right[right.length - 1] = 0;
		int max = prices[right.length - 1];//卖出最高价格
		for (int i = right.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], max - prices[i]);
			max = Math.max(max, prices[i]);
		}
		int result = 0;

		for (int i = 0; i < prices.length; i++) {
			result = Math.max(result, left[i] + right[i]);
		}
		return result;
	}
}
