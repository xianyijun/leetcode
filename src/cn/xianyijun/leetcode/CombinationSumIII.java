package cn.xianyijun.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xianyijun
	 *Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
	
	
	Example 1:
	
	Input: k = 3, n = 7
	
	Output:
	
	[[1,2,4]]
	
	Example 2:
	
	Input: k = 3, n = 9
	
	Output:
	
	[[1,2,6], [1,3,5], [2,3,4]]

 */
public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> current = new ArrayList<Integer>();
		dfs(1, k, n, current, result);
		return result;
	}

	private void dfs(int start, int k, int n, List<Integer> current, List<List<Integer>> result) {
		if (current.size() == k) {
			if (n == 0) {
				result.add(new ArrayList<Integer>(current));
			}
		}
		for (int i = start; i <= 9 && i <= n; i++) {
			current.add(i);
			dfs(i + 1, k, n - i, current, result);
			current.remove(current.size() - 1);
		}
	}
}
