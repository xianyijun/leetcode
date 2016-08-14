package cn.xianyijun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length <= 3) {
			return result;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j != i + 1 && nums[j - 1] == nums[j]) {
					continue;
				}
				int start = j + 1;
				int end = nums.length - 1;
				while (start < end) {
					int temp = nums[i] + nums[j] + nums[start] + nums[end];
					if (temp < target) {
						start++;
					} else if (temp > target) {
						end--;
					} else {
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[start]);
						list.add(nums[end]);
						result.add(list);
						start++;
						end--;
						while (start < end && nums[start] == nums[start - 1]) {
							start++;
						}
						while (start < end && nums[end] == nums[end + 1]) {
							end--;
						}
					}
				}
			}
		}
		return result;
	}
}
