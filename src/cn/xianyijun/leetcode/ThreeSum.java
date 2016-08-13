package cn.xianyijun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xianyijun
 *	Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

	Note: The solution set must not contain duplicate triplets.
	
	For example, given array S = [-1, 0, 1, 2, -1, -4],
	
	A solution set is:
	[
	  [-1, 0, 1],
	  [-1, -1, 2]
	]
 */
public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length < 3) {
			return result;
		}
		Arrays.sort(nums);
		for (int i = nums.length - 1; i >= 2; i--) {
			//跳过相同的值
			if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
				continue;
			}
			int temp = nums[i];
			int start = 0;
			int end = i - 1;
			while (start < end) {
				if (temp + nums[start] + nums[end] == 0) {
					List<Integer> list = new ArrayList<>();
					list.add(temp);
					list.add(nums[start]);
					list.add(nums[end]);
					start++;
					end--;
					while (start < end && nums[start] == nums[start - 1]) {
						start++;
					}
					while (start < end && nums[end] == nums[end + 1]) {
						end--;
					}
					result.add(list);
				} else if (temp + nums[start] + nums[end] < 0) {
					start++;
				} else {
					end--;
				}
			}
		}
		return result;
	}
}
