package cn.xianyijun.leetcode;

import java.util.ArrayList;
import java.util.List;

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
