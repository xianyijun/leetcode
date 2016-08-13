package cn.xianyijun.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xianyijun
 *	Given an array of integers, return indices of the two numbers such that they add up to a specific target.

	You may assume that each input would have exactly one solution.
	
	Example:
	Given nums = [2, 7, 11, 15], target = 9,
	
	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int number = nums[i];
			if (map.containsKey(target - number)) {
				return new int[] { map.get(target - number), i };
			}
			map.put(number, i);
		}
		throw new IllegalArgumentException();
	}
}
